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
	}
	
	public void tick()
	{
		
	}
	
	public void draw(Graphics graphics)
	{
		graphics.setColor(Color.RED);
		graphics.fillRect(x*width, y*height, width, height);
	}
}
