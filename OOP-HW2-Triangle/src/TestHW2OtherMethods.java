import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Michal Hotovitz
 */
public class TestHW2OtherMethods {

	Triangle tr1;
	Triangle tr2;
	Triangle tr3;
	Triangle tr4;

	@Before
	public void setUp() {
		tr1 = new Triangle1();
		tr2 = new Triangle2();

		tr3 = new Triangle1(new Point(0, (double) -1 / 3), -1);
		tr4 = new Triangle2(new Point(-1 / (Math.sqrt(3)), 0), 2 / (Math.sqrt(3)), false);
	}

	@Test
	public void testAreaAndPermeter() {
		assertTrue(HW2Utils.areEqual(tr1.getArea(), Math.sqrt(3) / 4));
		assertTrue(HW2Utils.areEqual(tr2.getArea(), Math.sqrt(3) / 4));
		assertTrue(HW2Utils.areEqual(tr3.getArea(), 1 / (Math.sqrt(3))));
		assertTrue(HW2Utils.areEqual(tr4.getArea(), 1 / (Math.sqrt(3))));

		assertTrue(HW2Utils.areEqual(tr1.getPerimeter(), 3));
		assertTrue(HW2Utils.areEqual(tr2.getPerimeter(), 3));
		assertTrue(HW2Utils.areEqual(tr3.getPerimeter(), 6 / (Math.sqrt(3))));
		assertTrue(HW2Utils.areEqual(tr4.getPerimeter(), 6 / (Math.sqrt(3))));
	} 

	@Test
	public void testIsEqual() {
		assert tr1.isEqual(tr1);
		assert tr2.isEqual(tr2);
		assert tr3.isEqual(tr3);
		assert tr4.isEqual(tr4);

		assert tr1.isEqual(tr2);
		assert tr2.isEqual(tr1);
		assert tr1.isEqual(tr2);
		assert tr2.isEqual(tr1);

		System.out.println(tr3);
		System.out.println(tr4);
		assert tr3.isEqual(tr3);
		assert tr4.isEqual(tr4);
		assert tr3.isEqual(tr4);
		assert tr4.isEqual(tr3);

		assert !tr3.isEqual(tr1);
		assert !tr3.isEqual(tr2);
		assert !tr4.isEqual(tr1);
		assert !tr4.isEqual(tr2);
	}

	@Test
	public void testContainsPoint() {
		assertTrue(tr1.contains(new Point(-0.4, -0.28)));
		assertTrue(tr1.contains(new Point(0, 0.57)));
		assertTrue(tr1.contains(new Point(0, 0)));
		assertTrue(tr1.contains(new Point(-0.1, -0.1)));
		assertFalse(tr1.contains(new Point(0, 2)));
		assertFalse(tr1.contains(new Point(0.3, 0.5)));
		
		assertTrue(tr2.contains(new Point(-0.4, -0.28)));
		assertTrue(tr2.contains(new Point(0, 0.57)));
		assertTrue(tr2.contains(new Point(0, 0)));
		assertTrue(tr2.contains(new Point(-0.1, -0.1)));
		assertFalse(tr2.contains(new Point(0, 2)));
		assertFalse(tr2.contains(new Point(0.3, 0.5)));
		
			
		assertTrue(tr3.contains(new Point(-1 / (Math.sqrt(3)), 0)));
		assertTrue(tr3.contains(new Point(0, -1)));
		assertTrue(tr3.contains(new Point(0, 0)));
		assertTrue(tr3.contains(new Point(-0.1, -0.1)));
		assertFalse(tr3.contains(new Point(0, 2)));
		assertFalse(tr3.contains(new Point(0.3, 0.5)));
		
		assertTrue(tr4.contains(new Point(-1 / (Math.sqrt(3)), 0)));
		assertTrue(tr4.contains(new Point(0, -1)));
		assertTrue(tr4.contains(new Point(0, 0)));
		assertTrue(tr4.contains(new Point(-0.1, -0.1)));
		assertFalse(tr4.contains(new Point(0, 2)));
		assertFalse(tr4.contains(new Point(0.3, 0.5)));
	}
	

	@Test
	public void testContainsTriangle() {
		assertTrue(tr1.contains(tr1));
		assertTrue(tr2.contains(tr2));
		assertTrue(tr3.contains(tr3));
		assertTrue(tr4.contains(tr4));
		assertTrue(tr1.contains(tr2));
		assertTrue(tr2.contains(tr1));
		assertTrue(tr3.contains(tr4));
		assertTrue(tr4.contains(tr3));
		
		tr1.scale(0.5);
		assertTrue(tr2.contains(tr1));
		tr2.scale(0.3);
		assertTrue(tr1.contains(tr2));
		
		assertFalse(tr1.contains(tr3));
		assertFalse(tr1.contains(tr4));
		assertFalse(tr2.contains(tr3));
		assertFalse(tr2.contains(tr4));
		assertFalse(tr3.contains(tr1));
		assertFalse(tr3.contains(tr2));
		assertFalse(tr4.contains(tr1));
		assertFalse(tr4.contains(tr2));
		
		tr1.scale(3);
		tr2.scale(4);
		assertFalse(tr1.contains(tr3));
		assertFalse(tr1.contains(tr4));
		assertFalse(tr2.contains(tr3));
		assertFalse(tr2.contains(tr4));
		
		tr1.scale(3);
		tr2.scale(3);
		assertTrue(tr1.contains(tr3));
		assertTrue(tr1.contains(tr4));
		assertTrue(tr2.contains(tr3));
		assertTrue(tr2.contains(tr4));
	}



}
