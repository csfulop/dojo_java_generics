package hu.fcs.dojo.generics;

import java.util.ArrayList;
import java.util.List;


public class AnimalHouse<T extends Animal> {
    private List<Cage<T>> cages = new ArrayList<>();

    public List<Cage<T>> getCages() {return cages;}

    public void add(T animal) {
        Cage<T> cage = new Cage<>();
        cage.put(animal);
        cages.add(cage);
    }
}
