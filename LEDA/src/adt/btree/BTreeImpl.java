package adt.btree;

import java.util.LinkedList;
import java.util.List;

public class BTreeImpl<T extends Comparable<T>> implements BTree<T> {

	protected BNode<T> root;
	protected int order;
	
	public BTreeImpl(int order) {
		this.order = order;
		this.root = new BNode<T>(order);
	}
	
	public void buildTree(T [] elements){
		for (T element : elements) 
			insert(element);
	}
	
	@Override
	public BNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}
	private int height(BNode<T> node){
		int resp = -1;
		if(!node.isEmpty()){
			if(node.isLeaf()){
				resp = 0;
			}else{
				resp = 1 + height(node.children.get(0));
			}
		}
		return resp;
	}
	@Override
	public BNode<T>[] depthLeftOrder() {
		@SuppressWarnings("unchecked")
		BNode<T> [] array = (BNode<T>[]) new Comparable[size()];
		
		List<BNode<T>> list = new LinkedList<BNode<T>>();
		
		BNode<T> current = root;
		
		int auxIndex=0;
		
		list.add(current);
		while (!current.isLeaf()) {
			for (int k = 0; k <= current.maxKeys; k++) {
				list.add(current.children.get(k));
			}
			auxIndex++;
			current = list.get(auxIndex);
		}
		
		auxIndex=0;
		
		for (BNode<T> node : list) {
			for (int i = 0; i < node.maxKeys; i++) {
				array[auxIndex++] = node.getChildren().get(i);
			}
		}
		
		return array;
	}

	@Override
	public int size() {
		int aux = 0;
		List<BNode<T>> list = new LinkedList();
		BNode<T> current = root;
		
		list.add(current);
		while (!current.isLeaf()) {
			for (int k = 0; k <= current.maxKeys; k++) {
				list.add(current.children.get(k));
			}
			aux++;
			current = list.get(aux);
		}
		int size = 0;
		for (BNode<T> node : list) {
			for (int i = 0; i < node.maxKeys; i++) {
				size += node.getElements().size();
			}
		}
		return size;
	}
	
	

	@Override
	public BNodePosition<T> search(T element) {
		return search(root, element);
	}
	

	public BNodePosition<T> search(BNode<T> node, T element){
		int i = 1;
		while (i <= node.size() && element.compareTo(node.getElements().get(i)) > 0){
			i++;
		}
		
		if (i <= node.getElements().size() && element.compareTo(node.getElements().get(i))>0)
		return new BNodePosition(node, i);
		
		if (node.isLeaf())
			return new BNodePosition(null, -1);
		
		return search(node.getChildren().get(i), element);
		
	}

	@Override
	public void insert(T element) {
		insert (element, root);
	}
	
	private void insert(T element, BNode<T> node){ 
		BNode<T> current = node;
		if (current.maxKeys == 2*order + 1 ){
			BNode<T> aux = new BNode(order);
			node = aux;
			aux.maxKeys = 0;
			aux.addChild(0, current);
			split(aux, 0, current);
			insertNonFull(element, node);
		}
		else{
			insertNonFull(element, node);
		}
	}
	
	private void insertNonFull(T keyElement , BNode<T> node){
		int indexKey = node.maxKeys -1;
		
		LinkedList<T> elements = node.getElements();
		
		if (node.isLeaf()){
			
			while ( indexKey >= 0 && keyElement.compareTo(elements.get(indexKey)) < 0){
				elements.add(indexKey + 1, elements.get(indexKey));
				indexKey--;
			}
			elements.add(indexKey+1, keyElement);
			node.maxKeys  = node.maxKeys + 1;
			node.setElements(elements);
		}
		else{
			while ( indexKey >= 0 && keyElement.compareTo(elements.get(indexKey)) < 0){
				indexKey--;
			}
			indexKey ++;
			
			LinkedList<BNode<T>> childrenList = node.getChildren();
			
			if ( childrenList.get(indexKey).maxKeys == 2*order +1){
				split(node, indexKey, childrenList.get(indexKey));
				if (keyElement.compareTo(node.getElementAt(indexKey)) > 0 ){
					indexKey++;
				}
			}
			
			insertNonFull(keyElement, node.getChildren().get(indexKey));
			
		}
	}
	
	/**
	 * Method to divide a  node when it not full.
	 * 
	 * @param parent node parent and internal child  not complete.
	 * @param index a index
	 * @param child It's the i-th parent's child  and the node to divide.
	 */
	private void split(BNode<T> parent, int index , BNode<T> child){
		BNode<T> current = new BNode(order);
		
		current.maxKeys = child.maxChildren -1;
		
		LinkedList<T> currentElements = new LinkedList<T>();
		LinkedList<T> childElements = child.getElements();
		
		for (int i = 0; i < order-1; i++){
			currentElements.add(i, childElements.get(i+order));
		}
		
		current.setElements(currentElements);
		
		LinkedList<BNode<T>> children = child.getChildren();
		
		if (!child.isLeaf()){
			for (int i=0; i < order ; i++){
				current.addChild(i, children.get(i+1));
			}
		}
		
		child.maxKeys = order-1;
		
		children = parent.getChildren();
		
		for (int i = parent.maxKeys; i >= index + 1 ; i--){
			parent.addChild(i+1, children.get(i));
		}
		
		parent.addChild(index+1, current);
		
		LinkedList<T> parentElements = new LinkedList<T>();
		
		for (int i = parent.maxKeys; i >= index  ; i--){
			parentElements.add(i+1, parentElements.get(i));
		}
		
		parentElements.add(index, parentElements.get(order-1));
		parent.setElements(parentElements);
		
		parent.maxKeys = parent.maxKeys +1;
		
	}
	
	//NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
	@Override
	public BNode<T> maximum(BNode<T> node) {
		//NAO PRECISA IMPLEMENTAR
		return null;
	}
	@Override
	public BNode<T> minimum(BNode<T> node) {
		//NAO PRECISA IMPLEMENTAR
		return null;
	}
	@Override
	public void remove(T element) {
		//NAO PRECISA IMPLEMENTAR

	}
	

}
