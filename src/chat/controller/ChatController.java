package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatDisplay; //ChatView
// simpleBot = chatBotClay
// display = view
// ChatView= ChatDisplay
// displayText = displayResponse
// collectUserText = getAnswer

/**
 * 
 * @author cand3952
 * @version 1.0 10/21/15
 */

public class ChatController 
{
	
	
	private Chatbot chatBotClay; // simpleBot 
	private ChatDisplay view; //display
	
	
	public ChatController()
	{
		view = new ChatDisplay(); 
		String user = view.getAnswer("What is your name?");
		chatBotClay = new Chatbot(user);
	}
	
	public void start()
	{
		view.displayResponse("Hello " + chatBotClay.getUserName());
		chat();
	}
	
	private void chat()
	{
		String textFromUser = view.getAnswer("Talk to the chatbot");   
		while(chatBotClay.lengthChecker(textFromUser))
		{
			textFromUser = view.getAnswer("wow" + textFromUser);
		}
	}
}
