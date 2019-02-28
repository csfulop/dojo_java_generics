package hu.fcs.dojo.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;


public class ZooTest {

    /**
     There are Animals.
     Cat is an Animal.
     Dog is an Animal.
     There is a Zoo. Represent it with a List of Animals.
     Animals can be added to the Zoo: add Cat and Dog to the Zoo.
     Strings can not be added to the Zoo.
     */
    @Test
    void testZoo() {
        List<Animal> zoo = new ArrayList<>();
        zoo.add(new Cat());
        zoo.add(new Dog());
        // zoo.add("asdf");
        // add(hu.fcs.dojo.generics.Animal) in List cannot be applied to (java.lang.String)
    }

    @Test
    void testCage() {
        // given
        Cage<Cat> catCage = new Cage<>();
        Cage<Dog> dogCage = new Cage<>();
        // Cage<String> stringCage = new Cage<>();
        // Type parameter 'java.lang.String' is not within its bound; should extend 'hu.fcs.dojo.generics.Animal'
        // when
        catCage.put(new Cat());
        dogCage.put(new Dog());
        // then
        assertThat(catCage.get(), is(instanceOf(Cat.class)));
        assertThat(dogCage.get(), is(instanceOf(Dog.class)));
    }

    /**
     There are Cages.
     Animals can be put/get into/from Cages.
     There are separate type of Cage for every type of Animal:
     Cat have to be put into a CatCage but cannot be put into a DogCage and a Dog cannot be put into a CatCage. Solve it with only 1 Cage object.
     Only Animals can have Cage, String can not have a Cage.
     The Zoo has a putIntoCage static method: you give in a Cage and the related Animal and it puts the Animal into the Cage.
     */
    @Test
    void testPutIntoCage() {
        // given
        Cage<Cat> catCage = new Cage<>();
        Cat cat = new Cat();
        Dog dog = new Dog();
        assertThat(catCage.get(), is(nullValue()));
        // when
        Zoo.putIntoCage(catCage, cat);
        // Zoo.putIntoCage(catCage, dog);
        // putIntoCage(hu.fcs.dojo.generics.Cage<T>,T) in Zoo cannot be applied to
        // (hu.fcs.dojo.generics.Cage<hu.fcs.dojo.generics.Cat>, hu.fcs.dojo.generics.Dog)
        // then
        assertThat(catCage.get(), is(cat));
    }

    /**
     The Zoo has a Cage factory static method: you give in an Animal and get back it inside a properly typed Cage.
     */
    @Test
    void testCageFactory() {
        // given
        Cat cat = new Cat();
        // when
        Cage<Cat> catCage = Zoo.createCage(cat);
        // then
        assertThat(catCage.get(), is(cat));
    }

    /**
     The Zoo has thematic AnimaHouses: a collection of Cages with the same type of Animals.
     If a new Animal is added to an AnimalHouse then they create a new Cage for him, put him into the Cage and add the Cage to the AnimalHouse.
     */
    @Test
    void testAnimalHouse() {
        // given
        AnimalHouse<Cat> catHouse = new AnimalHouse<>();
        // AnimalHouse<String> stringHouse;
        Cat cat = new Cat();
        // when
        catHouse.add(cat);
        // catHouse.add(new Dog());
        // then
        assertThat(catHouse.getCages().get(0).get(), is(cat));
    }

    /**
     They feed the Animals with Food: Bones, Meat, and Fish.
     There are Feeding events in the Zoo which describes which animal is fed with which food.
     */
    @Test
    void testFeeding() {
        // given
        // when
        Feeding<Cat, Fish> catFeeding = new Feeding<>(new Cat(), new Fish());
        // then
    }

    /**
     Animals eat Food (a method).
     When you execute the Feeding event then they feed the animal (call the eat method).
     The Zoo has feedAnimal static method: you give in a Cage with an Animal and a Food:
     it gets the Animal out of the Cage, creates a Feeding event and executes it.
     */
    @Test
    void testFeedAnimal() {
        // given
        Cat cat = new Cat();
        Cage<Cat> cage = new Cage<>();
        cage.put(cat);
        Fish fish = new Fish();
        // when
        Zoo.feedAnimal(cage, fish);
        // then
    }

    /**
     To organize the Feeding events they have to know which kind of Animal eats which kind of Food.
     For this create a Map.
     They keys of the Map are Food Classes and the values of the Map are List of Animal Classes.
     So describes the relationship between the type of Foods and type of Animals, not individual Animals.
     To solve this correctly you have to encounter the problem that Class<Dog> is not a sublass of Class<Animal>
     (see: https://stackoverflow.com/questions/2745265/is-listdog-a-subclass-of-listanimal-why-are-java-generics-not-implicitly-po).
     Use wildcards to solve the problem.
     */
    @Test
    void testAnimalEatsFood() {
        // given
        Map<Class<? extends Food>, List<Class<? extends Animal>>> likes = new HashMap<>();
        // when
        likes.put(Bone.class, new ArrayList<>());
        likes.get(Bone.class).add(Dog.class);
        likes.put(Meat.class, new ArrayList<>());
        likes.get(Meat.class).add(Dog.class);
        likes.get(Meat.class).add(Cat.class);
        // then
    }
}
