package com.coderscampus.Assignment5;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	private int initialCapacity = 10; // integer that sets the initial capacity of the array to a list of 10
	private Object[] items; // 'items' is an array of Object. Stores the items in the array list
	private int size; // keeps track of the number of items currently in the list

	// constructor initializes the 'items' array with the initialCapacity and sets the initial 'size' to 0
	public CustomArrayList() { 
		items = new Object[initialCapacity];
		size = 0;
	}

	
	// The 'add' method takes an item of type 'T', ('T' is a generic), as an argument and adds it to the array list 
	@Override
	public boolean add(T item) {
		// First it checks the current size of the list plus one exceeds the current capacity. 
		// If so, it invokes the 'checkCapacity' method to increase the capacity of the list
		checkCapacity(size + 1);
		// Then it assigns the new item to the next available index in the 'items' array
		// and increments the 'size' counter
		items[size++] = item;
		// Returns 'true' to indicate that the addition was successful
		return true;
	}

	private void checkCapacity(int minCapacity) {
		int oldCapacity = items.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = oldCapacity * 2;
			items = Arrays.copyOf(items, newCapacity);
			System.out.println("New Capacity: " + newCapacity);
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		return (T) items[index];
	}

	// CHECK LIST

	// [x] - CHECK CAPACITY: in checkCapacity method
	// When an item is added, check to see if there is enough space
	// If not double the size, from 10
	// If there is enough space add the item

	// [x] - RESIZING: in checkCapacity method (maybe another method for this?)
	// If the current capacity isn't big enough, the ArrayList
	// will create an array with a larger capacity, double the current size
	// and then copy the existing elements from the old array to the new array

	// [x] - ADDING ELEMENT: in add method
	// Once there is enough space, the new element is placed in the next
	// position in the ArrayList. The ArrayList keeps track of the number
	// of elements it contains and updates this count accordingly

	// [x] - UPDATE SIZE: in add method
	// After adding the element, the size of the ArrayList is increased by
	// one to reflect the addition of the new element

	// REMOVE - Coming soon
	// Will need to remove an element down the line
	// Think about how you plan on making that happen

}
