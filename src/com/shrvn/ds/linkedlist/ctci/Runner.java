package com.shrvn.ds.linkedlist.ctci;

import com.shrvn.ds.linkedlist.DoublyLinkedList;
import com.shrvn.ds.linkedlist.SinglyLinkedList;
import com.shrvn.ds.linkedlist.SinglyLinkedList.Node;
import com.shrvn.ds.stack.ArrayStack;

public class Runner {
	public static void main(String[] args) throws Exception {
		Runner run = new Runner();
		/**
		 * Test for Runner Technique and Weaving Algorithms. 
		 */
		/*SinglyLinkedList<Integer> list = createList(1,2);
        System.out.println(list.toString());
        run.printLinkedList(list.getMidNode());
        list.weave(list.getHead(),list.getMidNode().getNext());
        run.printLinkedList(list.getHead());*/
		//run.printLinkedList(run.sortedMerge(list.getHead(), list1.getHead()));
		/**
		 * Check for delete by index
		 */
		/*list.deleteByIndex(0);
        System.out.println(list.first());
        System.out.println(list.last());
        run.printLinkedList(list.getHead());*/
		/**
		 * Check for length by recursion
		 */
		/*System.out.println(list.recursiveLength());
        System.out.println(list.size());*/
		/**
		 * Check for length by recursion
		 */
		/*System.out.println(list.recursiveSearch(11));*/
		/**
		 * Check for Loops in linked list and length of loop
		 */
		/* list.getTail().setNext(list.getMidNode());*/
		/*System.out.println(run.getLength(list.getHead()));*/
		/**
		 * Check id a given characters in a linked list is a Palindrome
		 */
		/*SinglyLinkedList<Character> list = createList('R','A','D','A','R');
        run.printLinkedList(list.getHead());
        System.out.println(run.checkPalindrome(list));*/
		/**
		 * Remove the duplicates in a given in a sorted linked list 
		 */
		/*SinglyLinkedList<Integer> list = createList(1,2,2,2,3,3,3,23,23);
        run.printLinkedList(list.getHead());
        //System.out.println(run.removeDuplicate(list));
        run.removeRecursiveDuplicate(list.getHead());
        run.printLinkedList(list.getHead());*/
		/**
		 * Check if two lists are unique or equal 
		 */
		SinglyLinkedList<Integer> list = createList(1,2,2,2,3,3,3,23,23);
		DoublyLinkedList<Integer> list1 = createDoublyList(1,3,2,2,3,3,3,23,23);
        System.out.println(list.equals(list1));
		/**
		 * Remove the duplicates in a given un-sorted linked list 
		 * Method 1 : Brute Force.
		 */
		/*SinglyLinkedList<Integer> list = createList(1,2,2,2,3,3,3,23,23);
		list.abolishDuplicates();
		run.printLinkedList(list.getHead());*/
		/**
		 * Remove the duplicates in a given un sorted linked list by 
		 * Method 2 : Sorting and removing duplicates from sorted linked list.
		 */
		/*SinglyLinkedList<Integer> list = createList(1,2,2,2,3,3,3,23,23);
		Comparator<Integer> c = (x,y) -> (x < y) ? -1 : ((x == y) ? 0 : 1);
		list.sort(c);
		run.printLinkedList(list.getHead());
		list.removeDuplicates();
		run.printLinkedList(list.getHead());*/
		/**
		 * Method to swap two nodes
		 */

		/*
		 * SinglyLinkedList<Integer> list = createList(1,2,3,4,5);
		 * run.printLinkedList(list.getHead()); run.swap(list, 1, 4);
		 * run.printLinkedList(list.getHead());
		 */
	}

	/* ******** Method for Swapping two Nodes of a linked list ******** */
	public <E> SinglyLinkedList<E> swap(SinglyLinkedList<E> list,E first,E second) throws Exception{
		if(list.isEmpty()) return null;
		// Store the references of the Previous Node Current Node and the Next Node.
		Node<E> previous=null,
				firstPrevious=null,secondPrevious=null,
				firstNode=null,secondNode=null,
				secondNext=null,firstNext=null;
		
		Node<E> current = list.getHead();
		// Loop through all the elements to find if both the values exists and store all the required references.
		while(current.getNext()!=null){
			if(current.getElement().equals(first)) {
				firstPrevious = previous;
				firstNode = current;
				firstNext = firstNode.getNext();
			}else if(current.getElement().equals(second)) {
				secondPrevious = previous;
				secondNode = current;
				secondNext = secondNode.getNext();
			}
			previous = current;
			current = current.getNext();
		}
		// Update the tail accordingly.
		if(secondNext==null) {
			list.setTail(firstNode);
		}else if(firstNext == null) {
			list.setTail(secondNode);
		}
			
		if(firstNode== null || secondNode == null) {
			throw new Exception("The Requested Element does not exists in the list");
		}else {// If first element is not head of linked list 
			if (firstPrevious != null) 
				firstPrevious.setNext(secondNode);
			else //If first element is the head of linked list 
				list.setHead(secondNode); 

			// If second element is not head of linked list 
			if (secondPrevious != null) 
				secondPrevious.setNext(firstNode); 
			else // If second element is the head of linked list 
				list.setHead(firstNode);
		}
		// Swap next pointers 
		Node<E> temp = firstNode.getNext(); 
		firstNode.setNext(secondNode.getNext()); 
		secondNode.setNext(temp); 

		return list;
	}


