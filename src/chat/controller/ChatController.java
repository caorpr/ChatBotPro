package chat.controller;


import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.ChatPanel;
import chat.view.ChatView;//ChatView
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
	private Chatbot chatBotClay;  // sipmleBot
	private ChatView view; //display
	private ChatFrame baseFrame; // for the GUI
	
	
	
	public ChatController()
	{
		view = new ChatView();
		String user = view.getAnswer("What is your name?");
		chatBotClay = new Chatbot(user);
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
			textFromUser = chatBotClay.prossessConversation(textFromUser);
			textFromUser = view.getAnswer(textFromUser);
		}
	}
	
	
	public String fromUserToChatbot(String conversation)
	{
		String botResponse = "";
		
		if(chatBotClay.quitChecker(conversation))
		{
			shutDown();
		}
		
		botResponse = chatBotClay.prossessConversation(textFromUser);
		
		return botResponse;
	}
	
	
	
	public Chatbot getChatbot()
	{
		return chatBotClay;
	}
	
	public ChatView getChatView()
	{
		return view;
	}
	
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
	
	private void ShutDown()
	{
		view.displayResponse("Goodbye, " + chatBotClay.getUserName() + " it has been fun.");
		System.exit(0);
	}
	
	
}


									