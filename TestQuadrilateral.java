
class Point {
    private double x, y;
    
    public void setX(double x) {
        this.x = x;    
    }
    
    public void setY(double y) {
        this.y = y;    
    }
    
    
    public double getX() {
        return this.x;   
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setCoords(double x, double y) {
        setX(x);
        setY(y);
    }
    
    public Point(double x, double y) {
        setCoords(x, y);
    }
    
}

abstract class Quadrilateral {
    protected Point p1, p2, p3, p4;
    abstract public double area();
    
    protected double sideX(Point p1, Point p2){
        return (p1.getX() > p2.getX()) ? p1.getX() - p2.getX() :
            p2.getX() - p1.getX();
    }
    
    protected double sideY(Point p1, Point p2){
        return (p1.getY() > p2.getY()) ? p1.getY() - p2.getY() :
            p2.getY() - p1.getY();
    }
}

class Rectangle extends Quadrilateral {
    public Rectangle(double x1, double y1, double x2, double y2) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y1);
        p3 = new Point(x1, y2);
        p4 = new Point(x2, y2);
    }
    
    @Override
    public double area(){
        double w = this.sideX(this.p1, this.p4);
        double h = this.sideY(this.p1, this.p4);
        return w*h;
    }
}

class Square extends Rectangle {
    public Square(double x1, double y1, double x2, double y2) {
      super(x1, y1, x2, y2);
      if ((x1 - x2) != (y1 - y2)) {
          throw new ArithmeticException("Squares must have same sides");
      }
    }
    
    @Override
    public double area(){
        double s = this.sideX(this.p1, this.p4);
        return s*s;
    }
}

public class TestQuadrilateral
{
	public static void main(String[] args) {
		Quadrilateral P = new Rectangle(2,3,4,5);
		System.out.println(P.area());
    Quadrilateral Q = new Square(2,3,4,5);
		System.out.println(Q.area());
	}
}
