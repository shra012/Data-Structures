package com.shrvn.ds.linkedlist;

public class DoublyLinkedList<E> {
	// ---------------- nested Node class ---------------//
	private static class Node<E> {
		private E element; // reference to the element stored at this node
		private Node<E> next; // reference to the subsequent node in the list
		private Node<E> prev; // reference to the previous node in the list

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			next = n;
			prev = p;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> n) {
			next = n;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		@Override
		public String toString() {
			return (element != null) ? element.toString() : "";

		}
	}

	// instance variables of the SinglyLinkedList
	private Node<E> header = null; // head node of the list (or null if empty)
	private Node<E> trailer = null; // last node of the list (or null if empty
	private int size = 0; // number of nodes in the list

	public DoublyLinkedList() {
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, header, null);
		header.setNext(trailer);
	}

	/** Returns the number of elements in the linked list. */
	public int size() {
		return size;
	}

	/** Tests whether the linked list is empty. */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Returns (but does not remove) the first element of the list. */
	public E first() {
		if (isEmpty())
			return null;
		return header.getNext().getElement();
	}

	/** Returns (but does not remove) the last element of the list. */
	public E last() {
		if (isEmpty())
			return null;
		return trailer.getPrev().getElement();
	}

	// public update methods
	/** Adds element e to the front of the list. */
	public void addFirst(E e) {
		addBetween(e, header, header.getNext()); // place just after the header
	}

	/** Adds element e to the end of the list. */
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
	}

	/** Removes and returns the first element of the list. */
	public E removeFirst(E e) {
		if (isEmpty( )) return null;
		return remove(header.getNext()); // place just before the trailer
	}

	/** Removes and returns the last element of the list. */
	public E removeLast(E e) {
		return remove(trailer.getPrev()); // place just before the trailer
	}

	// private update methods
	/** Adds element e to the linked list in between the given nodes. */
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newNode = new Node<E>(e, predecessor, successor);
		predecessor.setNext(newNode);
		successor.setPrev(newNode);
		size++;
	}

	/** Removes the given node from the list and returns its element. */
	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}

}
