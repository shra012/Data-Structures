package com.shrvn.ds.queue;

public class ArrayQueue<E>  implements Queue<E>,CircularQueue<E> {
	private E[] data;
	private int topIndex = 0;
	private int size = 0;
	public static final int CAPACITY=1000;
	
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}
	
	public int size() { 
		return size; 
	}

	public boolean isEmpty() { 
		return (size == 0);
	}

	public void enqueue(E e) throws IllegalStateException {
		if (size() == data.length) 
			throw new IllegalStateException("Queue is full");
		
		int available = (topIndex + size) % data.length; // use modular arithmetic
		data[available] = e;
		size++;
	}

	public E first() {
		if (isEmpty()) return null;
		return data[topIndex];
	}

	public E dequeue() {
		if (isEmpty()) 
			return null;

		E answer = data[topIndex];
		data[topIndex] = null;
		topIndex = (topIndex + 1) % data.length;
		size--;
		return answer;
	}

	@Override
	public void rotate() {
		
	}
}