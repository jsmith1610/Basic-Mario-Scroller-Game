//Name: Jacob Smith
//Date: 10/23/20
//Description: This is the class that holds the code for drawing in the tubes from the json file

import java.awt.image.BufferedImage;
import java.awt.Graphics;

class Tube extends Sprite
{ 
	static BufferedImage image;
	Model model;
	
	Tube(int x, int y, Model m)
	{
		super(x,y,55,400,"tube");
		loadTubeImage();
		model = m;
	}
	void update(){ }
	
	void drawYourself(Graphics g)
	{
		g.drawImage(image, x - model.mario.x + model.mario.marioOffset, y, null);
	}
	Tube(Json ob, Model m)
    {
		super((int)ob.getLong("x"),(int)ob.getLong("y"),55,400,"tube");
		model = m;
		loadTubeImage();
		
    }
	 void loadTubeImage()
	 {
		 if(image == null)
		{
			image = View.loadImage("tube.png");
		}	
	 }
	 
	 boolean isTube()
	 {
		 return true;
	 }
}