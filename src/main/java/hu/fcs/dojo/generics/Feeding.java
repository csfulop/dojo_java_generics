package hu.fcs.dojo.generics;

public class Feeding<T extends Animal, U extends Food> {
    private final T animal;
    private final U food;

    public Feeding(T animal, U food) {
        this.animal = animal;
        this.food = food;
    }

    public void feed() {
        animal.eat(food);
    }

    public T getAnimal() {
        return animal;
    }

    public U getFood() {
        return food;
    }
}
