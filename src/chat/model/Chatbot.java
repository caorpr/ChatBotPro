package chat.model;

import java.util.ArrayList;



public class Chatbot 
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private ArrayList<String> keyboardMashList;
	private ArrayList<String> quitList;
	private String userName;
	private String content;
	private boolean keyboardMashChecker;
	private boolean quitChecker;
	
	
	private ArrayList<String> RandomTopic;
	
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.keyboardMashList = new ArrayList<String>();
		this.quitList = new ArrayList<String>();
		this.userName = userName;
		this.content = "board games";
		
		buildMemesList();
		buildPoliticalTopicsList();
		buildKeyboardMashList();
		buildQuitList();
	}
	
	
	private void buildMemesList()
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("harry potter");
		this.memesList.add("john cenna");
		this.memesList.add("runescape");
		this.memesList.add("settler's of ctan");
		this.memesList.add("yugioh");
		this.memesList.add("sanik");
		this.memesList.add("luigi death stare");
		this.memesList.add("philosoraptor");
	}
	
	
	
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("obama");
		this.politicalTopicList.add("white house");
		this.politicalTopicList.add("the constitution");
		this.politicalTopicList.add("president");
		this.politicalTopicList.add("the weather");
		this.politicalTopicList.add("11/4/16");
		this.politicalTopicList.add("Democrat");
		this.politicalTopicList.add("Republican");
		this.politicalTopicList.add("Economy");
		this.politicalTopicList.add("Debates");
	}
	
	private void buildKeyboardMashList()
	{
		this.keyboardMashList.add("sdf");
		this.keyboardMashList.add("dfg");
		this.keyboardMashList.add("cvb");
		this.keyboardMashList.add(",./");
	}
	
	
	private void buildQuitList()
	{
		this.quitList.add("quit");
	}
	
	
	
	
	
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		if(currentInput != null)
		{
			if(currentInput.length() > 0)
			{
				hasLength = true;
			}
		}
		
		return hasLength;
	}
	
	

	public String getUserName()
	{
		return userName;
	}
	
	public String getContent()
	{
		return content;
	}

	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		
		return hasContent;
	}
	
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPoliticalTopic = false;
		
		for(String politicalTopic : politicalTopicList)
		{
			if(currentInput.toLowerCase().contains(politicalTopic.toLowerCase()))
			{
				hasPoliticalTopic = true;
			}
		}
		return hasPoliticalTopic;
	}
	
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for(String meme : memesList)
		{
			if(currentInput.toLowerCase().contains(meme.toLowerCase()))
			{
				hasMeme = true;
			}
		}
		
		return hasMeme;
	}
	
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean hasMash = false;
		
		for(String keyboardMash : keyboardMashList)
		{
		
			if(currentInput.toLowerCase().contains(keyboardMash.toLowerCase()))
			{
				hasMash = true;
			}
		}
		
		return hasMash;
	}

	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
		
		if(currentInput.toLowerCase().equals("quit"))
		{
			hasQuit = true;
		}
		return hasQuit;
	
	}
	
	
	
	public String prossessConversation(String currentInput)
	{
		String nextConversation = "what do you want now?";
		int randomTopic = (int) (Math.random() * 5);  //This is a number between 0 and 4, not up to 5.
		
		if(keyboardMashChecker(currentInput))
		{
			return "stop spamming!!";
		}
		
		
		switch (randomTopic)
		{
			case 0:
				if(contentChecker(currentInput))
				{
					nextConversation = "Hey you talked about stuff" + "Cool! Now what?";
				}
			case 1:
				if(memeChecker(currentInput))
				{
					nextConversation = "Wow bro!" + "Now what?";
				}
			case 3:
				//Choose your own test here.
				if(currentInput.contains("star wars"));
				{
					nextConversation = "Did you know Darth Vader is Luke's dad?" + "what else do you like?";
				}
			case 4:
				//Random Chat topic here
				nextConversation = "Wow that's great." + "Do you like watermelon?";
			default:
				//Never will happen, but just in case the number generator is stupid, it's here.
				nextConversation = "Don't know why you are seeing this, please shut off this program." 
						+ "have you shut off the program yet?";
			break;
		}
		return nextConversation;
	}
	
	
	public ArrayList<String> getMemesList()
	{

		return null;

	}

	public ArrayList<String> getPoliticalTopicList()
	{
		return null;
	}
	
	public void setContent(String content)
	{
		
	}
}
