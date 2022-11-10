import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestOtherMethods {

	Rhombus r11;
	Rhombus r12;
	Rhombus r13;

	Rhombus r21;
	Rhombus r22;
	Rhombus r23;

	@Before
	public void setUp() {
		r11 = new Rhombus1();
		r12 = new Rhombus1(new Point(0, 0), Math.PI / 2, 1);
		r13 = new Rhombus1(new Point(1, 1), Math.PI / 3, 6);

		r21 = new Rhombus2();
		r22 = new Rhombus2(new Point(0, 0), Math.PI / 2, 1);
		r23 = new Rhombus2(new Point(1, 1), Math.PI / 3, 6);
	}

	@Test
	public void testConstructorAndIsEqual() {
		assertTrue(r11.isEqual(r12));
		assertTrue(r21.isEqual(r22));
		assertTrue(r11.isEqual(r21));
		assertTrue(r22.isEqual(r12));
		assertTrue(r23.isEqual(r13));
		assertTrue(r13.isEqual(r23));

		assertFalse(r11.isEqual(r13));
		assertFalse(r11.isEqual(r23));
		assertFalse(r23.isEqual(r12));
	}

	@Test
	public void testArea() {
		assertTrue(HW2Utils.areEqual(r12.getArea(), 0.5));
		assertTrue(HW2Utils.areEqual(r22.getArea(), 0.5));
		assertTrue(HW2Utils.areEqual(r13.getArea(), 6 * Math.sqrt(3)));
		assertTrue(HW2Utils.areEqual(r23.getArea(), 6 * Math.sqrt(3)));
	}

	@Test
	public void testPerimeter() {
		assertTrue(HW2Utils.areEqual(r12.getPerimeter(), 4 * Math.sqrt(0.5 * 0.5 * 2)));
		assertTrue(HW2Utils.areEqual(r22.getPerimeter(), 4 * Math.sqrt(0.5 * 0.5 * 2)));
		assertTrue(HW2Utils.areEqual(r13.getPerimeter(), 12 / Math.cos(Math.PI / 6)));
		assertTrue(HW2Utils.areEqual(r23.getPerimeter(), 12 / Math.cos(Math.PI / 6)));
	}

	@Test
	public void testGetCopy() {
		Point c = r12.getCenter();
		c.setX(10);
		assertNotEquals(r12.getCenter(), c);

		r12 = new Rhombus1(c, Math.PI / 2, 4);
		c.setX(20);
		assertEquals(r12.getCenter(), new Point(10, 0));
		assertNotEquals(r12.getCenter(), c);

		c = r22.getCenter();
		c.setX(10);
		assertNotEquals(r22.getCenter(), c);

		r22 = new Rhombus1(c, Math.PI / 2, 4);
		c.setX(20);
		assertEquals(r22.getCenter(), new Point(10, 0));
		assertNotEquals(r22.getCenter(), c);

		Point[] points = r21.getPoints();
		points[0].setX(10);
		points[1].setX(10);
		points[2].setX(10);
		points[3].setX(10);
		Point[] points2 = r21.getPoints();
		assertNotEquals(points[0], points2[0]);
		assertNotEquals(points[1], points2[1]);
		assertNotEquals(points[2], points2[2]);
		assertNotEquals(points[3], points2[3]);
	}

}