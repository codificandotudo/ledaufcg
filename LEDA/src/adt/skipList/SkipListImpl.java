package adt.skipList;

public class SkipListImpl<V> implements SkipList<V> {

	protected SkipNode<V> root;
	protected int level;
	protected int maxLevel;

	//SET THIS VALUE TO TRUE IF YOU ARE IMPLEMENTING MAX_LEVEL = LEVEL
	//SET THIS VALUE TO FALSE IF YOU ARE IMPLEMENTING MAX_LEVEL != LEVEL
	protected boolean useMaxLevelAsLevel = true;
	protected double probability = 0.5; 
	protected SkipNode<V> NIL;
	
	public SkipListImpl(int maxLevel) {
		if(useMaxLevelAsLevel){
			this.level = maxLevel;
		}else{
			this.level = 1;
		}
		this.maxLevel = maxLevel;
		root = new SkipNode(Integer.MIN_VALUE, maxLevel, new Integer(Integer.MIN_VALUE));
		NIL = new SkipNode(Integer.MAX_VALUE, maxLevel, new Integer(Integer.MAX_VALUE));
		connectRootToNil();
	}
	
	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL
	 * Caso esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com 
	 * level=1 e o metodo deve conectar apenas o forward[0].  
	 */
	private void connectRootToNil(){
		 if (this.level == this.maxLevel) {
             for (int i = 0; i < level; i++) {
                     this.root.forward[i] = NIL;
             }
		 } else {
             this.root.forward[0] = NIL;
		 }
	}
	
	
	
	/**
	 * Metodo que gera uma altura aleatoria para ser atribuida a um novo no no metodo
	 * insert(int,V) 
	 */
	private int randomLevel(){
		int randomLevel = 1;
		double random = Math.random();
		while(Math.random() <= probability && randomLevel < maxLevel){
			randomLevel = randomLevel + 1;
		}
		return randomLevel;
	}

	
	@Override
	public void insert(int key, V newValue) {
		 @SuppressWarnings("unchecked")
		 SkipNode<V>[] update =  new SkipNode[this.maxLevel];
         
		 SkipNode<V> current = root;
		 
         int random = this.randomLevel();

         for (int i = level - 1; i >= 0; i--) {
                 while (current.forward[i].key < key) {
                         current = current.forward[i];
                 }
                 update[i] = current;
         }
         
         current = current.forward[0];
         
         if (current.key == key) {
                 current.satteliteData = newValue;
         } else {
             if (random > this.level) {
                 for (int i = random - 1; i >= this.level; i--) {
                     update[i] = root;
                 }
                 this.level = random;
             }
             SkipNode<V> newNode = makeNode(key, random, newValue);
             
             for (int i = 0; i < random; i++) {
                     newNode.forward[i] = update[i].forward[i];
                     update[i].forward[i] = newNode;
             }
         }
	}

	@Override
	public void insert(int key, V newValue, int height) {
	
	     @SuppressWarnings("unchecked")
		 SkipNode<V> [] update = new SkipNode[this.maxLevel];
	     SkipNode<V> current = root;
	
	     for (int i = level - 1; i >= 0; i--) {
	             while (current.forward[i].key < key) {
	                     current = current.forward[i];
	             }
	             update[i] = current;
	     }
	
	     current = current.forward[0];
	
	     if (current.key == key) {
	             current.satteliteData = newValue;
	     } else {
	             if (height > this.level) {

                     for (int i = height - 1; i >= this.level; i--) {
                             update[i] = this.root;
                     }
                     this.level = height;
	
	             }
	             SkipNode<V> newNode = makeNode(key, height, newValue);
	             for (int i = 0; i < height; i++) {
                     newNode.forward[i] = update[i].forward[i];
                     update[i].forward[i] = newNode;
	             }
	     }
		
//		@SuppressWarnings("unused")
//		SkipNode<V> [] update = (SkipNode<V>[]) new Comparable[maxLevel];
//		
//		SkipNode<V> current = root;
//		
//		for (int i = level; i <= 1; i--){
//			while (current.forward[i].key < key){
//				current = current.forward[i];
//			}
//			update[i] = current;
//		}
//		current = current.forward[1];
//		
//		if (current.key == key){
//			current.satteliteData = newValue;
//		}
//		else{
//			int level = randomLevel();
//			if (level > this.level){
//				for (int i = this.level+1 ; i <= level; i--){
//					update[i] = root;
//				}
//				this.level = level;
//			}
//			current = makeNode(level, key, newValue);
//			
//			for(int i=1; i <= level; i++){
//				current.forward[i] = update[i].forward[i];
//				update[i].forward[i] = current;
//			}
//		}
		
	}
	
	private SkipNode<V> makeNode(int level, int key, V newValue){
		SkipNode<V> newNode = new SkipNode<V>(key, level, newValue);
		return newNode;
	}

	@Override
	public void remove(int key) {
		   SkipNode<V>[] update = new SkipNode[maxLevel];
           SkipNode current = this.root;

           for (int i = this.level - 1; i >= 0; i--) {
               while (!current.forward[i].equals(NIL) && current.forward[i].key < key) {
                       current = current.forward[i];
               }
               update[i] = current;
           }

           current = current.forward[0];

           if (current.key == key) {
               for (int i = 0; i < this.level; i++) {
                   if (!update[i].forward[i].equals(current)) {
                     break;
                   }
                   update[i].forward[i] = current.forward[i];
               }
           } 
          
	}

	@Override
	public int height() {
		 int height = 0;
         if(!isEmpty()){
             for(int i =0; i <root.forward.length; i++){
                 if(this.root.forward[i].satteliteData.equals(NIL)){
                         height = this.root.forward[i-1].forward.length;
                 }
             }
         }
         return height;
	}

	@Override
	public SkipNode<V> search(int key) {
		 SkipNode<V> current = root;

         for (int i = level - 1; i >= 0; i--) {
             while (current.forward[i].key < key) {
                    current = current.forward[i];
             }
             if (current.forward[i].key == key) {
                     return current.forward[i];
             }
         }

         return null;
	}

	@Override
	public int size(){
		 SkipNode<V> current = root;
		 
         int size = 0;
         while (current.forward[0].key != Integer.MAX_VALUE) {
                 current = current.forward[0];
                 size++;
         }
         return size;
	}

	@Override
	public SkipNode<V>[] toArray() {
		
		 SkipNode<V> current = this.root;
		 
		 SkipNode [] nodes = new SkipNode[size()];
		 
		 int index = 0;
         while (!current.forward[0].equals(NIL)) {
                 
        	 nodes[index++] = current;
                 
             current = current.forward[0];
         }
         
		return nodes;
	}

	@Override
	public boolean isEmpty() {
		  return root.forward[0].key == Integer.MAX_VALUE;
	}
	
	

}
