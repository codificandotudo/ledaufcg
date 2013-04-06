package sorting;

/**
 * Util implement swap method.
 * 
 * @version 1.0 2013/04/05
 * @author Samuel T. C. Santos
 * 
 * @see <a href="http://code.google.com/p/ledaufcg/">Sorting</a>
 *
 * @param <T>
 */
/**
 * Class containing useful methods to be used by the sorting algorithms.
 */
public class Util {
	/**
	 * Swaps the elements indexed by i and j in the array.
	 */
	public static void swap(Object[] array, int i, int j) {
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	
	// Instantiates a Generic Type
	public static <D> D getInstance(Class<D> _class) {
		try {
			return _class.newInstance();
		} catch (Exception _ex) {
			_ex.printStackTrace();
		}
		return null;
	}
}
