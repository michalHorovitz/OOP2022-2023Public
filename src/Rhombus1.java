
/**
 * @author Michal Hotovitz
 */
public class Rhombus1 extends RhombusAbs {

	private Point center;
	private double bottomAngle; // between 0 and pi
	private double verticalDiagonal;

	public Rhombus1(){
		this(new Point(), Math.PI/2, 1);
	}
	
	public Rhombus1(Point center, double bottomAngle, double verticalDiagonal) {
		super();
		this.center = center.copy();
		this.bottomAngle = bottomAngle;
		this.verticalDiagonal = verticalDiagonal;
	}

	@Override
	public Point getCenter() {
		return center.copy();
	}

	@Override
	public double getLengthEdge() {
		return (verticalDiagonal / 2.0) / ( Math.cos(bottomAngle / 2.0));
	}

	@Override
	public double getSmallAngle() {
		return Math.min(bottomAngle, Math.PI - bottomAngle);
	}

	@Override
	public double getBigAngle() {
		return Math.max(bottomAngle, Math.PI - bottomAngle);
	}

	@Override
	public void updateCenter(Point p) {
		center = p.copy();
	}

	@Override
	public void updateHorizontalDiagonal(double lengthHorizontalDiagonal) {
		bottomAngle = 2 * Math.atan(lengthHorizontalDiagonal / verticalDiagonal);
		if (bottomAngle < 0)
			bottomAngle += Math.PI;
	}

	@Override
	public void updateVerticalDiagonal(double lengthVerticalDiagonal) {
		bottomAngle = 2 * Math.atan(getLengthHorizontalDiagonal() / lengthVerticalDiagonal);
		if (bottomAngle < 0)
			bottomAngle += Math.PI;
		verticalDiagonal = lengthVerticalDiagonal;
	}

//	@Override
//	public void updateEdgeLength(double edgeLength) {
//		verticalDiagonal = edgeLength * Math.sin(bottomAngle / 2);
//	}

	@Override
	public void rotate() {
		verticalDiagonal = getLengthHorizontalDiagonal();
		bottomAngle = Math.PI - bottomAngle;
	}

	@Override
	public double getLengthVerticalDiagonal() {
		return verticalDiagonal;
	}

	@Override
	public double getLengthHorizontalDiagonal() {
		return verticalDiagonal * Math.tan(bottomAngle / 2.0);
	}

}
