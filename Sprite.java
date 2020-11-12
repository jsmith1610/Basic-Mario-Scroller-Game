//Name: Jacob Smith
//Date: 10/23/20
//Description: This is the super class that holds the info for the location of each individual sprite
//this also has a general collide meathod that gives the truth value of the collision 
//Another thing is has to help tell the truth value of which class youre looking at

import java.awt.Graphics;

abstract class Sprite
{
	int x,y;
	int w,h;
	String type;
	Sprite(int x, int y, int w, int h, String type)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.type = type;
		
	}
	abstract void update();
	abstract void drawYourself(Graphics g);
	
	boolean isTube(){return false;}
	boolean isMario(){return false;}
	boolean isGoomba(){return false;}
	boolean isFireball(){return false;}
	
	//General colliosn for sprites
	boolean Collide(Sprite a)
	{
		if(this.x + this.w <= a.x)
			return false;
		if(this.x >= a.x + a.w)
			return false;
		if(this.y >= a.y + a.h)
			return false;
		if(this.y + this.h <= a.y)
			return false;
		return true;	
	}
}