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

private JButton doubleClick;
private int clickValue;
private boolean doubleUsed;
private int color1;
private int color2;
private int color3;
private JButton tripleClick;
private boolean tripleUsed;
private JTextField yourClickValue;



	public PanelGUI(ControllerGUI baseController) 
	{
		this.baseController = baseController;
		
		tripleUsed = false;
		doubleUsed = false;//
		clickValue = 1;//
		
		//RGB
		color1 = 0;
		color2 = 255;
		color3 = 197;
		
		yourClickValue = new JTextField("Click value: "+clickValue);
		yourClickValue.setEditable(false);
		tripleClick = new JButton("Triple Click:200C");//
		doubleClick = new JButton("Double Click:10C");//
	    firstButton = new JButton("click");//
		firstTextField = new JTextField("Likes:");//
		firstTextField.setBackground(Color.decode("#00e5b1"));//
		firstTextField.setEditable(false);//
		baseLayout = new SpringLayout();
		
		
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		}

	private void setupPanel()
	{
		this.add(yourClickValue);
		this.add(tripleClick);
		this.add(doubleClick);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.setBackground(new Color(color1,color2,color3));
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
		baseLayout.putConstraint(SpringLayout.NORTH, tripleClick, 6, SpringLayout.SOUTH, doubleClick);
		baseLayout.putConstraint(SpringLayout.WEST, tripleClick, 0, SpringLayout.WEST, doubleClick);
		baseLayout.putConstraint(SpringLayout.NORTH, yourClickValue, -3, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, yourClickValue, 6, SpringLayout.EAST, firstButton);
		
		
	}
	
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()//"click" button
		{
			public void actionPerformed(ActionEvent click)
			{
			 likes = likes+clickValue;
				firstTextField.setText("likes: "+likes);
				
				color1 = (int) (Math.random()*256);
				color2 = (int) (Math.random()*256);
				color3 = (int) (Math.random()*256);
				
				
			}
		});
		
		doubleClick.addActionListener(new ActionListener()//double click button
		{
			public void actionPerformed(ActionEvent click)
			{
				
				if(likes >= 10 && doubleUsed == false )
				{
					clickValue =clickValue + 1;
					likes = likes-10;
					doubleUsed = true;
					firstTextField.setText("likes: "+likes);
					doubleClick.setBackground(Color.decode("#696868"));
					doubleClick.setEnabled(false);
					yourClickValue.setText("Click Value: "+clickValue);
				}
			}
		});
		
		tripleClick.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(likes >= 200 && tripleUsed == false)
				{
					clickValue = clickValue +3;
					yourClickValue.setText("Click Value: "+clickValue);
					tripleUsed= true;
					likes= likes - 200;
					firstTextField.setText("Likes: "+likes);
					tripleClick.setBackground(Color.decode("#696868"));
					tripleClick.setEnabled(false);
				}
			}
		});
		
		
		
	}
	
	
	
	
	







}
