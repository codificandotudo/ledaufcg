package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;
	private int index;

	public BSTImpl() {
		root = new BSTNode<T>();
		index = 0;
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(root);
	}

	public int height(BSTNode<T> node) {
		int leftHeight = 0;
		int rightHeight = 0;
		final int TREE_EMPTY = -1;

		if (node.isEmpty())
			return TREE_EMPTY;

		if (!node.getLeft().isEmpty())
			leftHeight += 1 + height((BSTNode<T>) node.getLeft());

		if (!node.getRight().isEmpty())
			rightHeight += 1 + height((BSTNode<T>) node.getRight());

		return Math.max(leftHeight, rightHeight);
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element, root);
	}

	public BSTNode<T> search(T element, BSTNode<T> node) {
		BSTNode<T> auxNode = new BSTNode<T>();

		if (!node.isEmpty()) {
			if (element.compareTo(node.getData()) < 0) {
				auxNode = search(element, (BSTNode<T>) node.getLeft());
			} else if (element.compareTo(node.getData()) > 0) {
				auxNode = search(element, (BSTNode<T>) node.getRight());
			} else
				auxNode = node;
		}
		return auxNode;
	}

	@Override
	public void insert(T element) {
		if (root.isEmpty()) {
			root = new BSTNode<T>();
			root.setData(element);
			root.setLeft(new BSTNode<T>());
			root.setRight(new BSTNode<T>());
		} else {
			BSTNode<T> current = root;
			BSTNode<T> parent = new BSTNode<T>();

			while (!current.isEmpty()) {
				if (element.compareTo(current.getData()) < 0) {
					parent = current;
					current = (BSTNode<T>) current.getLeft();
				} else if (element.compareTo(current.getData()) > 0) {
					parent = current;
					current = (BSTNode<T>) current.getRight();
				} else
					return;
			}

			BSTNode<T> newNode = new BSTNode<T>();
			newNode.setData(element);
			newNode.setParent(parent);
			newNode.setLeft(new BSTNode<T>());
			newNode.setRight(new BSTNode<T>());

			if (element.compareTo(parent.getData()) < 0) {
				parent.setLeft(newNode);
			} else {
				parent.setRight(newNode);
			}
		}

	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(root);
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		if (node.isEmpty())
			return null;
		return (node.getRight().isEmpty()) ? node : maximum((BSTNode<T>) node
				.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(root);
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		if (node.isEmpty())
			return null;
		return (node.getLeft().isEmpty()) ? node : minimum((BSTNode<T>) node
				.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		return sucessor(search(element));
	}

	private BSTNode<T> sucessor(BSTNode<T> node) {
		if (search(node.getData()) == null)
			return null;
		if (!node.getRight().isEmpty())
			return minimum((BSTNode<T>) node.getRight());

		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		while (!parent.isEmpty() && node.equals(parent.getRight())) {
			node = parent;
			parent = (BSTNode<T>) parent.getParent();
		}

		return parent;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		return predecessor(search(element));
	}

	private BSTNode<T> predecessor(BSTNode<T> node) {
		if (search(node.getData()) == null)
			return null;
		if (!node.getLeft().isEmpty())
			return maximum((BSTNode<T>) node.getLeft());

		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		while (!parent.isEmpty() && node.equals(parent.getLeft())) {
			node = parent;
			parent = (BSTNode<T>) parent.getParent();
		}

		return parent;
	}

	@Override
	public void remove(T element) {
		remove(search(element));

	}

	private void remove(BSTNode<T> node) {
		if (node.isEmpty()) return;
		
		if (node.getLeft().isEmpty() && node.getRight().isEmpty()) {
             node.setData(null);
             node.setLeft(new BSTNode<T>());
             node.setRight(new BSTNode<T>());
		} 
		else if ( node.getLeft().isEmpty() && !node.getRight().isEmpty() ||
				 !node.getLeft().isEmpty() && node.getRight().isEmpty() ){
			
			if (!node.equals(root)){
				if (node.getData().compareTo(node.getParent().getData())< 0){
					if (!node.getLeft().isEmpty())
						node.getParent().setLeft(node.getLeft());
					else
						node.getParent().setLeft(node.getRight());
				}
				else{
					if (!node.getLeft().isEmpty())
						node.getParent().setRight(node.getLeft());
					else
						node.getParent().setRight(node.getRight());
				}
			}
			else{
				if (!node.getRight().isEmpty())
					root = (BSTNode<T>)node.getRight();
				else
					root = (BSTNode<T>)node.getLeft();
				
				node =null;
				root.setParent(node);
			}
		}
		else{
			BSTNode<T> sucessor = sucessor(node);
			node.setData(sucessor.getData());
			remove(sucessor);
		}

	}

	@Override
	public T[] preOrder() {
		@SuppressWarnings("unchecked")
		T[] order = (T[]) new Comparable[size()];
		preOrder(order, root);
		this.index = 0;
		return order;
	}

	private void preOrder(T[] array, BSTNode<T> node) {
		if (node.isEmpty())
			return;

		visit(array, node);

		preOrder(array, (BSTNode<T>) node.getLeft());
		preOrder(array, (BSTNode<T>) node.getRight());
	}

	private void visit(T[] array, BSTNode<T> node) {
		array[index++] = node.getData();
	}

	@Override
	public T[] order() {
		@SuppressWarnings("unchecked")
		T[] order = (T[]) new Comparable[size()];

		order(order, root);
		this.index = 0;

		return order;
	}

	private void order(T[] array, BSTNode<T> node) {
		if (node.isEmpty())
			return;
		order(array, (BSTNode<T>) node.getLeft());
		visit(array, node);
		order(array, (BSTNode<T>) node.getRight());
	}

	@Override
	public T[] postOrder() {
		@SuppressWarnings("unchecked")
		T[] order = (T[]) new Comparable[size()];

		postOrder(order, root);
		this.index = 0;

		return order;
	}

	private void postOrder(T[] array, BSTNode<T> node) {
		if (node.isEmpty())
			return;
		postOrder(array, (BSTNode<T>) node.getLeft());
		postOrder(array, (BSTNode<T>) node.getRight());
		visit(array, node);
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		if (!node.isEmpty()) {
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
