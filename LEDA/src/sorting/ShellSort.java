package sorting;

/**
 * Shellsort is a simple extension of insertion sort that gains speed by
 * allowing exchanges of elements that are far apart.
 * 
 * The idea is to rearrange the array to give it the property that taking
 * every hth element (starting anywhere) yields a sorted array. Such a 
 * array is said to be h-sorted. Put another way, an h-sorted array is h
 * independent sorted array, interleaved together. By h-sorting for some large
 * values of h, we can move elements in the array long distances and thus make 
 * it easier to h-sort for smaller values of h. Using such a procedure for any
 * sequence of values of h that ends in 1 will produce a sorted array: 
 * 
 * That is the essence of shellsort.
 * 
 * @version 1.0 2013/04/09
 * @author Samuel T. C. Santos
 * 
 * @see <a href="http://code.google.com/p/ledaufcg/">Shell Sort</a>
 * 
 */
public class ShellSort<T extends Comparable<T>> implements Sorting<T>  {

	@Override
	public void sort(T[] array) {
		sort(array, 0, array.length);
	}
	
	private void sort (T[] array, int left, int right){
		int h;
		//Generate an initial value h for increment sequence..
		for (h=1; h < (right -1)/9 ; h = 3*h+1);
		
		for (; h >0 ; h /=3){
			for (int i= 1+h ; i < right; i++){
				int j = i;
				T key = array[i];
				while (j >= left+h && less(array, key, array[j-h])){
					Util.swap(array, j, j-h);
					j-= h;
				}
				array[j] = key;
			}
		}
			
	}
	
	private boolean less(T[] array, T key, T value){
		return key.compareTo(value) < 0;
	}

}
