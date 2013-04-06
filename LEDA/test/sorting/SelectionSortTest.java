package sorting;

public class SelectionSortTest {
	
	public static void main(String[] args) {
		
		SelectionSort<Integer> selection = new SelectionSort<Integer>();
		
		Integer [] array  = {2,4,6,7,3,1,0,8,5,9,-1};
		
		print (selection.toString(array));
		selection.sort(array);
		print (selection.toString(array));
		
	}
	
	public static void print(String str){
		System.out.println(str);
	}
}
