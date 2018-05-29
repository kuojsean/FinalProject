package snake.view;

import javax.swing.JFrame;
import java.awt.*;

import snake.model.*;

public class SnakeFrame extends JFrame
{

	public SnakeFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setupFrame();
	}
	
	public void setupFrame()
	{
		setTitle("CTEC Snake Game");
		setResizable(false);
		setLayout(new GridLayout(1,1,0,0));
		
		Screen gameScreen = new Screen();
		add(gameScreen);
		
		pack();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
