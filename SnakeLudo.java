import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class SnakeLudo implements ActionListener
{
	JFrame frame;
	JLabel[][] label=new JLabel[10][10];
	Container c;
	JPanel panel;
	JMenu menu;
	JTextArea text,diceresult,Win;
	JMenuBar menubar;
	JMenuItem newgame,exit,Start;
	JCheckBoxMenuItem submenu;
	JButton game,start,Exit,dice;
	JLabel diff,Options,player,Dice,finald;
	JRadioButton easy,medium,hard;
	int count=0;
	public SnakeLudo()
	{
	//******************************FRAME****************************************************************
		frame=new JFrame();
		frame.setSize(1150,900);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		c = frame.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.BLACK);
	//************************************Panel******************************************************
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		panel.setSize(200,frame.getHeight());
		c.add(panel);
	//************************************Menu bar*******************************************************
		menu=new JMenu("File");
		menubar=new JMenuBar();
		newgame =new JMenuItem("New Game");
		newgame.addActionListener(this);
		exit =new JMenuItem("Exit");
		exit.addActionListener(this);
		Start=new JMenuItem("Start");
  	
		
		menu.add(newgame);
		menu.add(Start);
 		menu.add(exit);
 		menubar.add(menu);
		frame.setJMenuBar(menubar);
		

	
	
	//*****************************************Labels****************************************************	
		int y=1;
		
 	 	for(int e=0;e<10;e++)
 	 	{
 	 	 
 	 	 	int width=(frame.getWidth()-200)/10;
 	 	 	int high=frame.getHeight()/10;
 	 		int x=201;
 	 		
 	 		for(int f=0;f<10;f++)
 	 		{
 	 			
 	 		
 	 			label[e][f]=new JLabel("",JLabel.CENTER);
 	 			label[e][f].setSize(width-2,high-6);
 	 			label[e][f].setLocation(x,y);
 	 			label[e][f].setBackground(Color.BLACK);
 	 			label[e][f].setForeground(Color.WHITE);
 	 			label[e][f].setOpaque(true);
 	 			c.add(label[e][f]);
 	 			label[e][f].setVisible(false);
 	 			x+=label[e][f].getWidth()+1;
 	 			
 	 		}
 	 		y+=label[0][0].getHeight()+1;
 	 	}
 	 	numbering();
 	 	
 	 	Options =new JLabel("Options");
 	 	Options.setFont(new Font("Times New Roman",Font.BOLD,25));
 	 	Options.setSize(Options.getPreferredSize());
 	 	Options.setLocation(15,panel.getHeight()/2);
 	 	Options.setOpaque(true);
 	 	Options.setBackground(Color.GRAY);
 	 	Options.setForeground(Color.BLACK);
 	 	panel.add(Options);
 	 	
 	 
		
		player=new JLabel("Player");
		player.setFont(new Font("Times New Roman",Font.BOLD,25));
 	 	player.setSize(player.getPreferredSize());
 	 	player.setLocation(panel.getX()+20,panel.getY()+60);
 	 	player.setOpaque(true);
 	 	player.setBackground(Color.GRAY);
 	 	player.setForeground(Color.BLACK);
 	 	panel.add(player);
		
		Dice=new JLabel("Dice Result");
		Dice.setFont(new Font("Times New Roman",Font.BOLD,25));
 	 	Dice.setLocation(panel.getX()+20,player.getY()+65);
 	 	Dice.setSize(Dice.getPreferredSize());
 	 	Dice.setOpaque(true);
 	 	Dice.setBackground(Color.GRAY);
 	 	Dice.setForeground(Color.BLACK);
 	 	panel.add(Dice);
 	 	
 	 	finald=new JLabel("Decions");
 	 	finald.setFont(new Font("Times New Roman",Font.BOLD,25));
 	 	finald.setSize(finald.getPreferredSize());
 	 	finald.setLocation(Dice.getX(),Dice.getY()+Dice.getHeight()+100);
 	 	finald.setOpaque(true);
 	 	finald.setBackground(Color.GRAY);
 	 	finald.setForeground(Color.BLACK);
 	 	panel.add(finald);
		
	
	//*****************************************TextArea**************************************************
	
		text=new JTextArea("Waiting");
		text.setFont(new Font("Times New Roman",Font.BOLD,20));
		text.setSize(panel.getWidth()-15,25);
		text.setLocation(player.getX()+20,player.getY()+player.getHeight()+10);
		text.setBackground(Color.GRAY);
		text.setForeground(Color.WHITE);
		text.setEditable(false);
		panel.add(text);
		
		diceresult=new JTextArea("0");
		diceresult.setFont(new Font("Times New Roman",Font.BOLD,35));
		diceresult.setSize(diceresult.getPreferredSize());
		diceresult.setLocation(Dice.getX()+20,Dice.getY()+Dice.getHeight()+10);
		diceresult.setBackground(Color.GRAY);
		diceresult.setForeground(Color.WHITE);
		diceresult.setEditable(false);
		panel.add(diceresult);	
			
		Win=new JTextArea("Waiting");
		Win.setFont(new Font("Times New Roman",Font.BOLD,20));
		Win.setSize(Win.getPreferredSize());
		Win.setLocation(finald.getX()+20,finald.getY()+finald.getHeight()+10);
		Win.setBackground(Color.GRAY);
		Win.setForeground(Color.WHITE);
		Win.setEditable(false);
		panel.add(Win);	
		

		
/*	//***************************************Radio Buttons****************************************************
		easy=new JRadioButton("Easy");
		easy.setSize(easy.getPreferredSize());
		easy.setBackground(Color.BLACK);
		easy.setForeground(Color.WHITE);
		easy.setLocation(diff.getX()+10,diff.getY()+diff.getWidth()-65);
		panel.add(easy);
		
		medium=new JRadioButton("Medium");
		medium.setSize(medium.getPreferredSize());
		medium.setBackground(Color.black);
		medium.setForeground(Color.WHITE);
		medium.setLocation(easy.getX(),easy.getY()+easy.getWidth()-25);
		panel.add(medium);
		
		hard=new JRadioButton("Hard");
		hard.setSize(hard.getPreferredSize());
		hard.setBackground(Color.black);
		hard.setForeground(Color.WHITE);
		hard.setLocation(medium.getX(),medium.getY()+medium.getWidth()-43);
		panel.add(hard);
	*/
	//********************************************Buttons******************************************************
		
		game=new JButton("New Game");
		game.setSize(game.getPreferredSize());
		game.setBackground(Color.BLACK);
		game.setForeground(Color.WHITE);
		game.addActionListener(this);
		game.setLocation(Options.getX()+10,Options.getY()+Options.getHeight()+15);
		panel.add(game);
		
		start=new JButton("Start");
		start.setSize(start.getPreferredSize());
		start.setBackground(Color.BLACK);
		start.setForeground(Color.WHITE);
		start.setLocation(game.getX(),game.getY()+game.getHeight()+15);
		start.addActionListener(this);
		panel.add(start);
		
		dice=new JButton("Dice");
		dice.setSize(dice.getPreferredSize());
		dice.setBackground(Color.BLACK);
		dice.setForeground(Color.WHITE);
		dice.setLocation(start.getX(),start.getY()+start.getHeight()+15);
		dice.addActionListener(this);
		panel.add(dice);
		
		Exit=new JButton("Exit");
		Exit.setSize(Exit.getPreferredSize());
		Exit.setBackground(Color.BLACK);
		Exit.setForeground(Color.WHITE);
		Exit.setLocation(dice.getX(),dice.getY()+dice.getHeight()+15);
		Exit.addActionListener(this);
		panel.add(Exit);

		dice.setEnabled(false);
		start.setEnabled(false);
		Start.setEnabled(false);
		frame.setVisible(true);
	}//*************************End of Construster***********************************
	public static void main (String[] args) 
	{
		new SnakeLudo();
	}//**************************End of Main******************************************
