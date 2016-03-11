package chat.model;

import java.util.*;

import chat.controller.ChatController;
import twitter4j.*;

public class CTECTwitter 
{
	


	private ArrayList <Status> statusList;
	private ArrayList <String> wordsList;
	private Twitter chatbotTwitter;
	private ChatController baseController;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		this.statusList = new ArrayList<Status>();
		this.wordsList = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
	}
	
	public void sendTweet(String message)
	{
		try
		{
		chatbotTwitter.updateStatus("#Clayton ### ## # #MOREHASHTAGS # ### # #HASHTAGS # # #### # #### ########### #SPAMMINGTHOSEHASHTAGS!");
		
	
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}


public String topResults(List<String> wordsList)
{
	
}



public void loadTweets(String twitterHandle) throws TwitterException
{
	Paging statusPage = new Paging(1, 100);
	
	
}


}
