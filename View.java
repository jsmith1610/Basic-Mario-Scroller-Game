//Name: Jacob Smith
//Date: 10/23/20
//Description: The point of this class is to color and fill in the background for the screen
//then it also loops through and helps draw all the sprites of the sprites class

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.Color;

class View extends JPanel
{
	Model model;//View location only
	
	View(Controller c, Model m)
	{
		model = m;
		c.setView(this);
		
	}
	static BufferedImage loadImage(String filename){
		BufferedImage im = null;
		try
		{
			im = ImageIO.read(new File(filename));
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
		return im;
	}
	
	public void paintComponent(Graphics g)
	{
		//Draw sky
		g.setColor(new Color(128, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//Draw ground
		g.setColor(new Color(100,255,80));
		g.fillRect(0,400,this.getWidth(), 100);
		
		//Draw Sprites
		for(int i = 0; i < model.sprites.size(); i++)
		{
			model.sprites.get(i).drawYourself(g);
		}	
	}
}
