package edu.brandeis.cs127.pa3;

/**
    Internal Nodes of B+-Trees.
    @author cs127b
 */
public class InternalNode extends Node{

	/**
       Construct an InternalNode object and initialize it with the parameters.
       @param d degree
       @param p0 the pointer at the left of the key
       @param k1 the key value
       @param p1 the pointer at the right of the key
       @param n the next node
       @param p the previous node
	 */
	public InternalNode (int d, Node p0, int k1, Node p1, Node n, Node p){

		super (d, n, p);
		ptrs [0] = p0;
		keys [1] = k1;
		ptrs [1] = p1;
		lastindex = 1;

		if (p0 != null) p0.setParent (new Reference (this, 0, false));
		if (p1 != null) p1.setParent (new Reference (this, 1, false));
	}

	/**
       The minimal number of keys this node should have.
       @return the minimal number of keys a leaf node should have.
	 */
	public int minkeys () {
		if (parentref==null) return 1;
		else return (degree-1)/2;
	}

	/**
       Check if this node can be combined with other into a new node without splitting.
       Return TRUE if this node and other can be combined. 
	 */
	public boolean combinable (Node other) {
		return lastindex+other.lastindex<degree-1;
	}


	/**
       Combines contents of this node and its next sibling (next)
       into a single node,
	 */
	public void combine () {
		Node ns=this.next;
		System.arraycopy(ns.keys, 1, keys, lastindex+1, ns.lastindex);
		System.arraycopy(ns.ptrs, 1, ptrs, lastindex+1, ns.lastindex);
		lastindex+=ns.lastindex;
		this.setNext(ns.next);
		if (this.next!=null) this.getNext().setPrev(this);
		readopt();
		UnnecessaryMethod();
	}

	/**
       Redistributes keys and pointers in this node and its
       next sibling so that they have the same number of keys
       and pointers, or so that this node has one more key and
       one more pointer.  Returns the key that must be inserted
       into parent node.
       @return the value to be inserted to the parent node
	 */
	public int redistribute () {
		InternalNode ns = (InternalNode) this.getNext();
		int newLastindex = (lastindex+ns.lastindex)/2;
		int keysShifted = Math.abs(lastindex-newLastindex);
		
		if (newLastindex<lastindex) { 
			//redistribute keys
			System.arraycopy(ns.keys, 1, ns.keys, keysShifted, ns.lastindex);
			System.arraycopy(keys, newLastindex+1, ns.keys, 0, keysShifted);
			//redistribute pointers
			System.arraycopy(ns.ptrs, 0, ns.ptrs, keysShifted-1, ns.lastindex+1);
			System.arraycopy(ptrs, newLastindex+1, ns.ptrs, 0, keysShifted);
		} else {
			//redistribute keys
			System.arraycopy(ns.keys, 1, keys, lastindex+1, keysShifted);
			System.arraycopy(ns.keys, keysShifted+1, ns.keys, 0, ns.lastindex-keysShifted);
			//redistribute pointers
			System.arraycopy(ns.ptrs, 0, ptrs, lastindex, keysShifted+1);
			System.arraycopy(ns.ptrs, keysShifted+1, ns.ptrs, 0, ns.lastindex-keysShifted);
		}
		
		ns.lastindex += lastindex-newLastindex-1;
		this.lastindex = newLastindex;		
		
		int toParent = ns.keys[0];
		ns.keys[0]=0;
		
		readopt();
		ns.readopt();
		
		UnnecessaryMethod();
		ns.UnnecessaryMethod();
		return toParent;
	}
	
	/**
       Inserts (val, ptr) pair into this node
       at keys [i] and ptrs [i].  Called when this
       node is not full.  Differs from {@link LeafNode} routine in
       that updates parent references of all ptrs from index i+1 on.
       @param val the value to insert
       @param ptr the pointer to insert 
       @param i the position to insert the value and pointer
	 */
	public void insertSimple (int val, Node ptr, int i) {
		
		System.arraycopy(keys, i, keys, i+1, lastindex+1-i);
		System.arraycopy(ptrs, i, ptrs, i+1, lastindex+1-i);
		keys[i]=val;
		ptrs[i]=ptr;
		lastindex++;
		readopt();
		UnnecessaryMethod();
	}

	/**
       Deletes keys [i] and ptrs [i] from this node,
       without performing any combination or redistribution afterwards.
       Does so by shifting all keys and pointers from index i+1 on
       one position to the left.  Differs from {@link LeafNode} routine in
       that updates parent references of all ptrs from index i+1 on.
       @param i the index of the key to delete
	 */
	public void deleteSimple (int i) {
		
		if (i < lastindex) {
			System.arraycopy(keys, i+1, keys, i, lastindex-i);
			System.arraycopy(ptrs, i+1, ptrs, i, lastindex-i);	
		}
		lastindex--;	
		readopt();	
		UnnecessaryMethod();
	}


