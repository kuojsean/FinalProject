package snake.view;

import javax.swing.JOptionPane;

public class PopupDisplay
{
	private String windowTitle;
	
	public PopupDisplay() 
	{
		windowTitle = "Snake";			
	}
	
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
}
