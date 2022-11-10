import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestGetters {
	
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
}
