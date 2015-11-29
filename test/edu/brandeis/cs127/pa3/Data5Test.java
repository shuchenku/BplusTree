package edu.brandeis.cs127.pa3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Data5Test {

	@Test
	public void test() {
		String[] commands = new String[] { "n4", "i128", "i34", "i446", "i163", "i73", "i350", "i171", "i76", "i327",
				"i108", "i121", "i226", "i92", "i344", "i201", "i404", "i381", "i353", "i132", "i355", "i234", "i204",
				"i58", "i326", "i190", "i437", "i221", "i161", "i181", "i71", "i270", "i308", "i105", "i216", "i470",
				"i178", "i65", "i141", "i253", "i392", "i248", "i374", "i117", "i340", "i218", "i317", "i243", "i98",
				"i170", "i375", "i405", "i10", "i267", "d470", "d128", "i197", "d132", "d405", "i477", "i54", "d308",
				"d10", "i146", "d375", "i471", "i196", "d326", "i102", "i152", "i19", "d71", "i214", "i127", "i495",
				"i164", "i472", "d477", "d92", "i257", "d374", "i215", "i100", "i265", "i132", "d253", "i195", "d381",
				"d19", "d34", "i96", "i59", "i148", "i23", "i155", "d204", "i6", "d96", "i457", "d317", "i259", "i239",
				"d392", "i361", "d98", "d404", "i77", "d257", "i493", "d471", "i60", "i166", "i83", "i169", "i86",
				"d132", "d54", "d327", "d472", "i305", "i45", "i255", "i167", "i346", "i291", "d340", "d493", "d437",
				"i217", "i96", "d58", "i145", "i90", "d6", "i101", "d127", "i12", "d267", "i389", "i337", "i418", "i28",
				"d117", "d446", "d23", "i129", "i266", "d166", "d216", "i413", "d495", "i461", "d413", "i157", "d337",
				"d12", "d141", "i147", "i448", "i78", "d145", "i46", "d28", "i250", "i375", "i12", "d197", "d344",
				"i199", "d418", "i470", "d291", "i397", "d355", "d45", "d346", "i138", "d59", "i71", "d350", "d470",
				"d305", "i298", "i269", "d83", "i32", "i68", "d157", "d255", "i309", "d448", "i434", "i482", "d199",
				"i285", "i496", "i335", "d434", "i388", "i130", "d353", "i22", "d482", "i384", "i188", "i13", "i314",
				"d214", "d457", "d361", "i414", "d496", "i124", "d384", "i44", "i482", "d170", "i316", "i180", "i385",
				"d397", "d12", "i343", "i498", "d108", "d498", "i187", "d270", "d335", "i323", "d161", "d265", "d309",
				"i479", "d285", "d375", "i260", "d385", "i53", "d388", "i208", "d187", "d316", "d208", "i103", "i499",
				"d343", "d90", "i332", "i123", "i432", "d269", "i325", "i293", "d499", "i37", "i33", "i104", "d169",
				"d13", "d389", "d32", "i240", "i301", "i189", "d178", "i399", "d314", "i79", "i106", "i272", "i277",
				"d399", "d152", "i182", "i292", "i117", "d180", "d461", "d432", "i399", "i252", "d46", "i21", "i168",
				"i193", "d259", "d243", "i346", "d138", "i29", "d44", "i247", "i500", "i191", "d323", "i28", "i387",
				"i137", "d191", "d28", "d247", "d387", "d399", "i376", "i223", "d479", "d53", "i475", "i387", "i474",
				"i253", "i282", "i74", "d60", "d221", "i149", "d376", "d474", "i197", "d277", "d223", "i179", "d475",
				"i318", "d318", "d21", "i294", "d215", "d217", "d129", "d332", "d414", "i273", "d482", "d147", "i385",
				"d22", "i138", "d218", "d146", "i246", "i107", "i448", "d448", "i69", "i87", "d325", "d74", "i305",
				"i42", "d201", "d346", "i490", "d490", "i408", "i241", "i261", "d193", "i156", "i365", "i122", "d117",
				"d29", "i1", "i191", "i183", "d1", "d33", "d37", "d163", "d79", "d42", "d246", "i46", "d298", "d124",
				"d365", "i344", "d46", "d65", "i383", "i11", "d195", "i306", "i499", "d11", "i368", "i416", "i228",
				"d68", "i371", "i444", "i375", "d69", "d130", "i423", "i227", "d368", "d499", "i70", "d137", "i33",
				"i108", "d121", "d416", "i355", "d260", "d33", "i88", "i438", "i56", "d226", "d292", "i204", "i254",
				"d204", "d355", "i384", "d183", "d293", "i121", "i372", "d444", "d56", "i405", "d239", "d344", "d248",
				"i49", "d371", "d227", "i184", "i290", "i27", "d70", "d71", "i451", "d73", "d372", "i413", "i31",
				"i178", "d121", "d451", "i365", "d27", "i351", "i157", "i213", "i114", "d31", "i459", "d114", "i332",
				"d100", "i144", "i395", "d49", "i242", "d171", "i214", "i192", "i275", "d213", "d76", "d266", "i495",
				"i460", "i243", "d77", "d78", "i473", "d86", "d438", "i361", "i342", "i236", "i137", "i374", "d87" };

		BTree tree = Main.buildTree(commands);

		
		assertEquals(tree.root.getKey(0), 0);
		assertEquals(tree.root.getKey(1), 228);
		assertEquals(tree.root.getKey(2), 0);
		assertEquals(tree.root.getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getKey(1), 178);
		assertEquals(tree.root.getPtr(0).getKey(2), 0);
		assertEquals(tree.root.getPtr(0).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getKey(1), 106);
		assertEquals(tree.root.getPtr(0).getPtr(0).getKey(2), 138);
		assertEquals(tree.root.getPtr(0).getPtr(0).getKey(3), 155);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getKey(1), 101);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getKey(2), 104);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(0).getKey(1), 88);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(0).getKey(2), 96);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(0).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(1).getKey(1), 101);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(1).getKey(2), 102);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(1).getKey(3), 103);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(2).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(2).getKey(1), 104);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(2).getKey(2), 105);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(0).getPtr(2).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getKey(1), 108);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getKey(2), 123);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(0).getKey(1), 106);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(0).getKey(2), 107);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(0).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(1).getKey(1), 108);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(1).getKey(2), 122);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(2).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(2).getKey(1), 123);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(2).getKey(2), 137);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(1).getPtr(2).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(2).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(2).getKey(1), 148);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(2).getKey(2), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(2).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(2).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(2).getPtr(0).getKey(1), 138);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(2).getPtr(0).getKey(2), 144);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(2).getPtr(0).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(2).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(2).getPtr(1).getKey(1), 148);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(2).getPtr(1).getKey(2), 149);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(2).getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(3).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(3).getKey(1), 164);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(3).getKey(2), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(3).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(3).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(3).getPtr(0).getKey(1), 155);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(3).getPtr(0).getKey(2), 156);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(3).getPtr(0).getKey(3), 157);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(3).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(3).getPtr(1).getKey(1), 164);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(3).getPtr(1).getKey(2), 167);
		assertEquals(tree.root.getPtr(0).getPtr(0).getPtr(3).getPtr(1).getKey(3), 168);
		assertEquals(tree.root.getPtr(0).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getKey(1), 189);
		assertEquals(tree.root.getPtr(0).getPtr(1).getKey(2), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getKey(1), 182);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getKey(2), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getPtr(0).getKey(1), 178);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getPtr(0).getKey(2), 179);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getPtr(0).getKey(3), 181);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getPtr(1).getKey(1), 182);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getPtr(1).getKey(2), 184);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(0).getPtr(1).getKey(3), 188);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getKey(1), 191);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getKey(2), 196);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(0).getKey(1), 189);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(0).getKey(2), 190);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(0).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(1).getKey(1), 191);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(1).getKey(2), 192);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(2).getKey(0), 0);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(2).getKey(1), 196);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(2).getKey(2), 197);
		assertEquals(tree.root.getPtr(0).getPtr(1).getPtr(1).getPtr(2).getKey(3), 214);
		assertEquals(tree.root.getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getKey(1), 294);
		assertEquals(tree.root.getPtr(1).getKey(2), 0);
		assertEquals(tree.root.getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getKey(1), 250);
		assertEquals(tree.root.getPtr(1).getPtr(0).getKey(2), 261);
		assertEquals(tree.root.getPtr(1).getPtr(0).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getKey(1), 240);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getKey(2), 242);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(0).getKey(1), 228);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(0).getKey(2), 234);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(0).getKey(3), 236);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(1).getKey(1), 240);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(1).getKey(2), 241);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(2).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(2).getKey(1), 242);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(2).getKey(2), 243);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(0).getPtr(2).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getKey(1), 253);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getKey(2), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getPtr(0).getKey(1), 250);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getPtr(0).getKey(2), 252);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getPtr(0).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getPtr(1).getKey(1), 253);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getPtr(1).getKey(2), 254);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(1).getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getKey(1), 273);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getKey(2), 282);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(0).getKey(1), 261);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(0).getKey(2), 272);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(0).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(1).getKey(1), 273);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(1).getKey(2), 275);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(2).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(2).getKey(1), 282);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(2).getKey(2), 290);
		assertEquals(tree.root.getPtr(1).getPtr(0).getPtr(2).getPtr(2).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getKey(1), 351);
		assertEquals(tree.root.getPtr(1).getPtr(1).getKey(2), 385);
		assertEquals(tree.root.getPtr(1).getPtr(1).getKey(3), 459);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getKey(1), 305);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getKey(2), 332);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(0).getKey(1), 294);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(0).getKey(2), 301);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(0).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(1).getKey(1), 305);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(1).getKey(2), 306);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(2).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(2).getKey(1), 332);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(2).getKey(2), 342);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(0).getPtr(2).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getKey(1), 365);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getKey(2), 375);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(0).getKey(1), 351);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(0).getKey(2), 361);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(0).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(1).getKey(1), 365);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(1).getKey(2), 374);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(2).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(2).getKey(1), 375);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(2).getKey(2), 383);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(1).getPtr(2).getKey(3), 384);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getKey(1), 405);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getKey(2), 413);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(0).getKey(1), 385);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(0).getKey(2), 387);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(0).getKey(3), 395);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(1).getKey(1), 405);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(1).getKey(2), 408);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(1).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(2).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(2).getKey(1), 413);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(2).getKey(2), 423);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(2).getPtr(2).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(3).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(3).getKey(1), 495);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(3).getKey(2), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(3).getKey(3), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(3).getPtr(0).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(3).getPtr(0).getKey(1), 459);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(3).getPtr(0).getKey(2), 460);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(3).getPtr(0).getKey(3), 473);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(3).getPtr(1).getKey(0), 0);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(3).getPtr(1).getKey(1), 495);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(3).getPtr(1).getKey(2), 500);
		assertEquals(tree.root.getPtr(1).getPtr(1).getPtr(3).getPtr(1).getKey(3), 0);
	}

}
