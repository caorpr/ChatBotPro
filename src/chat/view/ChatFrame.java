package chat.view;
import javax.swing.JFrame;
import chat.controller.ChatController;



public class ChatFrame extends JFrame
{
	
	private ChatController baseController;
	private ChatPanel basePanel;
	
	/**
	 * sets up the controller, panel, and frame.
	 * @param baseController
	 */
	public ChatFrame (ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setupFrame();
	}
	
	/**
	 * This tells the frame all of the properties it shold have.
	 */
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setTitle("GUI CHATBOT");
		this.setSize(400, 400);
		this.setVisible(true);
	}
	
	public ChatController getBaseController()
	{
		return baseController;
	}
}
