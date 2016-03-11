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



	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 100);
		int page = 1;
		while (page <= 10)
		{
			statusPage.setPage(page);;
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for (Status currentStatus : statusList)
		{
			String[] tweetText= currentStatus.getText().split(" ");
			for (String word : tweetText)
			{
				wordsList.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWods(wordsList);
		removeEmptyText();
	
	
	}
	
	private String removePunctuation(String currentString)
	{
		return null;
	}

	private void removeCommonEnglishWods(ArrayList<String> wordsList) 
	{

	}

	private void removeEmptyText()
	{
	
	}

	



}
