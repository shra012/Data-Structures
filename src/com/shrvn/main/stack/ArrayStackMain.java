package com.shrvn.main.stack;

import java.util.Scanner;

import com.shrvn.ds.stack.ArrayStack;
import com.shrvn.ds.stack.Stack;

public class ArrayStackMain<E>{
	/**
	 * Driver method to test my array stack
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Welcome To Shravan ArrayStack");
		Scanner sc = new Scanner(System.in);
		String input=null;
		ArrayStackMain<Integer> stack = new ArrayStackMain<>();
		Stack<Integer> S = new ArrayStack<>();
		do{
			System.out.println("Please select a option");
			System.out.println("1.push");
			System.out.println("2.pop");
			System.out.println("3.top");
			System.out.println("4.size");
			System.out.println("5.print Stack");
			String swicth = sc.next();
			stack.switchCase(swicth,S,sc);
			System.out.println("Do you want to continue? (Y/N)");
			input = sc.next();
			if(!("Y".equals(input) ||  "N".equals(input))){
				System.out.println("Sorry Wrong input.. Please enter Y or N");
				input=sc.next();
			}
		}while("Y".equals(input));
		System.out.println("Thank You :) ");
		sc.close();

		
		/*Stack<Integer> S = new ArrayStack<>();
		S.push(5);
		S.push(3);
		System.out.println(S.size());
		System.out.println(S.pop());
		System.out.println(S.isEmpty());
		System.out.println(S.pop());
		System.out.println(S.isEmpty());
		System.out.println(S.pop());
		S.push(7);
		S.push(9); System.out.println(S.top());
		S.push(4); System.out.println(S.size());
		System.out.println(S.pop());
		S.push(6);
		S.push(8);
		S.push(223);
		System.out.println(S.pop());
		ArrayStack<Integer> A=(ArrayStack<Integer>) S;
		A.printStack(A.getData());*/
	}
	@SuppressWarnings("unchecked")
	public void switchCase(String expression,Stack<E> s,Scanner sc){


		switch(expression) {
		case "1" :
			Integer integer=null;
				System.out.println("Enter the element to push");
				integer=sc.nextInt();	
			s.push((E) integer);
			switchCase("5",s,sc);
			break; // optional

		case "2" :
			s.pop();
			switchCase("5",s,sc);
			break; // optional
		case "3" :
			s.top();
			switchCase("5",s,sc);
			break; // optional
		case "4" :
			System.out.println("size of stack"+s.size());
			break; // optional
		case "5" :
			ArrayStack<Integer> A=(ArrayStack<Integer>) s;
			A.printStack(A.getData());
			break; // optional

			// You can have any number of case statements.
		default : // Optional
			System.out.println("Sorry Wrong Option ...");
		}
	}
}
