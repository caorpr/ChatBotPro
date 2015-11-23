package chat.view;
import javax.swing.JFrame;
import chat.controller.ChatController;



public class ChatFrame extends JFrame
{
	
	private CahtController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame (ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setTitle("GUI CHATBOT");
		this.setSize(400, 400);
		this.setVisible(true);
	}
}
