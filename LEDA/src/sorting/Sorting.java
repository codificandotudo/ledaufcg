package sorting;

/**
 * Sorting Interface.
 * 
 * @version 1.0 2013/04/05
 * @author Samuel T. C. Santos
 * 
 * @see <a href="http://code.google.com/p/ledaufcg/">Sorting</a>
 *
 * @param <T>
 */
public interface Sorting<T extends Comparable<T>> {

	/**
	 * Sorting the element into a array.
	 * 
	 * @param array
	 */
	public void sort( T[] array);
	
}
