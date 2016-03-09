package chat.view;


/**
 * MUCH IMPORTS
 */
import javax.swing.ImageIcon;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;     //  but Mr. H says it is okay for any of the projects that we do.
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import java.awt.Color;
import java.awt.event.*;

import chat.controller.ChatController;

import javax.swing.*;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private String windowMessage;
	private ImageIcon chatIcon;
	private JTextArea chatArea;
	private JTextField typingField;
	private JLabel promptLabel;
	private JButton submitButton;
	private JButton tweetButton;
	private JScrollPane textPane;
	//More ChatBot
	
	/**
	 * Sets up all of the methods, and GUI.
	 * @param baseController
	 */
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		chatArea = new JTextArea(10,30);
		typingField = new JTextField(30);
		promptLabel = new JLabel("");
		baseLayout = new SpringLayout();
	
		tweetButton = new JButton("send a tweet");
		submitButton = new JButton("suff");

		
		setupPanel();
		setupLayout();
		setupListeners();
	
		
		windowMessage = "Press q to receive 20$!!";
		chatIcon = new ImageIcon(getClass().getResource("images/trollface.jpg"));
	}
	
	
	private void setupChatPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		chatArea.setBackground(Color.MAGENTA);
		textPane = new JScrollPane(chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, typingField, 0, SpringLayout.EAST, textPane);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	
	/**
	 * All this is for the GUI, and telling it what to do.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(chatArea);
		this.add(typingField);
		this.add(promptLabel);
		this.setLayout(baseLayout);
		this.add(submitButton);
		this.add(tweetButton);
		typingField.setToolTipText("hints");
	}
	
	
	
	/**
	 * Crap code for the GUI.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, typingField, -21, SpringLayout.NORTH, chatArea);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -36, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 163, SpringLayout.WEST, this);
	}
	
	/**
	 * Sets up stuff that waits to be acted upon.
	 */
	private void setupListeners()
	{
		
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = typingField.getText();    //Grab user text     x
				String response = baseController.fromUserToChatbot(userText);    //send the text to controller   x give text to chatbot to process get chatbots answer
				chatArea.append("\nUser: " + userText);     //display the users text
				chatArea.append("\nChatbot: " + response);     //display answer
				typingField.setText("");    //clear user field 
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.sendTweet("");
			}
		});
	}
		
	public JTextField getTextField()
	{
		return typingField;
	}


	//ALL CHATBOT BELOW
	/**
	 * Gets your input, and puts it into the "answer" variable.
	 * @param showWords
	 * @return
	 */
	public String getAnswer(String showWords)
	{
		String answer = "";
		answer = JOptionPane.showInputDialog(null, showWords, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon, null, "Type Here").toString();
		return answer;
	}
	
	/**
	 * The window for the chatbot's response.
	 * @param showWords
	 */
	public void displayResponse(String showWords)
	{
		JOptionPane.showMessageDialog(null, showWords, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon);

	}
}
