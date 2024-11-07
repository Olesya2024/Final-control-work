package Application.Services;

import Animals.Base.Animal;
import Animals.Pets.Hamster.Hamster;
import Application.Base.Service;

import java.util.List;
import java.util.Optional;

public class StudyHamsterService extends Service {

    public List<String> getAvailableHamsterNames() {
        return farm.getHamsters().stream()
                .map(Animal::getName)
                .toList();
    }

    public String educateHamsterCommandHide(String name) {
        Optional<Hamster> result = farm.getHamsters().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandHide();
            writer.save(farm);
        }
        return output;
    }

    public String educateHamsterCommandRoll(String name) {
        Optional<Hamster> result = farm.getHamsters().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandRoll();
            writer.save(farm);
        }
        return output;
    }

    public String educateHamsterCommandSpin(String name) {
        Optional<Hamster> result = farm.getHamsters().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandSpin();
            writer.save(farm);
        }
        return output;
    }

}
