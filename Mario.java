//Name: Jacob Smith
//Date: 10/23/20
//Description: This class holds the the aspects of the Mario image
//it controls the movement and collsion of the sprite.
//It now also holds the arraylist of mario images

import java.awt.Graphics;
import java.awt.image.BufferedImage;

class Mario extends Sprite
{
	int px,py;
	static BufferedImage[] mario_images;
	int marioImageNum;
	double vert_velocity;
	int jumpFrames;
	static int marioOffset;
	
	public Mario(int x, int y){
		super(x,y,60,95,"Mario");
		vert_velocity = -14.0;
		jumpFrames = 0;
		marioOffset = 100;
		
		mario_images = new BufferedImage[5]; 
		mario_images[0] = View.loadImage("mario1.png");
		mario_images[1] = View.loadImage("mario2.png");
		mario_images[2] = View.loadImage("mario3.png");
		mario_images[3] = View.loadImage("mario4.png");
		mario_images[4] = View.loadImage("mario5.png");
		
	}
	//Jump function 
	void yeet()
	{	
		jumpFrames++;
		if (jumpFrames > 5){	
			vert_velocity = 10;
			if( y == 349)
				jumpFrames = 0;
		}
		else if(jumpFrames < 5)
		{
			vert_velocity = -45;
		}
	}
	void savePrevious()
	{
		px = x;
		py = y;
	}
	
	void getOutOfTube(Sprite t){
		if(x <= t.x + t.w && px >= t.x + t.w)
			x = t.x + t.w;
		if(x+w >= t.x && px+w <= t.x)
			x = t.x - w;
		if (y + h >= t.y && py + h <= t.y){
			y = t.y - h -1;
			jumpFrames = 0;
			vert_velocity = 0;
		}
		if (y <= t.y + t.h && py >= t.y +t.h)
			y = t.y + t.h;
	}
	void update()
	{	
		vert_velocity += 6.9;
		y+= vert_velocity;
		
		if(y > 500)
		{
			vert_velocity = 0.0;
			y = 500; // snap back to the ground
		}
		if(y > 400-h)
			vert_velocity  = -2.0;	
		if(y < 9)
			y = 0;
		if (y > 350)
			y = 349;
		
		marioImageNum++;
		if(marioImageNum > 4)
			marioImageNum = 0;
	}
	void drawYourself(Graphics g)
	{
		g.drawImage(mario_images[marioImageNum], marioOffset, y,null);
	}
	
	boolean isMario()
	 {
		 return true;
	 }
}