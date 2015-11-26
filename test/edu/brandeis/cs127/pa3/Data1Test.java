package edu.brandeis.cs127.pa3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Data1Test {

	@Test
	public void test() {
		String[] commands = new String[] {"n3","i10","i20",
				"i30","i40","i50",
				"i60","d100","i15",
				"i5","i2","d30",
				"d15","d2","d5","d40"};
		
		BTree tree = Main.buildTree(commands);
		
		assertEquals(tree.degree, 3);
		assertEquals(tree.root.getKey(1), 20);
		assertEquals(tree.root.getKey(2), 50);
		
		assertEquals(tree.root.getPtr(0).getKey(1), 10);
		assertEquals(tree.root.getPtr(1).getKey(1), 20);
		assertEquals(tree.root.getPtr(2).getKey(1), 50);
		assertEquals(tree.root.getPtr(2).getKey(2), 60);

		assertEquals(tree.root.getPtr(0).getPtr(0), null);
		assertEquals(tree.root.getPtr(0).getPtr(1), null);
		assertEquals(tree.root.getPtr(0).getPtr(2), null);

		assertEquals(tree.root.getPtr(1).getPtr(0), null);
		assertEquals(tree.root.getPtr(1).getPtr(1), null);
		assertEquals(tree.root.getPtr(1).getPtr(2), null);
		
		assertEquals(tree.root.getPtr(2).getPtr(0), null);
		assertEquals(tree.root.getPtr(2).getPtr(1), null);
		assertEquals(tree.root.getPtr(2).getPtr(2), null);
		


		
	}

}
