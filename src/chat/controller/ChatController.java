package chat.controller;


import java.util.ArrayList;

import twitter4j.Status;
import twitter4j.TwitterFactory;
import chat.model.CTECTwitter;
import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.ChatPanel;
import chat.view.ChatView;//ChatView
// simpleBot = chatBotClay
// display = view
// ChatView= ChatDisplay
// displayText = displayResponse
// collectUserText = getAnswer
//Version 1.7??!

public class ChatController 
{
	
	
	private Chatbot chatBotClay;  // sipmleBot
	private ChatView view; //display
	private ChatFrame baseFrame; // for the GUI
	private CTECTwitter myTwitter;
	private ChatController baseController;
	
	

	/**
	 * Declares the variables.
	 */
	public ChatController()
	{
		view = new ChatView();
		String user = view.getAnswer("What is your name?");
		chatBotClay = new Chatbot(user);
		myTwitter = new CTECTwitter(this);
		baseFrame = new ChatFrame(this);
		
	}
	

	/**
	 * starts the program.
	 */
	public void start()
	{
		view.displayResponse("Hello " + chatBotClay.getUserName());
		chat();
	}
	
	
	/**
	 * starts chat up, so you can talk to it.
	 */
	private void chat()
	{
		String textFromUser = view.getAnswer("Talk to the chatbot");   
		while(chatBotClay.lengthChecker(textFromUser))
		{
			textFromUser = chatBotClay.prossessConversation(textFromUser);
			textFromUser = view.getAnswer(textFromUser);
		}
	}
	
	/**
	 * The chatbot takes info, and stores it
	 * @param conversation
	 * @return
	 */
	public String fromUserToChatbot(String conversation)
	{
		String botResponse = "";
		
		if(chatBotClay.quitChecker(conversation))
		{
			shutDown();
		}
		
		botResponse = chatBotClay.prossessConversation(conversation);
		
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
	
	/**
	 * Says stuff when you shut it down, then exits.`
	 */
	private void shutDown()
	{
		view.displayResponse("Goodbye, " + chatBotClay.getUserName() + " it has been fun.");
		System.exit(0);
	}
	
	
	
	public void sendTweet(String tweet)
	{
		myTwitter.sendTweet(tweet);
	}
	
	
	public void handleErrors(String error)
	{
		view.displayResponse(error);
	}
	
}


									