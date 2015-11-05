package chat.view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * 
 * @author cand3952
 * @version 1.0 10/21/15
 */
public class ChatDisplay
{
	
		private String windowMessage;
		private ImageIcon chatIcon;
		
		public ChatDisplay()
		{
			windowMessage = "Press q to receive 20$!!";
			chatIcon = new ImageIcon(getClass().getResource("images/trollface"));
		}
	

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

