package chapter3;

import java.util.LinkedList;
import java.util.Optional;

public class AnimalQueue {
    private final LinkedList<Animal> cats = new LinkedList<>();
    private final LinkedList<Animal> dogs = new LinkedList<>();
    private int order = 0;

    public void enqueue(Animal animal) {
        animal.setOrder(this.order++);
        if (animal instanceof Dog) {
            dogs.addLast(animal);
        } else if (animal instanceof Cat) {
            cats.addLast(animal);
        }
    }

    public Animal dequeueAny() {
        Optional<Animal> oldestDog = Optional.ofNullable(dogs.peekFirst());
        Optional<Animal> oldestCat = Optional.ofNullable(cats.peekFirst());

        if (!oldestDog.isPresent() && !oldestCat.isPresent()) {
            return null;
        } else if (!oldestDog.isPresent()) {
            return dequeueCat();
        } else if (!oldestCat.isPresent()) {
            return dequeueDog();
        }

        if (oldestDog.get().isOlderThan(oldestCat.get())) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Animal dequeueCat() {
        return cats.poll();
    }

    public Animal dequeueDog() {
        return dogs.poll();
    }

    public static void main(String[] args) {
        AnimalQueue queue = new AnimalQueue();
        queue.enqueue(new Dog("Riley"));
        queue.enqueue(new  Cat("Shadow"));
        queue.enqueue(new Cat("Fluffy"));
        queue.enqueue(new Dog("Spot"));
        System.out.println(queue.dequeueAny());
        System.out.println(queue.dequeueAny());
        System.out.println(queue.dequeueAny());
        System.out.println(queue.dequeueAny());
    }
}
