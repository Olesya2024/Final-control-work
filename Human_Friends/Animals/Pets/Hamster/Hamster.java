package Animals.Pets.Hamster;

import Animals.Base.Animal;
import Animals.Base.PetsType;
import java.util.Date;
import java.util.UUID;

public class Hamster extends Animal {
    protected Hamster(String name, Date birthday) {
        super(UUID.randomUUID(), name, PetsType.HAMSTER, birthday);
    }

    public static Hamster create(String name, Date birthday){
        return new Hamster(name, birthday);
    }

    public String commandRoll() {
        return learnOrExecute(HamsterAnimalCommand.commandRoll(this.id));
    }

    public String commandHide() {
        return learnOrExecute(HamsterAnimalCommand.commandHide(this.id));
    }

    public String commandSpin() {
        return learnOrExecute(HamsterAnimalCommand.commandSpin(this.id));
    }
}
