package com.coderscampus.Assignment5;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	private int initialCapacity = 10; // Integer that sets the initial capacity of the array to a list of 10.
	private Object[] items; // 'items' is an array of Object. Stores the items in the array list.
	private int size; // Keeps track of the number of items currently in the list.

	// Constructor initializes the 'items' array with the initialCapacity and sets
	// the initial 'size' to 0.
	public CustomArrayList() {
		items = new Object[initialCapacity];
		size = 0;
	}

	// The 'add' method takes an item of type 'T', ('T' is a generic), as an
	// argument and adds it to the array list.
	@Override
	public boolean add(T item) {
		// First it checks the current size of the list plus one exceeds the current
		// capacity. If so, it invokes the 'checkCapacity' method to increase the
		// capacity of the list.
		checkCapacity(size + 1);
		// Then it assigns the new item to the next available index in the 'items' array
		// and increments the 'size' counter.
		items[size++] = item;
		// Returns 'true' to indicate that the addition was successful.
		return true;
	}

	// The 'checkCapacity' is a helper method used by the 'add' method to ensure
	// that the array has enough capacity to accommodate the desired size
	private void checkCapacity(int minCapacity) {
		// It calculates the old capacity of the array
		int oldCapacity = items.length;
		// If the minimum capacity is greater than the old capacity, it doubles the
		// old capacity to get a new capacity and then uses 'Arrays.copyOf' to create a
		// new array with the new capacity and copies the elements from the old array to
		// the new one. This array is responsible for dynamically resizing the array
		// when necessary.
		if (minCapacity > oldCapacity) {
			int newCapacity = oldCapacity * 2;
			items = Arrays.copyOf(items, newCapacity);
			System.out.println("New Capacity: " + newCapacity);
		}
	}

	// The 'getSize' method returns the current size of the dynamic array list.
	@Override
	public int getSize() {
		return size;
	}

	// The 'get' method takes an index as an argument and retrieves the item at that
	// index in the array.
	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		// It first checks if the index is within the valid range (between 0 and 'size - 1')
		// If not, it throws an 'IndexOutOfBoundsException.'
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		// It then casts the item stored at the specified index to type 'T' and returns it.
		return (T) items[index];
	}
	// REMOVE - Coming soon
	// Will need to remove an element down the line
	// Think about how you plan on making that happen
}