	/* Methods for removing Duplicates start*/
	public <E> SinglyLinkedList<E> removeDuplicate(SinglyLinkedList<E> list){
		Node<E> current = list.getHead();
		if(list.isEmpty()) return null;
		while(current.getNext()!=null){
			if(current.getElement() == current.getNext().getElement() ) {
				current.setNext(current.getNext().getNext());
				list.decreaseSize();
			}else {
				current = current.getNext();
			}

		}
		return list;
	}

	public <E> void removeRecursiveDuplicate(Node<E> current){
		if(current.getNext()==null) return;
		if(current.getElement() == current.getNext().getElement() ) {
			current.setNext(current.getNext().getNext());
			removeRecursiveDuplicate(current);
		}else {
			removeRecursiveDuplicate(current.getNext());
		}
	}

	/* ******** Methods for removing Duplicates end ******** */

	/* Method for creating the Linked List */
	@SafeVarargs // Added safe variable arguments to avoid heap pollution Refer https://softwareengineering.stackexchange.com/questions/155994/java-heap-pollution.
	public static <E> SinglyLinkedList<E> createList(E... args){
		SinglyLinkedList<E> list = new SinglyLinkedList<E>();
		for(E arg : args){
			list.addLast(arg);
		}
		return list;
	}
	/* Method for creating the Linked List */
	@SafeVarargs // Added safe variable arguments to avoid heap pollution Refer https://softwareengineering.stackexchange.com/questions/155994/java-heap-pollution.
	public static <E> DoublyLinkedList<E> createDoublyList(E... args){
		DoublyLinkedList<E> list = new DoublyLinkedList<E>();
		for(E arg : args){
			list.addLast(arg);
		}
		return list;
	}
	/* ******** Method for creating the Linked List ******** */

	/* Method for checking if the elements are Palindrome */
	public Boolean checkPalindrome(SinglyLinkedList<?> list){
		Node<?> node = list.getHead();
		ArrayStack<Node<?>> stack = new ArrayStack<Node<?>>();
		if(list.isEmpty()) return Boolean.FALSE;
		while(node!=null){
			stack.push(node);
			node = node.getNext();
		}
		node = list.getHead();
		while(node!=null){
			Node<?> poppedNode = stack.pop();
			if(poppedNode.equals(node)) {
				node = node.getNext();
				continue;
			}
			else
				return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	/* ******** Method for checking if the elements are Palindrome ******** */

	/* Method for merging two sorted linked list and maintain the sorted order in the newly created list */
	SinglyLinkedList.Node<Integer> sortedMerge(SinglyLinkedList.Node<Integer> headA, SinglyLinkedList.Node<Integer> headB) {

		/* a dummy first node to hang the result on */
		SinglyLinkedList.Node<Integer> dummyNode = new SinglyLinkedList.Node<Integer>(0, null);

		/* tail points to the last result node */
		SinglyLinkedList.Node<Integer> tail = dummyNode;
		while (true) {

			/* if either list runs out,use the other list */
			if (headA == null) {
				tail.setNext(headB);
				break;
			}
			if (headB == null) {
				tail.setNext(headA);
				break;
			}

			/* Compare the data of the two lists whichever lists' data is smaller, append it into tail and advance the head to the next Node */
			if (headA.getElement() <= headB.getElement()) {
				tail.setNext(headA);
				headA = headA.getNext();
			} else {
				tail.setNext(headB);
				headB = headB.getNext();
			}

			/* Advance the tail */
			tail = tail.getNext();
		}
		return dummyNode.getNext();
	}

	/* ******** Method for merging two sorted linked list ******** */


	public void printLinkedList(SinglyLinkedList.Node<?> node) {
		if(node==null) return;
		SinglyLinkedList.Node<?> tempHead = node;
		while (tempHead != null) {
			System.out.print(tempHead.getElement());
			if (tempHead.getNext() != null)
				System.out.print(" ");
			tempHead = tempHead.getNext();
		}
		System.out.println("");
	}

	/* Finding the length of a loop in a chained linked list */
	public <E> Integer getLength(Node<E> current) {
		Node<E> fp = current;
		Node<E> sp = current;
		while (fp!=null && fp.getNext() != null) {
			fp = fp.getNext().getNext();         // fast pointer updates two nodes per iteration
			sp = sp.getNext();                     // slow pointer updates each node per iteration
			if(fp.equals(sp))
				return countNodes(sp);
		}
		return null;
	}

	public <E> Integer countNodes(Node<E> sp){
		Node<E> current = sp;
		int count = 0;
		while(current!=null){
			current=current.getNext();
			count++;
			if(sp.equals(current))
				return count;
		}
		return count;
	}

	/* ******** Finding the length of a loop in a chained linked list ******** */

}
