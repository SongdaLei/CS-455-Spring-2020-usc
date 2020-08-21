//Name: Songda Lei
//USC NetId:8374371181
//CSCI 455 PA1
//Spring 2020

// we included the import statements for you
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
   int labelbottom;
   int barleft;
   int barwidth;
   int barHeight;
   double barscale;
   Color color;
   String label;


   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale).

      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   public Bar(int bottom, int left, int width, int barHeight,
              double scale, Color color, String label) {
      labelbottom = bottom;
      barleft = left;
      barwidth = width;
      this.barHeight = barHeight;
      barscale = scale;
      this.color = color;
      this.label = label;
   }
   
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */
   public void draw(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      Font font= g2.getFont();
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D labelBounds = font.getStringBounds(label, context);
      int widthOfLabel = (int) labelBounds.getWidth();
      int heightOfLabel = (int) labelBounds.getHeight();
      //System.out.println(widthOfLabel);

      //Draw the label
      int x = barleft + barwidth/2 - widthOfLabel/2;
      g2.setColor(Color.BLACK);
      g2.drawString(label, x, labelbottom);

      //Draw the rectangle
      int height = (int) (barscale * (barHeight-heightOfLabel));
      int y = labelbottom-heightOfLabel-height;
      g2.setColor(color);
      Rectangle bar = new Rectangle(barleft,y,barwidth,height);
      g2.fill(bar);




   }
}
