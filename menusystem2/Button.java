package menusystem2;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Button extends Menu
{
	String str = "Test";
	
	public Button(int x, int y, int width, int height, String str)
	{
		super(x, y, width, height);
		this.str = new String(str);
	}
	
	public Button(int xPos, int yPos, int xSize, int ySize, boolean bool, String str)
	{
		super(xPos, yPos, xSize, ySize, bool);
		this.str = new String(str);
	}
	
	public static Color randomColor()
	{
		return new Color(random(0,255), random(0,255), random(0,255));
//		return new Color(random(2,13), random(40,105), random(83,171));
		
//		float hbase = 0.604f, hspread = .01f;
//		float sbase = 0.73f, sspread = .05f;
//		float bbase = 0.19f, bspread = .10f;
//		
//		float h = randomf(hbase-hspread, hbase+hspread);
//		float s = randomf(sbase-sspread, sbase+sspread);
//		float b = randomf(bbase-bspread, bbase+bspread);
////		float h = 0.56f;
////		float s = .5f;
////		float b = .5f;
//		return Color.getHSBColor(h, s, b);
	}
	
	//positive amount = brighter, negative = darker
	public static Color changeColor(Color color, int amount)
	{
		return makeColor(color.getRed()+amount, color.getGreen()+amount, color.getBlue()+amount);
	}
	
	public static Color invertColor(Color color)
	{
		return new Color(255-color.getRed(), 255-color.getGreen(), 255-color.getBlue());
	}
	
	public static Color makeColor(int r, int g, int b)
	{
		r = capRange(r);
		g = capRange(g);
		b = capRange(b);
		return new Color(r, g, b);
	}
	
	public static int capRange(int num)
	{
		if(num < 0)
			num = 0;
		else if(num > 255)
			num = 255;
		return num;
	}
	
	public int getFontSize(Graphics g)
	{
		int fsize = 8;
		int increment = 1;
		for(int i = 0; i < 72+1; i+=increment)
		{
			Font f = new Font("Verdana", Font.PLAIN, i);
			g.setFont(f);
			Rectangle2D rect = g.getFontMetrics(f).getStringBounds(str, g);
			
			fsize = i-increment;
			if(rect.getMaxX()-rect.getMinX() > width-5)
				break;
			if(rect.getMaxY()-rect.getMinY() > height-5)
				break;
		}
		
		switch(fsize)
		{
		case 12:
			increment = 2;
			break;
		case 28:
			increment = 8;
			break;
		case 36:
			increment = 12;
			break;
		case 48:
			increment = 24;
			break;
		}
		
		return fsize;
	}
	
	public void render(Graphics g)
	{
		Color buttonColor = new Color(bgcolor.getRed(), bgcolor.getGreen(), bgcolor.getBlue());
		if(pressed1)
			buttonColor = changeColor(buttonColor, 50);
		if(pressed3)
			buttonColor = changeColor(buttonColor, -50);
		g.setColor(buttonColor);
		g.fillRect((int)x, (int)y, width, height);
		
		Font f = new Font("Verdana", Font.PLAIN, getFontSize(g));
		g.setFont(f);
		FontMetrics fm = g.getFontMetrics(f);
		Rectangle2D rect = fm.getStringBounds(str, g);
		
		int xCenter = (int)x + (width/2);
		int yCenter = (int)y + (height/2);
		int sX = xCenter - (int)(rect.getWidth()/2);
		int sY = yCenter - (int)(rect.getHeight()/2) + fm.getAscent();
		
//		g.setColor(Color.black);
		g.setColor(invertColor(bgcolor));
		g.drawString(str, sX, sY);
		
		for(int i = 0; i < menus.size(); i++)
			menus.get(i).render(g);
	}
	
	public String toString()
	{
		return "Button(\""+str+"\")";
	}
}
