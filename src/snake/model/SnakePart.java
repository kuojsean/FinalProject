package snake.model;

import java.awt.*;

public class SnakePart
{

	private int x, y, width, height;
	
	public SnakePart(int x, int y, int tileSize)
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
		graphics.setColor(Color.BLACK);
		graphics.fillRect(x * width,  y * height,  width,  height);
		graphics.setColor(Color.GREEN);
		graphics.fillRect(x* width + 2, y* height + 2, width - 4, height - 4);
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
