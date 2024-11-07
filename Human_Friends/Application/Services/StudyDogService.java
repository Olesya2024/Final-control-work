package Application.Services;

import Animals.Base.Animal;
import Animals.Pets.Dog.Dog;
import Application.Base.Service;

import java.util.List;
import java.util.Optional;

public class StudyDogService extends Service {


    public List<String> getAvailableDogNames() {
        return farm.getDogs().stream()
                .map(Animal::getName)
                .toList();
    }

    public String educateDogCommandBark(String name) {
        Optional<Dog> animal = farm.getDogs().stream().filter(dog -> dog.getName().equals(name)).findFirst();
        String output = "";
        if (animal.isPresent()) {
            output = animal.get().commandBark();
            writer.save(farm);
        }
        return output;
    }

    public String educateDogCommandSit(String name) {
        Optional<Dog> result = farm.getDogs().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandSit();
            writer.save(farm);
        }
        return output;
    }

    public String educateDogCommandStay(String name) {
        Optional<Dog> result = farm.getDogs().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandStay();
            writer.save(farm);
        }
        return output;
    }

    public String educateDogCommandFetch(String name) {
        Optional<Dog> result = farm.getDogs().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandFetch();
            writer.save(farm);
        }
        return output;
    }

    public String educateDogCommandPaw(String name) {
        Optional<Dog> result = farm.getDogs().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandPaw();
            writer.save(farm);
        }
        return output;
    }

    public String educateDogCommandRoll(String name) {
        Optional<Dog> result = farm.getDogs().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandRoll();
            writer.save(farm);
        }
        return output;
    }

}
