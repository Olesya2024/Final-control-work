package Application.Services;

import Animals.Base.Animal;
import Animals.PackAnimals.Camel.Camel;
import Animals.PackAnimals.Donkey.Donkey;
import Animals.PackAnimals.Horse.Horse;
import Animals.Pets.Cat.Cat;
import Animals.Pets.Dog.Dog;
import Animals.Pets.Hamster.Hamster;
import Application.Base.Service;
import java.util.Date;

public class AddAnimalService extends Service {


    public void addCat(String name, Date birthday) {
        addAnimal(Cat.create(name, birthday));
    }

    public void addDog(String name, Date birthday) {
        addAnimal(Dog.create(name, birthday));
    }

    public void addHamster(String name, Date birthday) {
        addAnimal(Hamster.create(name, birthday));
    }

    public void addHorse(String name, Date birthday) {
        addAnimal(Horse.create(name, birthday));
    }

    public void addCamel(String name, Date birthday) {
        addAnimal(Camel.create(name, birthday));
    }

    public void addDonkey(String name, Date birthday) {
        addAnimal(Donkey.create(name, birthday));
    }

    private void addAnimal(Animal animal) {
        farm.addAnimal(animal);
        writer.save(farm);
    }


}