//**********************Action Listener Method*******************************
	public void actionPerformed(ActionEvent ex)
	{
		if(ex.getSource().equals(game))
		{
			for(int m=0;m<10;m++)
			{
				for(int n=0;n<10;n++)
				{
					label[m][n].setVisible(true);
				}
			}
			c.setBackground(Color.WHITE);
			numbering();
			diceresult.setText("0");
			count=0;
			dice.setEnabled(false);
			start.setEnabled(true);
			Start.setEnabled(true);
			String name=JOptionPane.showInputDialog(null,"Enter Player Name");
			text.setText(name);
			Win.setText("");
		}
		if(ex.getSource().equals(newgame))
		{
			for(int m=0;m<10;m++)
			{
				for(int n=0;n<10;n++)
				{
					label[m][n].setVisible(true);
				}
			}
			c.setBackground(Color.WHITE);
			numbering();
			diceresult.setText("0");
			count=0;
			dice.setEnabled(false);
			start.setEnabled(true);
			Start.setEnabled(true);
			String name=JOptionPane.showInputDialog(null,"Enter Player Name");
			text.setText(name);
			Win.setText("");
		}
		if(ex.getSource().equals(exit))
		{
			frame.setVisible(false);
			new Introduction();
			
		}
		if(ex.getSource().equals(dice))
		{
			play();
		}
		if(ex.getSource().equals(start))
		{
			dice.setEnabled(true);
			start.setEnabled(false);
		}
		if(ex.getSource().equals(Start))
		{
			dice.setEnabled(true);
			start.setEnabled(false);
		}
		if(ex.getSource().equals(Exit))
		{
			JOptionPane.showMessageDialog(null,"Are you Sure?");
		 	frame.setVisible(false);
			new Introduction();
		
		}
	}
