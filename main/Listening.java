package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Listening implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{

	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		switch(key)
		{
		case KeyEvent.VK_SPACE:
			Main.menu.printMenus();
			break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		switch(key)
		{
		}
	}
	
	public void keyTyped(KeyEvent e)
	{

	}
	
	public void mouseClicked(MouseEvent e)
	{
		Main.mse.setLocation(e.getX()/Main.pixelSize, e.getY()/Main.pixelSize);
//		System.out.println(save);
		if(Main.isMouseLeft)		//left click
		{
		}
		else if(Main.isMouseMiddle)	//middle click
		{
		}
		else if(Main.isMouseRight)	//right click
		{
		}
	}
	
	public void mouseDragged(MouseEvent e)
	{
		Main.mse.setLocation(e.getX()/Main.pixelSize, e.getY()/Main.pixelSize);
		
		if(Main.isMouseLeft)		//left click
		{
		}
		else if(Main.isMouseMiddle)	//middle click
		{
		}
		else if(Main.isMouseRight)	//right click
		{
		}
		
		mouseChanged();
	}
	
	public void mousePressed(MouseEvent e)
	{
		mouseToggled(e, true);
		
		if(Main.isMouseLeft)		//left click
		{
		}
		else if(Main.isMouseMiddle)	//middle click
		{
		}
		else if(Main.isMouseRight)	//right click
		{
		}
		
		mouseChanged();
	}

	public void mouseReleased(MouseEvent e)
	{
		mouseToggled(e, false);
		mouseChanged();
	}
	
	public static void mouseToggled(MouseEvent e, boolean toggle)
	{
		Main.mse.setLocation(e.getX()/Main.pixelSize, e.getY()/Main.pixelSize);
		
		if(e.getButton() == MouseEvent.BUTTON1)			//left click
			Main.isMouseLeft = toggle;
		else if(e.getButton() == MouseEvent.BUTTON2)	//middle click
			Main.isMouseMiddle = toggle;
		else if(e.getButton() == MouseEvent.BUTTON3)	//right click
			Main.isMouseRight = toggle;
	}
	
	//called when the press states in the menus need to be updated
	public static void mouseChanged()
	{
//		System.out.println("mouse changed!");
		
		Main.menu.press1(Main.mse, Main.isMouseLeft);	//left click
		
		Main.menu.press2(Main.mse, Main.isMouseMiddle);	//middle click
		
		Main.menu.press3(Main.mse, Main.isMouseRight);	//right click
	}
	
	public void mouseMoved(MouseEvent e)
	{
		Main.mse.setLocation(e.getX(), e.getY());
	}

	public void mouseWheelMoved(MouseWheelEvent e)
	{
		if(e.getWheelRotation() < 0)		//scrolled up
		{
			
		}
		else if(e.getWheelRotation() > 0)	//scrolled down
		{
			
		}
	}
	
	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}
}
