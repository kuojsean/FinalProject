package snake.model;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Screen extends JPanel implements Runnable
{

	public int width = 1280;
	public int height = 720;
	private Thread thread;
	private boolean running = false;
	
	private SnakePart body;
	private ArrayList<SnakePart> snake;
	
	private int x = 10;
	private int y = 10;		
	private int size = 5;
	
	private boolean right = false;
	private boolean left = false;
	private boolean up = false;
	private boolean down = false;
	
	private int ticks = 0;
	
	public Screen()
	{
		setPreferredSize( new Dimension(width,height));
		
		snake = new ArrayList<SnakePart>();
		
		start();
	}
	
	public void tick()
	{
		if(snake.size() == 0)
		{
			body = new SnakePart(x, y, 10);
			snake.add(body);
		}
		
		ticks++;
		if (ticks > 250000)
		{
			if(right)
			{
				x++;
			}
			if(left)
			{
				x--;
			}
			if(up)
			{
				y++;
			}
			if(down)
			{
				y--;
			}
		}
	}
	
	public void paint(Graphics graphics)
	{
		for(int index = 0; index < snake.size(); index++)
		{
			snake.get(index).draw(graphics);
		}
	}
	
	public void start()
	{
		running = true;
		thread = new Thread(this, "Game Loop");
		thread.start();
	}
	
	public void stop()
	{
		
	}
	
	
	public void run()
	{
		while(running)
		{
			tick();
			repaint();
		}
	}
}
