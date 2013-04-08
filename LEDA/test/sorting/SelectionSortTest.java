package sorting;

public class SelectionSortTest {
	
	public static void main(String[] args) {
		
		SelectionSort<Integer> selection = new SelectionSort<Integer>();
		
		Integer [] array  = {2,4,6,7,3,1,0,8,5,9,-1};
		
		print (Util.toString(array));
		selection.sort(array);
		print (Util.toString(array));
		
	}
	
	public static void print(String str){
		System.out.println(str);
	}
}
