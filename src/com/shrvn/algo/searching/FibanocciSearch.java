package com.shrvn.algo.searching;


import java.util.Arrays;

/**
 *  Input:  arr[] = {2, 3, 4, 10, 40}, x = 10
	Output:  3
	Element x is present at index 3.

	Input:  arr[] = {2, 3, 4, 10, 40}, x = 11
	Output:  -1
	Element x is not present.
 * @author shravan
 *
 */
public class FibanocciSearch {
    int [] fibanocci;
	public static void main(String[] args) {
		int arr[] = {2, 3, 4, 10, 40};
		FibanocciSearch search = new FibanocciSearch();
        System.out.println(search.doSearch(arr,4));
	}

	public int doSearch(int[] arr,int x){
		int length = arr.length;
		getNearestFibannoci(length);
        int fibMMm2 = fibanocci[fibanocci.length-3]; // (m-2)'th Fibonacci No.
        int fibMMm1 = fibanocci[fibanocci.length-2]; // (m-1)'th Fibonacci No.
        int fibM = fibanocci[fibanocci.length-1];
        int offset = -1;
        while (fibM > 1)
        {
            // Check if fibMm2 is a valid location
            int i = min(offset+fibMMm2, length-1);

            /* If x is greater than the value at
            index fibMm2, cut the subarray array
            from offset to i */
            if (arr[i] < x)
            {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            }

            /* If x is greater than the value at index
            fibMm2, cut the subarray after i+1 */
            else if (arr[i] > x)
            {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            }

            /* element found. return index */
            else return i;
        }

        /* comparing the last element with x */
        if(fibMMm1 == 1 && arr[offset+1] == x)
            return offset+1;

        return -1;
	}

    public static int min(int x, int y)
    { return (x <= y)? x : y; }

    /**
     * Returns the nearest fibanocci number
     * @param number the number to which we have to find the nearest fibanocci number
     * @return
     */
    public int getNearestFibannoci(int number){
        if(number <= 0) return 0;
        if(number == 1) return 1;
        return getNearestFibannoci(number,1,1);
    }

    /**
     * Returns the nearest fibanocci number
     * @param number the number to which we have to find the nearest fibanocci number
     * @return
     */
    public int getNearestFibannoci(int number,int previous,int current){
        int i=1;
        fibanocci = new int[i];
        while(number>=current){
            int newCurrent = getNextFibannoci(previous,current);
            previous=current;
            current=newCurrent;
            fibanocci[i-1]=previous;
            i++;
            fibanocci = Arrays.copyOf(fibanocci,i);
        }
        fibanocci[i-1] = current;
        return current;
    }

    /**
     * Returns the next fibanocci
     * @param previous previous fibanocci number
     * @param current current fibanocci number
     * @return
     */
	public int getNextFibannoci(int previous,int current){
	    return previous+current;
    }
}
