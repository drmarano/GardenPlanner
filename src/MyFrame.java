import javax.swing.JFrame;

// this class specifies the panel that is visible to the user
public class MyFrame extends JFrame{
	// we declare an instance of DragPanel 
	DragPanel dragPanel = new DragPanel();
	// we define the frame's size, add the drag panel
	MyFrame(){
		this.setTitle("Drag and Drop Demo");
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(dragPanel);
		this.setVisible(true);
	}

}
