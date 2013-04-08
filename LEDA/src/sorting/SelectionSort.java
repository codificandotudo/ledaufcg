package sorting;

/**
 * One of the simplest sorting algorithms works as follows:
 * First, find the smallest element in array, and exchange it
 * with the element in the first position. Then, the second smallest
 * element and exchange it with the second position. Continue this
 * way until the entire array is sorted. This method is called
 * selection sort.
 * 
 * @version 1.0 2013/04/05
 * @author Samuel T. C. dos Santos
 * 
 * @see <a href="http://code.google.com/p/ledaufcg/">Selection Sort</a>
 * 
 * @param <T>
 */
public class SelectionSort<T extends Comparable<T>> implements Sorting<T> {

	/**
	 * Sorting an generic array.
	 *  
	 * @param array
	 */
	public void sort(T[] array){
		for (int i=0; i < array.length-1; i++){
			int index = smallest(i, array);
			Util.swap(array, index, i);
		}
	}

	/**
	 * Find the smallest element into the array.
	 * 
	 * @param beginIndex the index of begin search.
	 * @param array an array 
	 * 
	 * @return the position of the smallest value.
	 */
	public int smallest(int beginIndex , T[] array){
		int smallestIndex = beginIndex;
		for(int i = beginIndex + 1; i< array.length; i++){
			if (array[i].compareTo(array[smallestIndex]) < 0){
				smallestIndex = i;
			}
		}
		return smallestIndex;
	}

}
