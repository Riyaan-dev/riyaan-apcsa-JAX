package polygon;

import java.awt.geom.*; 
import java.util.ArrayList; 
import gpdraw.*; 

public class IrregularPolygon {

    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }

    public double perimeter() {


        if (myPolygon.size() < 2) {

            return 0;
        }

        double perimeter = 0;

        for (int i = 0; i < myPolygon.size(); i++) {

            Point2D.Double current = myPolygon.get(i);

            Point2D.Double next = myPolygon.get((i + 1) % myPolygon.size());

            double dx = next.x - current.x;
            double dy = next.y - current.y;

            perimeter += Math.sqrt(dx * dx + dy * dy);
        }

        return perimeter;
    }
  public double area() {
        if (myPolygon.size() < 3) {
            return 0;
        }

        double sum = 0;

        for (int i = 0; i < myPolygon.size(); i++) {


            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i + 1) % myPolygon.size());

            sum += (current.x * next.y) - (next.x * current.y);
        }

        return Math.abs(sum) / 2.0;
    }

    public void draw()
    {
        try {
            if (myPolygon.size() < 2) {
                return;
            }

            SketchPad pad = new SketchPad(500, 500);


            DrawingTool pen = new DrawingTool(pad);

            Point2D.Double first = myPolygon.get(0);


            pen.up();
            pen.move(first.x, first.y);

            pen.down();

            for (int i = 1; i < myPolygon.size(); i++) {

                Point2D.Double point = myPolygon.get(i);
                pen.move(point.x, point.y);
            }

            pen.move(first.x, first.y);

        } catch (java.awt.HeadlessException e) {



            
            System.out.println("Exception: No graphics support available.");
        }
    }
  
}