package stacksAndQueues.AnimalShelter;

import static org.junit.Assert.*;
import org.junit.Test;

public class AnimalShelterTestRunner {
	
	@Test
	public void RemoveOldestAnimalTest() {
		// it should ... add animals to a queue and check to see if oldest animal is removed.
		Animal[] initArr = new Animal[] {
			new Dog("Max"),
			new Cat("Harry"),
			new Dog("Abe"),
			new Dog("Marcel"),
			new Dog("George"),
			new Cat("Michael")
		};
		AnimalShelter shelter = new AnimalShelter();
		
		for (int i = 0; i < initArr.length; i++) {
			shelter.Enqueue(initArr[i]);
		}
		
		Animal animal = shelter.DequeueAny();
		
		if (!animal.getClass().toString().toLowerCase().equals("dog") && !animal.name.toLowerCase().equals("max")) {
			fail("Expected Dog - Max to be removed from shelter, but instead removed:" + animal.name);
		}
		
		animal = shelter.DequeueAny();
		
		if (!animal.getClass().toString().toLowerCase().equals("dog") && !animal.name.toLowerCase().equals("harry")) {
			fail("Expected Cat - Harry to be removed from shelter, but instead removed:" + animal.name);
		} 
		
	}
	
	@Test
	public void RemoveOldestCatTest() {
		// it should ... add animals to a queue and check to see if oldest cat is removed.
		Animal[] initArr = new Animal[] {
				new Dog("Max"),
				new Cat("Harry"),
				new Dog("Abe"),
				new Dog("Marcel"),
				new Dog("George"),
				new Cat("Michael")
			};
		AnimalShelter shelter = new AnimalShelter();
		
		for (int i = 0; i < initArr.length; i++) {
			shelter.Enqueue(initArr[i]);
		}
		
		Animal animal = shelter.DequeueCat();
		
		if (!animal.getClass().toString().toLowerCase().equals("cat") && !animal.name.toLowerCase().equals("harry")) {
			fail("Expected Cat - Harry to be removed from shelter, "
					+ "but instead removed:" + animal.name + " with type:" + animal.getClass().toString());
		}
		
		animal = shelter.DequeueCat();
		
		if (!animal.getClass().toString().toLowerCase().equals("cat") && !animal.name.toLowerCase().equals("michael")) {
			fail("Expected Cat - Michael to be removed from shelter, "
					+ "but instead removed:" + animal.name + " with type:" + animal.getClass().toString());
		}
		
	}
	
	@Test
	public void RemoveOldestDogTest() {
		// it should ... add animals to a queue and check to see if oldest dog is removed.
		Animal[] initArr = new Animal[] {
				new Dog("Max"),
				new Cat("Harry"),
				new Dog("Abe"),
				new Dog("Marcel"),
				new Dog("George"),
				new Cat("Michael")
			};
		AnimalShelter shelter = new AnimalShelter();
		
		for (int i = 0; i < initArr.length; i++) {
			shelter.Enqueue(initArr[i]);
		}
		
		Animal animal = shelter.DequeueDog();
		
		if (!animal.getClass().toString().toLowerCase().equals("dog") && !animal.name.toLowerCase().equals("max")) {
			fail("Expected Dog - Max to be removed from shelter, "
					+ "but instead removed:" + animal.name + " with type:" + animal.getClass().toString());
		}
		
		animal = shelter.DequeueDog();
		
		if (!animal.getClass().toString().toLowerCase().equals("dog") && !animal.name.toLowerCase().equals("abe")) {
			fail("Expected Dog - Max to be removed from shelter, "
					+ "but instead removed:" + animal.name + " with type:" + animal.getClass().toString());
		}
		
	}
	
	@Test
	public void RemoveOldestNonLinear() {
		// it should ... remove oldest animals from shelter in non linear way
		// for example: if dog -> cat -> dog -> dog -> cat, then remove first 2 dogs, then remove cat and see if correct object is removed. 
		Animal[] initArr = new Animal[] {
				new Dog("Max"),
				new Cat("Harry"),
				new Dog("Abe"),
				new Dog("Marcel"),
				new Dog("George"),
				new Cat("Michael")
			};
		AnimalShelter shelter = new AnimalShelter();
		
		for (int i = 0; i < initArr.length; i++) {
			shelter.Enqueue(initArr[i]);
		}
		
		shelter.DequeueDog(); // max
		shelter.DequeueDog(); // harry
		
		Animal animal = shelter.DequeueCat();
		
		if (!animal.getClass().toString().toLowerCase().equals("cat") && !animal.name.toLowerCase().equals("harry")) {
			fail("Expected Cat - Harry to be removed from shelter, "
					+ "but instead removed:" + animal.name + " with type:" + animal.getClass().toString());
		}
		
	}
	
}
