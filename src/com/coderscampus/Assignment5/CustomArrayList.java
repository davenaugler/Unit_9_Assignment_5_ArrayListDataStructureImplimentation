package com.coderscampus.Assignment5;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	private int defaultCapacity = 10;
	private Object[] items;
	private int size;

	public CustomArrayList() {
		items = new Object[defaultCapacity];
		size = 0;
	}

	@Override
	public boolean add(T item) {
		checkCapacity(size + 1);
		items[size++] = item;
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
