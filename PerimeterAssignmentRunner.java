import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter(Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints(Shape s) {
        int numPoints = 0;
        for (Point currPt : s.getPoints()) {
            numPoints = numPoints + 1;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        double perimeter = getPerimeter(s);
        double avgLength = perimeter / getNumPoints(s);
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        double lgstSide = 0.0;

        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
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

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        String lgstPtrFile = "";
        DirectoryResource dr = new DirectoryResource();
        double lgstShapePtr = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape currShape = new Shape(fr);
            if (lgstShapePtr < getPerimeter(currShape)) {
                lgstPtrFile = f.getName();
                lgstShapePtr = getPerimeter(currShape);
            }
        }
        return lgstPtrFile;
        // File temp = null; // replace this code
        // return temp.getName();
    }

    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of points = " + getNumPoints(s));
        System.out.println("Avg length = " + getAverageLength(s));
        System.out.println("Largest side = " + getLargestSide(s));
        System.out.println("Largest X coordinate = " + getLargestX(s));
    }

    public void testPerimeterMultipleFiles() {
        System.out.println("Largest perimeter = " + testFileWithLargestPerimeter());
        System.out.println("File with the largest perimeter = " + getFileWithLargestPerimeter());
    }

    public double testFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double lgstShapePtr = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape currShape = new Shape(fr);
            if (lgstShapePtr < getPerimeter(currShape)) {
                lgstShapePtr = getPerimeter(currShape);
            }
        }
        return lgstShapePtr;
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle() {
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0, 0));
        triangle.addPoint(new Point(6, 0));
        triangle.addPoint(new Point(3, 6));
        for (Point p : triangle.getPoints()) {
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = " + peri);
    }

    // This method prints names of all files in a chosen folder that you can use to
    // test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}