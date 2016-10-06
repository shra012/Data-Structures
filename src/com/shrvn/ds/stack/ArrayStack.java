/**
 * 
 */
package com.shrvn.ds.stack;


/**
 * ArrayStack class is the implementation of Abstract Data Type
 * stack with array.
 * @author shravan
 *
 * @param Any Wrapper class can be used, this is achieved by java generics
 */
public class ArrayStack<E> implements Stack<E>   {

	public static final int CAPACITY =1000;  // default array capacity
	private E[] data;                        // generic array used for storage
	private int topIndex=-1;                 // index of the top element in stack

	public ArrayStack() {
		this(CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
	}
	
	
	/**
	 * @return the current stack of specified value
	 */
	public E[] getData() {
		return data;
	}

	/* (non-Javadoc)
	 * @see com.shrvn.ds.stack.Stack#size()
	 */
	@Override
	public int size() {
		return (topIndex+1);
	}
	
	/* (non-Javadoc)
	 * @see com.shrvn.ds.stack.Stack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return (topIndex==-1);
	}

	/* (non-Javadoc)
	 * @see com.shrvn.ds.stack.Stack#push(java.lang.Object)
	 */
	@Override
	public void push(E stack) {
		if(size()==data.length)
			throw new IllegalStateException("Stack is full dude :(");

		data[++topIndex]=stack;
	}

	/* (non-Javadoc)
	 * @see com.shrvn.ds.stack.Stack#top()
	 */
	@Override
	public E top() {
		if(isEmpty()){
			return null;	
		}
		return data[topIndex];
	}

	/* (non-Javadoc)
	 * @see com.shrvn.ds.stack.Stack#pop()
	 */
	@Override
	public E pop() {
		if(isEmpty()){
			return null;	
		}
		E value = data[topIndex];
		data[topIndex]=null;
		topIndex--;
		return value;
	}
	
	/**
	 * Prints the value inside stack
	 * @param e array of elements that is to be printed
	 */
	public void printStack(Object[] stack) {
		if(isEmpty()){
			System.out.println("Stack is empty dude :(");
		}
		for (int i = 0; i < stack.length; i++) {
			if(null==stack[i]){
				break;
			}
			System.out.println(stack[i]+" ");
		}

	}

}
