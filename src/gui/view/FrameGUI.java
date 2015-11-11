package gui.view;

import javax.swing.JFrame;
import gui.controller.ControllerGUI;

public class FrameGUI  extends JFrame
{
private PanelGUI basePanel;
private ControllerGUI  baseController;
	
	public FrameGUI(ControllerGUI baseController)
	{
		this.baseController = baseController;
		basePanel = new PanelGUI(baseController);
		setupFrame();
	}

	private void setupFrame() 
	{
		this.setContentPane(basePanel);
		this.setSize(400,400);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("You Up clik Like");
		
	}
	 public ControllerGUI getBaseController()
	 {
		 return baseController;
	 }
	
	
	
	
	
	
	
}
