//Name: Jacob Smith
//Date: 10/23/20
//Description: This class holds the the aspects of the Goomba image
//it controls the movement and removal of the the Goomba sprite

import java.awt.image.BufferedImage;
import java.awt.Graphics;

class Goomba extends Sprite
{
	int px, py;
	int direction;
	double horizontal_shift;
	int goombaTimer;
	boolean goombaHit;
	boolean goombaImage;
	static BufferedImage goomba_image;
	static BufferedImage goombaFire_image;
	Model model;
	
	Goomba(int x, int y, Model m)
	{
		super(x,y,59,70,"goomba");
		horizontal_shift = 10.0;
		direction = 1;
		model = m;
		if(goomba_image == null || goombaFire_image == null)
		{
			goomba_image = View.loadImage("goomba.png");
			goombaFire_image = View.loadImage("goomba_fire.png");
		}
		goombaImage = true;
		goombaHit = false;
		goombaTimer = 0;
	}
	
	Goomba(Json ob, Model m)
    {
		super((int)ob.getLong("x"),(int)ob.getLong("y"),59,70,"goomba");
		direction = 1;
		horizontal_shift = 10.0;
		model = m;
		if(goomba_image == null || goombaFire_image == null)
		{
			goomba_image = View.loadImage("goomba.png");
			goombaFire_image = View.loadImage("goomba_fire.png");
		}
		goombaImage = true;
		goombaHit = false;
    }
	
	void update()
	{
		savePrevious();
		horizontal_shift = 10.0;
		x+= horizontal_shift * direction;
		for(int i = 0; i < model.sprites.size(); i++)
		{
			if(model.sprites.get(i).isTube())
			{
				if(this.Collide(model.sprites.get(i)))
					hasCollidedTube(model.sprites.get(i));
			}
			if(model.sprites.get(i).isFireball())
			{
				
				if(this.Collide(model.sprites.get(i)));
				{
					hasCollidedFireball(model.sprites.get(i));
				}
			}
		}
			
	}
	void hasCollidedTube(Sprite t)
	{
		if(x <= t.x + t.w && px >= t.x + t.w)
		{
			x = t.x + t.w;
			horizontal_shift = 1.0;
			direction *= -1;
		}
		if(x+w >= t.x && px+w <= t.x){
			x = t.x - w;
			horizontal_shift = 1.0;
			direction *= -1;
		}
	}
	void hasCollidedFireball(Sprite f)
	{
		if(x <= f.x + f.w)
		{
			goombaTimer++;
			goombaImage = false;
			goombaHit = true;
			direction = 0;
			if (goombaTimer >= 75)
			{
				goombaHit = false;
				for(int i = 0; i < model.sprites.size(); i++)
				{		
					if(model.sprites.get(i).isGoomba())
						model.sprites.remove(i);
				}
			}
		}
	}
	boolean isGoomba()
	 {
		 return true;
	 }
	
	void savePrevious()
	{
	px = x;
	py = y;
	}
	void drawYourself(Graphics g)
	{
		if(goombaImage)
			g.drawImage(goomba_image, x-model.mario.x+model.mario.marioOffset, y, null);
		if(goombaHit)
			g.drawImage(goombaFire_image, x-model.mario.x+model.mario.marioOffset, y, null);
	}
}