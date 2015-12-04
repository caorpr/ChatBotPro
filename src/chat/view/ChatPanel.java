package chat.view;

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
	//More ChatBot
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		chatArea = new JTextArea(10,30);
		typingField = new JTextField(30);
		promptLabel = new JLabel("");
		baseLayout = new SpringLayout();
	
		submitButton = new JButton("suff");

		
		setupPanel();
		setupLayout();
		setupListeners();
	
		
		windowMessage = "Press q to receive 20$!!";
		chatIcon = new ImageIcon(getClass().getResource("images/trollface.jpg"));
	}
	
	
	private void setupPanel()
	{
		this.add(chatArea);
		this.add(typingField);
		this.add(promptLabel);
		this.setLayout(baseLayout);
		this.add(submitButton);
		typingField.setToolTipText("hints");
	}
	
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, typingField, -21, SpringLayout.NORTH, chatArea);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -36, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 163, SpringLayout.WEST, this);

	}
	
	
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
	}
		
		
	
	

	public JTextField getTextField()
	{
		return typingField;
	}


	//ALL CHATBOT BELOW
	
	public String getAnswer(String showWords)
	{
		String answer = "";
		answer = JOptionPane.showInputDialog(null, showWords, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon, null, "Type Here").toString();
		return answer;
	}
	
	
	public void displayResponse(String showWords)
	{
		JOptionPane.showMessageDialog(null, showWords, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon);

	}
}
