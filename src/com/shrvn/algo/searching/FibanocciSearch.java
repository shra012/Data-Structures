package com.shrvn.algo.searching;


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

	public static void main(String[] args) {
		int arr[] = {2, 3, 4, 10, 40};
		FibanocciSearch search = new FibanocciSearch();
		search.doSearch(arr);
	}

	public int doSearch(int[] arr){
		int length = arr.length;

		return 0;
	}

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
        while(number>=current){
            int newCurrent = getNextFibannoci(previous,current);
            previous=current;
            current=newCurrent;
        }
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
