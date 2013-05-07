package sorting.divideAndConquer.hybridMergesort;


import java.util.Arrays;

import sorting.SortingImpl;

/**
 * The algorithm is an hybrid of mergesort and insertion sort. Depending on the size of the input, 
 * the algorithm decides between the application of mergesort or insertion 
 * sort. The implementation of the algorithm must be in-place!
 */
public class HybridMergesort<T extends Comparable<T>> extends SortingImpl<T>{
	/**
	 * The limit to choose between applying merge or insertion. For inputs with size 
	 * less or equal to 4, apply insertion sort. 
	 */
	public static final int SIZE_LIMIT = 4;
	
	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;
	
	protected void sort(T[] array,int leftIndex, int rightIndex){
		hybridMergesort(array, leftIndex, rightIndex);
	}
	
	
	protected void hybridMergesort(T array[], int leftIndex, int rightIndex ){

		MERGESORT_APPLICATIONS++;
		
		if (leftIndex < rightIndex){
			
			int middleIndex = (leftIndex + rightIndex)/2;
			
			if (array.length > SIZE_LIMIT){
				
				hybridMergesort(array, leftIndex, middleIndex);
			
				hybridMergesort(array, middleIndex+1, rightIndex);
		
				merge(array, leftIndex, middleIndex, rightIndex);
			}
			else{
				insertionsort(array, leftIndex, middleIndex);
				
				insertionsort(array, middleIndex+1, rightIndex);
		
				merge(array, leftIndex, middleIndex, rightIndex);
			}
		}
	}
	
	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
		//cria um vetor auxilia...
		T[] arrayAux = (T[]) new Comparable[array.length];
		
		for (int i=leftIndex ; i<= middleIndex; i++){
			arrayAux[i] = array[i]; 
		}
		
		for (int j= middleIndex+1; j <= rightIndex; j++){
			arrayAux[rightIndex + middleIndex + 1 - j] = array[j];
		}
		
		int i = leftIndex;
		int j = rightIndex;
		
		for (int k = leftIndex; k <= rightIndex; k++){
			if (arrayAux[i].compareTo(arrayAux[j]) <= 0){
				array[k] = arrayAux[i];
				i++;
			}
			else{
				array[k] = arrayAux[j];
				j--;
			}
		}
		
	
	}
	
	protected void insertionsort(T[] array, int leftIndex, int rightIndex) {
		
		INSERTIONSORT_APPLICATIONS++;
		
		int n = (rightIndex - leftIndex)+1;
		
		for(int j=leftIndex+1; j < n; j++){
			
			T key = array[j];
			
			int i = j-1;
			
			while (i >= 0 && (array[i].compareTo(key)>0 )){
				array[i+1] = array[i];
				i--;
			}
			array[i+1] = key;
		}
		
		
	}
	
	public int getCallInsertionApplications(){
		return INSERTIONSORT_APPLICATIONS;
	}
	
	public int getCallMergesortApplications(){
		return MERGESORT_APPLICATIONS;
	}

}

