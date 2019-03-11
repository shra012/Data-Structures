package com.shrvn.ds.linkedlist.ctci;

import com.shrvn.ds.linkedlist.SinglyLinkedList;
import com.shrvn.ds.linkedlist.SinglyLinkedList.Node;
import com.shrvn.ds.stack.ArrayStack;

public class Runner {
    public static void main(String[] args) {
        Runner run = new Runner();

        /*System.out.println(list.toString());
        run.printLinkedList(list.getMidNode());
        list.weave(list.getHead(),list.getMidNode());
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
        SinglyLinkedList<Integer> list = createList(1,2,2,2,3,3,3,23,23);
        run.printLinkedList(list.getHead());
        //System.out.println(run.removeDuplicate(list));
        run.removeRecursiveDuplicate(list.getHead());
        run.printLinkedList(list.getHead());
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
    @SafeVarargs // Added safe variable arguments to avoid heap pollution.
	public static <E> SinglyLinkedList<E> createList(E... args){
        SinglyLinkedList<E> list = new SinglyLinkedList<E>();
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
