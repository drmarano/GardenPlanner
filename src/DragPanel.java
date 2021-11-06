import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// this class specifies a panel that can be dragged across the screen
public class DragPanel extends JPanel{
	// this is the image to be dragged
	ImageIcon image = new ImageIcon("smiley.png");
	final int WIDTH = image.getIconWidth();
	final int HEIGHT= image.getIconHeight();
	Point imageCorner;
	Point prevPt;
	
	// this allows the user to drag the panel
	DragPanel(){
		imageCorner = new Point(0,0);
		ClickListener clickListener = new ClickListener();
		DragListener dragListener = new DragListener();
		this.addMouseListener(clickListener);
		this.addMouseMotionListener(dragListener);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		image.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
	}
	
	// this specifies the starting point of the image by identifying where the mouse is clicked
	private class ClickListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			prevPt = e.getPoint();
		}
	}
	
	// this specifies the location of the mouse while the click button is held down
	// and continuously updates the image location accordingly
	private class DragListener extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent e) {
			Point currentPt = e.getPoint();
			//move the image based on the difference between the starting and current position of the mouse
			imageCorner.translate(
				(int)(currentPt.getX()-prevPt.getX()),
				(int)(currentPt.getY()-prevPt.getY())
			);
			prevPt = currentPt;
			repaint();
		}
	}
}