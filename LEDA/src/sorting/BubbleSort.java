package sorting;

/**
 * The first sort that many people learn, because it is so simple, is bubble
 * sort: Keep passing through the file, exchanging adjacent elements that
 * are out of order, continuing until the array is sort.
 * 
 * For each i for 1 to right-1, the inner (j) loop puts the minimum element
 * among the elements in a[i], ..., a[right] into a[i] by passing from right
 * to left through elements, compare-exchanging successive elements.
 * 
 * The smallest one moves on all such comparisons, so it "bubbles" to the beginning.
 * As in  selection sort, as the index i travels from left to right
 * through the array, the elements to its left are in their final position in 
 * the array.
 * 
 * @version 1.0 2013/04/08
 * @author Samuel T. C. Santos
 * 
 * @see <a href="http://code.google.com/p/ledaufcg/">Selection Sort</a>
 * 
 * @param <T>
 * 
 *     
 */
public class BubbleSort<T extends Comparable<T>> implements Sorting<T> {

	@Override
	public void sort(T[] array) {
		sort(array, 0, array.length);
	}
	
	private void sort(T[] array, int left, int right){
		for (int i=left+1; i < right; i++){
			for(int j = right-1; j >= i; j--){
				if (less(array, j-1, j)){
					Util.toString(array);
					Util.swap(array, j-1, j);
					Util.toString(array);
				}
			}
		}
	}
	
	private boolean less(T[] array, int x, int y){
		return array[x].compareTo(array[y]) > 0;
	}

	
}
