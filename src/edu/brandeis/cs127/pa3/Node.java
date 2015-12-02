package edu.brandeis.cs127.pa3;

/**
   Superclass of Leaf Nodes (LeafNode) and Internal Nodes (InternalNode)
   of B+-Trees.
   @author cs127b
 */
public abstract class Node{
	int degree;                // Degree of the tree
	int lastindex;             // What is the last key/ptr index currently in use?

	Node[] ptrs;    
	//  Node children.  Can use indices 0..degree.  Currently using lastindex.
	//  Leaf Nodes 's pointers are all null. 

	int[] keys;      // Node search keys.  Can use indices 1..degree.  Currently using 1..lastindex

	Node next, prev;   
	//  The nodes appear after / before me at the same level. The first node of a 
	//  level's prev is null and the last node of a level's next is null.

	Reference parentref;     
	// What is the reference to this node in its parent node?
	// Root's parentref is null.

	public String myname; // This nodes unique name (used for printouts)

	/**
       Constructor which is called by {@link LeafNode} and {@link InternalNode}
       @param d the node degree 
       @param n the next sibling
       @param p the previous sibling
	 */
	protected Node (int d, Node n, Node p){
		degree = d;
		ptrs = new Node[degree]; 
		keys = new int[degree];
		next = n;
		prev = p;

		if (p != null) p.next = this;
		if (n != null) n.prev = this;

		lastindex = 0;
		parentref = null;

		myname = BTree.nextNodeName();
	}

	public abstract void outputForGraphviz();

	/**
       Get the last key index of the Node.
       @return the last key index
	 */
	public int getLast () {
		return lastindex;
	}

	/**
       Get the ith pointer of current node
       @param i the index 
       @return the i_th node of current node
	 */
	public Node getPtr (int i) {
		return ptrs [i];
	}

	/**
       Get the ith key of current node
       @param i the index 
       @return the i_th key of current node 
	 */
	public int getKey (int i) {
		return keys [i];
	}

	/**
       Get the next node of current node 
       @return a node which is next to this node, or null if this node is the last one of one level
	 */
	public Node getNext () {
		return next;
	}

	/**
       Get the previous node of current node
       @return a node which is right before this node, or null if this node is the first one of a level
	 */
	public Node getPrev () {
		return prev;
	}

	/**
       Get the parent reference of current node
       @return a reference which refers to the parend node, or null if this node is the root
	 */
	public Reference getParent () {
		return parentref;
	}

	/**  
	 Get the maximum number of keys in this node.
	 @return the max number of keys in this node (degree - 1)
	 */
	int maxkeys () {
		return degree - 1;
	}

	/** 
	Count the key number of the level this node is in.
	(for print purpose)
	 */
	int getLevelKeyNumber() {
		int i = lastindex;

		Node p = this;
		while ((p = p.prev) != null) i += p.getLast();

		p = this;
		while ((p = p.next) != null) i += p.getLast();

		return i;
	}

	/**
       Calculate out how many keys can this level have.
	 */
	int getMaxLevelKeyNumber(){
		int i = 1;
		int total = 1;
		int level = 1;
		Node p = this;

		while(p.getParent() != null){
			p = p.getParent().getNode();
			level++;
		}

		while (i < level) {
			total *= degree;
			i++;
		}

		return total * (degree -1);
	}

	/**
       Returns the fullness state of this node
       @return true if this node is full, (has degree - 1 keys).
	 */
	public boolean full () {
		return lastindex == degree - 1;
	}

	/** 
	Checks whether two Node objects are siblings. 
	Two instances of Node are siblings if they are children of the same node.
	@param other 
	@return true if other's parent is the same as this's; otherwise false
	 */
	public boolean siblings (Node other){
		return ((other != null) && (parentref.getNode () == other.getParent ().getNode ()));

	}

	/**
       Set the parent reference of current node
       @param l the parent reference
	 */
	public void setParent (Reference l) {parentref = l;}

	/**
       Set the next node to n
       @param n the new next node
	 */
	public void setNext (Node n) {next = n;}

	/**
       Set the previous node to p
       @param p the new previous node
	 */

	public void setPrev (Node p) {prev = p;}

	/**
       Set the initial pointer, which is ptrs[0]
       @param p the first pointer
	 */
	void setInitPtr (Node p) {ptrs [0] = p;}

	/**
       Find index i s.t. keys [i] == val, or if val
       were to be inserted, keys [i] is where it should
       be placed.  More formally, returns i s.t.
       keys [i-1] < val <= keys [i], or 
       lastindex if val >= keys [lastindex]
       @param val the value to find 
       @return the index of the key where val should be
	 */
	public int findKeyIndex (int val){
		int i = 1;
		while (i<=lastindex) {
			if (val > keys[i-1] && val<=keys[i]) break;	
			i++;
		}
		return i;
	}