//*************************************************Play***************************************************
	public void play()
	{
		int count1=0;
		int random=(int )((Math.random()*6)+1);
		diceresult.setText(Integer.toString(random));
		diceresult.setFont(new Font("Times New Roman",Font.BOLD,35));
		if(random==6&&count==0)
		{
			label[9][0].setText("Player 1");
			count++;
		}
		else if(count!=0)
		{
			for(int g=0;g<10;g++)
			{
				for(int h=0;h<10;h++)
				{
					if(label[g][h].getText().equals("Player 1"))
					{
						if((g==9||g==7||g==5||g==3||g==1)&&(h==9))
						{
								String num6=label[g][h-1].getText();
								int num7=Integer.parseInt(num6);
								num7+=1;
								int num8=num7+random;
									label[g][h].setText(Integer.toString(num7));
									label[g][h].setFont(new Font("Times New Roman",Font.BOLD,25));
									
									for(int i=0;i<10;i++)
									{
										for(int j=0;j<10;j++)
										{
										
											if(label[i][j].getText().equals(Integer.toString(num8)))
											{
												label[i][j].setText("Player 1");
												label[i][j].setFont(new Font("Times New Roman",Font.BOLD,25));
												Snakefound();
												Ladder();
											}
										}
									
									}
								
						}
						else if((g==0||g==2||g==4||g==6||g==8)&&(h==0))
						{
								String num6=label[g][h+1].getText();
								int num7=Integer.parseInt(num6);
								num7+=1;
								int num8=num7+random;
								
								if(num8<=100)
								{
									label[g][h].setText(Integer.toString(num7));
									label[g][h].setFont(new Font("Times New Roman",Font.BOLD,25));
							
									for(int i=0;i<10;i++)
									{
										for(int j=0;j<10;j++)
										{
										
											if(label[i][j].getText().equals(Integer.toString(num8)))
											{
												label[i][j].setText("Player 1");
												label[i][j].setFont(new Font("Times New Roman",Font.BOLD,25));
												Snakefound();
												Ladder();
												break;
											}
										}
								
									}
								}
								if(num8==100)
								{
									Win.setText("Win");
									Win.setFont(new Font("Times New Roman",Font.BOLD,35));
									Win.setSize(Win.getPreferredSize());
									dice.setEnabled(false);
								}
						}
						else
						{
							if(g==0||g==2||g==4||g==6||g==8)
							{
								String num6=label[g][h-1].getText();
								int num7=Integer.parseInt(num6);
								num7-=1;
								
								int num8=num7+random;
								System.out.println(num8);
								if(num8<=100)
								{
									label[g][h].setText(Integer.toString(num7));
									label[g][h].setFont(new Font("Times New Roman",Font.BOLD,25));
									for(int i=0;i<10;i++)
									{
										for(int j=0;j<10;j++)
										{
										
											if(label[i][j].getText().equals(Integer.toString(num8)))
											{
												label[i][j].setText("Player 1");
												label[i][j].setFont(new Font("Times New Roman",Font.BOLD,25));
												Snakefound();
												Ladder();
												break;
											}
										}
								
									}
								}
								if(num8==100)
								{
									Win.setText("Win");
									Win.setFont(new Font("Times New Roman",Font.BOLD,20));
									Win.setSize(Win.getPreferredSize());
									dice.setEnabled(false);
								}
							}
							else if((g==9||g==7||g==5||g==3||g==1)&&count1==0)
							{
								count1++;
								String num6=label[g][h+1].getText();
								int num7=Integer.parseInt(num6);
								num7-=1;
								label[g][h].setText(Integer.toString(num7));
								label[g][h].setFont(new Font("Times New Roman",Font.BOLD,25));
								num7+=random;
							
								for(int i=0;i<10;i++)
								{
									for(int j=0;j<10;j++)
									{
										
										if(label[i][j].getText().equals(Integer.toString(num7)))
										{
											label[i][j].setText("Player 1");
											label[i][j].setFont(new Font("Times New Roman",Font.BOLD,25));
											Snakefound();
											Ladder();
										}
									}
								
								}
							}
						}
						
					}
				}
			
			}
		}


	}
