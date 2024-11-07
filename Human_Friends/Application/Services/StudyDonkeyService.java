package Application.Services;

import Animals.Base.Animal;
import Animals.PackAnimals.Donkey.Donkey;
import Application.Base.Service;

import java.util.List;
import java.util.Optional;

public class StudyDonkeyService extends Service {


    public List<String> getAvailableDonkeyNames() {
        return farm.getDonkeys().stream()
                .map(Animal::getName)
                .toList();
    }

    public String educateDonkeyCommandWalk(String name) {
        Optional<Donkey> result = farm.getDonkeys().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandWalk();
            writer.save(farm);
        }
        return output;
    }


    public String educateDonkeyCommandCarryLoad(String name) {
        Optional<Donkey> result = farm.getDonkeys().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandCarryLoad();
            writer.save(farm);
        }
        return output;
    }

    public String educateDonkeyCommandBray(String name) {
        Optional<Donkey> result = farm.getDonkeys().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandBray();
            writer.save(farm);
        }
        return output;
    }

    public String educateDonkeyCommandKick(String name) {
        Optional<Donkey> result = farm.getDonkeys().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandKick();
            writer.save(farm);
        }
        return output;
    }

}
