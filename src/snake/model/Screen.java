package snake.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import snake.view.*;


public class Screen extends JPanel implements Runnable
{

	public int width = 1280;
	public int height = 720;
	private Thread thread;
	private boolean running = false;
	
	private PopupDisplay display;
	
	private SnakePart body;
	private ArrayList<SnakePart> snake;
	
	private int x = 10;
	private int y = 10;		
	private int size = 5;
	
	private Random random;
	
	private boolean right = true;
	private boolean left = false;
	private boolean up = false;
	private boolean down = false;
	
	private Food apple;
	private ArrayList<Food> apples;
	
	private int score = 0;
	
	private int ticks = 0;
	private int tickDifficulty = 600000;
	
	private Key key;
	
	public Screen()
	{
		setFocusable(true);
		key = new Key();
		addKeyListener(key);
		setPreferredSize( new Dimension(width,height));
		
		random = new Random();
		
		snake = new ArrayList<SnakePart>();
		apples = new ArrayList<Food>();
		
		start();
	}
	
	public void tick()
	{
		if(snake.size() == 0)
		{
			body = new SnakePart(x, y, 10);
			snake.add(body);
		}
		
		if(apples.size() == 0)
		{
			int x = random.nextInt(127);
			int y = random.nextInt(71);
			
			apple = new Food(x,y,10);
			apples.add(apple);
		}
		
		for(int index = 0; index < apples.size(); index ++) 
		{
			if(x == apples.get(index).getX() && y == apples.get(index).getY())
			{
				size++;
				apples.remove(index);
				index--;
				tickDifficulty -= 500;
				score ++;
			}
		}
		
		for(int index = 0; index < snake.size(); index++)
		{
			if(x == snake.get(index).getX() && y == snake.get(index).getY())
			{
				if(index != snake.size() - 1) 
				{
					stop();
				}
			}
		}
		
		if (x < 0 || x > 127 || y < 0 || y > 71)
		{
			stop();
		}
		
		ticks++;
		
		if (ticks > tickDifficulty)
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
				y--;
			}
			if(down)
			{
				y++;
			}
			
			ticks = 0;
			
			body = new SnakePart(x,y, 10);
			snake.add(body);
			
			if(snake.size() > size)
			{
				snake.remove(0);
			}
		}
		

		

	}
	
	public void paint(Graphics graphics)
	{
		graphics.clearRect(0, 0, width, height);
		for(int index = 0; index < snake.size(); index++)
		{
			snake.get(index).draw(graphics);
		}
		for(int index = 0; index < apples.size(); index++)
		{
			apples.get(index).draw(graphics);
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
		running = false;
		try
		{
			thread.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		display.displayText("Game Over");
		display.displayText("Your Score is: " + score);
		score = 0;
		tickDifficulty = 600000;
	}
	
	
	public void run()
	{
		while(running)
		{
			tick();
			repaint();
		}
	}
	
	private class Key implements KeyListener
	{

		@Override
		public void keyTyped(KeyEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_RIGHT && !left)
			{
				up = false;
				down = false;
				right = true;
				left = false;
			}
			if (key == KeyEvent.VK_LEFT && !right)
			{
				up = false;
				down = false;
				left = true;
				right = false;
			}
			
			if (key == KeyEvent.VK_UP && !down)
			{
				up = true;
				down = false;
				left = false;
				right = false;
			}
			
			if (key == KeyEvent.VK_DOWN && !up)
			{
				up = false;
				down = true;
				left = false;
				right = false;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			// TODO Auto-generated method stub
			
		}
	}
}
