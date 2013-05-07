package sorting.variationsOfBubblesort;

import sorting.SortingImpl;
import sorting.Util;

/**
 * The implementation of the algorithm must be in-place! 
 */
public class Gnomesort<T extends Comparable<T>> extends SortingImpl<T>{
	

protected void sort(T[] array,int leftIndex, int rightIndex){
	
	if (leftIndex > rightIndex) return;
	
	gnomesort(array, leftIndex, rightIndex);
}

private void gnomesort(T[] array, int leftIndex, int rightIndex) {
int position = leftIndex+1;
	
	while(position <= rightIndex){
		if ( array[position].compareTo(array[position-1]) >= 0){
			position = position+1;
		}
		else{
			Util.swap(array, position, position-1);
			if (position > 1){
				position = position - 1;
			}
			else{
				position = position + 1;
			}
		}
	}
	
}
	
	
}
