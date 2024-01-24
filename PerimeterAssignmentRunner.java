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

}

public void testPerimeter (Shape s) {
    System.out.println(getNumPoints(s));
    System.out.println(getAverageLength(s));
}