//*********************************************************Numbring*************************************
	public void numbering()
	{
		int numbering=1;
		for(int f=0;f<10;f++)
		{	
			String num=Integer.toString(numbering);
			label[9][f].setText(num);
			label[9][f].setFont(new Font("Times New Roman",Font.BOLD,25));
			numbering++;
		}
		
		numbering=11;
		for(int d=10;d>0;d--)
		{
			String num=Integer.toString(numbering);
			label[8][d-1].setText(num);
			label[8][d-1].setFont(new Font("Times New Roman",Font.BOLD,25));
			numbering++;
		}
		
		numbering=21;
		for(int d=0;d<10;d++)
		{
			String num=Integer.toString(numbering);
			label[7][d].setText(num);
			label[7][d].setFont(new Font("Times New Roman",Font.BOLD,25));
			numbering++;
		}
		
		numbering=31;
		for(int d=10;d>0;d--)
		{
			String num=Integer.toString(numbering);
			label[6][d-1].setText(num);
			label[6][d-1].setFont(new Font("Times New Roman",Font.BOLD,25));
			numbering++;
		}
		
		numbering=41;
		for(int d=0;d<10;d++)
		{
			
			String num=Integer.toString(numbering);
			label[5][d].setText(num);
			label[5][d].setFont(new Font("Times New Roman",Font.BOLD,25));
			numbering++;
		}
		
		numbering=51;
		for(int d=10;d>0;d--)
		{
			
			String num=Integer.toString(numbering);
			label[4][d-1].setText(num);
			label[4][d-1].setFont(new Font("Times New Roman",Font.BOLD,25));
			numbering++;
		}
		
		numbering=61;
		for(int d=0;d<10;d++)
		{
			
			String num=Integer.toString(numbering);
			label[3][d].setText(num);
			label[3][d].setFont(new Font("Times New Roman",Font.BOLD,25));
			numbering++;
		}
		
		numbering=71;
		for(int d=10;d>0;d--)
		{
			
			String num=Integer.toString(numbering);
			label[2][d-1].setText(num);
			label[2][d-1].setFont(new Font("Times New Roman",Font.BOLD,25));
			numbering++;
		}
		
		numbering=81;
		for(int d=0;d<10;d++)
		{
			
			String num=Integer.toString(numbering);
			label[1][d].setText(num);
			label[1][d].setFont(new Font("Times New Roman",Font.BOLD,25));
			numbering++;
		}
		
		numbering=91;
		for(int d=10;d>0;d--)
		{
			
			String num=Integer.toString(numbering);
			label[0][d-1].setText(num);
			label[0][d-1].setFont(new Font("Times New Roman",Font.BOLD,25));
			numbering++;
		}
		ImageIcon cl=new ImageIcon("L.PNG");
		ImageIcon le=new ImageIcon("Lend.PNG");
		ImageIcon ls=new ImageIcon("Lstart.PNG");
		label[1][3].setIcon(cl);
		label[1][3].setVerticalTextPosition(0);
		label[1][3].setHorizontalTextPosition(0);
		
		label[0][3].setIcon(ls);
		label[0][3].setVerticalTextPosition(0);
		label[0][3].setHorizontalTextPosition(0);
		
		label[2][3].setIcon(cl);
		label[2][3].setVerticalTextPosition(0);
		label[2][3].setHorizontalTextPosition(0);
		
		label[3][3].setIcon(le);
		label[3][3].setVerticalTextPosition(0);
		label[3][3].setHorizontalTextPosition(0);
		
		label[2][9].setIcon(ls);
		label[2][9].setVerticalTextPosition(0);
		label[2][9].setHorizontalTextPosition(0);
		
		label[3][9].setIcon(cl);
		label[3][9].setVerticalTextPosition(0);
		label[3][9].setHorizontalTextPosition(0);
		
		label[4][9].setIcon(cl);
		label[4][9].setVerticalTextPosition(0);
		label[4][9].setHorizontalTextPosition(0);
		
		label[5][9].setIcon(cl);
		label[5][9].setVerticalTextPosition(0);
		label[5][9].setHorizontalTextPosition(0);
		
		label[6][9].setIcon(le);
		label[6][9].setVerticalTextPosition(0);
		label[6][9].setHorizontalTextPosition(0);
		
		label[4][6].setIcon(ls);
		label[4][6].setVerticalTextPosition(0);
		label[4][6].setHorizontalTextPosition(0);
		
		label[5][6].setIcon(cl);
		label[5][6].setVerticalTextPosition(0);
		label[5][6].setHorizontalTextPosition(0);
		
		label[6][6].setIcon(cl);
		label[6][6].setVerticalTextPosition(0);
		label[6][6].setHorizontalTextPosition(0);
		
		label[7][6].setIcon(cl);
		label[7][6].setVerticalTextPosition(0);
		label[7][6].setHorizontalTextPosition(0);
		
		label[8][6].setIcon(le);
		label[8][6].setVerticalTextPosition(0);
		label[8][6].setHorizontalTextPosition(0);
		
		label[2][0].setIcon(ls);
		label[2][0].setVerticalTextPosition(0);
		label[2][0].setHorizontalTextPosition(0);
		
		label[3][0].setIcon(cl);
		label[3][0].setVerticalTextPosition(0);
		label[3][0].setHorizontalTextPosition(0);
		
		label[4][0].setIcon(cl);
		label[4][0].setVerticalTextPosition(0);
		label[4][0].setHorizontalTextPosition(0);
	
		label[5][0].setIcon(cl);
		label[5][0].setVerticalTextPosition(0);
		label[5][0].setHorizontalTextPosition(0);
		
		label[6][0].setIcon(cl);
		label[6][0].setVerticalTextPosition(0);
		label[6][0].setHorizontalTextPosition(0);
		
		label[7][0].setIcon(le);
		label[7][0].setVerticalTextPosition(0);
		label[7][0].setHorizontalTextPosition(0);
		
		label[7][3].setIcon(ls);
		label[7][3].setVerticalTextPosition(0);
		label[7][3].setHorizontalTextPosition(0);
		
		label[8][3].setIcon(cl);
		label[8][3].setVerticalTextPosition(0);
		label[8][3].setHorizontalTextPosition(0);
		
		label[9][3].setIcon(le);
		label[9][3].setVerticalTextPosition(0);
		label[9][3].setHorizontalTextPosition(0);
	}
