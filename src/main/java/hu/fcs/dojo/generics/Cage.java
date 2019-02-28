package hu.fcs.dojo.generics;

public class Cage<T extends Animal> {
    private T inhabitant;

    public void put(T a) {
        inhabitant = a;
    }
    
    public T get() {
        return inhabitant;
    }
}
