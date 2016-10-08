package com.shrvn.ds.linkedlist;

public class SinglyLinkedList<E> {
	// ---------------- nested Node class ---------------//
	private static class Node<E> {
		private E element;                     // reference to the element stored at this node
		private Node<E> next;                  // reference to the subsequent node in the list

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
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
	}

	// ----------- end of nested Node class -----------//

	// instance variables of the SinglyLinkedList
	private Node<E> head = null;               // head node of the list (or null if empty)
	private Node<E> tail = null;               // last node of the list (or null if empty
	private int size = 0;                      // number of nodes in the list

	public SinglyLinkedList() {
		// constructs an initially empty list
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @return head (but does not remove) the first element
	 */
	public E first() {
		if (isEmpty())
			return null;
		return head.getElement();
	}

	/**
	 * @return last (but does not remove) the last element
	 */
	public E last() {
		if (isEmpty())
			return null;
		return tail.getElement();
	}

	// -------Update methods of Singly Linked List------//

	/**
	 * Adds element e to the front of the list
	 * @param e
	 */
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0)
			tail = head;                       // special case: new node becomes tail also
		size++;
	}


	/**
	 * Adds element e to the end of the list
	 * @param e
	 */
	public void addLast(E e) { 
		Node<E> newest = new Node<>(e, null);  // node will eventually be the tail
		if (isEmpty())
			head = newest;                     // special case: previously empty list
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}

	/**
	 * Removes and returns the first element
	 * @return E
	 */
	public E removeFirst( ) {
		if (isEmpty( )) return null;
		E answer = head.getElement(); 
		head = head.getNext();
		size--;
		if (size == 0)
			tail = null; return answer;
	}

}
