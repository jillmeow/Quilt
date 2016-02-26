/**
 * Quilt.java
 * 
 * A program produces a quilt pattern
 * By Jill Mirandilla
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Quilt extends JPanel {
    private static List<Rectangle> allSquares = new ArrayList<Rectangle>();
    private static List<Rectangle> currentSquares = new ArrayList<Rectangle>();
    private static List<Rectangle> squares = new ArrayList<Rectangle>();
    private List<String> newSquares = new ArrayList<String>();
    
    int count = 0;

    public Quilt() {
        Scanner inputLine = new Scanner(System.in);

        while (inputLine.hasNextLine()) {
            String[] line = inputLine.nextLine().split(" ");

            if (line.length == 4) {
                if (isDouble(line[0]) && isInteger(line[1]) && isInteger(line[2]) && isInteger(line[3])) {
                    double scaleDouble = Double.parseDouble(line[0]) * 100;
                    int scale = (int) scaleDouble;

                    int r = Integer.parseInt(line[1]);
                    int g = Integer.parseInt(line[2]);
                    int b = Integer.parseInt(line[3]);
                    
                    newSquares.add(scale +" "+ r +" " +g +" "+b);
                    squares.add(new Rectangle(true, new Color(r, g, b), 0, 0, scale, scale));
                   
                }
            }
        }

        
        if(squares.get(0).getWidth() > 400){
          resizeBig(newSquares);
        } else if(squares.get(0).getWidth() < 200){
          resizeSmall(newSquares);
        }
        
        drawAndSet(newSquares);
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.white);
    }
    
    
    public static void drawAndSet(List<String> squares){
        int count = 0;
        int squareNum = 0;
        
        for(String s : squares){
            String[] newSquare = s.split(" ");
            int scale = Integer.parseInt(newSquare[0]);
            int r = Integer.parseInt(newSquare[1]);
            int g = Integer.parseInt(newSquare[2]);
            int b = Integer.parseInt(newSquare[3]);
            List<Rectangle> group = new ArrayList<Rectangle>();
            if(count == 0){
                currentSquares.add(new Rectangle(true, new Color(r, g, b), 400-scale/2, 400-scale/2, scale, scale));
                allSquares.add(new Rectangle(true, new Color(r, g, b), 400-scale/2, 400-scale/2, scale, scale));
            } else {
                for(Rectangle c : currentSquares){
                    for(int i = 1; i <= 4; i++){
                        int xPosition = 0, yPosition = 0;
                        if(i == 1){
                            xPosition = c.getX() - scale/2;
                            yPosition = c.getY() - scale/2;
                            
                        } else if(i == 2){
                            xPosition = (c.getX() + c.getWidth()) - scale/2;
                            yPosition = c.getY() - scale/2;
                        } else if(i == 3){
                            xPosition = c.getX() - scale/2;
                            yPosition = (c.getY() + c.getHeight()) - scale/2;
                        } else if(i == 4){
                            xPosition = (c.getX() + c.getWidth()) - scale/2;
                            yPosition = (c.getY() + c.getHeight()) - scale/2;
                        }
                        group.add(new Rectangle(true, new Color(r, g, b), xPosition, yPosition, scale, scale));
                        allSquares.add(new Rectangle(true, new Color(r, g, b), xPosition, yPosition, scale, scale));
                    }
                }
                currentSquares.clear();
                for(Rectangle sq : group){
                    currentSquares.add(sq);
                }
            }
            
            count++;
        }
    }
    
    public static void resizeSmall(List<String> squares){
      int count = 0;
      for(String s : squares){
        String[] resizeSquare = s.split(" ");
        int scale = Integer.parseInt(resizeSquare[0]);
        int r = Integer.parseInt(resizeSquare[1]);
        int g = Integer.parseInt(resizeSquare[2]);
        int b = Integer.parseInt(resizeSquare[3]);
        scale = scale*2;
        String newSquare = scale +" "+ r +" " +g +" "+b;
        squares.set(count, newSquare);
        count++;
      }
    }
    
    public static void resizeBig(List<String> squares){
      int count = 0;
      for(String s : squares){
        String[] resizeSquare = s.split(" ");
        int scale = Integer.parseInt(resizeSquare[0]);
        int r = Integer.parseInt(resizeSquare[1]);
        int g = Integer.parseInt(resizeSquare[2]);
        int b = Integer.parseInt(resizeSquare[3]);
        scale = (scale/2)/2;
        String newSquare = scale +" "+ r +" " +g +" "+b;
        squares.set(count, newSquare);
        count++;
      }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        JFrame fileFrame = new JFrame();
        fileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fileFrame.getContentPane().add(new Quilt());
        fileFrame.pack();
        fileFrame.setVisible(true);
        fileFrame.setTitle("Quilt Pattern");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int numShapes = 1;
        int center = 150;
        int currentSqr; 
        int lastSqr = 0;
        int i = 1; 
        int j = 0;

        for(Rectangle s: allSquares){
          s.draw(g);
        }
    }
}