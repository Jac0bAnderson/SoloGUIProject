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
private JButton doubleClick;
private int clickValue;
private boolean doubleUsed;



	public PanelGUI(ControllerGUI baseController) 
	{
		this.baseController = baseController;
		
		doubleUsed = false;
		clickValue = 1;
		doubleClick = new JButton("Double Click:10C");//
	    firstButton = new JButton("click");//
		firstTextField = new JTextField("Likes:");//
		firstTextField.setBackground(Color.decode("#00e5b1"));//
		firstTextField.setEditable(false);//
		baseLayout = new SpringLayout();//
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		}

	private void setupPanel()
	{
		this.add(doubleClick);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.setBackground(Color.decode("#00ffc5"));
	}
	
	private void setupLayout()//trash bin of design tab junk
	{
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 94, SpringLayout.SOUTH, firstButton);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 21, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 0, SpringLayout.WEST, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 151, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, -133, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, doubleClick, 65, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, doubleClick, 10, SpringLayout.WEST, this);
		firstButton.setVerticalAlignment(SwingConstants.TOP);
		
		
	}
	
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()//"click" button
		{
			public void actionPerformed(ActionEvent click)
			{
			 likes = likes+clickValue;
				firstTextField.setText("likes: "+likes);
			}
		});
		
		doubleClick.addActionListener(new ActionListener()//double click button
		{
			public void actionPerformed(ActionEvent click)
			{
				
				if(likes >= 10 && doubleUsed == false )
				{
					clickValue =2;
					likes = likes-10;
					doubleUsed = true;
					firstTextField.setText("likes: "+likes);
					doubleClick.setBackground(Color.decode("#696868"));
				}
			}
		});
		
		
	}
	
	
	
	
	







}