	/**
       Find index i s.t. ptrs [i] is the pointer that
       should be followed in the search for val.  More
       formally, returns i s.t.
       keys [i] <= val < keys [i + 1]
       or 0, if val < keys [1].  Note, cannot compute
       this result by incrementing or decrementing
       result of findKeyIndex
       @param val
       @return the index of pointer that we should follow in order to find val
	 */
	public int findPtrIndex (int val){
		int i = 0;
		
		do {
			if (val>=keys[i] && (i==lastindex || val<keys[i+1])) break;
			i++;
		} while (i <= lastindex);
	
		return i; 
	}

	/**
       Shifts pointers and keys beginning at ptrs [i]
       and keys [i + 1] as far left in the node as they
       can go, overwriting the current pointers and
       keys stored there.
       @param i the position it shifts from.
	 */
	void shiftleft (int i){
		ptrs [0] = ptrs [i];

		if (ptrs [0] != null) ptrs [0].getParent ().setIndex (0);

		for (int j = i+1; j <= lastindex; j++) {
			ptrs [j - i] = ptrs [j];
			keys [j - i] = keys [j];
			if (ptrs [j - i] != null) ptrs [j - i].getParent ().setIndex (j - i);
		}

		lastindex -= i;
	}

	/**
       Print to stdout the entire tree rooted at this node
	 */
	void print (){
		int indent = getDepth()* degree * 3 + (1 - getLevelKeyNumber()/getMaxLevelKeyNumber()) * 3 ;

		for (int i = 0; i < indent; i++){
			System.out.print(" ");
		}
		printLevel ();
		if (ptrs [0] != null) ptrs [0].print ();
	}

	/** 
	Print to stdout, this node and its next siblings
	 */
	void printLevel (){
		printNode ();
		if (next != null) {
			if ( siblings (next))
				System.out.print ("--");
			else 
				System.out.print ("   ");
			next.printLevel ();
		}else{
			System.out.println ();
		}
	}

	/**
       for printing purpose.
	 */
	int getDepth(){
		int i = 0;
		Node p = this;

		while ((p = p.ptrs[0]) != null)i++;
		return i;
	}

	/**
       Delete the key and pointer at index i.  Combine or
       redistribute nodes if necessary to preserve order of node.
       @param i the index of key and pointer to delete
	 */
	public void delete (int i){		
		deleteSimple(i);	
		if (lastindex<minkeys()) {			
			if (siblings(next) && combinable(next)) this.fancyCombine();
			else if (siblings(prev) && combinable(prev)) prev.fancyCombine();
			else if (siblings(next)) this.fancyRedistribute();
			else if (siblings(prev)) prev.fancyRedistribute();
		}
	}
	
	abstract protected void fancyRedistribute();
	
	abstract protected void fancyCombine();
	
	abstract protected void updateInternal(int val);
	
	abstract protected int getMinRST();
	
	/**
       The minimum number of keys this node should have, which differs from {@link LeafNode} and 
       {@link InternalNode}.
       @return the mininal number of key
	 */
	public abstract int minkeys ();

	/**
       Print to stdout, contents of this node.
	 */
	abstract void printNode ();

	/**
       Check if this node can be combined with other into a new node without splitting.
       Return TRUE if this node and other can be combined. 
       @return true if this node can be combined with other; otherwise false.
	 */
	public abstract boolean combinable (Node other);

	/**
       Combines the contents of this node and its next sibling (next)
       into a single node
	 */
	public abstract void combine ();

	/**
       Redistributes keys and pointers in this node and its
       next slibing so that they have the same number of keys
       and pointers, or so that this node has one more key and
       one more pointer,.  
       @return the key that must be inserted into parent node  
	 */
	public abstract int redistribute ();

	/**
       Inserts (val, ptr) pair into this node
       at keys [i] and ptrs [i].  Called when this
       node is not full.
       @param val the value to insert
       @param ptr the pointer to insert
       @param i the index where the key and pointer should be
	 */
	public abstract void insertSimple (int val, Node ptr, int i);

	/**
       Deletes keys [i] and ptrs [i] from this node,
       without performing any combination or redistribution afterwards.
       It is done by shifting all keys and pointers from index i+1 on
       one position to the left.
       @param i the index of key and pointer to delete
	 */
	public abstract void deleteSimple (int i);

	/**
       Equivalent to {@link #findKeyIndex} in {@link LeafNode} but calls
       itself recursively in {@link InternalNode}.
       @return the reference where the key should be
	 */
	public abstract Reference search (int val);

	/**
       The difference between
       {@link LeafNode} and {@link InternalNode} is whether a split
       creates a {@link LeafNode} or {@link InternalNode}, and whether the split
       results in a duplicate key being inserted
       into parent or not.  (For {@link LeafNode}, yes.  For
       {@link InternalNode}, no.)  
       @param val the value to insert 
       @param ptr the pointer to insert
	 */
	public abstract void insert (int val, Node ptr);
	
	
	// w/o calling this the tree would still be valid
	protected void UnnecessaryMethod() {
		// set keys to 0 so that tests pass.
		int i = lastindex+1;
		while (i<degree) {
			ptrs[i]=null;
			keys[i]=0;
			i++;
		}
	}

}

