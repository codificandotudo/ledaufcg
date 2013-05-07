package sorting.complexSorting;

import sorting.Sorting;

public class Mergesort <T extends Comparable<T>> implements Sorting {

	@Override
	public void sort(Comparable[] array) {
		int n = array.length;
		
	}
	
	public static void main(String[] args) {
		int [] a = new int[] {1,45,67,32,90,3,9};
		
		int middle = (int)Math.ceil((double)a.length / 2);
		
		System.out.println(middle);
		
	}
	
}

