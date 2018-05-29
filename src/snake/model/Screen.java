package snake.model;

import javax.swing.JPanel;
import java.awt.*;


public class Screen extends JPanel implements Runnable
{

	public int width = 1280;
	public int height = 720;
	private Thread thread;
	private boolean running = false;
	
	public Screen()
	{
		setPreferredSize( new Dimension(width,height));
		
		start();
	}
	
	public void tick()
	{
		
	}
	
	public void paint(Graphics graphics)
	{
		
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
