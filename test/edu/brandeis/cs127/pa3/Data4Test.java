package edu.brandeis.cs127.pa3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Data4Test {

	@Test
	public void test() {
		String[] commands = new String[] { "n3", "d86", "d438", "i361", "i342", "i236", "i137", "i374", "d87", "d164",
				"d423", "i481", "d261", "i169", "d88", "i466", "i133", "d495", "i198", "d178", "i415", "d96", "i422",
				"d395", "d351", "i180", "d214", "i134", "d383", "d361", "d415", "d374" };

		BTree tree = Main.buildTree(commands);

//		assertEquals(tree.root.getKey(0), 0);
		assertEquals(tree.root.getKey(1), 236);
//		assertEquals(tree.root.getKey(2), 0);
//		assertEquals(tree.root.getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getKey(1), 169);
//		assertEquals(tree.root.getPtr(0).getKey(2), 0);
//		assertEquals(tree.root.getPtr(0).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getKey(1), 137);
//		assertEquals(tree.root.getPtr(0).getPtr(0).getKey(2), 0);
//		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getKey(1), 133);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getKey(2), 134);
//		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getKey(1), 137);
//		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getKey(2), 0);
//		assertEquals(tree.root.getPtr(0).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getKey(1), 198);
//		assertEquals(tree.root.getPtr(0).getPtr(1).getKey(2), 0);
//		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getKey(1), 169);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getKey(2), 180);
//		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getKey(1), 198);
//		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getKey(2), 0);
//		assertEquals(tree.root.getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getKey(1), 422);
//		assertEquals(tree.root.getPtr(1).getKey(2), 0);
//		assertEquals(tree.root.getPtr(1).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getKey(1), 342);
//		assertEquals(tree.root.getPtr(1).getPtr(0).getKey(2), 0);
//		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getKey(1), 236);
//		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getKey(2), 0);
//		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getKey(1), 342);
//		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getKey(2), 0);
//		assertEquals(tree.root.getPtr(1).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getKey(1), 466);
		assertEquals(tree.root.getPtr(1).getPtr(1).getKey(2), 481);
//		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getKey(1), 422);
//		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getKey(2), 0);
//		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getKey(1), 466);
//		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getKey(2), 0);
//		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getKey(1), 481);
//		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getKey(2), 0);

	}

}