//**********************************************************Snake found method***************************************
	public void Snakefound()
	{
		for(int k=0;k<10;k++)
		{
			for(int l=0;l<10;l++)
			{
				try
				{
				if(label[k][l].getText().equals("Player 1"))
				{
					if(label[k][l+1].getText().equals("98"))
					{
						int num9=Integer.parseInt(label[k][l+1].getText());
						num9+=1;
						label[k][l].setText(Integer.toString(num9));
						label[3][1].setText("Player 1");
						Win.setText("Snake :(");
						Win.setSize(Win.getPreferredSize());
					}
					if(label[k][l+1].getText().equals("87"))
					{
						int num9=Integer.parseInt(label[k][l+1].getText());
						num9-=1;
						label[k][l].setText(Integer.toString(num9));
						label[4][5].setText("Player 1");
						Win.setText("Snake:(");
					}
					if(label[k][l-1].getText().equals("77"))
					{
						int num9=Integer.parseInt(label[k][l-1].getText());
						num9-=1;
						label[k][l].setText(Integer.toString(num9));
						label[5][4].setText("Player 1");
						Win.setText("Snake:(");
					}
					if(label[k][l+1].getText().equals("68"))
					{
						int num9=Integer.parseInt(label[k][l+1].getText());
						num9-=1;
						label[k][l].setText(Integer.toString(num9));
						label[7][6].setText("Player 1");
						Win.setText("Snake:(");
					}
					if(label[k][l+1].getText().equals("44"))
					{
						int num9=Integer.parseInt(label[k][l+1].getText());
						num9-=1;
						label[k][l].setText(Integer.toString(num9));
						label[8][2].setText("Player 1");
						Win.setText("Snake:(");
					}
					if(label[k][l+1].getText().equals("32"))
					{
						int num9=Integer.parseInt(label[k][l+1].getText());
						num9+=1;
						label[k][l].setText(Integer.toString(num9));
						label[9][7].setText("Player 1");
						Win.setText("Snake:(");
					}
				}
				}
				catch(Exception e)
				{
				}
			}
		}
	}
