package sorting.variationsOfBubblesort;

import sorting.SortingImpl;
import sorting.Util;

/**
 * The combsort algoritm.
 */
public class Combsort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		combsort(array, leftIndex, rightIndex);
	}

	
	
	private void combsort(T[] array, int leftIndex, int rightIndex) {
		int gap = array.length;
		
		boolean swapped = true;
		
		while (gap > 1 || swapped) {
			if (gap > 1)
				gap = (int) (gap / 1.25);

			int i = leftIndex;
			swapped = false;
			while (i + gap < rightIndex) {
				if (array[i].compareTo(array[i + gap]) > 0) {
					Util.swap(array, i, i+gap);
					swapped = true;
				}
				i++;
			}
		}

	}
}

