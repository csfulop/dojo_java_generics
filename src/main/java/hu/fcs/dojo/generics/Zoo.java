package hu.fcs.dojo.generics;

public class Zoo {

    public static <T extends Animal> void putIntoCage(Cage<T> cage, T animal){
        cage.put(animal);
    }

    public static <T extends Animal> Cage<T> createCage(T animal) {
        Cage<T> cage = new Cage<>();
        cage.put(animal);
        return cage;
    }

    public static <T extends Animal, U extends Food> void feedAnimal(Cage<T> cage, U food) {
        T animal = cage.get();
        Feeding<T,U> feeding = new Feeding<>(animal,food);
        feeding.feed();
    }

}