//*********************************************Ladders************************************************************
	public void Ladder()
	{
			for(int k=0;k<10;k++)
		{
			for(int l=0;l<10;l++)
			{
				try
				{
				if(label[k][l].getText().equals("Player 1"))
				{
					if(label[k][l+1].getText().equals("65"))
					{
						int num9=Integer.parseInt(label[k][l+1].getText());
						num9-=1;
						label[k][l].setText(Integer.toString(num9));
						label[0][3].setText("Player 1");
						Win.setText("Ahaaa!!!");
						Win.setSize(Win.getPreferredSize());
					}
					if(label[k][l-1].getText().equals("32"))
					{
						int num9=Integer.parseInt(label[k][l-1].getText());
						num9-=1;
						label[k][l].setText(Integer.toString(num9));
						label[2][9].setText("Player 1");
						Win.setText("Ahaaa!!!");
					}
					if(label[k][l+1].getText().equals("22"))
					{
						int num9=Integer.parseInt(label[k][l+1].getText());
						num9-=1;
						label[k][l].setText(Integer.toString(num9));
						label[2][0].setText("Player 1");
						Win.setText("Ahaaa!!!");
					}
					if(label[k][l+1].getText().equals("5"))
					{
						int num9=Integer.parseInt(label[k][l+1].getText());
						num9-=1;
						label[k][l].setText(Integer.toString(num9));
						label[7][3].setText("Player 1");
						Win.setText("Ahaaa!!!");
					}
					if(label[k][l+1].getText().equals("13"))
					{
						int num9=Integer.parseInt(label[k][l+1].getText());
						num9+=1;
						label[k][l].setText(Integer.toString(num9));
						label[4][6].setText("Player 1");
						Win.setText("Ahaaa!!!");
					}
				}
				}
				catch(Exception e)
				{
				}
			}
		}
	}	
	
}//***********************End of Class*************************************************