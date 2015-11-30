package chat.view;

import javax.swing.ImageIcon;
<<<<<<< HEAD
import javax.swing.JComponent;
import javax.swing.JOptionPane;
=======
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;     //  but Mr. H says it is okay for any of the projects that we do.
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
>>>>>>> origin/master

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
	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	
<<<<<<< HEAD
	//Chatbot stuff below
=======
	//ChatBot stuff below
>>>>>>> origin/master
	
	private String windowMessage;
	private ImageIcon chatIcon;
	
	//More ChatBot
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
<<<<<<< HEAD
		chatArea = new JButton("Don't Click the button!");
=======
		firstButton = new JButton("Don't Click the button!");
<<<<<<< HEAD

		
=======
>>>>>>> origin/master
>>>>>>> origin/master
		firstTextField = new JTextField("Type Words Here");

		
		setupPanel();
		setupLayout();
		setupListeners();
	
		
		windowMessage = "Press q to receive 20$!!";
		chatIcon = new ImageIcon(getClass().getResource("images/trollface.jpg"));
	}

	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
	
	}
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 162, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -6, SpringLayout.NORTH, firstButton);
		
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 132, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -63, SpringLayout.SOUTH, this);
	}
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		this.addMouseListener(new MouseListener()
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
		this.addMouseMotionListener(new MouseMotionListener()
		{
			
			
			public void mouseMoved(MouseEvent moved)
			{
				firstButton.setText("Mouse X:" + moved.getX() + " Y: " + moved.getY());
				
				if((moved.getX() > 25 && moved.getX() < 40) && (moved.getY() > 50 && moved.getY() < 70))
				{
					changeRandomColor();
				}
			}
			
			public void mouseDragged(MouseEvent dragged)
			{
				firstTextField.setText("dragged!");
			}
			
		});
		
	}
	
	private void changeRandomColor()
	{
		int red, green, blue;
		
<<<<<<< HEAD
		red = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));	
=======
		this.addMouseMotionListener(new MouseMotionListener()
		{
			
			
			public void mouseMoved(MouseEvent moved)
			{
				firstButton.setText("Mouse X:" + moved.getX() + " Y: " + moved.getY());
				
				if((moved.getX() > 25 && moved.getX() < 40) && (moved.getY() > 50 && moved.getY() < 70))
				{
					changeRandomColor();
				}
			}
			
			public void mouseDragged(MouseEvent dragged)
			{
				firstTextField.setText("dragged!");
			}
			
		});
		
	}
	
	private void changeRandomColor()
	{
		int red, green, blue;
		
		red = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));
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
>>>>>>> origin/master
	}
}
