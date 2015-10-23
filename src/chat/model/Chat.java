package chat.model;

import java.util.ArrayList;

public class Chat 
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	public Chat(String userName)
	{
		
	}
	
	private void buildMemesList()
	{
		
	}
	
	private void buildPoliticalTopicsList()
	{
		
	}
	
	
	
	
	
	public boolean lenghtChecker(String currentInput)
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
	
	
	public boolean contentChecker(String currentInput)
	{
		return false;
	}
	
	public boolean politicalTopicChecker(String currentInput)
	{
		return false;
	}
	
	public String getUserName()
	{
		return null;
	}
	
	public String getContent()
	{
		return null;
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
