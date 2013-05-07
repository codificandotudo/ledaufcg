package sorting.divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import sorting.SortingImpl;
import sorting.Util;

/**
 * Data Structures  
 * @author SamuelSantos
 *
 * @param <T>
 */
public class Mergesort<T extends Comparable<T>> extends SortingImpl<T> {


	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		mergesort(array, leftIndex, rightIndex);
	}
	
	protected void mergesort(T array[], int leftIndex, int rightIndex ){

		if (leftIndex < rightIndex){
			
			int middleIndex = (leftIndex + rightIndex)/2;
			
			mergesort(array, leftIndex, middleIndex);
			
			mergesort(array, middleIndex+1, rightIndex);
		
			merge(array, leftIndex, middleIndex, rightIndex);
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
		
		System.out.println(Arrays.asList(array).toString());
		
	}//fim merge
	    
}
