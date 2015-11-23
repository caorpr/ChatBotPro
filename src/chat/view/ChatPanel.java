package chat.view;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

import chat.controller.ChatController;


public class ChatPanel
{
	private ChatController baseController;
	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		firstButton = new JButton("Don' Click the button!");
		
		firstTextField = new JTextField("Type Words Here");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
	}
	
	private void setupLayout()
	{
		//GUI GARBAGE STUFF!
	}
	
	
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		
		this.addMouseListener(new MouseListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		
		{
			public void mouseClicked(MouseEvent clicked)
			{
			
				if(SwingUtilities.isLeftMouseButton(clicked))
				{
					firstTextField.setText("left click!");
				}
				else if(SwingUtilities.isRightMouseButton(clicked))
				{
					firstTextField.setText("right click!");
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent released)
			{
				changeRandomColor();
			}
			
			
			@Override
			public void mousePressed(MouseEvent pressed)
			{
				changeRandomColor();
			}
			
			@Override
			public void mouseEntered(MouseEvent entered)
			{
				changeRandomColor();
			}
			
			
			@Override
			public void mouseExited(MouseEvent exited)
			{
				changeRandomColor();
			}
			
		});
		
		
		
		
		
		
		
	}
}
