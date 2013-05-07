package sorting.simpleSorting;

import sorting.SortingImpl;
import sorting.Util;

/**
 * The bubble sort algorithm pushes big elements to the right or small elements to 
 * the left by exchanging adjacent elements. The algorithm must sort the elements from 
 * leftIndex to rightIndex (inclusive). 
 */
public class Bubblesort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		// A = [1,2,3,8,5,6] , n=2
		int n = rightIndex - leftIndex;
		
		for (int i=leftIndex; i<= rightIndex-1; i++){
			
			for (int j=leftIndex ; j<= rightIndex-1; j++){
				if ( array[j].compareTo(array[j+1]) > 0){
					Util.swap(array, j, j+1);
				}
					
			}
		}
	}

	
	
	
}

