package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

public class AVLTreeImpl<T extends Comparable<T>> 
    extends BSTImpl<T> implements AVLTree<T> {

	//TODO Do not forget: you must override the methods insert and remove conveniently.

	public void insert(T element){
		insert(root, element);
	}
	
	private void insert(BSTNode node, T element){
		if(node.isEmpty()){
			node.setData(element);
			node.setLeft (new BSTNode<T>());
			node.setRight(new BSTNode<T>());
		}else{
			if( node.compareTo(element) < 0){
				insert((BSTNode<T>)node.getLeft(), element);
				
			}else if ( node.compareTo(element) > 0){
			     insert((BSTNode<T>)node.getRight(), element);
		}
			rebalance(node);
		}
	}
	
	public void remove(T element){
		
	}
	
	//AUXILIARY
	protected int calculateBalance(BSTNode<T> node){
		return (!root.isEmpty()) ? height((BSTNode<T>)node.getLeft()) - height((BSTNode<T>)node.getRight()):0; 
	}
	
	//AUXILIARY
	protected void rebalance(BSTNode<T> node){
		rebalance(root, node);
	}
	
	private void rebalance (BSTNode<T> current, BSTNode<T> node){
		
		if(current.isEmpty()) return;
		
		BSTNode<T> nodeLeft = (BSTNode<T>)current.getLeft();
		BSTNode<T> nodeRight = (BSTNode<T>)current.getRight();
		
		if( !nodeLeft.isEmpty() && nodeLeft.getLeft().equals(node))
			leftRotation(current);
		else if(!nodeLeft.isEmpty() && nodeLeft.getRight().equals(node))
			doubleLeftRotation(current);
		else if(!nodeRight.isEmpty() && nodeRight.getRight().equals(node))
			rightRotation(current);
		else
			doubleRightRotation(current);	
	}
	
	
	//AUXILIARY
	protected void rebalanceUp(BSTNode<T> node){
		BSTNode<T> parent = (BSTNode<T>)node.getParent();
		while (!parent.isEmpty()){
			rebalance(parent);
			parent = (BSTNode<T>)parent.getParent();
		}
	}
	
	//AUXILIARY
	protected void leftRotation(BSTNode<T> node){
		
		BSTNode<T> father = (BSTNode<T>) node.getLeft();
		
		BSTNode<T> subTreeRight = (BSTNode<T>)father.getRight();
		
		if(root.equals(node)){
			root = father;
			father.setParent(null);			
		}else{
			BSTNode<T> grandfather = (BSTNode<T>) node.getParent();
			if(grandfather.getLeft().equals(node))
				grandfather.setLeft(father);
			else
				grandfather.setRight(father);
			father.setParent(grandfather);
		}
		
		//tree right
		father.setRight(node);
		node.setParent(father);
		node.setLeft(subTreeRight);
		
		if(subTreeRight.isEmpty())
			subTreeRight.setParent(node);
	}
	
	//AUXILIARY
	protected void rightRotation(BSTNode<T> node){
		BSTNode<T> father = (BSTNode<T>) node.getRight();
		
		BSTNode<T> subTreeLeft = (BSTNode<T>) father.getLeft();
		
		if(root.equals(node)){
			root = father;
			father.setParent(null);			
		}else{
			BSTNode<T> grandfather = (BSTNode<T>) node.getParent();
			if(grandfather.getLeft().equals(node))
				grandfather.setLeft(father);
			else
				grandfather.setRight(father);
			father.setParent(grandfather);
		}
		
		//tree left 
		father.setLeft(node);
		node.setParent(father);
		node.setRight(subTreeLeft);
		
		if(!subTreeLeft.isEmpty())
			subTreeLeft.setParent(node);
			
	}
	
	protected void doubleLeftRotation(BSTNode<T> node){
		BSTNode<T> father = (BSTNode<T>)node.getLeft();
		BSTNode<T> child = (BSTNode<T>)father.getRight();
		
		BSTNode<T> subTreeRight = (BSTNode<T>)child.getRight();
		BSTNode<T> subTreeLeft = (BSTNode<T>)child.getLeft();
		
		if(root.equals(node)){
			root = child;
			child.setParent(null);			
		}else{
			BSTNode<T> grandfather = (BSTNode<T>)node.getParent();
			if(grandfather.getLeft().equals(node))
				grandfather.setLeft(child);
			else
				grandfather.setRight(child);
			child.setParent(grandfather);
		}
		//tree right 
		child.setRight(node);
		node.setParent(child);
		node.setLeft(subTreeRight);
		if(! subTreeRight.isEmpty())
			subTreeRight.setParent(node);

		
		//tree left
		child.setLeft(father);
		father.setParent(child);
		father.setRight(subTreeLeft);
		if(!subTreeLeft.isEmpty())
			subTreeLeft.setParent(father);
		

	}
	
	protected void doubleRightRotation(BSTNode<T> node){
		
		BSTNode<T> father = (BSTNode<T>) node.getRight();
		BSTNode<T> child = (BSTNode<T>)father.getLeft();
		
		BSTNode<T> subTreeLeft = (BSTNode<T>) child.getLeft();
		BSTNode<T> subTreeRight =(BSTNode<T>) child.getRight();
		
		if(root.equals(node)){
			root = child;
			child.setParent(null);			
		}else{
			BSTNode<T> grandfather = (BSTNode<T>)node.getParent();
			if(grandfather.getLeft().equals(node))
				grandfather.setLeft(child);
			else
				grandfather.setRight(child);
			child.setParent(grandfather);
		}
		//tree left
		child.setLeft(node);
		node.setParent(child);
		node.setRight(subTreeRight);
		if(!subTreeRight.isEmpty())
			subTreeRight.setParent(node);
		
		//tree right
		child.setRight(father);
		father.setParent(child);
		father.setLeft(subTreeLeft);
		if(!subTreeLeft.isEmpty())
			subTreeLeft.setParent(father);

		
	}
	
	
	
}
