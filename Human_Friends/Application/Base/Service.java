package Application.Base;

import Operation.AnimalFarm;

import Operation.filewriter.Writer;
import Operation.Farm;
import Operation.filewriter.AnimalWriter;


public abstract class Service {
    protected final Farm farm;
    protected final Writer<Farm> writer = new AnimalWriter();

    protected Service() {
        farm = writer.load();
        if (farm.getAllAnimals().isEmpty()) {
            AnimalFarm.fillAnimals(farm.getAllAnimals());
            writer.save(farm);
        }
    }
}
