package Operation;

import Operation.servise.DateService;
import Animals.Base.Animal;
import Animals.PackAnimals.Camel.Camel;
import Animals.PackAnimals.Donkey.Donkey;
import Animals.PackAnimals.Horse.Horse;
import Animals.Pets.Cat.Cat;
import Animals.Pets.Dog.Dog;
import Animals.Pets.Hamster.Hamster;

import java.util.Collections;
import java.util.List;

public class AnimalFarm {

    public static void fillAnimals(List<Animal> animals) {
        addDogs(animals);
        addCats(animals);
        addHamsters(animals);
        addHorses(animals);
        addCamels(animals);
        addDonkeys(animals);
        shuffle(animals);
    }

    private static void shuffle(List<Animal> animals) {
        Collections.shuffle(animals);
    }

    private static void addDonkeys(List<Animal> animals) {
        Donkey eeyore = Donkey.create("Буцефал", DateService.stringToDate("18-09-2017"));
        eeyore.commandWalk();
        eeyore.commandCarryLoad();
        eeyore.commandBray();
        animals.add(eeyore);

    }

    private static void addCamels(List<Animal> animals) {
        Camel sandy = Camel.create("Гоша", DateService.stringToDate("03-11-2016"));
        sandy.commandWalk();
        sandy.commandCarryLoad();
        animals.add(sandy);

    }

    private static void addHorses(List<Animal> animals) {
        Horse thunder = Horse.create("Иа", DateService.stringToDate("21-07-2015"));
        thunder.commandTrot();
        thunder.commandCanter();
        thunder.commandGallop();
        animals.add(thunder);

    }

    private static void addHamsters(List<Animal> animals) {
        Hamster hammy = Hamster.create("Хома", DateService.stringToDate("10-03-2021"));
        hammy.commandRoll();
        hammy.commandHide();
        animals.add(hammy);

    }

    private static void addCats(List<Animal> animals) {
        Cat whiskers = Cat.create("Мурка", DateService.stringToDate("15-05-2019"));
        whiskers.commandSit();
        whiskers.commandPounce();
        animals.add(whiskers);

    }

    private static void addDogs(List<Animal> animals) {
        Dog fido = Dog.create("Бобик", DateService.stringToDate("01-01-2020"));
        fido.commandSit();
        fido.commandStay();
        fido.commandFetch();
        animals.add(fido);

    }


}
