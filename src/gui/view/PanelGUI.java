package gui.view;

import gui.controller.ControllerGUI;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
//import java.awt.Toolkit;
//import java.util.concurrent.TimeUnit;

public class PanelGUI extends JPanel
{
private int likes;	
private ControllerGUI baseController;
private JButton clickerButton;
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
private JButton autoClick;
private boolean autoClickUsed;
private JTextField RGBcolor;
private JButton simpleMode;
private boolean simpleUsed;
private boolean simpleUsed2;






	public PanelGUI(ControllerGUI baseController) 
	{
		this.baseController = baseController;
		
		tripleUsed = false;
		doubleUsed = false;//
		clickValue = 1;//
		simpleUsed = false;//
		simpleUsed2 = false;//
		
		
		//RGB
		color1 = 0;
		color2 = 255;
		color3 = 197;
		
		simpleMode = new JButton("Simple");
		RGBcolor = new JTextField("R: " +color1+ " G: " +color2+ " B: " +color3);//
		RGBcolor.setOpaque(false);//
		autoClickUsed= false;//
		autoClick = new JButton("auto click:10000C");//
		yourClickValue = new JTextField("Click value: "+clickValue);//
		yourClickValue.setEditable(false);//
		yourClickValue.setOpaque(false);//
		tripleClick = new JButton("Triple Click:200C");//
		doubleClick = new JButton("Double Click:10C");//
	    clickerButton = new JButton("click");//
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
		this.add(simpleMode);
		this.add(RGBcolor);
		
		// ADD WHEN WORKING
		//this.add(autoClick);
		this.add(yourClickValue);
		this.add(tripleClick);
		this.add(doubleClick);
		this.setLayout(baseLayout);
		this.add(clickerButton);
		this.add(firstTextField);
		this.setBackground(new Color(color1,color2,color3));
	}
	
	private void setupLayout()//trash bin of design tab junk
	{
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 94, SpringLayout.SOUTH, clickerButton);
		baseLayout.putConstraint(SpringLayout.NORTH, clickerButton, 21, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, clickerButton, 0, SpringLayout.WEST, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 151, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, -133, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, doubleClick, 65, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, doubleClick, 10, SpringLayout.WEST, this);
		clickerButton.setVerticalAlignment(SwingConstants.TOP);
		baseLayout.putConstraint(SpringLayout.NORTH, yourClickValue, -3, SpringLayout.NORTH, clickerButton);
		baseLayout.putConstraint(SpringLayout.WEST, yourClickValue, 6, SpringLayout.EAST, clickerButton);
		baseLayout.putConstraint(SpringLayout.WEST, autoClick, 12, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, tripleClick, 6, SpringLayout.SOUTH, autoClick);
		baseLayout.putConstraint(SpringLayout.WEST, tripleClick, 0, SpringLayout.WEST, autoClick);
		baseLayout.putConstraint(SpringLayout.NORTH, autoClick, 6, SpringLayout.SOUTH, doubleClick);
		baseLayout.putConstraint(SpringLayout.NORTH, RGBcolor, 12, SpringLayout.SOUTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, RGBcolor, 0, SpringLayout.WEST, clickerButton);
		baseLayout.putConstraint(SpringLayout.NORTH, simpleMode, -1, SpringLayout.NORTH, yourClickValue);
		baseLayout.putConstraint(SpringLayout.WEST, simpleMode, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, RGBcolor, 111, SpringLayout.WEST, clickerButton);
		
		
	}
	
	private void setupListeners()
	{
		clickerButton.addActionListener(new ActionListener()//"click" button
		{
			public void actionPerformed(ActionEvent click)
			{
			 likes = likes+clickValue;
				firstTextField.setText("likes: "+likes);
				
				color1 = (int) (Math.random()*256);
				color2 = (int) (Math.random()*256);
				color3 = (int) (Math.random()*256);
				
				  setBackground(new Color(color1, color2, color3));
				  firstTextField.setBackground(new Color(color1, color2, color3));
				  RGBcolor.setText("R: " +color1+ " G: " +color2+ " B: " +color3);
				
				
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
		
		
		autoClick.addActionListener(new ActionListener()
				{
			      public void actionPerformed(ActionEvent click)
			      {
			    	  if(likes >= 10000 && autoClickUsed == false)
			    	  {
			    		  likes = likes - 50;
			    		  firstTextField.setText("likes: "+likes);
			    		  autoClick.setBackground(Color.decode("#696868"));
			    		  autoClick.setEnabled(false);
			    		  
			    		  while(true)
			    		  {
			    			  
			    		  }
			    	  }
			      }
			
				});
		
		tripleClick.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(likes >= 200 && tripleUsed == false)
				{
					clickValue = clickValue +2;
					yourClickValue.setText("Click Value: "+clickValue);
					tripleUsed= true;
					likes= likes - 200;
					firstTextField.setText("Likes: "+likes);
					tripleClick.setBackground(Color.decode("#696868"));
					tripleClick.setEnabled(false);
				}
			}
		});
		//The extra buttons wont come back....but should.
		simpleMode.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					if(simpleUsed == false)
					{
						doubleClick.setEnabled(false);
						doubleClick.setVisible(false);
						
						autoClick.setEnabled(false);
						autoClick.setVisible(false);
						
						tripleClick.setEnabled(false);
						tripleClick.setVisible(false);
						
						yourClickValue.setEnabled(false);
						yourClickValue.setVisible(false);
						
						RGBcolor.setEnabled(false);
						RGBcolor.setVisible(false);
						
						simpleMode.setEnabled(true);
						simpleMode.setText("");
						simpleMode.setOpaque(false);
						
						
						
						simpleUsed = true;
						
					}
					else
					{
						doubleClick.setEnabled(true);
						doubleClick.setVisible(true);
						
						autoClick.setEnabled(true);
						autoClick.setVisible(true);
						
						tripleClick.setEnabled(true);
						tripleClick.setVisible(true);
						
						yourClickValue.setEnabled(true);
						yourClickValue.setVisible(true);
						
						RGBcolor.setEnabled(true);
						RGBcolor.setVisible(true);
						
						simpleMode.setEnabled(true);
						simpleMode.setOpaque(true);
						simpleMode.setText("Simple");
						
						simpleUsed = false;
					}
					
				}
			});
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	







}
