package com.shrvn.ds.queue;

import com.shrvn.ds.linkedlist.CircularlyLinkedList;

public class LinkedCircularQueue<E> implements CircularQueue<E> {
	private CircularlyLinkedList<E> list = new CircularlyLinkedList<>(); // an empty list
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		list.addLast(e);

	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		return list.first();
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}

	@Override
	public void rotate() {
		list.rotate();	
	}

}
