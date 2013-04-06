package sorting;

public class InsertionSortTest {

	public static void main(String[] args) {
		InsertionSort<Integer> insertion = new InsertionSort<Integer>();
		
		Integer [] array  = {2,4,6,7,3,1,0,8,5,9,-1};
		
		print (insertion.toString(array));
		insertion.sort(array);
		print (insertion.toString(array));
	}
	
	private static void print(String str){
		System.out.println(str);
	}
}
