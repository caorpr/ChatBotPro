package chat.model;

import java.util.ArrayList;



public class Chatbot 
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicsList;
	private String userName;
	private String content;
	
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicsList = new ArrayList<String>();
		this.userName = userName;
		this.content = "board games";
		
		buildMemesList();
		buildPoliticalTopicsList();
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
		this.memesList.add("blandk");
	}
	
	
	
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicsList.add("obama");
		this.politicalTopicsList.add("white house");
		this.politicalTopicsList.add("the constitution");
		this.politicalTopicsList.add("president");
		this.politicalTopicsList.add("the weather");
		
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
	
	public boolean politicalTopicsChecker(String currentInput)
	{
		return false;
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
