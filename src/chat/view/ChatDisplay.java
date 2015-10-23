package chat.view;

import javax.swing.JOptionPane;

/**
 * 
 * @author cand3952
 * @version 1.0 10/21/15
 */
public class ChatDisplay
{
	
	/**
	 *  
	 * This is what is shown in the Popup window. Usually a question.
	 * @param showWords
	 * @return
	 */
	public String getAnswer(String showWords)
	{
		String answer = "";
		answer = JOptionPane.showInputDialog(null, showWords);
		return answer;
	}
	
	/**
	 * 
	 * @param showWords
	 */
	public void displayResponse(String showWords)  // displayText
	{
		JOptionPane.showMessageDialog(null, showWords);
	}
}

