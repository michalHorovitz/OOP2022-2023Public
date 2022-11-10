import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestUpdateMethods {
	
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
		r13.updateEdgeLength(6 / Math.cos(Math.PI / 6));
		assertTrue(HW2Utils.areEqual(r13.getLengthVerticalDiagonal(),12));
		assertEquals(r13.getCenter(),new Point(1,1));
		assertTrue(HW2Utils.areEqual(r13.getLengthHorizontalDiagonal(), Math.sqrt(3) * 4));
		assertTrue(HW2Utils.areEqual(r13.getSmallAngle(), Math.PI/3));
		assertTrue(HW2Utils.areEqual(r13.getLengthEdge(), 6 / Math.cos(Math.PI / 6)));
		
		r23.updateEdgeLength(6 / Math.cos(Math.PI / 6));
		assertTrue(HW2Utils.areEqual(r23.getLengthVerticalDiagonal(),12));
		assertEquals(r23.getCenter(),new Point(1,1));
		assertTrue(HW2Utils.areEqual(r23.getLengthHorizontalDiagonal(),Math.sqrt(3) * 4));
		assertTrue(HW2Utils.areEqual(r23.getSmallAngle(), Math.PI/3));
		assertTrue(HW2Utils.areEqual(r23.getLengthEdge(), 6 / Math.cos(Math.PI / 6)));
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
}
