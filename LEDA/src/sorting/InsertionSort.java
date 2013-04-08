package sorting;

/**
 * The method that people often use to sort bridge hands is to
 * considerer the cards one at a time, inserting each into its proper
 * place among those already considered (keeping them sorted). In a
 * computer implementation, we need to make space for element being 
 * inserted by moving larger elements one position to the right, and then
 * inserting the element into the vacated position. 
 * 
 * This code is a java implementation of this method, which is called
 * insertion sort.
 * 
 * @version 1.0 2013/04/06
 * @author Samuel T. C. Santos
 * 
 * @see <a href="http://code.google.com/p/ledaufcg/">Selection Sort</a>
 * 
 * @param <T>
 */
public class InsertionSort<T extends Comparable<T>> implements Sorting<T> {

	@Override
	public void sort(T[] array) {
		for (int i=0; i< array.length; i++){
			int smallestIndex = smallest(i, array);
			
			//store the value
			T key = array[smallestIndex];
			
			//shift in the element unsorted
			int j;
			for (j=smallestIndex; j > i; j--)
				Util.swap(array, j, j-1);			
			
			//shift and find the correct position to insert.
			while(less(array, key, j)){
				Util.swap(array, j, j-1);
			}
			array[j] = key;
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
	
	/**
	 * Compare two element and return if x is less than y.
	 * Then y is greater than x.
	 * 
	 * @param array an array
	 * @param x an index of the array
	 * @param y an other index of the array
	 * 
	 * @return true or false
	 */
	public boolean less(T[]array, T key, int index){
		return (array[index].compareTo(key) > 0); 
	}
		
}
