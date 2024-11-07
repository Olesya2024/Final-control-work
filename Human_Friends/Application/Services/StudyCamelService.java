package Application.Services;

import Animals.Base.Animal;
import Animals.PackAnimals.Camel.Camel;
import Application.Base.Service;


import java.util.List;
import java.util.Optional;

public class StudyCamelService extends Service {


    public List<String> getAvailableCamelNames() {
        return farm.getCamels().stream()
                .map(Animal::getName)
                .toList();
    }

    public String educateCamelCommandWalk(String name) {
        Optional<Camel> result = farm.getCamels().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandWalk();
            writer.save(farm);
        }
        return output;
    }

    public String educateCamelCommandCarryLoad(String name) {
        Optional<Camel> result = farm.getCamels().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandCarryLoad();
            writer.save(farm);
        }
        return output;
    }

    public String educateCamelCommandSit(String name) {
        Optional<Camel> result = farm.getCamels().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandSit();
            writer.save(farm);
        }
        return output;
    }

    public String educateCamelCommandRun(String name) {
        Optional<Camel> result = farm.getCamels().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandRun();
            writer.save(farm);
        }
        return output;
    }


}
