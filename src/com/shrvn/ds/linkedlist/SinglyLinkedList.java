package com.shrvn.ds.linkedlist;

import java.util.Comparator;

import com.shrvn.ds.linkedlist.SinglyLinkedList.Node;

public class  SinglyLinkedList<E> {
	// ---------------- nested Node class ---------------//
	public static class Node<E> {
		private E element;                     // reference to the element stored at this node
		private Node<E> next;                  // reference to the subsequent node in the list

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public Node(E e) {
			element = e;
			next = null;
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

		@Override
		public String toString() { return element.toString(); }

		@Override
		public boolean equals(Object obj) {
			@SuppressWarnings("unchecked")
			E compareElement = ((Node<E>) obj).getElement();
			E element = this.getElement();
			if(element==null && compareElement==null) return true;
			if(element==null) return false;
			return element.equals(compareElement);
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

	public void increaseSize() {
		if(isEmpty()) return;
		size+=1;
	}

	public void decreaseSize() {
		if(isEmpty()) return;
		size-=1;
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
	 * @return head (but does not remove) the first element
	 */
	public Node<E> getHead() {
		if (isEmpty())
			return null;
		return head;
	}

	/**
	 * @return tail (but does not remove) the first element
	 */
	public Node<E> getTail() {
		if (isEmpty())
			return null;
		return tail;
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
	 *
	 * @param e The element to be added.
	 */
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0)
			tail = head;                       // special case: new node becomes tail also
		size++;
	}


	/**
	 * Adds element e to the end of the list
	 *
	 * @param e The element to be added.
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
	 *
	 * @return E The element that has been removed.
	 */
	public E removeFirst() {
		if (isEmpty()) return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0)
			tail = null;
		return answer;
	}

	// -------Detele methods of Singly Linked List------//


	/**
	 * Deletes the node of linked list by index.
	 * @param index the index which indicates the position of the node which is to be deleted.
	 * @return Node which has been removed.
	 */
	public Node<E> deleteByIndex(Integer index) {
		if (isEmpty() || index<0) return null;
		if(index > size()+1) return null;
		Node<E> current = head;
		if(index==0) {
			head = current.getNext();               // when the index is 0 replace head
		}

		for(int i=1 ; i<index;i++) {
			current = current.getNext();
		}
		if(index!=0) {
			current.setNext(current.getNext().getNext());
		}
		size--;

		if (size == 0)                              // special case : when the last node is deleted update tail.
			tail = null;

		if(size==index)
			tail=current;

		return current;
	}

	// -------Print methods of Singly Linked List------//

	/**
	 * Prints the contents of all the nodes of the linked list.
	 * @return String of printed elements of all nodes.
	 */
	@Override
	public String toString() {
		if (isEmpty())
			return "Empty";

		Node<E> node = head;
		StringBuilder result = new StringBuilder();
		for (int i = 0; ; i++) {
			result.append(node.element);
			if (i==size-1)
				return result.toString();                         // return the list when the size is met.
			result.append(" ");
			node = node.getNext();
		}
	}
	// -------Length methods of Singly Linked List------//

	/**
	 * Finds the length of the LinkedList recursively.
	 * @return Integer The length of the linked list.
	 */
	public Integer recursiveLength() {
		return  recursiveLength(head);
	}

	/**
	 * Finds the length of the LinkedList recursively.
	 * @param current the node which is to be incremented until the next link is null.
	 * * @return Integer The length of the linked list.
	 */
	private Integer recursiveLength(Node<E> current) {
		return current!=null ? recursiveLength(current.getNext())+1 : 0;
	}
	// -------Searching methods of Singly Linked List------//

	/**
	 * Check if the element exists in the LinkedList.
	 * @param element The element that needs to be searched.
	 * @return Boolean which indicates the element is added in the linked list.
	 */
	public Boolean recursiveSearch(E element) {
		if(null==element) return Boolean.FALSE;
		return contains(element,head);
	}

	/**
	 * Check if the LinkedList contains the element.
	 * @param element the element to be searched.
	 * @param current the node link to be looked through.
	 * @return Boolean which indicates the element is added in the linked list.
	 */
	private Boolean contains(E element,Node<E> current) {
		if(null==current) return Boolean.FALSE;
		return  element.equals(current.element) ? Boolean.TRUE : contains(element,current.getNext());
	}

	/**
	 * Finds the element at a given index from the last node.
	 * @param index the position of the element in the linked list that has to be returned.
	 * @return The element at the index.
	 */
	public E getNthNodeFromTail(Integer index){
		index = size-index+1;
		return getElement(index);
	}

	/**
	 * Finds the element at a given index.
	 * @param index the position of the element in the linked list that has to be returned.
	 * @return The element at the index.
	 */
	public E getElement(Integer index){
		if(head==null ) return null;
		Node<E> expected = getElement(head,index);
		return expected!=null?expected.getElement():null;
	}

	/**
	 * Takes head pointer of the linked list and index
	 * as arguments and return data at index
	 * @param current current the node in the given position in the linked list.
	 * @param index the current position of the node in the linked list.
	 * @return The element at the index.
	 */
	private Node<E> getElement( Node<E> current, Integer index) {
		assert (index<size && index>0): "Invalid index. The value is greater than or lesser than the size of linked list" ;
		int count = 1;

		//if count equal too n return node.data
		if(count == index)
			return current;

		//recursively decrease n and increase
		// head to next pointer
		return getElement(current.getNext(), index- 1);
	}

	/**
	 * To find the number of times the element passed exists in the linked list
	 * @param element The element for which
	 * @return
	 */
	public Integer countInstance(E element){
		if(isEmpty()) return null;
		return count(element,head,0);
	}

	/**
	 *
	 * @param element
	 * @param current
	 * @param count
	 * @return
	 */
	private Integer count(E element,Node<E> current,Integer count){
		if(current.getElement().equals(element)){
			count++;
		}
		return current.getNext()!=null ? count(element,current.getNext(),count):count;
	}

	// -------Sorting methods of Singly Linked List------//
	/**
	 * Uses Merge Sort to sort the linked list based on the comparator provided.
	 * @param c Comparator which compares two objects by the defined logic.
	 */
	public void sort(Comparator<? super E> c) {
		Node<E> sortedHead = mergeSort(getHead(),c);
		head = sortedHead;
	}
	/**
	 * The best sorting algorithm to get a sorted linked list in O(n log n)
	 * @param current Node which undergoes the sorting
	 * @param c Comparator which compares two objects by the defined logic.
	 * @return
	 */
	private Node<E> mergeSort(Node<E> current,Comparator<? super E> c) {
		if(isEmpty() || current.getNext()==null) return current;
		Node<E> midNode = getMidNode(current);
		Node<E> midNodeNext = midNode.getNext();
		midNode.setNext(null);
		//Runner run = new Runner();
		//System.out.print("First  :");
		//run.printLinkedList(current);
		//System.out.print("Second :");
		//run.printLinkedList(midNodeNext);
		Node<E> left = mergeSort(current,c);
		Node<E> right= mergeSort(midNodeNext,c);
		Node<E> result = sortedMerge(left,right,c);
		return result;
	}

	/**
	 * Merge two sorted linked list.
	 * @param first Node object which is to be merged with <code>second</code> list
	 * @param second Node object which is to be merged with <code>first</code> list
	 * @param c Comparator which compares two objects is used for the merge to maintain the sorted order.
	 * @return Node the head <code>Node</code> of the linked list
	 */
	private Node<E> sortedMerge(Node<E> first,Node<E> second,Comparator<? super E> c){
		Node<E> newNodeHead = new Node<E>(first.getElement());
		Node<E> newNode = newNodeHead;
		while(first!=null || second!=null) {
			if(first==null) {
				newNode.setNext(second);
				second=second.getNext();
			}else if(second==null) {
				newNode.setNext(first);
				first=first.getNext();
			}else if(c.compare(first.getElement(), second.getElement()) >= 0 ) {
				newNode.setNext(second);
				second=second.getNext();
			}else {
				newNode.setNext(first);
				first=first.getNext();
			}
			newNode = newNode.getNext();
		}
		return newNodeHead.getNext();
	}
	// -------Special Techniques of Singly Linked List------//
	public void removeDuplicates(){
		if(isEmpty()) return;
		removeDuplicates(head);
	}

	public void removeDuplicates(Node<E> current){

		if(current.getNext()==null) return;
		if(current.getElement() == current.getNext().getElement() ) {
			current.setNext(current.getNext().getNext());
			removeDuplicates(current);
		}else {
			removeDuplicates(current.getNext());
		}
	}
	public void abolishDuplicates(){
		Node<E> current = head;
		while(current!=null){
			Node<E> previous = current;
			Node<E> after = current.getNext();
			while(after!=null){
				if(current.getElement().equals(after.getElement())){
					previous.setNext(after.getNext());
					decreaseSize();
					after = after.getNext();
				}else {
					previous = after;
					after = after.getNext();
				}
			}
			current=current.getNext();
		}
	}
	/**
	 * Used the Runner Technique to find the middle node of the linked list
	 * @return Node<E> The middle node of the linked list.
	 */
	public Node<E> getMidNode(Node<E> current) {
		//basic checks
		if(current==null) return null;
		if(current.getNext()==null) return current;
		//implementation
		Node<E> fastPointer = current.getNext();
		Node<E> slowPointer = current;

		while (fastPointer!=null && fastPointer.getNext() != null) {
			fastPointer = fastPointer.getNext().getNext();         // fast pointer updates two nodes per iteration
			slowPointer = slowPointer.getNext();                     // slow pointer updates each node per iteration
		}
		return slowPointer;
	}
	/**
	 * Used the Runner Technique to find the middle node of the linked list
	 * @return Node<E> The middle node of the linked list.
	 */
	public Node<E> getMidNode() {
		return getMidNode(getHead());
	}

	/**
	 * Use this method to perform weaving of linked list.
	 * @param first - Node of the first list
	 * @param second - Node of the second list
	 */
	public void weave(Node<E> first, Node<E> second){
		while (second != null && first!=null) {
			Node<E> tempFirst = first.getNext();
			Node<E> tempSecond = second.getNext();
			if(second.getNext()==null){                   // breaking case when the second sets of nodes ends.
				first.setNext(second);
				tail=second;
				break;
			}
			second.setNext(first.getNext());
			first.setNext(second);
			first = tempFirst;
			second = tempSecond;
		}
	}
}
