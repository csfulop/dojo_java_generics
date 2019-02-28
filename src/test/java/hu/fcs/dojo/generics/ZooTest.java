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

    @Test
    void testCageFactory() {
        // given
        Cat cat = new Cat();
        // when
        Cage<Cat> catCage = Zoo.createCage(cat);
        // then
        assertThat(catCage.get(), is(cat));
    }

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
        assertThat(catHouse.getCages().get(0).get(),is(cat));
    }

    @Test
    void testFeeding() {
        // given
        // when
        Feeding<Cat, Fish> catFeeding = new Feeding<>(new Cat(), new Fish());
        // then
    }

    @Test
    void testFeedAnimal() {
        // given
        Cat cat = new Cat();
        Cage<Cat> cage = new Cage<>();
        cage.put(cat);
        Fish fish = new Fish();
        // when
        Zoo.feedAnimal(cage,fish);
        // then
    }

    @Test
    void testAnimalEatsFood() {
        // given
        Map<Class<? extends Food>, List<Class<? extends Animal>>> likes = new HashMap<>();
        // when
        likes.put(Bone.class,new ArrayList<>());
        likes.get(Bone.class).add(Dog.class);
        likes.put(Meat.class,new ArrayList<>());
        likes.get(Meat.class).add(Dog.class);
        likes.get(Meat.class).add(Cat.class);
        // then
    }
}
