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
	
	C
	
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
	
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getContent()
	{
		return getContent;
	}
	
	public ArrayList<String> getMemesList();
	{
		
	}
	
	
}
