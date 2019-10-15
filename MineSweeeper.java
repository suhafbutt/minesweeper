import java.awt.geom.* ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class MineSweeeper implements ActionListener,MouseListener
{
	JFrame frame;
	Container c;
	int high=20,width=20;
	JButton[][] button=new JButton[10][10];
	JButton reset,exit;
	ImageIcon icon;
	ImageIcon obj1=new ImageIcon("Bomb.PNG");
	JLabel[][] label=new JLabel[10][10];
	JTextField field;
	JPanel panel;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem NewGame,Exit;
	int mines,dwn,upp,lft,chk=0;
	
	public MineSweeeper()
	{
		
	
		
	//**************FRAME SETTING*******************************************	
		FlowLayout obj=new FlowLayout();
		frame=new JFrame("MineSweeper");
		frame.setSize(469,580);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//**********************************CONTAINER SETTING*******************
		c=frame.getContentPane();
  	 	 c.setLayout(null);
 	  	 c.setBackground(Color.BLACK);
 	
 	//***********************************Menu**********************************************************
 		menubar=new JMenuBar();
 		menu=new JMenu("File");
 		NewGame=new JMenuItem("New Game");
 		NewGame.addActionListener(this);
 		Exit=new JMenuItem("Exit");
 		Exit.addActionListener(this);
 		menu.add(NewGame);
 		menu.add(Exit);
 		menubar.add(menu);
 		frame.setJMenuBar ( menubar ) ;
 	
 	//*********************************PANEL SETTING***********************	
 		panel=new JPanel();
 		panel.setBackground(Color.GRAY);
 		panel.setSize(459,64);
 		panel.setLocation(1,0);
 		panel.setLayout(null);
 		
 	
 	
	//*********************************BUTTON CREATION LOOP*********************
 	   int yaxis=65;
 	  	 int d=0;
 	  	  for(int a=0;a<10;a++)
 	  	  {
 	  	  	int xaxis=1;
 	  	  	
 	  	  	for(int b=0;b<10;b++)
 	  	  	{
 	  	  		button[a][b]=new JButton("");
 	  	  		button[a][b].setSize(45,45);
 	  	  		button[a][b].setLocation(xaxis,yaxis);
 	  	  		button[a][b].setBackground(Color.LIGHT_GRAY);
 	  	  		button[a][b].addActionListener(this);
 	  	  		button[a][b].addMouseListener(this);
 	  	  		c.add(button[a][b]);
 	  	  		xaxis+=button[a][b].getWidth()+1;
 	  	  	}
 	  	  	yaxis+=button[0][0].getHeight()+1;
 	  	  	
 	  	  }
 	  	  
 	  	  
 //***********************************GAME BUTTON***************************************
 	  	  reset=new JButton();
 	  	  icon=new ImageIcon("Smile.PNG");
 	  	  
 	  	  reset.setIcon(icon);
 	  	  reset.setBackground(Color.WHITE);
 	  	  reset.setSize(icon.getIconWidth(),icon.getIconHeight());
 	  	  reset.setLocation((frame.getWidth()/2)-(reset.getWidth()/2),0);
 	  	  reset.addActionListener(this);
 	  	  panel.add(reset);
 	  	  
 	  	  exit=new JButton("EXIT");
 	  	  exit.setSize(exit.getPreferredSize());
 	  	  exit.setLocation((reset.getX()/2)-(exit.getWidth()/2),20);
 	  	  exit.setBackground(Color.LIGHT_GRAY);
	  	  exit.addActionListener(this);
	  	  c.add(exit);
 	  	  
 	  	  
 //********************************TEXT FIELD*********************************
 		field=new JTextField("Game Started");
 		field.setFont(new Font("Times New Roman",Font.BOLD,14));
 		field.setSize(field.getPreferredSize());
 		field.setBackground(Color.BLACK);
 		field.setForeground(Color.WHITE);
 		field.setLocation(reset.getX()+100,(panel.getHeight()/2)-(field.getHeight()/2));
 		c.add(field);
 			
 	  	  
 //**************************************LABEL SETTING***********************************
 	 yaxis=65;
 	 for(int e=0;e<10;e++)
 	 {
 	 	 
 	 	 
 	 	int xaxis=1;
 	 	for(int f=0;f<10;f++)
 	 	{
 	 		
 	 		label[e][f]=new JLabel("",JLabel.CENTER);
 	 		label[e][f].setSize(45,45);
 	 		label[e][f].setLocation(xaxis,yaxis);
 	 		label[e][f].setBackground(Color.WHITE);
 	 		label[e][f].setForeground(Color.BLACK);
 	 		label[e][f].setOpaque(true);
 	 		c.add(label[e][f]);
 	 		xaxis+=label[e][f].getWidth()+1;
 	 	}
 	 	yaxis+=label[0][0].getHeight()+1;
 	 }
 	 	setup();
 	 
		c.add(panel);
		frame.setVisible(true);
	}//***************************END of CONSTRUCTER**********************************************
	
	
//**********************************ACTION PERFORMED METHOD**************************************
	
	public void actionPerformed(ActionEvent e)
	{ 
	//********************************************MENU BAR**************************************************************
		if(e.getSource().equals(NewGame))
		{
			chk=0;
			reset.setIcon(icon);
				
				for(int i=0;i<10;i++)
				{
					for(int j=0;j<10;j++)
					{
					
						button[i][j].setVisible(true);
						//button[i][j].setBackground(Color.GRAY);
						button[i][j].setEnabled(true);
						button[i][j].setBackground(Color.LIGHT_GRAY);
					}
				}
				field.setText("Game Started");
		}
		if(e.getSource().equals(Exit))
		{
			frame.setVisible(false);
			new Introduction();
		}
	
	//*****************************************Exit Button************************************************************
	
	
		if(e.getSource().equals(exit))
		{
			frame.setVisible(false);
			new Introduction();
		}
	//****************************************************reset button method**********************************************	
			if(e.getSource().equals(reset))
			{
				reset.setIcon(icon);
				chk=0;
				for(int i=0;i<10;i++)
				{
					for(int j=0;j<10;j++)
					{
					
						button[i][j].setVisible(true);
						//button[i][j].setBackground(Color.GRAY);
						button[i][j].setEnabled(true);
						button[i][j].setBackground(Color.LIGHT_GRAY);
						button[i][j].setText("");
					}
				}
				field.setText("Game Started");
			}
			
	//*********************************************************lose funtion*******************************************************	
		for(int u=0;u<10;u++)
		{
			for(int v=0;v<10;v++)
			{
				if(e.getSource().equals(button[u][v]))
				{
					button[u][v].setVisible(false);
					if(label[u][v].getText().equals("0"))
					{
						ImageIcon obj=new ImageIcon("Sad.PNG");
						reset.setIcon(obj);
						field.setText("lose");
						

						
						for(int m=0;m<10;m++)
						{
							for(int n=0;n<10;n++)
							{
								button[m][n].setEnabled(false);
								//button[m][n].setBackground(Color.LIGHT_GRAY);
								if(label[m][n].getText().equals("0"))
								{
									if(button[m][n].getText()!="x")
									{
										button[m][n].setVisible(false);
									}
									
									
								}
								
							}
						}
						chk++;
						lose();
					}
					else if(label[u][v].getText()=="")
					{
						check(u,v);
					}
					
				
				}
				
				
			}
		}
	//********************************************************winning funtion********************************************************
		int z=0,cross=0;
		for(int ex=0;ex<10;ex++)
		{
			for(int vx=0;vx<10;vx++)
			{
					if(button[ex][vx].isVisible()==false)
					{
						z++;
							
					}
				
			}
		}
		if(z==86)
		{
			z=0;
			field.setText("You Won");
			Win();
			chk++;
		}
		
	}
	//**********************************************************MOUSE Listenre***********************************
		public void mousePressed(MouseEvent e)
	 	{
        }

    	public void mouseReleased(MouseEvent e)
    	{
        }

   		public void mouseEntered(MouseEvent e)
    	{
    	}
        public void mouseExited(MouseEvent e) 
    	{
    	} 
        public void mouseClicked(MouseEvent e)
    	{
			if(e.getButton()==3&&chk==0)
			{
    		int cross=0;
    		for(int alpha=0;alpha<10;alpha++)
    		{
    			for(int beta=0;beta<10;beta++)
    			{
    				if(e.getSource().equals(button[alpha][beta]))
    				{
    					if(button[alpha][beta].getText().equals("x"))
    					{
    						button[alpha][beta].setText("");
    					}
    					else
    					{
    						button[alpha][beta].setText("x");
    						button[alpha][beta].setForeground(Color.BLACK);
    					}
    				}	
  
    					if(button[alpha][beta].getText().equals("x"))
						{
							if(label[alpha][beta].getText().equals("0"))
							{
								cross++;
								
							}
						}
						if(cross==14)
						{
							cross=0;
							field.setText("You Won");
							Win();
						}
    			}
    		}
			}
        }//*********************************************************End Mouse Listener******************************

   //*****************************************************Checking Empty************************
	public void check(int k,int l)
	{

		//*************Right side Check**********
						int p=l;
						while((p<9))
						{
							if(label[k][p+1].getText().equals("")&&label[k][p].getText().equals(""))
							{
								button[k][p+1].setVisible(false);
								check(k,p+1);
							}
							else if(label[k][p+1].getText()!="0"&&label[k][p].getText().equals(""))
							{
								button[k][p+1].setVisible(false);
							}
							else
							{
								
								break;
							}
							p++;
							
							
							
						}
						
		//***********Left Side Check**********
						
						int o=l;
						while((o>0))
						{	
							if(label[k][o-1].getText().equals("")&&label[k][o].getText().equals(""))
							{
								button[k][o-1].setVisible(false); 
							//	check(k,o-1);
							}
							else if(label[k][o-1].getText()!="0"&&label[k][o].getText().equals(""))
							{
								button[k][o-1].setVisible(false);
							}
							else
							{
								
								break;
							}
							o--;
						}
						
						
		//***********Down Side Check**********
						int q=k;
						while(q<9)
						{
							if(label[q+1][l].getText().equals("")&&label[q][l].getText().equals(""))
							{
								
								button[q+1][l].setVisible(false);
								check(q+1,l);
							}
							else if(label[q+1][l].getText()!="0"&&label[q][l].getText().equals(""))
							{
								button[q+1][l].setVisible(false);
							}
							else
							{
								break;
							}
							
							q++;
						}
						
		//****************Up Side Check***********
						int r=k;
						while(r>0)
						{
							if(label[r-1][l].getText().equals("")&&label[r][l].getText().equals(""))
							{
								button[r-1][l].setVisible(false);
								
								//check(r-1,l);
							}
							else if(label[r-1][l].getText()!="0"&&label[r][l].getText().equals(""))
							{
								button[r-1][l].setVisible(false);
							}
							else
							{
								break;
							}
						
							r--;
						}
	}

	public static void main (String[] args)
	{
		new MineSweeeper();
	}//end of main
	
	//*********************************SETUP*******************************************************
	public void setup()
	{
		//first line***************
		label[0][3].setText("1");
		label[0][4].setText("0");//*****bomb
		label[0][4].setHorizontalTextPosition(0);
		label[0][4].setVerticalTextPosition(0);
		label[0][4].setIcon(obj1);
		label[0][4].setOpaque(false);
		label[0][5].setText("2");
		label[0][6].setText("1");
		label[0][7].setText("1");
		label[0][8].setText("1");
		label[0][9].setText("0");//*****bomb
		label[0][9].setHorizontalTextPosition(0);
		label[0][9].setVerticalTextPosition(0);
		label[0][9].setIcon(obj1);
		label[0][9].setOpaque(false);
		
		//*****2nd Line************
		
		label[1][3].setText("1");
		label[1][4].setText("1");
		label[1][5].setText("2");
		label[1][6].setText("0");//***bomb
		label[1][6].setHorizontalTextPosition(0);
		label[1][6].setVerticalTextPosition(0);
		label[1][6].setIcon(obj1);
		label[1][6].setOpaque(false);
		label[1][7].setText("1");
		label[1][8].setText("1");
		label[1][9].setText("1");
		
		//********3rd Line*********
		
		label[2][1].setText("1");
		label[2][2].setText("1");
		label[2][3].setText("1");
		label[2][5].setText("1");
		label[2][6].setText("2");
		label[2][7].setText("3");
		label[2][8].setText("2");
		label[2][9].setText("1");
		
		//*******4rth Line************
		
		label[3][1].setText("1");
		label[3][2].setText("0");//*****bomb
		label[3][2].setHorizontalTextPosition(0);
		label[3][2].setVerticalTextPosition(0);
		label[3][2].setIcon(obj1);
		label[3][2].setOpaque(false);
		label[3][3].setText("1");
		label[3][6].setText("1");
		label[3][7].setText("0");//****bomb
		label[3][7].setHorizontalTextPosition(0);
		label[3][7].setVerticalTextPosition(0);
		label[3][7].setIcon(obj1);
		label[3][7].setOpaque(false);
		label[3][8].setText("0");//****bomb
		label[3][8].setIcon(obj1);
		label[3][8].setHorizontalTextPosition(0);
		label[3][8].setVerticalTextPosition(0);
		label[3][8].setOpaque(false);
		label[3][9].setText("1");
		
		//***************5th Line***********************
		
		label[4][1].setText("2");
		label[4][2].setText("2");
		label[4][3].setText("2");
		label[4][6].setText("1");
		label[4][7].setText("2");
		label[4][8].setText("2");
		label[4][9].setText("1");
		
		//**************6th Line************************
		
		label[5][0].setText("1");
		label[5][1].setText("2");
		label[5][2].setText("0");//****bomb
		label[5][2].setHorizontalTextPosition(0);
		label[5][2].setVerticalTextPosition(0);
		label[5][2].setIcon(obj1);
		label[5][2].setOpaque(false);
		label[5][3].setText("1");
		label[5][7].setText("1");
		label[5][8].setText("2");
		label[5][9].setText("2");
		
		//******************7th Line************************
		
		label[6][0].setText("0");//*****bomb
		label[6][0].setHorizontalTextPosition(0);
		label[6][0].setVerticalTextPosition(0);
		label[6][0].setIcon(obj1);
		label[6][0].setOpaque(false);
		label[6][1].setText("2");
		label[6][2].setText("1");
		label[6][3].setText("1");
		label[6][5].setText("1");
		label[6][6].setText("2");
		label[6][7].setText("3");
		label[6][8].setText("0");//*****bomb
		label[6][8].setHorizontalTextPosition(0);
		label[6][8].setVerticalTextPosition(0);
		label[6][8].setIcon(obj1);
		label[6][8].setOpaque(false);
		label[6][9].setText("0");//*****bomb
		label[6][9].setHorizontalTextPosition(0);
		label[6][9].setVerticalTextPosition(0);
		label[6][9].setIcon(obj1);
		label[6][9].setOpaque(false);
		
		//**********************8th Line******************
		
		label[7][0].setText("1");
		label[7][1].setText("1");
		label[7][5].setText("1");
		label[7][6].setText("0");//****bomb
		label[7][6].setHorizontalTextPosition(0);
		label[7][6].setVerticalTextPosition(0);
		label[7][6].setIcon(obj1);
		label[7][6].setOpaque(false);
		label[7][7].setText("0");//****bomb
		label[7][7].setHorizontalTextPosition(0);
		label[7][7].setVerticalTextPosition(0);
		label[7][7].setIcon(obj1);
		label[7][7].setOpaque(false);
		label[7][8].setText("3");
		label[7][9].setText("2");
		
		//***************************9th Line************************
		
		label[8][0].setText("1");
		label[8][1].setText("1");
		label[8][2].setText("2");
		label[8][3].setText("1");
		label[8][4].setText("1");
		label[8][5].setText("1");
		label[8][6].setText("2");
		label[8][7].setText("2");
		label[8][8].setText("1");
		
		//*******************************10th Line***********************
		
		label[9][0].setText("1");
		label[9][1].setText("0");//****bomb
		label[9][1].setHorizontalTextPosition(0);
		label[9][1].setVerticalTextPosition(0);
		label[9][1].setIcon(obj1);
		label[9][1].setOpaque(false);
		label[9][2].setText("2");
		label[9][3].setText("0");//*****bomb
		label[9][3].setHorizontalTextPosition(0);
		label[9][3].setVerticalTextPosition(0);
		label[9][3].setIcon(obj1);
		label[9][3].setOpaque(false);
		label[9][4].setText("1");
	}
	//*********************************************************Lose View**************************************************
	public void lose()
	{
		for(int ae=0;ae<10;ae++)
		{
			for(int be=0;be<10;be++)
			{
				button[ae][be].setEnabled(false);
				button[ae][be].setVisible(true);
				button[ae][be].setBackground(Color.BLACK);
				button[ae][be].setText("");
			}
		}
		//*************L***************
		button[0][2].setBackground(Color.WHITE);
		button[1][2].setBackground(Color.WHITE);
		button[2][2].setBackground(Color.WHITE);
		button[3][2].setBackground(Color.WHITE);
		button[3][3].setBackground(Color.WHITE);
		button[3][4].setBackground(Color.WHITE);
		
		//******************O***************
		button[0][6].setBackground(Color.WHITE);
		button[1][6].setBackground(Color.WHITE);
		button[2][6].setBackground(Color.WHITE);
		button[3][6].setBackground(Color.WHITE);
		button[0][8].setBackground(Color.WHITE);
		button[1][8].setBackground(Color.WHITE);
		button[2][8].setBackground(Color.WHITE);
		button[3][8].setBackground(Color.WHITE);
		button[0][7].setBackground(Color.WHITE);
		button[3][7].setBackground(Color.WHITE);
		
		//*************S**********************
		button[5][2].setBackground(Color.WHITE);
		button[5][3].setBackground(Color.WHITE);
		button[5][4].setBackground(Color.WHITE);
		button[6][2].setBackground(Color.WHITE);
		button[7][2].setBackground(Color.WHITE);
		button[7][3].setBackground(Color.WHITE);
		button[7][4].setBackground(Color.WHITE);
		button[8][4].setBackground(Color.WHITE);
		button[9][4].setBackground(Color.WHITE);
		button[9][3].setBackground(Color.WHITE);
		button[9][2].setBackground(Color.WHITE);
		
		//******************E****************
		//button[5][5].setBackground(Color.BLACK);
		button[5][6].setBackground(Color.WHITE);
		button[5][7].setBackground(Color.WHITE);
		button[5][8].setBackground(Color.WHITE);
		button[6][6].setBackground(Color.WHITE);
		button[7][6].setBackground(Color.WHITE);
		button[8][6].setBackground(Color.WHITE);
		button[9][6].setBackground(Color.WHITE);
		button[7][8].setBackground(Color.WHITE);
		button[7][7].setBackground(Color.WHITE);
		button[9][7].setBackground(Color.WHITE);
		button[9][8].setBackground(Color.WHITE);
		
	}
	//*********************************************Win View********************************************
	public void Win()
	{
		for(int ae=0;ae<10;ae++)
		{
			for(int be=0;be<10;be++)
			{
				button[ae][be].setEnabled(false);
				button[ae][be].setVisible(true);
				button[ae][be].setBackground(Color.BLACK);
				button[ae][be].setText("");
			}
		}
		//***********W***************
		button[0][2].setBackground(Color.WHITE);
		button[1][2].setBackground(Color.WHITE);
		button[2][2].setBackground(Color.WHITE);
		button[2][4].setBackground(Color.WHITE);
		button[3][3].setBackground(Color.WHITE);
		button[1][4].setBackground(Color.WHITE);
		button[3][5].setBackground(Color.WHITE);
		button[2][6].setBackground(Color.WHITE);
		button[1][6].setBackground(Color.WHITE);
		button[0][6].setBackground(Color.WHITE);
		
		//********I*****************
		button[5][1].setBackground(Color.WHITE);
		button[5][2].setBackground(Color.WHITE);
		button[5][3].setBackground(Color.WHITE);
		button[6][2].setBackground(Color.WHITE);
		button[7][2].setBackground(Color.WHITE);
		button[8][2].setBackground(Color.WHITE);
		button[8][1].setBackground(Color.WHITE);
		button[8][3].setBackground(Color.WHITE);
		
		//******N*****
		button[5][5].setBackground(Color.WHITE);
		button[6][5].setBackground(Color.WHITE);
		button[7][5].setBackground(Color.WHITE);
		button[8][5].setBackground(Color.WHITE);
		button[6][6].setBackground(Color.WHITE);
		button[7][7].setBackground(Color.WHITE);
		button[8][8].setBackground(Color.WHITE);
		button[7][8].setBackground(Color.WHITE);
		button[6][8].setBackground(Color.WHITE);
		button[5][8].setBackground(Color.WHITE);
		
	}
	
}