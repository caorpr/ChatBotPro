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


public class ChatController 
{
	
	private Chatbot chatBotClay;  // sipmleBot
	private ChatView view; //display
	private ChatFrame baseFrame; // for the GUI
	
	
	/**
	 * Declares the variables.
	 */
	public ChatController()
	{
		view = new ChatView();
		String user = view.getAnswer("What is your name?");
		chatBotClay = new Chatbot(user);
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
	
	
}


									