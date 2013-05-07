package adt.splaytree;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSplaytree2{

	private SplayTree<Integer> treeImpl;
	
	@Before
	public void setUp() throws Exception {
			
		
		treeImpl = new SplayTreeImpl<Integer>();
		treeImpl.insert(3);
		treeImpl.insert(1);
		treeImpl.insert(4);
		treeImpl.insert(5);
		treeImpl.insert(2);
		treeImpl.insert(9);
		treeImpl.insert(6);
		treeImpl.insert(8);
	}
	
	
	
	@Test
	public void testInsert() {
		treeImpl.insert(7);
		assertEquals(5, treeImpl.height());
		assertArrayEquals(new Integer[]{7, 6, 5, 2, 1, 4, 3, 8, 9},treeImpl.preOrder());

	}
	
	
	
		
}
