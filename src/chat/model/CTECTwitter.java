package chat.model;

import java.io.File;
import java.io.FileNotFoundException;
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
		statusList.clear();
		wordsList.clear();
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
		removeCommonEnglishWords(wordsList);
		removeEmptyText();
	
	
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,;:\"(){}^[]<>-"; // the backslash is to not make it have errors!
		
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			if (punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}

	
	private List removeCommonEnglishWords(ArrayList<String> wordList) 
	{
		String[] boringWords = importWordsToArray();
			
		for (int count = 0; count < wordList.size(); count++)
		{
			for (int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if (wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length; // Exit the inner loop
				}
			}
		}
		//Comment this if you want to keep Twitter usernames in your word list.
//		removeTwitterUsernamesFromList(wordList);
	
		return wordList;
	}
	
	
	
	
	private void removeEmptyText()
	{
		for (int spot = 0; spot < wordsList.size(); spot++)
		{
			if (wordsList.get(spot).equals(""))
			{
				wordsList.remove(spot);
				spot--;
			}
		}
	}

	
	
	private String[] importWordsToArray()
	{
		String[] boringWords;
		int wordsCount = 0;

		Scanner wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		while (wordFile.hasNext()) 
		{
			wordsCount++;
			wordFile.next();
		}
		wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		boringWords = new String[wordsCount];
		int boringWordCount = 0;
		while (wordFile.hasNext()) 
		{
			boringWords[boringWordCount] = wordFile.next();
			boringWordCount++;
		}
		wordFile.close();

		return boringWords;
	}
	
	
	
	
	
	private void removeTwitterUsernamesFromList(List<String> wordList)
	{
		for (int wordCount = 0; wordCount < wordList.size(); wordCount++)
		{
			if (wordList.get(wordCount).length() >= 1 && wordList.get(wordCount).charAt(0) == '@')
			{
				wordList.remove(wordCount);
				wordCount--;
			}
		}
	}
	
	
	
	public String topResults()
	{
		String tweetResults = "";
		
		int topWordLocation = 0;
		int topCount = 0;
		
		for (int index = 0; index < wordsList.size(); index++)
		{
			int wordUseCount = 1;
			
			for(int spot = index + 1; spot < wordsList.size(); spot++)
			{
				if(wordsList.get(index).equals(wordsList.get(spot)))
				{
					wordUseCount++;
				}
				if(wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocation = index;
				}
			}
		}
		
		tweetResults = "The most used word in the tweets was " + wordsList.get(topWordLocation) + " and was used " + topCount  + " times!";
		return tweetResults;
	}
	
	
	
	public String sampleInvestigation() //put a string parameter here.
	{
		String results = "";
		
		Query query = new Query("marathon"); // put the parameter in there.
		query.setCount(100);
		query.setGeoCode(new GeoLocation(40.587521, -111.869178), 5, Query.MILES); //(within 5 miles of the point)
		query.setSince("2016-1-1");
		try
		{
			QueryResult result = chatbotTwitter.search(query);
			results.concat("Count : " + result.getTweets().size());
			for (Status tweet : result.getTweets())
			{
				results.concat("@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n");
			}
		}
		catch (TwitterException error)
		{
			error.printStackTrace();
		}
		
		return results;
	}

	
	public String checkForMemes(String memeResults)
	{
		String results = "";
		Query memeQuery = new Query(memeResults);
		memeQuery.setSince("1998-11-12");
		
		memeQuery.setGeoCode(new GeoLocation(40.549930, 111.860949), 0.1524, Query.KILOMETERS); //500 feet. This is just about Alta
	
		try
		{
			QueryResult result = chatbotTwitter.search(memeQuery);
			results.concat("The most used meme at alta is: " + result.getClass().getResourceAsStream("Memes.txt"));;
			for (Status tweet : result.getTweets())
			{
				results.concat("@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n");
			}
		}
		catch (TwitterException error)
		{
			error.printStackTrace();
		}
		
		return results;
	}
	
	
	


}
