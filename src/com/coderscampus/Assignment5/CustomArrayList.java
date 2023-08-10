package com.coderscampus.Assignment5;

public class CustomArrayList<T> implements CustomList<T> {
	// backed by a real Java array
	// When you add more than 10 elements it should 
	// increase in size automatically
	// When adding a new element, if the backing Object array is full, 
	// you should have the array double in size.
	Object[] items = new Object[10];

	@Override
	public boolean add(T item) {
		// fill this with the content required to successfully add
		return false;
	}

	@Override
	public int getSize() {
		// fill this with the content required to getSize();
		return 0;
	}

	@Override
	public T get(int index) {
		// fill this with the content required to get();
		return null;
	}

}
