package adt.bst;

import junit.framework.Assert;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {

	BSTImpl<Integer> bst;
	
	@Before
	public void setUp(){
		bst = new BSTImpl<Integer>();
	}
	
	@Test
	public void testInitialization() {
		Assert.assertTrue(bst.isEmpty());
		Assert.assertTrue(bst.height() == -1);
		Assert.assertNotNull(bst.getRoot());
		Assert.assertNull(bst.getRoot().getData());
		Assert.assertNull(bst.getRoot().getParent());
		Assert.assertNull(bst.getRoot().getLeft());
		Assert.assertNull(bst.getRoot().getRight());	
	}
	
	@Test
	public void testGetRoot(){
		bst.insert(new Integer(3));
		assertEquals(new Integer(3), bst.getRoot().getData());
		
		bst.remove(new Integer(3));
		assertEquals(null, bst.getRoot().getData());
	}

	@Test
	public void testInsert(){
		int[] keys = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
		
		for (int i : keys) {
			bst.insert(i);
		}
		assertArrayEquals(new Integer[]{8,4,2,1,3,6,5,7,12,10,9,11,14,13,15}, bst.preOrder());
		assertArrayEquals(new Integer[]{1,3,2,5,7,6,4,9,11,10,13,15,14,12,8}, bst.postOrder());		
	}
	
	@Test
	public void testRemove(){
		int[] keys = {15,6,3,7,2,4,13,9};
		
		for (int i : keys) {
			bst.insert(i);
		}
		assertArrayEquals(new Integer[]{2,3,4,6,7,9,13,15}, bst.order());
		
		bst.remove(15);
		assertArrayEquals(new Integer[]{2,3,4,6,7,9,13}, bst.order());
		
		bst.remove(13);
		assertArrayEquals(new Integer[]{2,3,4,6,7,9}, bst.order());
		
		bst.remove(9);
		assertArrayEquals(new Integer[]{2,3,4,6,7}, bst.order());
		
		bst.remove(7);
		assertArrayEquals(new Integer[]{2,3,4,6}, bst.order());
		
		bst.remove(6);
		assertArrayEquals(new Integer[]{2,3,4}, bst.order());
		
		bst.remove(4);
		assertArrayEquals(new Integer[]{2,3}, bst.order());

		bst.remove(3);
		assertArrayEquals(new Integer[]{2}, bst.order());
		
		bst.remove(2);
		assertArrayEquals(new Integer[]{}, bst.order());

	}
	
	
	@Test
	public void testSearch(){
		int[] keys = {8,4,12,2,6,10,14,1,0,3,5,7,9,11,13,15,-1};
		
		for (int i : keys) {
			bst.insert(i);
		}
		for (int i : keys){
			assertEquals(new Integer(i), bst.search(i).getData());
		}
		assertEquals(null, bst.search(100).getData());
	}
	
	@Test
	public void testMaximum(){
		int[] keys = {8,4,12,2,6,10,14,1,0,3,5,7,9,11,13,15,-1};
		
		for (int i : keys) {
			bst.insert(i);
		}
		assertEquals(new Integer(15), bst.maximum().getData());
		bst.remove(15);
		assertEquals(new Integer(14), bst.maximum().getData());
		bst.remove(14);
		assertEquals(new Integer(13), bst.maximum().getData());
	}
	
	@Test 
	public void testMinimum(){
		
	}
	
	@Test
	public void testIsEmpty(){
		assertTrue(bst.isEmpty());
		
		bst.insert(new Integer(9));
		
		assertFalse(bst.isEmpty());
		
		bst.remove(new Integer(9));
		
		assertTrue(bst.isEmpty());
	}
	
	@Test
	public void testHeight(){
		assertEquals(-1, bst.height());
		
		bst.insert(11);
		assertEquals(0, bst.height());
		
		bst.insert(9);
		assertEquals(1, bst.height());
		
		bst.insert(13);
		assertEquals(1, bst.height());
		
		bst.insert(15);
		assertEquals(2, bst.height());
		
		bst.insert(17);
		assertEquals(3, bst.height());
		
		bst.remove(17);
		assertEquals(2, bst.height());
		bst.remove(15);
		bst.remove(13);
		bst.remove(9);
		bst.remove(11);
		assertEquals(-1, bst.height());
	}
	
	@Test
	public void testSize(){
		assertEquals(0, bst.size());
		bst.insert(9);
		assertEquals(1, bst.size());
		bst.insert(5);
		assertEquals(2, bst.size());
	}
	
	@Test
	public void testPreOrderWalk(){
		
	}
	
	@Test
	public void testOrderWalk(){
		
	}

	@Test
	public void testPostOrderWalk(){
		
	}	
	
}