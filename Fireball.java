//Name: Jacob Smith
//Date: 10/23/20
//Description: This class holds the the aspects of the fireball image
//it controls the movement and removal of the the fireball sprites


import java.awt.image.BufferedImage;
import java.awt.Graphics;

class Fireball extends Sprite
{
	static BufferedImage fireball_image;
	double horizontal_shift;
	double vert_shift;
	int timer;
	int fireballFrames;
	Model model;
	Fireball(int x, int y, Model m)
	{
		super(x,y,47,47,"fireball");
		horizontal_shift = 0.5;
		vert_shift = -10.0;
		fireball_image = View.loadImage("fireball.png");
		model = m;
	}
	
	void update()
	{
		//This is the method that updates and tells the image how to move
		horizontal_shift += 1.0;
		x+= horizontal_shift;
		
		vert_shift -= 0.5;
		y+= vert_shift;
		
		if (y >= 400)
			vert_shift = -18.0;
		if(y <= 275)
			vert_shift = 20.0; 
	}
	//Draw the fireball
	void drawYourself(Graphics g)
	{
		g.drawImage(fireball_image,x-model.mario.x + model.mario.marioOffset, y, null);
	}
	
	boolean isFireball()
	 {
		 return true;
	 }
}