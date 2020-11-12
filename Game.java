//Name: Jacob Smith
//Date: 10/23/20
//Description: This is the central class that sets up the JFrame 
//and then connects a lot of the classes together and communicates 
//the info to each other
import javax.swing.JFrame;
import java.awt.Toolkit;

public class Game extends JFrame
{
	Model model;
	View view;
	Controller controller;
	Tube t;

	public Game()
	{
		model = new Model();
		controller = new Controller(model);
		view = new View(controller, model);
		
		this.setTitle("Side Scroller");
		this.setSize(800, 500);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		view.addMouseListener(controller);
		this.addKeyListener(controller);
		
			Json j = Json.load("map.json");
			model.unmarshal(j);
			System.out.println("You have loaded in a map");
		
	}

	public static void main(String[] args)
	{
		//Json ob = t.marshal();
		//ob.save("tubetest.json");
		//Json j = Json.load("tubetest.json");
		//Tube t = new Tube(j);
		
		Game g = new Game();
		g.run();
		
	}
public void run()
{
	while(true)
	{
		controller.update();
		model.update();
		view.repaint(); // Indirectly calls View.paintComponent
		Toolkit.getDefaultToolkit().sync(); // Updates screen

		// Go to sleep for 50 miliseconds
		try
		{
			Thread.sleep(40);
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}

}
