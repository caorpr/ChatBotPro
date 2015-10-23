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
	
	
<<<<<<< HEAD:src/chat/model/Chatbot.java
	public String getUserName()
	{
		return userName;
	}
	
	public String getContent()
	{
		return getContent;
=======
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
>>>>>>> origin/master:src/chat/model/Chat.java
	}
	
	public ArrayList<String> getMemesList();
	{
		
	}
	
	public ArrayList<String> getPoliticalTopicList()
	{
		return null;
	}
	
	public void setContent(String content)
	{
		
	}
}
