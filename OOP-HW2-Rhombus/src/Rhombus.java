/**
 * An interface for a Rhombus which is diagonals are parallel to the axises.
 * 
 * This interface should be implemented in two different classes as part of HW2.
 * 
 * @author Michal Horovitz.
 * 
 */

public interface Rhombus {

	/**
	 * @return the corners of the rhombus. The order of the points are as follows:
	 *         1. the left point. 2. the upper point 3. the right point 4. the
	 *         bottom point Note that this method should return a copy of the
	 *         top-left corner, and not a reference to a field.
	 */
	public Point[] getPoints();

	/**
	 * @return the center point. Note that this method should return a copy of the
	 *         center point, and not a reference to a field.
	 */
	public Point getCenter();

	/**
	 * @return the edge length
	 */
	public double getLengthEdge();

	/**
	 * @return the length of the vertical diagonal of the rhombus
	 */
	public double getLengthVerticalDiagonal();

	/**
	 * @return the length of the horizontal diagonal of the rhombus
	 */
	public double getLengthHorizontalDiagonal();

	/**
	 * @return the smaller angle (in radians)
	 */
	public double getSmallAngle();

	/**
	 * @return the bigger angle (in radians)
	 */
	public double getBigAngle();

	/**
	 * @return the area
	 */
	public double area();

	/**
	 * @return the perimeter
	 */
	public double perimeter();

	/**
	 * @param p (not null) Set the center point of the rhombus to be a copy of p.
	 *          This method moves the rhombus to be centered at p, and it doesn't
	 *          change the length of the diagonals, the angles, and the length of
	 *          the edged.
	 */
	public void updateCenter(Point p);

	/**
	 * @param lengthHorisontalDiagonal - Set the length of horisonatal diagonal of
	 *                                 the rhombus. This method doesn't change the
	 *                                 center point, or the length of the vertical
	 *                                 diagonal, but the angles are changed.
	 */
	public void updateHorizontalDiagonal(double lengthHorizontalDiagonal);

	/**
	 * @param lengthVerticalDiagonal - Set the length of vertical diagonal of the
	 *                               rhombus. This method doesn't change the center
	 *                               point, or the length of the horizontal
	 *                               diagonal, but the angles are changed.
	 */
	public void updateVerticalDiagonal(double lengthVerticalDiagonal);

	/**
	 * @param edgeLength - Set the length of edges of the rhombus. This method
	 *                   doesn't change the center point, or the angles.
	 */
	public void updateEdgeLength(double edgeLength);

	/**
	 * Rotate the rhombus pi/2 radians (90- degrees)t. The center point,
	 * the size of the rhombus and its angles are not changed.
	 */
	public void rotate();

	/**
	 * @param scalePar:double - Multiply the edge length of the diagonal by
	 *                        scalePar. The center point and the angels are not
	 *                        changed).
	 *                        Assume that scalePar>0
	 */
	public void scale(double scalePar);

	/**
	 * @param delta:double - Move the rhombus to the right by delta (Note that delta
	 *                     might be negative, and then the rhombus is moved to the
	 *                     left).
	 */
	public void moveVertical(double delta);

	/**
	 * @param delta:double - Move up the rhombus (this) by delta (Note that delta
	 *                     might be negative, and then the rhombus is moved down).
	 */
	public void moveHorizontal(double delta);

	/**
	 * @param Rhombus:Rhombus
	 * @return If the rhombus represented by the parameter represents the same
	 *         rhombus as this, then return true. Otherwise, return false
	 */
	public boolean isEqual(Rhombus rhombus);

//	/**
//	 * @param rhombus:Rhombus
//	 * @return If the rhombus (this) contains the rhombus which represented by the
//	 *         paramter, then return true. Otherwise, return false
//	 */
//	public boolean contains(Rhombus rhombus);

}
