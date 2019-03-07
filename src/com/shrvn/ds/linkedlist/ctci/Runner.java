package com.shrvn.ds.linkedlist.ctci;

import com.shrvn.ds.linkedlist.SinglyLinkedList;
import com.shrvn.ds.linkedlist.SinglyLinkedList.Node;
import com.shrvn.ds.stack.ArrayStack;
import com.shrvn.ds.stack.Stack;

public class Runner {
    public static void main(String[] args) {
        Runner run = new Runner();
        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();
        //SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
        list.addLast('T');
        list.addLast('X');
        list.addLast('X');
        list.addLast('T');
        

        /*System.out.println(list.toString());
        run.printLinkedList(list.getMidNode());
        list.weave(list.getHead(),list.getMidNode());
        run.printLinkedList(list.getHead());*/
        run.printLinkedList(list.getHead());
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

        System.out.println(run.checkPalindrome(list));

        
    }

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

    SinglyLinkedList.Node<Integer> sortedMerge(SinglyLinkedList.Node<Integer> headA, SinglyLinkedList.Node<Integer> headB) {
    /* a dummy first node to
       hang the result on */
        SinglyLinkedList.Node<Integer> dummyNode = new SinglyLinkedList.Node<Integer>(0, null);

    /* tail points to the
    last result node */
        SinglyLinkedList.Node<Integer> tail = dummyNode;
        while (true) {

        /* if either list runs out,
        use the other list */
            if (headA == null) {
                tail.setNext(headB);
                break;
            }
            if (headB == null) {
                tail.setNext(headA);
                break;
            }

        /* Compare the data of the two
        lists whichever lists' data is
        smaller, append it into tail and
        advance the head to the next Node
        */
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

    public Integer getLength(Node current) {
        Node<?> fp = current;
        Node<?> sp = current;
        while (fp!=null && fp.getNext() != null) {
            fp = fp.getNext().getNext();         // fast pointer updates two nodes per iteration
            sp = sp.getNext();                     // slow pointer updates each node per iteration
            if(fp.equals(sp))
              return countNodes(sp);
        }
        return null;
    }

    public Integer countNodes(Node<?> sp){
        Node<?> current = sp;
        int count = 0;
        while(current!=null){
            current=current.getNext();
            count++;
            if(sp.equals(current))
                return count;
        }
        return count;
    }

}
