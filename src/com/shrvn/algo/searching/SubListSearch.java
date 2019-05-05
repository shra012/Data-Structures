package com.shrvn.algo.searching;

import com.shrvn.ds.linkedlist.SinglyLinkedList;
import com.shrvn.ds.linkedlist.SinglyLinkedList.Node;

import java.util.Arrays;

public class SubListSearch {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> firstList = SinglyLinkedList.createList(4,5,6,7);
        SinglyLinkedList<Integer> secondList = SinglyLinkedList.createList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(new SubListSearch().sublistSearch(firstList,secondList));

    }

    public <E> boolean sublistSearch(SinglyLinkedList<E> firstList , SinglyLinkedList<E> secondList){
        Node<E> firstCurrent = firstList.getHead();
        Node<E> secondCurrent = secondList.getHead();
        Node<E> secondPosition = secondList.getHead();
        while(firstCurrent!=null && secondCurrent!=null){

            if(firstCurrent.getElement().equals(secondCurrent.getElement())){
                firstCurrent = firstCurrent.getNext();
                secondCurrent = secondCurrent.getNext();
                if(firstCurrent==null){
                   return true;
                }
            }else{
                firstCurrent = firstList.getHead();
                secondCurrent = secondPosition.getNext();
                secondPosition = secondPosition.getNext();
            }
        }
        return false;
    }
}
