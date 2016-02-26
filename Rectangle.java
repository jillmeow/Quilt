import java.awt.*;
/**
 * Rectangle.java
 *
 * A program that draws a rectangular shape.
 * By Jill Mirandilla
 */
public class Rectangle{
  private int x;  // x location;
  private int y;  // y location;
  private Color shade;  // colour of Rectangle
  private int width; //width of Rectangle
  private int height;//height of Rectangle
  private boolean fill; //drawRect false or fillRect true
  private static int totalCount; //Total number of rectangles that would be draw
  private int thisCount; //Rectangle's number in order
  
  
  /*constructor for Rectangle*/
  public Rectangle(boolean fill, Color shade,int x, int y , int width, int height){
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.shade = shade;
    this.fill=fill;
    this.totalCount++;
    this.thisCount = totalCount;
  }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
  
  
  
 /*draw this rectangle*/
    public void draw(Graphics g){
        g.setColor(shade);
        if (fill ){
            g.fillRect(x, y, width, height);
        } else  {
            g.drawRect(x, y, width, height);
        }
    }
  
}

