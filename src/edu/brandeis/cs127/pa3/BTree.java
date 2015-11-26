package edu.brandeis.cs127.pa3;

import java.io.File;
import java.io.FileOutputStream;
/**
   Class of B+-Trees.  All search, insertion and deletion
   routines are invoked through the B+-Tree object.
 */
public class BTree{

	int degree;
	Node root;

	public static FileOutputStream outfile = null;
	private static int nodeNames = 1;

	/**
       Construct a BTree object with degree d. 
       @param d the degree of BTree
	 */
	public BTree (int d) {
		degree = d;
		root = null;
	}

	public static String nextNodeName() {
		return "n" + String.valueOf(nodeNames++);
	}

	/**
	 * This produced a graphviz (dot language) output
	 * to generate a viewable representation of this tree
	 */
	public void outputForGraphviz() {
		String header = "digraph btree {\n";
		String footer = "\n}\n";

		// At each call, reopen the file
		try {
			if (outfile != null) outfile.close();
			outfile = new FileOutputStream(new File("tree.dot"));
		} catch (Exception e) {
			System.out.println("Fatal: Exception "+e+" occured while opening output file outstream");
			System.exit(-1);
		}

		writeOut(header);
		if (root != null)
			root.outputForGraphviz();
		writeOut(footer);
	}


	/**
	 * Writes the string out to the output file
	 *
	 * @param s String to write out
	 */
	public static void writeOut(String s) {
		try {
			outfile.write(s.getBytes());
		} catch (Exception e) {
			System.out.println("Fatal: Exception "+e+" occured while writing to file");
			System.exit(-1);
		}
	}

	/**
       Return leaf node location of where val does or SHOULD
       appear within this B+-Tree.  Result will indicate
       which leaf node (result.getNode ()) and which key
       index within this leaf node (result.getIndex ()).
       @param val the value to look for in the B tree
	 */
	public void search (int val) {

		System.out.println("\n");

		System.out.println("SEARCH: ");

		if (root == null) 
			System.out.println(val + " not found in empty tree.");
		else {

			// Find where val should be
			Reference l = root.search (val);

			// Is this where it actually is?
			if (l.getMatch ()) {
				System.out.print(val + " found at index, " +l.getIndex ()+" in leaf node, ");
				l.getNode ().printNode ();
				System.out.println(".");
			} else
				System.out.println(val + " not found in existing tree.");
		}
	}

	/** 
	Insert a integer val in its proper location in the tree.
	Must make sure to update the root afterwards if it is replaced.
	@param val the value to insert to the btree 
	 */
	public void insert (int val) {

		System.out.println("\n");
		System.out.print("INSERT: ");
		if (root == null) {

			// This is the first insert in the tree - time to create a node
			root = new LeafNode  (degree, val, null, null);
			System.out.println(val);
		} else {

			// First search where to put the new key

			Reference l = root.search (val);

			if (l.getMatch ())
				System.out.println(val + " is already in the tree.");
			else {

				// The tree doesn't contain this key so call insert on the leaf where it should appear

				l.getNode ().insert (val, null);
				System.out.println(val);

				// Check to see if we have a new root and update if necessary
				if (root.getParent () != null)
					root = root.getParent ().getNode ();
			}
		}
	}   

	/**
       Printout current B+ tree
	 */
	public void print () {
		if (root == null)
			System.out.println("EMPTY TREE");
		else
			root.print ();
	}

	/**
       Delete a value from the B+ tree if it exists in a leaf node.
       @param val the value to delete from this B tree
	 */
	public void delete (int val) {

		System.out.println("\n");
		System.out.println("DELETE: "+val);
		
		if (val==257) {
			System.out.println(val);
		}	

		if (root == null)   
			System.out.println(val + " not in empty tree.");
		else {
			Reference l = root.search (val);

			if (! l.getMatch ())     
				System.out.println(val + " not in tree");
			else {
				l.getNode ().delete (l.getIndex ());

				// Replace the root if it consists of just a single pointer
				if (root.getLast () == 0) {
					root = root.getPtr (0);
					if (root != null) root.parentref = null;
				}
			}
		}
	}
}
