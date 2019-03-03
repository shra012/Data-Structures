package com.shrvn.ds.linkedlist.ctci;

import com.shrvn.ds.linkedlist.SinglyLinkedList;

public class Runner {
    public static void main(String[] args) {
        Runner run = new Runner();
        SinglyLinkedList list = new SinglyLinkedList<Integer>();
        SinglyLinkedList list1 = new SinglyLinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);

        list1.addLast(1);
        list1.addLast(2);

        /*System.out.println(list.toString());
        run.printLinkedList(list.getMidNode());
        list.weave(list.getHead(),list.getMidNode());
        run.printLinkedList(list.getHead());*/

        run.printLinkedList(run.merge(list, list1));
    }


    public SinglyLinkedList.Node merge(SinglyLinkedList<Integer> list1, SinglyLinkedList<Integer> list2) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.addLast(0);
        SinglyLinkedList.Node<Integer> result = list.getHead();
        SinglyLinkedList.Node<Integer> head1 = list1.getHead();
        SinglyLinkedList.Node<Integer> head2 = list2.getHead();

        while (true) {
            if (head1 == null) {
                result.setNext(head2);
                break;
            } else if (head2 == null) {
                result.setNext(head1);
                break;
            } else {
                if (head1.getElement() > head2.getElement()) {
                    result.setNext(head2);
                    head2 = head2.getNext();
                } else {
                    result.setNext(head1);
                    head1 = head1.getNext();
                }
                result = result.getNext();
            }
        }
        return list.getHead().getNext();
    }

    SinglyLinkedList.Node sortedMerge(SinglyLinkedList.Node<Integer> headA, SinglyLinkedList.Node<Integer> headB) {
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
        SinglyLinkedList.Node<?> tempHead = node;
        while (tempHead != null) {
            System.out.print(tempHead.getElement());
            if (tempHead.getNext() != null)
                System.out.print(" ");
            tempHead = tempHead.getNext();
        }
        System.out.println("");
    }

}
