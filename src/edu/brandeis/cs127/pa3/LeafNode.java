package edu.brandeis.cs127.pa3;

/**
   LeafNodes of B+ trees
 */
public class LeafNode extends Node {

	/**
       Construct a LeafNode object and initialize it with the parameters.
       @param d the degree of the leafnode
       @param k the first key value of the node
       @param n the next node 
       @param p the previous node
	 */
	public LeafNode (int d, int k, Node n, Node p){
		super (d, n, p);
		keys [1] = k;
		lastindex = 1;
	}      


	public void outputForGraphviz() {

		// The name of a node will be its first key value
		// String name = "L" + String.valueOf(keys[1]);
		// name = BTree.nextNodeName();

		// Now, prepare the label string
		String label = "";
		for (int j = 0; j < lastindex; j++) {
			if (j > 0) label += "|";
			label += String.valueOf(keys[j+1]);
		}
		// Write out this node
		BTree.writeOut(myname + " [shape=record, label=\"" + label + "\"];\n");
	}

	/** 
	the minimum number of keys the leaf node should have.
	 */
	public int minkeys () {
		if (parentref==null) {
			return 1;
		} else {
			return degree/2;
		}
	}

	/**
       Check if this node can be combined with other into a new node without splitting.
       Return TRUE if this node and other can be combined. 
       @return true if this node can be combined with other; otherwise false.
	 */
	public boolean combinable (Node other){
		return lastindex+other.lastindex<degree;
	}

	/**
       Combines contents of this node and its next sibling (nextsib)
       into a single node
	 */
	public void combine (){
		Node ns=this.next;
		System.arraycopy(ns.keys, 1, keys, lastindex+1, ns.lastindex);
		lastindex+=ns.lastindex;
		this.next = ns.next;
		if (this.next!=null) this.next.prev = this;
		UnnecessaryMethod();
	}

	/**
       Redistributes keys and pointers in this node and its
       next sibling so that they have the same number of keys
       and pointers, or so that this node has one more key and
       one more pointer,.  
       @return int Returns key that must be inserted
       into parent node.
	 */
	public int redistribute (){  
		Node ns = this.getNext();
		int newLastindex = (lastindex+ns.lastindex+1)/2;
		int keysShifted = Math.abs(lastindex-newLastindex);
		
		if (newLastindex<lastindex) {
			System.arraycopy(ns.keys, 1, ns.keys, keysShifted+1, ns.lastindex);
			System.arraycopy(keys, newLastindex+1, ns.keys, 1, keysShifted);
		} else {
			System.arraycopy(ns.keys, 1, keys, lastindex+1, keysShifted);
			System.arraycopy(ns.keys, 1+keysShifted, ns.keys, 1, ns.lastindex-keysShifted);
		}
		ns.lastindex += lastindex-newLastindex;
		lastindex = newLastindex;
		
		UnnecessaryMethod();
		ns.UnnecessaryMethod();
		return ns.keys[1];
	}

	/**
       Insert val into this node at keys [i].  (Ignores ptr) Called when this
       node is not full.
       @param val the value to insert to current node
       @param ptr not used now, use null when call this method 
       @param i the index where this value should be
	 */
	public void insertSimple (int val, Node ptr, int i){
		System.arraycopy(keys, i, keys, i+1, lastindex+1-i);
		keys[i] = val;
		lastindex++;
		UnnecessaryMethod();
	}


	/**
       Deletes keys [i] and ptrs [i] from this node,
       without performing any combination or redistribution afterwards.
       Does so by shifting all keys from index i+1 on
       one position to the left.  
	 */
	public void deleteSimple (int i){
		System.arraycopy(keys, i+1, keys, i, lastindex-i);
		lastindex--;
		UnnecessaryMethod();
	} 

	/**
       Uses findKeyIndex, and if val is found, returns the reference with match set to true, otherwise returns
       the reference with match set to false.
       @return a Reference object referring to this node. 
	 */
	public Reference search (int val){
		int loc = this.findKeyIndex(val);
		boolean foundYa = false;
		if (loc>lastindex) {
			foundYa = val==keys[loc-1];
			loc=lastindex;
		} else {
			foundYa = val==keys[loc];
		}
		return new Reference(this, loc, foundYa);
	}

	/**
       Insert val into this, creating split
       and recursive insert into parent if necessary
       Note that ptr is ignored.
       @param val the value to insert
       @param ptr (not used now, use null when calling this method)
	 */
	public void insert (int val, Node ptr){
		
		int toIndex = findKeyIndex(val);
		
		// if leafnode not full then just insert the key
		if (!full()) {
			insertSimple(val,null,toIndex);
			return;
		}
		
		// otherwise make a new right sibling for the current node, redistribute.
		Node ns = null;
		if (toIndex>lastindex) {
			ns = new LeafNode(degree, val, this.next,(Node) this);
		} else {
			ns = new LeafNode(degree, keys[lastindex], this.next,(Node) this);
			lastindex--;
			insertSimple(val,null,toIndex);
		}
	
		int toParent = redistribute();
		
		//insert into parent
		if (this.parentref!=null) {
			this.getParent().getNode().insert(toParent, ns);
		} else {
			new InternalNode(degree,this,toParent,ns,null,null); 
		}
	}


	/**
       Print to stdout the content of this node
	 */
	void printNode (){
		System.out.print ("[");
		for (int i = 1; i < lastindex; i++) 
			System.out.print (keys[i]+" ");
		System.out.print (keys[lastindex] + "]");
	}
}
