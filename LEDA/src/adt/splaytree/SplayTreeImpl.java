package adt.splaytree;

import adt.avltree.AVLTreeImpl;
import adt.bst.BSTNode;

public class SplayTreeImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements
		SplayTree<T> {

	private void splay(BSTNode<T> node){
		//TODO Implement this method to perform the splay correctly by uwing the rotations 
		//implemented in AVLTreeImpl
	}
	
	@Override
	protected void insert(BSTNode<T> node, T value) {
		//override this method to perform splay when inserting a new data into the tree
	}
}
