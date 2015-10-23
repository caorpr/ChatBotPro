package chat.model;

import java.util.ArrayList;



public class Chatbot 
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	public Chatbot(String userName)
	{
		this.userName = userName;
	}
	
	
	private void buildMemesList()
	{
		
	}
	
	private void buildPoliticalTopicsList()
	{
		
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
		return false;
	}
	
	public boolean politicalTopicChecker(String currentInput)
	{
		return false;
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
