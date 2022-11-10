/**
 * @author Michal Hotovitz
 */
public class Rhombus2 extends RhombusAbs {

	private Point bottomPoint;
	private Point leftPoint;
	
	public Rhombus2(){
		this(new Point(), Math.PI/2, 1);
	}
	
	public Rhombus2(Point center, double bottomAngle, double verticalDiagonal) {
		super();
		bottomPoint = new Point(center.getX(),center.getY()-verticalDiagonal/2);
		leftPoint = new Point(center.getX()-Math.tan(bottomAngle/2)*verticalDiagonal/2, center.getY());
	}

	@Override
	public Point getCenter() {
		return new Point(bottomPoint.getX(), leftPoint.getY());
	}

	@Override
	public double getLengthEdge() {
		double deltax = bottomPoint.getX() - leftPoint.getX();
		double deltay = leftPoint.getY() - bottomPoint.getY();
		return Math.sqrt(deltax * deltax + deltay * deltay);
	}

	@Override
	public double getLengthVerticalDiagonal() {
		double deltay = leftPoint.getY() - bottomPoint.getY();
		return deltay*2;
	}

	@Override
	public double getLengthHorizontalDiagonal() {
		double deltax = bottomPoint.getX() - leftPoint.getX();
		return deltax*2;
	}

	@Override
	public double getSmallAngle() {
		double bottumAngle = 2*(Math.asin((getLengthHorizontalDiagonal()/2)/getLengthEdge()));
		return Math.min(bottumAngle, Math.PI-bottumAngle);
	}

	@Override
	public double getBigAngle() {
		double bottumAngle = 2*Math.asin((getLengthHorizontalDiagonal()/2)/getLengthEdge());
		return Math.max(bottumAngle, Math.PI-bottumAngle);
	}

	@Override
	public void updateCenter(Point p) {
		double deltax = p.getX() - bottomPoint.getX();
		double deltay = p.getY() - leftPoint.getY();
		Point movePoint = new Point(deltax, deltay);
		
		bottomPoint.move(movePoint);
		leftPoint.move(movePoint);
	}

	@Override
	public void rotate() {
		double delta = (getLengthVerticalDiagonal()-getLengthHorizontalDiagonal())/2.0;
		
		leftPoint.moveHorizontal(delta*(-1));
		bottomPoint.moveVertical(delta);
	}

	@Override
	public void updateHorizontalDiagonal(double lengthHorizontalDiagonal) {
		double deltax = (getLengthHorizontalDiagonal() -lengthHorizontalDiagonal)/2.0 ;
		leftPoint.moveHorizontal(deltax);
	}

	@Override
	public void updateVerticalDiagonal(double lengthVerticalDiagonal) {
		double deltay = (getLengthVerticalDiagonal() -lengthVerticalDiagonal)/2.0 ;
		bottomPoint.moveVertical(deltay);
	}

}
