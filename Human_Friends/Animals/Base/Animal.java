package Animals.Base;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Animal implements Serializable {
    protected final UUID id;
    protected final String name;
    protected final IAnimalType type;
    protected final Date birthday;
    protected final List<AnimalCommand> commands = new ArrayList<>();

    protected Animal(UUID id, String name, IAnimalType type, Date birthday) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.birthday = birthday;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public IAnimalType getType() {
        return type;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getAge() {
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(birthday);
        if (birthDate.after(today)) {

        }
        int yearDiff = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        int monthsBetween = today.get(Calendar.MONTH) - birthDate.get(Calendar.MONTH) + 12 * yearDiff;

        if (today.get(Calendar.DAY_OF_MONTH) >= birthDate.get(Calendar.DAY_OF_MONTH)) {
            monthsBetween++;
        }
        return monthsBetween;
    }

    public String getLearnedCommands() {
        return commands.stream()
                       .map(AnimalCommand::getTitle)
                       .collect(Collectors.joining(", "));
    }

    protected String learnOrExecute(AnimalCommand command) {
        if (isCommandLearned(command.getTitle())) {
            return command.getTitle() + "' была успешно выполнена";
        } else {
            commands.add(command);
            return command.getTitle() + "' была успешно обучена";
        }
    }

    private boolean isCommandLearned(String title) {
        return commands.stream()
                       .anyMatch(command -> Objects.equals(command.getTitle(), title));
    }
}
