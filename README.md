Java Generics DOJO
------------------

1. There are Animals
1. Cat is an Animal
1. Dog is an Animal
1. There is a Zoo. Represent it with a List of Animals
1. Animals can be added to the Zoo: add Cat and Dog to the Zoo
1. Strings can not be added to the Zoo
1. There are Cages.
1. Animals can be put/get into/from Cages
1. There are separate type of Cage for every type of Animal: 
Cat have to be put into a CatCage but cannot be put into a DogCage and a Dog cannot be put into a CatCage. Solve it with only 1 Cage object.
1. Only Animals can have Cage, String can not have a Cage
1. The Zoo has a putIntoCage static method: 
you give in a Cage and the related Animal and it puts the Animal into the Cage
1. The Zoo has a Cage factory static method: you give in an Animal and get back it inside a properly typed Cage
1. The Zoo has thematic AnimaHouses: a collection of Cages with the same type of Animals
1. If a new Animal is added to an AnimalHouse 
then they create a new Cage for him, 
put him into the Cage 
and add the Cage to the AnimalHouse
1. They feed the Animals with Food: Bones, Meat, and Fish
1. Animals eat Food (a method)
1. There are Feeding events in the Zoo which describes which animal is fed with which food. 
When you execute the Feeding event then they feed the animal (call the eat method)
1. The Zoo has feedAnimal static method: 
you give in a Cage with an Animal and a Food:
it gets the Animal out of the Cage, creates a Feeding event and executes it.
1. To organize the Feeding events they have to know which kind of Animal eats which kind of Food. 
For this create a Map. 
They keys of the Map are Food Classes and the values of the Map are List of Animal Classes.
So describes the relationship between the type of Foods and type of Animals, not individual Animals.  
To solve this correctly you have to encounter the problem that Class\<Dog\> is not a sublass of Class\<Animal\> 
(see:https://stackoverflow.com/questions/2745265/is-listdog-a-subclass-of-listanimal-why-are-java-generics-not-implicitly-po). 
Use wildcards to solve the problem.  
