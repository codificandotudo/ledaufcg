package sorting;

/**
 * 
 * @author Home
 *
 * @param <T>
 * 
 * Bubble sort execution:
 *       
 * i=1 [ 2, 4, 6, 7, 3, 1, 0, 8, 5, 9, -1]
 *     [ -1, 2, 4, 6, 3, 7, 0, 1, 5, 9, 8] j=10
 *          
 * i=2 [ -1, 2, 4, 6, 3, 7, 0, 1, 5, 9, 8]
 *     [ -1, 0, 2, 4, 6, 3, 7, 1, 5, 8, 9] j=9
 *     
 * i=3 [ -1, 0, 2, 4, 6, 3, 7, 1, 5, 8, 9]
 *     [ -1, 0, 2, 1, 4, 6, 3, 7, 5, 8, 9] j=8
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
