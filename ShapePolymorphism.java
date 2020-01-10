interface Shape {
  public abstract int area();
}

abstract class TwoDim implements Shape{
}

abstract class ThreeDim implements Shape{
  public abstract int volume();
}

class Rectangle extends TwoDim {
  protected int w,h;

  public Rectangle(int w, int h) {
    this.w = w;
    this.h = h;
  }
  public int area() {
    return h*w;
  }
}

class Square extends Rectangle {
  public Square(int s) {
    super(s, s);
  }
}

class Cuboid extends ThreeDim {
  protected int w,h,l;

  public Cuboid(int w, int h, int l) {
    this.w = w;
    this.h = h;
    this.l = l;
  }
  public int area() {
    return 2*(w*h + w*l + l*h);
  }
  public int volume() {
    return w*h*l;
  }
}

class Cube extends Cuboid {
  public Cube(int s) {
    super(s, s, s);
  }
}

public class ShapePolymorphism {
  public static void main (String[] args) {
    Shape[] S = new Shape[4];
    S[0] = new Rectangle(2, 3);
    S[1] = new Square(4);
    S[2] = new Cuboid(1,2,3);
    S[3] = new Cube(2);

    for (Shape s: S) {
      String output = String.valueOf(s.area());
      if (s instanceof ThreeDim) {
        ThreeDim t = (ThreeDim) s ;  // Downcasting is not useless ;)
        output = output + ", " + String.valueOf(t.volume());
      }
      System.out.println(output);
    }
  }
}
