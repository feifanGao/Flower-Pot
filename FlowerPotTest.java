

public class FlowerPotTest {
    //@Test
	public static void main(String[] args) {
		Pot p1 = new Pot("Square", 12);
		Pot p2 = new Pot("Circle", 12);
		Flower f = new Flower("yellow", "dandelion", 12, 23);
		Flower f2 = new Flower("white", "orchid", 2, 53.4);
		Flower f3 = new Flower("green", "parsely", 2, 53.4);
		Flower f4 = new Flower("orange", "tulip", 6, 53.4);
		Flower f5 = new Flower("red", "rose", 15, 53.4);
		Flower f6 = new Flower("yellow", "dandelion", 12, 23);
		Flower f7 = new Flower("white", "rose", 4, 53.4);
		Flower f8 = new Flower(null, "rose", 46, 34);
		Flower f9 = new Flower(null, null, 46, 34);
		// p2.insert(f);
		// p2.insert(f2);
		// p2.insert(f3);
		// p2.insert(f4);
		// p1.insert(f5);
		// p1.insert(f8);
		// p1.insert(f7);
		p2.insert(f8);
		p2.insert(f9);
		// for (int i = 0; i < 10; i++) {
		// 	p2.insert(f2);
		// }
		// for (int i = 0; i < 10; i++) {
		// 	p1.insert( new Flower("yellow", "dandelion", 12, 23));
		// }
		Pot np = Pot.combine(p1, p2);
		System.out.println(np.view());
		System.out.println(np.getShape());
		System.out.println(np.count());
		System.out.println(np.size());
		// assertEquals(np.count(), 5);
		// assertEquals(np.size(), 5);
		// assertFalse(np.contains(null));
		// assertEquals(np.getShape(), p1.getShape());

		// System.out.println(np.view());
		// System.out.println(p2.count());

		// p2.replaceColour(null, f);

		// System.out.println(p2.view());
		// System.out.println(p2.count());
		
		// p.water();

		// System.out.println(p.averageAge());
		
		
		// p.insert(f8);
		// p.insert(f9);
		// assertEquals(p.averageAge(), averageAge(x), 0.0001);
		// p.insert(null);
		
		
		// p.water();
		// assertEquals(p.averageAge(), averageAge(x), 0.0001);
		// p.water();
		// assertEquals(p.averageAge(), averageAge(x), 0.0001);
		// p.water();
		// assertEquals(p.averageAge(), averageAge(x), 0.0001);
		// p.water();
		// assertEquals(p.averageAge(), averageAge(x), 0.0001);
		// p.water();
		// assertEquals(p.averageAge(), averageAge(x), 0.0001);
		// p.water();
		// p.water();
		// p.water();
		// p.water();
		// p.water();
		// p.water();
		// p.water();
		// p.water();
		// p.water();
		// p.water();
		// p.water();
		// p.water();
		// assertEquals(p.averageAge(), averageAge(x), 0.0001);
		// assertEquals(p.rearrange(), 9);
	}
	
}
