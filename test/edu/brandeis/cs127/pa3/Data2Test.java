package edu.brandeis.cs127.pa3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Data2Test {

	@Test
	public void test() {
		String[] commands = new String[] { "n10", "i1", "i10", "i20", "i30", "i40", "i50", "i60", "i70", "i80", "i90",
				"i100", "i110", "i120", "i130", "i140", "i150", "i160", "i170", "d50", "d100", "d170", "i100", "i170",
				"d1", "i10", "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i10", "i11", "i12", "i13", "i14",
				"i15", "i16", "i17", "i18", "i19", "i20", "i21", "i22", "i23", "i24", "i25", "i26", "i27", "i28", "i29",
				"i30", "i31", "i32", "i33", "i34", "i35", "i36", "i37", "i38", "i39", "i40", "i41", "i42", "i43", "i44",
				"i45", "i46", "i47", "d110", "d21", "d22", "d23", "d41", "d24", "d170" };

		BTree tree = Main.buildTree(commands);

		assertEquals(tree.degree, 10);
		
		assertEquals(tree.root.getKey(1), 31);
		
		assertEquals(tree.root.getPtr(0).getKey(1), 6);
		assertEquals(tree.root.getPtr(0).getKey(2), 11);
		assertEquals(tree.root.getPtr(0).getKey(3), 16);
		assertEquals(tree.root.getPtr(0).getKey(4), 25);
		
		assertEquals(tree.root.getPtr(0).getPtr(0).getKey(1), 1);
		assertEquals(tree.root.getPtr(0).getPtr(0).getKey(2), 2);
		assertEquals(tree.root.getPtr(0).getPtr(0).getKey(3), 3);
		assertEquals(tree.root.getPtr(0).getPtr(0).getKey(4), 4);
		assertEquals(tree.root.getPtr(0).getPtr(0).getKey(5), 5);
		
		assertEquals(tree.root.getPtr(0).getPtr(1).getKey(1), 6);
		assertEquals(tree.root.getPtr(0).getPtr(1).getKey(2), 7);
		assertEquals(tree.root.getPtr(0).getPtr(1).getKey(3), 8);
		assertEquals(tree.root.getPtr(0).getPtr(1).getKey(4), 9);
		assertEquals(tree.root.getPtr(0).getPtr(1).getKey(5), 10);
		
		assertEquals(tree.root.getPtr(0).getPtr(2).getKey(1), 11);
		assertEquals(tree.root.getPtr(0).getPtr(2).getKey(2), 12);
		assertEquals(tree.root.getPtr(0).getPtr(2).getKey(3), 13);
		assertEquals(tree.root.getPtr(0).getPtr(2).getKey(4), 14);
		assertEquals(tree.root.getPtr(0).getPtr(2).getKey(5), 15);

		assertEquals(tree.root.getPtr(0).getPtr(3).getKey(1), 16);
		assertEquals(tree.root.getPtr(0).getPtr(3).getKey(2), 17);
		assertEquals(tree.root.getPtr(0).getPtr(3).getKey(3), 18);
		assertEquals(tree.root.getPtr(0).getPtr(3).getKey(4), 19);
		assertEquals(tree.root.getPtr(0).getPtr(3).getKey(5), 20);
		
		assertEquals(tree.root.getPtr(0).getPtr(4).getKey(1), 25);
		assertEquals(tree.root.getPtr(0).getPtr(4).getKey(2), 26);
		assertEquals(tree.root.getPtr(0).getPtr(4).getKey(3), 27);
		assertEquals(tree.root.getPtr(0).getPtr(4).getKey(4), 28);
		assertEquals(tree.root.getPtr(0).getPtr(4).getKey(5), 29);
		assertEquals(tree.root.getPtr(0).getPtr(4).getKey(6), 30);
		
		
		
		
		assertEquals(tree.root.getPtr(1).getKey(1), 36);
		assertEquals(tree.root.getPtr(1).getKey(2), 42);
		assertEquals(tree.root.getPtr(1).getKey(3), 60);
		assertEquals(tree.root.getPtr(1).getKey(4), 120);
		
		assertEquals(tree.root.getPtr(1).getPtr(0).getKey(1), 31);
		assertEquals(tree.root.getPtr(1).getPtr(0).getKey(2), 32);
		assertEquals(tree.root.getPtr(1).getPtr(0).getKey(3), 33);
		assertEquals(tree.root.getPtr(1).getPtr(0).getKey(4), 34);
		assertEquals(tree.root.getPtr(1).getPtr(0).getKey(5), 35);
		
		assertEquals(tree.root.getPtr(1).getPtr(1).getKey(1), 36);
		assertEquals(tree.root.getPtr(1).getPtr(1).getKey(2), 37);
		assertEquals(tree.root.getPtr(1).getPtr(1).getKey(3), 38);
		assertEquals(tree.root.getPtr(1).getPtr(1).getKey(4), 39);
		assertEquals(tree.root.getPtr(1).getPtr(1).getKey(5), 40);
		
		assertEquals(tree.root.getPtr(1).getPtr(2).getKey(1), 42);
		assertEquals(tree.root.getPtr(1).getPtr(2).getKey(2), 43);
		assertEquals(tree.root.getPtr(1).getPtr(2).getKey(3), 44);
		assertEquals(tree.root.getPtr(1).getPtr(2).getKey(4), 45);
		assertEquals(tree.root.getPtr(1).getPtr(2).getKey(5), 46);
		assertEquals(tree.root.getPtr(1).getPtr(2).getKey(6), 47);


		assertEquals(tree.root.getPtr(1).getPtr(3).getKey(1), 60);
		assertEquals(tree.root.getPtr(1).getPtr(3).getKey(2), 70);
		assertEquals(tree.root.getPtr(1).getPtr(3).getKey(3), 80);
		assertEquals(tree.root.getPtr(1).getPtr(3).getKey(4), 90);
		assertEquals(tree.root.getPtr(1).getPtr(3).getKey(5), 100);
		
		assertEquals(tree.root.getPtr(1).getPtr(4).getKey(1), 120);
		assertEquals(tree.root.getPtr(1).getPtr(4).getKey(2), 130);
		assertEquals(tree.root.getPtr(1).getPtr(4).getKey(3), 140);
		assertEquals(tree.root.getPtr(1).getPtr(4).getKey(4), 150);
		assertEquals(tree.root.getPtr(1).getPtr(4).getKey(5), 160);
		

		

	}

}
