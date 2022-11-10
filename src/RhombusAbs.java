
public abstract class RhombusAbs implements Rhombus {

	@Override
	public double getArea() {
		return getLengthHorizontalDiagonal() * getLengthVerticalDiagonal() / 2;
	}

	@Override
	public double getPerimeter() {
		return 4 * getLengthEdge();
	}

	@Override
	public Point[] getPoints() {

		double verticalDiagonal = getLengthVerticalDiagonal();
		double horizontalDigonal = getLengthHorizontalDiagonal();

		Point leftPoint = getCenter();
		leftPoint.moveHorizontal(-horizontalDigonal / 2);

		Point botPoint = getCenter();
		botPoint.moveVertical(-verticalDiagonal / 2);

		Point rightPoint = getCenter();
		rightPoint.moveHorizontal(horizontalDigonal / 2);

		Point upPoint = getCenter();
		upPoint.moveVertical(verticalDiagonal / 2);

		Point[] resultsPoints = { leftPoint, upPoint, rightPoint, botPoint };
		return resultsPoints;
	}

	@Override
	public void scale(double scalePar) {
		if (scalePar <= 0)
			return;
		updateEdgeLength(getLengthEdge() * scalePar);
	}

	@Override
	public void moveVertical(double delta) {
		Point center = getCenter();
		center.moveVertical(delta);
		updateCenter(center);

	}

	@Override
	public void moveHorizontal(double delta) {
		Point center = getCenter();
		center.moveHorizontal(delta);
		updateCenter(center);
	}

	@Override
	public void updateEdgeLength(double edgeLength) {
		double currLength = getLengthEdge();
		double factor = edgeLength / currLength;
		double currLengthVerticalDiagonal = getLengthVerticalDiagonal();
		double currLengthHorizontalDiagonal =getLengthHorizontalDiagonal();
		updateVerticalDiagonal(factor * currLengthVerticalDiagonal);
		updateHorizontalDiagonal(factor * currLengthHorizontalDiagonal);
	};

	@Override
	public boolean isEqual(Rhombus rhombus) {
		return (getCenter().equals(rhombus.getCenter())
				&& (HW2Utils.areEqual(getLengthVerticalDiagonal(), rhombus.getLengthVerticalDiagonal()))
				&& (HW2Utils.areEqual(getBigAngle(), rhombus.getBigAngle())));
	}

}
