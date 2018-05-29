package snake.model;

import java.awt.*;

public class Food
{
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	public Food(int x, int y, int tileSize)
	{
		this.x = x;
		this.y = y;
		width = tileSize;
		height = tileSize;
	}
	
	public void tick()
	{
		
	}
	
	public void draw(Graphics graphics)
	{
		graphics.setColor(Color.RED);
		graphics.fillRect(x*width, y*height, width, height);
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
}
