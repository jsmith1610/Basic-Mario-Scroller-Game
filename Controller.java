//Name: Jacob Smith
//Date: 10/23/20
//Description: This is the where the controls for moving the stage and also has the code for when
// the user presses the ctrl a fireball is shot out of mario.

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Controller implements ActionListener, MouseListener, KeyListener
{
	View view;
	Model model;
	int timer;
	boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;
	boolean spacebar;
	boolean ctrl;
	
	Controller(Model m)
	{
		model = m;
	}	
	public void actionPerformed(ActionEvent e){	}
	void setView(View v)
	{
		view = v;
	}
	
	public void mousePressed(MouseEvent e) {   }	
	public void mouseReleased(MouseEvent e){   }
	public void mouseEntered(MouseEvent e) {   }
	public void mouseExited(MouseEvent e)  {   }
	public void mouseClicked(MouseEvent e) {   }
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: keyRight = true; break;
			case KeyEvent.VK_LEFT: keyLeft = true; break;
			case KeyEvent.VK_UP: keyUp = true; break;
			case KeyEvent.VK_DOWN: keyDown = true; break;
			case KeyEvent.VK_SPACE:spacebar = true; break;
			case KeyEvent.VK_CONTROL:ctrl = true; break;
		}
		char c = e.getKeyChar();
		if (c == 'l')
		{
			Json j = Json.load("map.json");
			//model.unmarshal(j);
			System.out.println("You have loaded in a map");
		}
	}
	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: keyRight = false; break;
			case KeyEvent.VK_LEFT: keyLeft = false; break;
			case KeyEvent.VK_UP: keyUp = false; break;
			case KeyEvent.VK_DOWN: keyDown = false; break;
			case KeyEvent.VK_SPACE:spacebar = false; break;
			case KeyEvent.VK_CONTROL:ctrl = false; break;
		}
	}

	public void keyTyped(KeyEvent e)
	{
	}

	void update()
	{	
		model.mario.savePrevious();
		//The timer makes sure that a fireball is not shot at every second
		//Moves the screen from right to left with the arrow keys
		if(keyRight)
			model.mario.x+=5;
		if(keyLeft)
			model.mario.x-=5;
		if(keyUp || spacebar) 
			model.mario.yeet();	
		if(ctrl)
			timer += 5;
			if(timer > 10)
			{
				model.sprites.add(new Fireball(model.mario.x+70,model.mario.y,model));
				timer = 0;
			}
	}
}
