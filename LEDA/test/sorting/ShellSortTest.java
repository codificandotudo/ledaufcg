package sorting;

public class ShellSortTest {

	public static void main(String[] args) {
		ShellSort<Integer> shell = new ShellSort<Integer>();
		
		Integer [] array  = {2,4,6,7,3,1,0,8,5,9,-1};
		
		print (Util.toString(array));
		shell.sort(array);
		print (Util.toString(array));
		
	}
	
	private static void print(String str){
		System.out.println(str);
	}
	
}
