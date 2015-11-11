package gui.view;

import gui.controller.ControllerGUI;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class PanelGUI extends JPanel
{
private int likes;	
private ControllerGUI baseController;
private JButton firstButton;
private JTextField firstTextField;
private SpringLayout baseLayout;
private ImageIcon likeicon;



	public PanelGUI(ControllerGUI baseController) 
	{
		this.baseController = baseController;
		
		firstButton = new JButton("Click");
		firstButton.setVerticalAlignment(SwingConstants.TOP);
		firstTextField = new JTextField("Likes:");
		firstTextField.setBackground(Color.decode("#00e5b1"));
		firstTextField.setEditable(false);
		baseLayout = new SpringLayout();
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.setBackground(Color.decode("#00ffc5"));
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 94, SpringLayout.SOUTH, firstButton);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 21, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 0, SpringLayout.WEST, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 151, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, -133, SpringLayout.EAST, this);
	}
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			 likes = likes+1;
				firstTextField.setText("likes: "+likes);
			}
		});
	}
	
	
	
	
	







}