	/**
       Uses findPtrInex and calls itself recursively until find the value or find the position 
       where the value should be.
       @return the reference pointing to a leaf node.
	 */
	public Reference search (int val) {
		Node nextPtr = ptrs[this.findPtrIndex(val)];
		return nextPtr.search(val);
	}

	/**
       Insert (val, ptr) into this node. Uses insertSimple, redistribute etc.
       Insert into parent recursively if necessary
       @param val the value to insert
       @param ptr the pointer to insert 
	 */
	public void insert (int val, Node ptr) {

		int toIndex = findKeyIndex(val);

		// if not full then just insert the key
		if (!full()) {
			insertSimple(val,ptr,toIndex);
			return;
		}
		// otherwise make a new right sibling for the current node, redistribute.
		Node ns = null;
		if (toIndex>lastindex) {
			ns = new InternalNode(degree,null,val,ptr,next,(Node) this);
		} else {
			ns = new InternalNode(degree, null,keys[lastindex], ptrs[lastindex], next,(Node) this);	
			lastindex--;
			insertSimple(val,ptr,toIndex);
		}
		
		int toParent = redistribute();
		// recursively insert into parent if exists
		if (getParent()!=null) parentref.getNode().insert(toParent, ns);				
		else new InternalNode(degree,this,toParent,ns,null,null);
	}
	
	protected void fancyCombine() {
		// the index to be removed in parent
		int toRemove = next.parentref.getIndex();
		// value in that key
		int bringDown = parentref.getNode().keys[toRemove];
		// insert in any of these two nodes that is not full
		if (next.full()) insert(bringDown, next.ptrs[0]);
		else next.insert(bringDown, next.ptrs[0]);
		// combine
		this.combine();
		// remove from parent right siblings pointer and key
		parentref.getNode().delete(toRemove);	
	}
	
	protected void fancyRedistribute() {
		// the index to be replaced in parent
		int toRemove = next.parentref.getIndex();
		// value in that key
		int bringDown = parentref.getNode().keys[toRemove];
		
		// insert in any of these two nodes that is not full
		if (next.full()) insert(bringDown, next.ptrs[0]);
		else next.insert(bringDown, next.ptrs[0]);
		
		// redistribute
		int toParent = this.redistribute();
		//replace key in parent
		parentref.getNode().keys[toRemove] = toParent;
	}
	
	protected void updateInternal(int val) {
		// index the value deleted
		int outOfDateIndex = this.findKeyIndex(val);
		
		if (outOfDateIndex>lastindex) outOfDateIndex--;
		// recursively look for the key's occurrence in ancestors 
		if (val==keys[outOfDateIndex]) {
			// if found, recursively look for minimum in the current node's right subtree
			keys[outOfDateIndex] = ptrs[outOfDateIndex].getMinRST();
			return;
		}
		if (parentref!=null) parentref.getNode().updateInternal(val);
	}
	
	public int getMinRST() {
		return this.ptrs[0].getMinRST();
	}


	public void outputForGraphviz() {

		// The name of a node will be its first key value
		// String name = "I" + String.valueOf(keys[1]);
		// name = BTree.nextNodeName();

		// Now, prepare the label string
		String label = "";
		for (int j = 0; j <= lastindex; j++) {
			if (j > 0) label += "|";
			label += "<p" + ptrs[j].myname + ">";
			if (j != lastindex) label += "|" + String.valueOf(keys[j+1]);
			// Write out any link now
			BTree.writeOut(myname + ":p" + ptrs[j].myname + " -> " + ptrs[j].myname + "\n");
			// Tell your child to output itself
			ptrs[j].outputForGraphviz();
		}
		// Write out this node
		BTree.writeOut(myname + " [shape=record, label=\"" + label + "\"];\n");
	}

	/**
       Print out the content of this node
	 */
	void printNode () {

		int j;
		System.out.print("[");
		for (j = 0; j <= lastindex; j++) {
			if (j == 0)
				System.out.print (" * ");
			else
				System.out.print(keys[j] + " * ");

			if (j == lastindex)
				System.out.print ("]");
		}
	}
	
	protected void readopt() {
		for (int i=0;i<=this.lastindex;i++) {
			ptrs[i].setParent(new Reference(this,i,false));
		}
	}
}


