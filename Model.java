//Name: Jacob Smith
//Date: 10/23/20
//Descriptions: this is the class that holds the arraylist that contains the elements of the tubes and goombas 
//from the json file. It also holds the collision of mario and the tubes and other sprites

import java.util.ArrayList;
import java.util.Iterator;
class Model
{
	ArrayList<Sprite> sprites;
	Mario mario;
	Model()
	{
		sprites = new ArrayList<Sprite>();
		mario = new Mario(100,50);
		sprites.add(mario);	
	}
	public void update()
	{	
		for(int i = 0; i < sprites.size(); i++)
		{
			sprites.get(i).update();
			Sprite s1 = sprites.get(i);
			for(int j = 0; j < sprites.size(); j++)
			{
				Sprite s2 = sprites.get(j);
					if(Collide(s1,s2))
					{
						if(s1 instanceof Mario)
							((Mario)s1).getOutOfTube(s2);
					}
			}
		}
	}
	boolean Collide(Sprite a, Sprite b)
	{
		if(a.x + a.w < b.x) 
			return false;
		if(a.x > b.x + b.w)
			return false;
		if(a.y + a.h < b.y) 
			return false;
		if(a.y > b.y + b.h) 
			return false;
		return true;
	}
	 void unmarshal(Json ob)
	 {
		 sprites = new ArrayList<Sprite>();
		 sprites.add(mario);
		 Json jsonList = ob.get("sprites");
		 Json tubesList = jsonList.get("tubes");
		 Json goombasList= jsonList.get("goombas");
		 for(int i = 0; i < tubesList.size(); i++)
		 {
			  sprites.add(new Tube(tubesList.get(i),this));
		 }
		 for(int i = 0; i < goombasList.size(); i++)
		 {
			  sprites.add(new Goomba(goombasList.get(i),this));
		 }	
	 }
}