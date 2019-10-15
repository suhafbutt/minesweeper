import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.AbstractButton;
import javax.swing.event.*;

public class Introduction implements ActionListener,ChangeListener
{
	JFrame frame;
	JButton b,b1,b2,b3;
	JLabel label;
	JTextArea field,f,f1,f2;
	Container c;
	ImageIcon icon;
	int x=25,y=20;
	public Introduction()
	{
		//*************************************FRAME*************************************
		FlowLayout obj=new FlowLayout();
		frame=new JFrame("Project");
		frame.setSize(1000,600);
		frame.setLayout(null);
		frame.setResizable(false);
		c = frame.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.GRAY);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//********************************Label*******************************************
		
		
		
		
		f=new JTextArea("INTRODUCTION TO US");
		
		
		f.setFont(new Font("Times New Roman",Font.BOLD, 24));
		f.setBackground(Color.GRAY);
		f.setForeground(Color.WHITE);
		f.setEditable(false);
		f.setSize(f.getPreferredSize());
		f.setLocation((frame.getWidth()/2)-(f.getWidth()/2),5);
		c.add(f);
	
		
		icon=new ImageIcon("intro1.PNG");
		label=new JLabel();
		label.setLayout(null);
 		//label.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(10,Color.BLUE,Color.RED)));
 		label.setSize(icon.getIconWidth(),icon.getIconHeight());
 		label.setLocation(20,f.getY()+f.getHeight()+10);
 		label.setIcon(icon);
 		c.add(label);
		
		
		
		
		
		f2=new JTextArea("Group Members");
		f2.setFont(new Font("Times New Roman",Font.BOLD, 24));
		f2.setSize(f2.getPreferredSize());
		f2.setLocation(icon.getIconWidth()+60,55);
		f2.setBackground(Color.GRAY);
		f2.setForeground(Color.WHITE);
		f2.setEditable(false);
		c.add(f2);
	
		field=new JTextArea("=>Ali Ahmad \t SP11-BCS-012 \n\n=>Suhaf Azam \t SP11-BCS-120 \n\n=>Junaid Hanif  SP11-BCS-045 \n\n=>Salman Arif \t SP11-BCS-157");
		field.setFont(new Font("Times New Roman",Font.BOLD,14));
		field.setSize(field.getPreferredSize());
		field.setLocation(icon.getIconWidth()+100,f2.getY()+f2.getHeight()+10);
		field.setBackground(Color.GRAY);
		field.setForeground(new Color(0,0,0));
		field.setEditable(false);
		c.add(field);
		
		f1=new JTextArea("Our Efforts");
		f1.setFont(new Font("Times New Roman",Font.BOLD, 24));
		f1.setSize(f1.getPreferredSize());
		f1.setLocation(icon.getIconWidth()+60,field.getY()+field.getHeight()+50);
		f1.setBackground(Color.GRAY);
		f1.setForeground(Color.WHITE);
		f1.setEditable(false);
		c.add(f1);
		
	
 		
		
		//*************************************BUTTONS*************************************

		b=new JButton("MineSweeper");
		b.setSize(137,30);
		b.setLocation(label.getX()+label.getWidth()+100,f1.getHeight()+f1.getY()+10);
		b.setBackground(Color.LIGHT_GRAY);
		b.addActionListener(this);
		b.addChangeListener(this);
		c.add(b);
		
		b1=new JButton("WumPus");
		b1.setSize(137,30);
		b1.setLocation(b.getX(),b.getY()+b.getHeight()+5);
		b1.setBackground(Color.LIGHT_GRAY);
		b1.addActionListener(this);
		b1.addChangeListener(this);
		c.add(b1);
		
			
		b3=new JButton("Snake and Ladder");
		b3.setSize(b3.getPreferredSize());
		b3.setLocation(b1.getX(),b1.getY()+b1.getHeight()+5);
		b3.setBackground(Color.LIGHT_GRAY);
		b3.addActionListener(this);
		b3.addChangeListener(this);
		c.add(b3);
		
		b2=new JButton("Exit");
		b2.setSize(b3.getPreferredSize());
		b2.setLocation(b3.getX(),b3.getY()+b3.getHeight()+5);
		b2.setBackground(Color.LIGHT_GRAY);
		b2.addActionListener(this);
		b2.addChangeListener(this);
		c.add(b2);
			
			
		
		frame.setVisible(true);
	}//****************************END of Constructer******************
	public static void main (String[] args)
	{
		new Introduction();
		new ProjTest();
	}//****************************END of MAIN*************************
	
//***************************************Action Listener*******************************************************

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(b))
		{
			new MineSweeeper();
			frame.setVisible(false);
		}
		if(e.getSource().equals(b1))
		{
			new  WumpusGame();
			frame.setVisible(false);
		}
		if(e.getSource().equals(b2))
		{
			System.exit(0);
		}
		if(e.getSource().equals(b3))
		{
			frame.setVisible(false);
		   new SnakeLudo();
		}
	
	}

public void stateChanged(ChangeEvent changeEvent) {
	
	if(changeEvent.getSource().equals(b2)){
		label.setSize(icon.getIconWidth(),icon.getIconHeight());
 		label.setLocation(20,f.getY()+f.getHeight()+10);
 		label.setIcon(new ImageIcon("intro1.PNG"));
 		c.add(label);
		
		}
	    if(changeEvent.getSource().equals(b1)){
	    label.setSize(icon.getIconWidth(),icon.getIconHeight());
 		label.setLocation(20,f.getY()+f.getHeight()+10);
 		label.setIcon(new ImageIcon("WumpusWorld.PNG"));
 		c.add(label);
 		}
	    if(changeEvent.getSource().equals(b)){
	    label.setSize(icon.getIconWidth(),icon.getIconHeight());
 		label.setLocation(20,f.getY()+f.getHeight()+10);
 		label.setIcon(new ImageIcon("MineSweeper.PNG"));
 		c.add(label);
 		}	
	   if(changeEvent.getSource().equals(b3)){
	    label.setSize(icon.getIconWidth(),icon.getIconHeight());
 		label.setLocation(20,f.getY()+f.getHeight()+10);
 		label.setIcon(new ImageIcon("fire2.PNG"));
 		c.add(label);
 		}
	
	
	}



}