package edu.brandeis.cs127.pa3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Data3Test {

	@Test
	public void test() {
		String[] commands = new String[] { "n3", "i1", "i10", "i20", "i30", "i40", "i50", "i60", "i70", "i80", "i90",
				"i100", "i110", "i120", "i130", "i140", "i150", "i160", "i170", "d50", "d100", "d170", "i100", "i170",
				"d1", "i10", "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i10", "i11", "i12", "i13", "i14",
				"i15", "i16", "i17", "i18", "i19", "i20", "i21", "i22", "i23", "i24", "i25", "i26", "i27", "i28", "i29",
				"i30", "i31", "i32", "i33", "i34", "i35", "i36", "i37", "i38", "i39", "i40", "i41", "i42", "i43", "i44",
				"i45", "i46", "i47", "d110", "d21", "d22", "d23", "d41", "d24", "d170" };

		BTree tree = Main.buildTree(commands);

		assertEquals(tree.degree, 3);
		
		assertEquals(tree.root.getKey(1), 18);
		
		assertEquals(tree.root.getPtr(0).getKey(1), 10);
		
		assertEquals(tree.root.getPtr(0).getPtr(0).getKey(1), 5);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getKey(1), 3);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(0).getKey(1), 1);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(0).getKey(2), 2);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(1).getKey(1), 3);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(1).getKey(2), 4);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getKey(1), 7);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getKey(2), 9);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(0).getKey(1), 5);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(0).getKey(2), 6);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(1).getKey(1), 7);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(1).getKey(2), 8);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(2).getKey(1), 9);

		assertEquals(tree.root.getPtr(0).getPtr(1).getKey(1), 14);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getKey(1), 12);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getPtr(0).getKey(1), 10);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getPtr(0).getKey(2), 11);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getPtr(1).getKey(1), 12);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getPtr(1).getKey(2), 13);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getKey(1), 16);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(0).getKey(1), 14);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(0).getKey(2), 15);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(1).getKey(1), 16);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(1).getKey(2), 17);
		
		
		assertEquals(tree.root.getPtr(1).getKey(1), 34);
		assertEquals(tree.root.getPtr(1).getKey(2), 80);

		
		assertEquals(tree.root.getPtr(1).getPtr(0).getKey(1), 26);
		assertEquals(tree.root.getPtr(1).getPtr(0).getKey(2), 30);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getKey(1), 20);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getKey(2), 25);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(0).getKey(1), 18);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(0).getKey(2), 19);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(1).getKey(1), 20);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(2).getKey(1), 25);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getKey(1), 28);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getPtr(0).getKey(1), 26);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getPtr(0).getKey(2), 27);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getPtr(1).getKey(1), 28);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getPtr(1).getKey(2), 29);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getKey(1), 32);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(0).getKey(1), 30);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(0).getKey(2), 31);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(1).getKey(1), 32);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(1).getKey(2), 33);
		
		assertEquals(tree.root.getPtr(1).getPtr(1).getKey(1), 40);
		assertEquals(tree.root.getPtr(1).getPtr(1).getKey(2), 44);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getKey(1), 36);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getKey(2), 38);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(0).getKey(1), 34);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(0).getKey(2), 35);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(1).getKey(1), 36);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(1).getKey(2), 37);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(2).getKey(1), 38);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(2).getKey(2), 39);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getKey(1), 42);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(0).getKey(1), 40);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(1).getKey(1), 42);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(1).getKey(2), 43);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getKey(1), 46);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getKey(2), 60);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(0).getKey(1), 44);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(0).getKey(2), 45);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(1).getKey(1), 46);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(1).getKey(2), 47);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(2).getKey(1), 60);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(2).getKey(2), 70);
		
		assertEquals(tree.root.getPtr(1).getPtr(2).getKey(1), 120);
		assertEquals(tree.root.getPtr(1).getPtr(2).getPtr(0).getKey(1), 100);
		assertEquals(tree.root.getPtr(1).getPtr(2).getPtr(0).getPtr(0).getKey(1), 80);
		assertEquals(tree.root.getPtr(1).getPtr(2).getPtr(0).getPtr(0).getKey(2), 90);
		assertEquals(tree.root.getPtr(1).getPtr(2).getPtr(0).getPtr(1).getKey(1), 100);
		assertEquals(tree.root.getPtr(1).getPtr(2).getPtr(1).getKey(1), 140);
		assertEquals(tree.root.getPtr(1).getPtr(2).getPtr(1).getKey(2), 160);
		assertEquals(tree.root.getPtr(1).getPtr(2).getPtr(1).getPtr(0).getKey(1), 120);
		assertEquals(tree.root.getPtr(1).getPtr(2).getPtr(1).getPtr(0).getKey(2), 130);
		assertEquals(tree.root.getPtr(1).getPtr(2).getPtr(1).getPtr(1).getKey(1), 140);
		assertEquals(tree.root.getPtr(1).getPtr(2).getPtr(1).getPtr(1).getKey(2), 150);
		assertEquals(tree.root.getPtr(1).getPtr(2).getPtr(1).getPtr(2).getKey(1), 160);

		







		

	}

}
