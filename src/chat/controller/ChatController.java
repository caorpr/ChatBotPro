package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.ChatPanel; //ChatView
// simpleBot = chatBotClay
// display = view
// ChatView= ChatDisplay
// displayText = displayResponse
// collectUserText = getAnswer

/**
 * 
 * @author cand3952
 */

public class ChatController 
{
	
	private ChatFrame baseFrame; // for the GUI
	private Chatbot chatBotClay; // simpleBot 
	private ChatPanel view; //display
	
	
	public ChatController()
	{
		view = new ChatPanel();
		String user = view.getAnswer("What is your name?");
		chatBotClay = new Chatbot(user);
		
		//GUI BELOW
		baseFrame = new ChatFrame(this);
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
			if(chatBotClay.contentChecker(textFromUser))
			{
					view.displayResponse("Wow, I had no idea you loved " + chatBotClay.getContent() + " bra!");
			}
			else if(chatBotClay.memeChecker(textFromUser));
			{
				view.displayResponse("We cannot understand your input.");
			}
	
			textFromUser = view.getAnswer(textFromUser);
		}
	}
	
	

	

	
	
	
}


									