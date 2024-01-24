import edu.duke.*;

public class PerimeterRunner {
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

}

public void testPerimeter () {

}