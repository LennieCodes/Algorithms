package stacksAndQueues.AnimalShelter;

import java.util.LinkedList;

// 3.6
public class AnimalShelter {
	private LinkedList<Animal> queue;
	
	public AnimalShelter() {
		queue = new LinkedList<Animal>();
	}
	
	public void Enqueue(Animal animal) {
		queue.add(animal);
	}
	
	public Animal DequeueAny() {
		return queue.poll();
	}
	
	public Animal DequeueCat() {
		
		if (queue.peek() instanceof Cat) {
			return queue.poll();
		}
		
		// needs testing. 
		for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i) instanceof Cat) {
				return queue.remove(i);
			}
		}
		
		return queue.poll();
			
		
	}
	
	public Animal DequeueDog() {
		if (queue.peek() instanceof Dog) {
			return queue.poll();
		}
		
		for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i) instanceof Dog) {
				return queue.remove(i);
			}
		}
		
		return queue.poll();

	}
	
	
}

