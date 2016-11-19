package com.shrvn.ds.queue;

public class Josephus {
	/** Computes the winner of the Josephus problem using a circular queue. */

	public static <E> E JosephusWinner(CircularQueue<E> queue, int k) {
		if (queue.isEmpty()) 
			return null; 

		while (queue.size() > 1) {
			for (int i=0; i < k-1; i++) // skip past k-1 elements 
				queue.rotate();
			
			E e  = queue.dequeue();  // remove the front element from the collection
			System.out.println(" " + e + " is out"); // the winner
		}
		return queue.dequeue();
	}
	/* Builds a circular queue from an array of objects. */ 
	public static <E> CircularQueue<E> buildQueue(E a[]) {
		CircularQueue<E> queue = new LinkedCircularQueue<>();
		for (int i=0; i<a.length; i++)
			queue.enqueue(a[i]);
		
		return queue;
	}
	
	 /** Tester method */
	public static void main(String[] args) {
		String[] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred","kumar","shravan","selva"};
		/*CircularQueue<String> queue = new ArrayQueue<>(10);
		for (int j = 0; j < a1.length; j++) {
			queue.enqueue(a1[j]);	
		}
		queue.dequeue();
		queue.enqueue("ganesh");
		queue.enqueue("Ram");
		for (int i = 0; i < 10; i++) {
			System.out.println(queue.dequeue());	
		}*/
		
		
		String[] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"}; 
		String[] a3 = {"Mike", "Roberto"};
		
		System.out.println("First winner is " + JosephusWinner(buildQueue(a1), 3));
		System.out.println("Second winner is " + JosephusWinner(buildQueue(a2), 10));
		System.out.println("Third winner is " + JosephusWinner(buildQueue(a3), 7));
	}
}
