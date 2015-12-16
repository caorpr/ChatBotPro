package chat.view;

import javax.swing.JOptionPane;

public class ChatView 
{
	/**
	 * Gets the input of the user, and puts it into "answer".
	 * @param input
	 * @return
	 */

	public String getAnswer(String input)
	{
		String answer = "";
		answer = JOptionPane.showInputDialog(null, input);
		return answer;
	}
	
	/**
	 * This is for all of the Window panes.
	 * @param input
	 */
	public void displayResponse(String input)
	{
		JOptionPane.showMessageDialog(null, input);
	}
}
