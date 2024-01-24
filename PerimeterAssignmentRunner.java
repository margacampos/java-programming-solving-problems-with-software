import edu.duke.*;

public class PerimeterAssignmentRunner {
    public double getPerimeter(Shape s) {
        double totalPerim = 0;

        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.getDistance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }

        return totalPerim;
    }

    public int getNumPoints(Shape s) {
        return s.getPoints().length;
    }

    public double getAverageLength(Shape s) {
        double perimeter = getPerimeter(s);
        double avgLength = perimeter / s.getPoints().length;
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        double lgstSide = 0;

        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.getDistance(currPt);
            if (currDist > lgstSide) {
                lgstSide = currDist;
            }
            prevPt = currPt;
        }

        return lgstSide;
    }

    public double getLargestX(Shape s) {
        double lgstX = s.getLastPoint().getX();
        for (Point currPt : s.getPoints()) {
            if (lgstX < currPt.getX()) {
                lgstX = currPt.getX();
            }
        }
        return lgstX;
    }

}

public void testPerimeter (Shape s) {
    System.out.println(getNumPoints(s));
    System.out.println(getAverageLength(s));
    System.out.println(getLargestSide(s));
    System.out.println(getLargestX(s));
}