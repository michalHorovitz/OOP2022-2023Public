import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestHW2 {

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
	public void testGetPoints() {
		Point[] r11Points = r11.getPoints();
		Point[] r21Points = r11.getPoints();
		testPointsRhombus1(r11Points);
		testPointsRhombus1(r21Points);

		Point[] r13Points = r13.getPoints();
		Point[] r23Points = r23.getPoints();
		testPointsRhombus3(r13Points);
		testPointsRhombus3(r23Points);
	}

	private void testPointsRhombus1(Point[] points) {
		assertTrue(points[0].equals(new Point(-0.5, 0)));
		assertTrue(points[1].equals(new Point(0, 0.5)));
		assertTrue(points[2].equals(new Point(0.5, 0)));
		assertTrue(points[3].equals(new Point(0, -0.5)));
	}

	private void testPointsRhombus3(Point[] points) {
		assertTrue(points[0].equals(new Point(1 - Math.sqrt(3), 1)));
		assertTrue(points[1].equals(new Point(1, 4)));
		assertTrue(points[2].equals(new Point(1 + Math.sqrt(3), 1)));
		assertTrue(points[3].equals(new Point(1, -2)));
	}

	@Test
	public void testGetCenter() {
		assertTrue(r11.getCenter().equals(new Point(0, 0)));
		assertTrue(r21.getCenter().equals(new Point(0, 0)));

		assertTrue(r13.getCenter().equals(new Point(1, 1)));
		assertTrue(r23.getCenter().equals(new Point(1, 1)));
	}

	@Test
	public void testGetDiagonalsLength() {
		assertTrue(HW2Utils.areEqual(r11.getLengthVerticalDiagonal(), 1));
		assertTrue(HW2Utils.areEqual(r11.getLengthHorizontalDiagonal(), 1));

		assertTrue(HW2Utils.areEqual(r21.getLengthVerticalDiagonal(), 1));
		assertTrue(HW2Utils.areEqual(r21.getLengthHorizontalDiagonal(), 1));

		assertTrue(HW2Utils.areEqual(r13.getLengthVerticalDiagonal(), 6));
		assertTrue(HW2Utils.areEqual(r13.getLengthHorizontalDiagonal(), Math.sqrt(3) * 2));

		assertTrue(HW2Utils.areEqual(r23.getLengthVerticalDiagonal(), 6));
		assertTrue(HW2Utils.areEqual(r23.getLengthHorizontalDiagonal(), Math.sqrt(3) * 2));
	}

	@Test
	public void testGetEdgeLength() {
		assertTrue(HW2Utils.areEqual(r12.getLengthEdge(), Math.sqrt(0.5 * 0.5 * 2)));
		assertTrue(HW2Utils.areEqual(r22.getLengthEdge(), Math.sqrt(0.5 * 0.5 * 2)));
		assertTrue(HW2Utils.areEqual(r13.getLengthEdge(), 3 / Math.cos(Math.PI / 6)));
		assertTrue(HW2Utils.areEqual(r23.getLengthEdge(), 3 / Math.cos(Math.PI / 6)));
	}

	@Test
	public void testGetAngles() {
		assertTrue(HW2Utils.areEqual(r11.getSmallAngle(), Math.PI / 2));
		assertTrue(HW2Utils.areEqual(r11.getBigAngle(), Math.PI / 2));

		assertTrue(HW2Utils.areEqual(r21.getSmallAngle(), Math.PI / 2));
		assertTrue(HW2Utils.areEqual(r21.getBigAngle(), Math.PI / 2));

		assertTrue(HW2Utils.areEqual(r13.getSmallAngle(), Math.PI / 3));
		assertTrue(HW2Utils.areEqual(r13.getBigAngle(), Math.PI - Math.PI / 3));

		assertTrue(HW2Utils.areEqual(r23.getSmallAngle(), Math.PI / 3));
		assertTrue(HW2Utils.areEqual(r23.getBigAngle(), Math.PI - Math.PI / 3));
	}

	@Test
	public void testAreaAndPerimeter() {
		assertTrue(HW2Utils.areEqual(r12.getArea(), 0.5));
		assertTrue(HW2Utils.areEqual(r22.getArea(), 0.5));
		assertTrue(HW2Utils.areEqual(r13.getArea(), 6 * Math.sqrt(3)));
		assertTrue(HW2Utils.areEqual(r23.getArea(), 6 * Math.sqrt(3)));

		assertTrue(HW2Utils.areEqual(r12.getPerimeter(), 4 * Math.sqrt(0.5 * 0.5 * 2)));
		assertTrue(HW2Utils.areEqual(r22.getPerimeter(), 4 * Math.sqrt(0.5 * 0.5 * 2)));
		assertTrue(HW2Utils.areEqual(r13.getPerimeter(), 12 / Math.cos(Math.PI / 6)));
		assertTrue(HW2Utils.areEqual(r23.getPerimeter(), 12 / Math.cos(Math.PI / 6)));
	}

	@Test
	public void testUpdateCenter() {
		r12.updateCenter(new Point(-5, -10));
		assertTrue(HW2Utils.areEqual(r12.getLengthEdge(), r22.getLengthEdge()));
		assertTrue(HW2Utils.areEqual(r12.getSmallAngle(), r22.getSmallAngle()));
		assertEquals(r12.getCenter(), new Point(-5, -10));

		r22.updateCenter(new Point(-5, -10));
		assertTrue(HW2Utils.areEqual(r12.getLengthEdge(), r22.getLengthEdge()));
		assertTrue(HW2Utils.areEqual(r12.getSmallAngle(), r22.getSmallAngle()));
		assertEquals(r12.getCenter(), new Point(-5, -10));
	}

	@Test
	public void testUpdateDiagonals() {
		
		r13.updateVerticalDiagonal(12);
		assertTrue(HW2Utils.areEqual(r13.getLengthVerticalDiagonal(),12));
		assertEquals(r13.getCenter(),new Point(1,1));
		assertTrue(HW2Utils.areEqual(r13.getLengthHorizontalDiagonal(), Math.sqrt(3) * 2));
		assertFalse(HW2Utils.areEqual(r13.getSmallAngle(), Math.PI/3));
		assertFalse(HW2Utils.areEqual(r13.getLengthEdge(), 6 / Math.cos(Math.PI / 6)));
		
		r13.updateHorizontalDiagonal(Math.sqrt(3) * 4);
		assertTrue(HW2Utils.areEqual(r13.getLengthVerticalDiagonal(),12));
		assertEquals(r13.getCenter(),new Point(1,1));
		assertTrue(HW2Utils.areEqual(r13.getLengthHorizontalDiagonal(), Math.sqrt(3) * 4));
		assertTrue(HW2Utils.areEqual(r13.getSmallAngle(), Math.PI/3));
		assertTrue(HW2Utils.areEqual(r13.getLengthEdge(), 6 / Math.cos(Math.PI / 6)));
		
		r23.updateVerticalDiagonal(12);
		assertTrue(HW2Utils.areEqual(r23.getLengthVerticalDiagonal(),12));
		assertEquals(r23.getCenter(),new Point(1,1));
		assertTrue(HW2Utils.areEqual(r23.getLengthHorizontalDiagonal(), Math.sqrt(3) * 2));
		assertFalse(HW2Utils.areEqual(r23.getSmallAngle(), Math.PI/3));
		assertFalse(HW2Utils.areEqual(r23.getLengthEdge(), 6 / Math.cos(Math.PI / 6)));
		
		r23.updateHorizontalDiagonal(Math.sqrt(3) * 4);
		assertTrue(HW2Utils.areEqual(r23.getLengthVerticalDiagonal(),12));
		assertEquals(r23.getCenter(),new Point(1,1));
		assertTrue(HW2Utils.areEqual(r23.getLengthHorizontalDiagonal(), Math.sqrt(3) * 4));
		assertTrue(HW2Utils.areEqual(r23.getSmallAngle(), Math.PI/3));
		assertTrue(HW2Utils.areEqual(r23.getLengthEdge(), 6 / Math.cos(Math.PI / 6)));
	}

	@Test
	public void testUpdateEdgeLength() {

	}

	@Test
	public void testRotate() {
		r13.rotate();
		assertTrue(HW2Utils.areEqual(r13.getLengthHorizontalDiagonal(),6));
		assertEquals(r13.getCenter(),new Point(1,1));
		assertTrue(HW2Utils.areEqual(r13.getLengthVerticalDiagonal(),Math.sqrt(3) * 2));
		assertTrue(HW2Utils.areEqual(r13.getSmallAngle(), Math.PI/3));
		
		r23.rotate();
		assertTrue(HW2Utils.areEqual(r23.getLengthHorizontalDiagonal(),6));
		assertEquals(r23.getCenter(),new Point(1,1));
		assertTrue(HW2Utils.areEqual(r23.getLengthVerticalDiagonal(),Math.sqrt(3) * 2));
		assertTrue(HW2Utils.areEqual(r23.getSmallAngle(), Math.PI/3));
	}
	
	@Test
	public void testScale() {
		r13.scale(2);
		assertTrue(HW2Utils.areEqual(r13.getLengthVerticalDiagonal(),12));
		assertEquals(r13.getCenter(),new Point(1,1));
		assertTrue(HW2Utils.areEqual(r13.getLengthHorizontalDiagonal(), Math.sqrt(3) * 4));
		assertTrue(HW2Utils.areEqual(r13.getSmallAngle(), Math.PI/3));
		assertTrue(HW2Utils.areEqual(r13.getLengthEdge(), 6 / Math.cos(Math.PI / 6)));
		
		r23.scale(2);
		assertTrue(HW2Utils.areEqual(r23.getLengthVerticalDiagonal(),12));
		assertEquals(r23.getCenter(),new Point(1,1));
		assertTrue(HW2Utils.areEqual(r23.getLengthHorizontalDiagonal(),Math.sqrt(3) * 4));
		assertTrue(HW2Utils.areEqual(r23.getSmallAngle(), Math.PI/3));
		assertTrue(HW2Utils.areEqual(r23.getLengthEdge(), 6 / Math.cos(Math.PI / 6)));
	}

	@Test
	public void testMove() {
		r12.moveHorizontal(-5);
		r12.moveVertical(-10);
		assertTrue(HW2Utils.areEqual(r12.getLengthEdge(), r22.getLengthEdge()));
		assertTrue(HW2Utils.areEqual(r12.getSmallAngle(), r22.getSmallAngle()));
		assertEquals(r12.getCenter(), new Point(-5, -10));

		r22.moveHorizontal(-5);
		r22.moveVertical(-10);
		assertTrue(HW2Utils.areEqual(r22.getLengthEdge(), r12.getLengthEdge()));
		assertTrue(HW2Utils.areEqual(r22.getSmallAngle(), r12.getSmallAngle()));
		assertEquals(r22.getCenter(), new Point(-5, -10));
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