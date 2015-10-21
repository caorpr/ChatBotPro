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
	
	
	
	
	
	
}
