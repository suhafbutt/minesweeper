//
 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
/**
 *
 * @author Ali Ch
 */
public class WumpusGame implements ActionListener , KeyListener {

    /**
     * @param args the command line arguments
     */
    JFrame frame,framehlp;
    Container c,panelIin;
    
    JPanel panelS,panelI,panelT;
    JButton help,start,reset,exit,exit1,hlpframe;
    
    JCheckBox    wumpus,gold,all;
    JRadioButton trail,nowGame;
    
    JLabel labelBlck[][] =new JLabel[5][5] ;
    
    
    FlowLayout f=new FlowLayout();
    
    JLabel smokeLabel,goldLabel,blankLabel,wumpusLabel,score,arrow,goldGot;
    JTextField scoref,arrowf,goldGotf;
    JTextArea text;
    JScrollBar Scrollers;
    JLabel helplabel,helplabel1,helplabel2,helplabel3,helplabel4,helplabel5,helplabel6,helplabel7,helplabel8,helplabel9,helplabel10;
    
   
    int h,k,x1,y1,x=0,y=4,imagecount=0;
    String goldC="0", scoreC="0", arrowC="2",info="";
    
    int[][] logic;         
    
    public WumpusGame(){
    inti();
    
    frame =new JFrame("Wumpus Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(670, 570);
    
    //************************panel of GAME INFO
    panelI=new JPanel();
    panelI.setSize(120,200);
    panelI.setLocation(5,5);
    panelI.setLayout(null);
    panelI.setBackground(Color.GRAY);
    panelI.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),"Game Info"));
    
    score =new JLabel("Score  :");
    score.setSize(score.getPreferredSize());
    score.setLocation(10,20);
    
    scoref =new JTextField(scoreC);    
    scoref.setSize(score.getPreferredSize());
    scoref.setBackground(Color.GRAY);
    scoref.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY)));
    scoref.setLocation(60,score.getY());
    
    arrow =new JLabel("Arrow  :");
    arrow.setSize(arrow.getPreferredSize());
    arrow.setLocation(score.getX(),score.getY()+15);
    
    arrowf =new JTextField(arrowC);    
    arrowf.setSize(arrowf.getPreferredSize());
    arrowf.setBackground(Color.GRAY);
    arrowf.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY)));
    arrowf.setEditable(false);
    arrowf.setLocation(60,arrow.getY());
    
    
    goldGot =new JLabel("Gold     :");
    goldGot.setSize(arrow.getPreferredSize());
    goldGot.setLocation(arrow.getX(),arrow.getY()+15);
    
    goldGotf =new JTextField(goldC);    
    goldGotf.setSize(goldGotf.getPreferredSize());
    goldGotf.setBackground(Color.GRAY);
    goldGotf.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY)));
    goldGotf.setLocation(60,goldGot.getY());
    
    
    
    
    //*********************container for Scroll pane
    panelIin=new JPanel();
    panelIin.setSize(100,80);
    panelIin.setLocation(10,80);
    panelIin.setBackground(Color.LIGHT_GRAY);
    panelIin.setLayout(f);
    
    text =new JTextArea(5,5);
    text.setLocation(3,70);
    text.setBackground(Color.LIGHT_GRAY);
    
    text.setEditable (false);
    text.setLineWrap (false);   
    
   
    panelIin.add(text);
    
    
    //******buttun help
    help =new JButton("Help");
    help.setSize(help.getPreferredSize());
    help.setBackground(Color.LIGHT_GRAY);
    help.setLocation(30,165);
    help.addActionListener(this);
    
    panelI.add(scoref);
    panelI.add(score);
    panelI.add(arrow);
    panelI.add(arrowf);
    panelI.add(goldGot);
    panelI.add(goldGotf);
    panelI.add(panelIin);
    panelI.add(help);
    
    //************************panel of GAME SETTING
    panelS=new JPanel();
    panelS.setSize(120,302);
    panelS.setLocation(5,220);
    panelS.setBackground(Color.GRAY);
    panelS.setLayout(null);
    panelS.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),"Game Settings"));
    
    gold=new JCheckBox("Show Gold         ");
    gold.setBackground(Color.GRAY);
    gold.setSize(gold.getPreferredSize());
    gold.setLocation(3,40);
    gold.setEnabled(true);
    gold.addActionListener(this);
    
    wumpus=new JCheckBox("Show Wumpus ");
    wumpus.setBackground(Color.GRAY);
    wumpus.setSize(wumpus.getPreferredSize());
    wumpus.setLocation(gold.getX(),gold.getY()+20);
    wumpus.setEnabled(true);
    wumpus.addActionListener(this);
    
    all=new JCheckBox("Show all hidden");
    all.setBackground(Color.GRAY);
    all.setVisible(true);
    all.setEnabled(false);
    all.setSize(all.getPreferredSize());
    all.setLocation(wumpus.getX(),wumpus.getY()+20);
    all.addActionListener(this);    
    
     
    trail=new JRadioButton("Trail            ");
    trail.setBackground(Color.GRAY);
    trail.setSize(trail.getPreferredSize());
    trail.setLocation(all.getX(),all.getY()+30);
    trail.addActionListener(this);
    
    nowGame=new JRadioButton("Now Play",true);
    nowGame.setBackground(Color.GRAY);
    nowGame.setSize(nowGame.getPreferredSize());
    nowGame.setLocation(trail.getX(),trail.getY()+20);
    nowGame.addActionListener(this);
        
    
    start=new JButton("Start ");
    start.setBackground(Color.LIGHT_GRAY);
    start.setSize(start.getPreferredSize());
    start.setLocation(nowGame.getX()+23,nowGame.getY()+60); 
    start.addActionListener(this);
    
    
    reset=new JButton("reset");
    reset.setBackground(Color.LIGHT_GRAY);
    reset.setSize(start.getPreferredSize());
    reset.setLocation(start.getX(),start.getY()+35);
    reset.addActionListener(this);
    
    
    exit=new JButton(" Exit  ");
    exit.setBackground(Color.LIGHT_GRAY);
    exit.setSize(start.getPreferredSize());
    exit.setLocation(reset.getX(),reset.getY()+35);
    exit.addActionListener(this);    
  
    //  
    panelS.add(gold);
    panelS.add(wumpus);
    panelS.add(all);
    //
    panelS.add(nowGame);
    panelS.add(trail);
    //
    panelS.add(start);
    panelS.add(reset);
    panelS.add(exit);
    
    //************************panel of GAME TABLE
    panelT=new JPanel();
    panelT.setSize(508,508);
    panelT.setLocation(130,13);
    panelT.setLayout(null);
    panelT.setBackground(Color.BLACK);
    panelT.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK)));
    
    //

    
    
      
   //**********************************for the black cover
     
    imagesetter();
    
   
    
    //************************************adding to frame 
    frame.add(panelI);
    frame.add(panelS);
    frame.add(panelT);
    
    //************************addind all to container
    
    c=frame.getContentPane();
    c.setLayout(null);
    c.setBackground(Color.GRAY);
    
    
    frame.setVisible(false);
    frame.setVisible(true);
    }
    
    //***********************************Adding Key Listner***************************
    
   
    public void keyPressed(KeyEvent keyEvent){
    	
    	//******************Event for "LEFT" arrow keyboard key
    	if(keyEvent.getKeyCode()==KeyEvent.VK_LEFT){
    	   if(x>0){
            --x;
            if(logic[y][x]==3||logic[y][x]==1){
           	   lose();
           	   String a =scoref.getText();
           	   int x =Integer.parseInt(a);
           	   x=x-1000;
           	   a=Integer.toString(x);
           	   scoref.setText(a);
           	   frame.setFocusable(false);
           	   }
               else if(logic[y][x]==4){
            	       win();
            	       String a =scoref.getText();
           	           int x =Integer.parseInt(a);
           	           x=x+1000;
           	           a=Integer.toString(x);
           	           scoref.setText(a);
           	           goldGotf.setText("100");
            	       frame.setFocusable(false);
            	}
            	else{
             
             
             info=info+"\n"+"Moving LEFT";
             text.setText(info);
             panelIin.add(text);
             
           x1=2;
           y1=2;
           for(h=0;h<5;h++)
              {   
    	      for(k=0; k<5; k++){
    	         
    	         if(labelBlck[h][k].isVisible()){
    	         	
    	         	  if(logic[h][k]==0){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("blank.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==1){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("fire2.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==2){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("smk.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==4){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("gold.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }  	         	
    	         	  if(logic[h][k]==3){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("wumpus.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	
    	         	}
    	            
                 
    	         x1+=labelBlck[h][0].getWidth()+1;
    	         }
                 x1=2;
                 y1+=labelBlck[h][0].getHeight()+1;
              }
           labelBlck[y][x].setIcon(new ImageIcon("tux.PNG"));
           labelBlck[y][x].setVisible(true);
           labelBlck[y][x].setSize(100,100);   
             
             
             }
    		
    	   }//end of else
    	}
    	
    	//******************Event for "RIGHT" arrow keyboard key
    	if(keyEvent.getKeyCode()==KeyEvent.VK_RIGHT){
        
        if(x<5&&x!=4){
           ++x;
           if(logic[y][x]==3||logic[y][x]==1){
           	lose();
           	String a =scoref.getText();
           	   int x =Integer.parseInt(a);
           	   x=x-1000;
           	   a=Integer.toString(x);
           	   scoref.setText(a);
           	frame.setFocusable(false);
           	}
            else if(logic[y][x]==4){
            	win();
            	String a =scoref.getText();
           	    int x =Integer.parseInt(a);
           	    x=x+1000;
           	    a=Integer.toString(x);
           	    scoref.setText(a);
           	    goldGotf.setText("100");
            	frame.setFocusable(false);
            	}
            	else{
                      
           info=info+"\n"+"Moving RIGHT";
           text.setText(info);
           panelIin.add(text);
           
           x1=2;
           y1=2;
           for(h=0;h<5;h++)
              {   
    	      for(k=0; k<5; k++){
    	         
    	         if(labelBlck[h][k].isVisible()){
    	         	
    	         	  if(logic[h][k]==0){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("blank.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==1){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("fire2.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==2){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("smk.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==4){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("gold.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }  	         	
    	         	  if(logic[h][k]==3){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("wumpus.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	
    	         	}
    	            
                 
    	         x1+=labelBlck[h][0].getWidth()+1;
    	         }
                 x1=2;
                 y1+=labelBlck[h][0].getHeight()+1;
              }
           labelBlck[y][x].setIcon(new ImageIcon("tux.PNG"));
           labelBlck[y][x].setVisible(true);
           labelBlck[y][x].setSize(100,100);   
            }
          }//end of else
    	}
    	
    	//******************Event for "DOWN" arrow keyboard key
    	if(keyEvent.getKeyCode()==KeyEvent.VK_DOWN){
    		if(y<5&&y!=4){
                ++y;
               if(logic[y][x]==3||logic[y][x]==1){
           	     lose();
           	     String a =scoref.getText();
           	     int x =Integer.parseInt(a);
           	     x=x-1000;
           	     a=Integer.toString(x);
           	     scoref.setText(a);
           	     frame.setFocusable(false);
           	     }
                 else if(logic[y][x]==4){
            	         win();
            	         String a =scoref.getText();
           	             int x =Integer.parseInt(a);
           	             x=x+1000;
           	             a=Integer.toString(x);
           	             scoref.setText(a);
           	             goldGotf.setText("100");
            	         frame.setFocusable(false);
            	 }
            	else{
                             
               info=info+"\n"+"Moving DOWN";
               text.setText(info);
               panelIin.add(text);
           x1=2;
           y1=2;
           for(h=0;h<5;h++)
              {   
    	      for(k=0; k<5; k++){
    	         
    	         if(labelBlck[h][k].isVisible()){
    	         	
    	         	  if(logic[h][k]==0){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("blank.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==1){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("fire2.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==2){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("smk.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==4){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("gold.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }  	         	
    	         	  if(logic[h][k]==3){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("wumpus.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	
    	         	}
    	            
                 
    	         x1+=labelBlck[h][0].getWidth()+1;
    	         }
                 x1=2;
                 y1+=labelBlck[h][0].getHeight()+1;
              }
           labelBlck[y][x].setIcon(new ImageIcon("tux.PNG"));
           labelBlck[y][x].setVisible(true);
           labelBlck[y][x].setSize(100,100);   
             }
    	
    		}//******end of else
    	}    	
    	
    	//******************Event for "UP" arrow keyboard key
    	if(keyEvent.getKeyCode()==KeyEvent.VK_UP){
    	 
    	if(y>0){
           --y;    
               
               if(logic[y][x]==3||logic[y][x]==1){
           	     lose();
           	     String a =scoref.getText();
           	     int x =Integer.parseInt(a);
           	     x=x-1000;
           	     a=Integer.toString(x);
           	     scoref.setText(a);
           	     frame.setFocusable(false);
           	     }
                 else if(logic[y][x]==4){
            	         win();
            	         String a =scoref.getText();
           	             int x =Integer.parseInt(a);
           	             x=x+1000;
           	             a=Integer.toString(x);
           	             scoref.setText(a);
           	             goldGotf.setText("100");
            	         frame.setFocusable(false);
            	 }
            	else{
               info=info+"\n"+"Moving UP";
               text.setText(info);
               panelIin.add(text);   
           
           x1=2;
           y1=2;
           for(h=0;h<5;h++)
              {   
    	      for(k=0; k<5; k++){
    	         
    	         if(labelBlck[h][k].isVisible()){
    	         	
    	         	  if(logic[h][k]==0){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("blank.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==1){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("fire2.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==2){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("smk.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==4){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("gold.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }  	         	
    	         	  if(logic[h][k]==3){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("wumpus.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	
    	         	}
    	            
                 
    	         x1+=labelBlck[h][0].getWidth()+1;
    	         }
                 x1=2;
                 y1+=labelBlck[h][0].getHeight()+1;
              }
           labelBlck[y][x].setIcon(new ImageIcon("tux.PNG"));
           labelBlck[y][x].setVisible(true);
           labelBlck[y][x].setSize(100,100);   
    		
    		}
    	}//****end of else
    	
    	}//**********end of pressed event
    }	
   public void keyReleased(KeyEvent evt){
   }
   
   public void keyTyped(KeyEvent evt){
   }
      
    //***********************************Mouse events*********************************
    
    public void actionPerformed(ActionEvent actionEvent){
         
         frame.requestFocusInWindow();
         
         
         //********************event of checkBox "ALL"
         if(actionEvent.getSource()==all){
         	
         	gold.setEnabled(false);
         	wumpus.setEnabled(false);
         	
         	x1=2;
            y1=2;
           for(h=0;h<5;h++)
              {   
    	      for(k=0; k<5; k++){
    	         
    	         
    	         	
    	         	  if(logic[h][k]==0){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("blank.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==1){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("fire2.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==2){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("smk.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==4){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("gold.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }  	         	
    	         	  if(logic[h][k]==3){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("wumpus.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	
    	         	    	            
                 
    	         x1+=labelBlck[h][0].getWidth()+1;
    	         }
                 x1=2;
                 y1+=labelBlck[h][0].getHeight()+1;
              }
         	
         	}
    	//******** "START" button
    	if(actionEvent.getSource()==start){
    		    
             frame.addKeyListener(this);
    frame.setFocusable(true);
    	
    		}
    	//***********"show gold" checkBox.    	
    	if(actionEvent.getSource()==gold){
    		all.setEnabled(false);
    	 x1=2;
           y1=2;
           for(h=0;h<5;h++)
              {   
    	      for(k=0; k<5; k++){
    	         if(logic[h][k]==4){
    	         
    	         labelBlck[h][k].setIcon(new ImageIcon("gold.PNG"));
                 labelBlck[h][k].setSize(100,100);
    	         labelBlck[h][k].setLocation(x1,y1);
    	         
    	         labelBlck[h][k].setVisible(true);
    	         panelT.add(labelBlck[h][k]);
    	         }
    	         	   	         	
    	         x1+=labelBlck[h][k].getWidth()+1;
    	         }
                 x1=2;
                 y1+=labelBlck[h][0].getHeight()+1;
              }
    		   
    		}
    	
    	//***********"show wumpus" checkBox.    	
    	if(actionEvent.getSource()==wumpus){
    		all.setEnabled(false);
    		x1=2;
           y1=2;
           for(h=0;h<5;h++)
              {   
    	      for(k=0; k<5; k++){
    	         if(logic[h][k]==3){
    	         
    	         labelBlck[h][k].setIcon(new ImageIcon("wumpus.PNG"));
                 labelBlck[h][k].setSize(100,100);
    	         labelBlck[h][k].setLocation(x1,y1);
    	         
    	         labelBlck[h][k].setVisible(true);
    	         panelT.add(labelBlck[h][k]);
    	         }
    	         	   	         	
    	         x1+=labelBlck[h][k].getWidth()+1;
    	         }
                 x1=2;
                 y1+=labelBlck[h][0].getHeight()+1;
              }
 
    		}
    	
    	//***************"HELP" button

    	if(actionEvent.getSource()==help){
    		
    		help();
    		
    		}     
    	
    	 //********"EXIT" button event
    	 if(actionEvent.getSource()==exit){
    		
   		Introduction obj=new Introduction();
    		frame.setVisible(false);
    		}
    	
    	//********* "RESET" button event
    	    	
    	if(actionEvent.getSource()==reset){
    	  
           frame.setVisible(false);
           new WumpusGame();
           
    		}//end of button "reset" 
    	   	
    	//*****"hlpframe" button in help menu
    	if(actionEvent.getSource()==hlpframe){
    		
    		framehlp.setVisible(false);
    		}//end of button "hlpframe"
    	if(actionEvent.getSource()==trail){
    		nowGame.setSelected(false);
    		gold.setEnabled(false);
         	wumpus.setEnabled(false);
    		all.setEnabled(true);
    		}
    	if(actionEvent.getSource()==nowGame){
    		trail.setSelected(false);
    		all.setEnabled(false);
    		all.setSelected(false);
    		gold.setSelected(false);
    	    wumpus.setSelected(false);
    		gold.setEnabled(true);
         	wumpus.setEnabled(true);
    		inti();
    	    imagesetter();
    		}	
    	
    	}//end of event
    

    
    
    //******************************************methode of main
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        new WumpusGame();
        
}//end of main methode 
    
    public void help(){
    	framehlp = new JFrame("Wumpus Game Help");
    	framehlp.setSize(250,320);
    	framehlp.setLayout(f);
    	framehlp.setVisible(true);
    	
    	helplabel = new JLabel(" >> A simple move Forward.");
    	helplabel1=new JLabel (" >> A simple Turn Left by 90°.");
    	helplabel2=new JLabel (" >> A simple Turn Right by 90°.");
    	helplabel3= new JLabel(" >> The action Grab can be used to pick");
    	helplabel7= new JLabel("up gold when in the same room as gold.");
    	helplabel4= new JLabel(" >> The action Climb can be used to climb");
    	helplabel8=new JLabel("out of cave in the initial start position.");
      	helplabel5=new JLabel (" >> He action Shoot can be used to fire");
    	helplabel9=new JLabel ("arrow in a straight direction the agent is");
    	helplabel6=new JLabel(" facing. The arrow continues until it");
    	helplabel10=new JLabel("hit and kills the wumpus or hits a wall.");
    
        //***********button for help frame "OK".  	
    	hlpframe = new JButton("  OK  ");
    	hlpframe.setSize(hlpframe.getPreferredSize());
    	hlpframe.setBackground(Color.GRAY);
       	hlpframe.setLocation(200,380);
    	hlpframe.setLocation(200,350);
    	hlpframe.addActionListener(this);
    	
    framehlp.add(helplabel);
    framehlp.add(helplabel1);
    framehlp.add(helplabel2);
    framehlp.add(helplabel3);
    framehlp.add(helplabel7);
    framehlp.add(helplabel4);
    framehlp.add(helplabel8);
    framehlp.add(helplabel5);
    framehlp.add(helplabel9);
    framehlp.add(helplabel6);
    framehlp.add(helplabel10);
    framehlp.add(hlpframe);		
      	
    }
    
    //***************"imagesetter" methode 
     
    public void imagesetter(){
    	   x1=2;
           y1=2;
           for(h=0;h<5;h++)
              {   
    	      for(k=0; k<5; k++){
    	         if(imagecount==0){
    	            labelBlck[h][k]=new JLabel();
    	            }
    	         labelBlck[h][k].setIcon(new ImageIcon("blankblck.PNG"));
                 labelBlck[h][k].setSize(100,100);
    	         labelBlck[h][k].setLocation(x1,y1);
    	         
    	         labelBlck[h][k].setVisible(false);
    	         panelT.add(labelBlck[h][k]);
    	         if(h==4&&k==0)
    	         	{
    	            labelBlck[4][0].setIcon(new ImageIcon("tux.PNG"));
    	            labelBlck[4][0].setVisible(true);
    	            panelT.add(labelBlck[4][0]);
    	            }
    	         	   	         	
    	         x1+=labelBlck[h][k].getWidth()+1;
    	         }
                 x1=2;
                 y1+=labelBlck[h][0].getHeight()+1;
              }
   imagecount++;
    }
    	
    	//***********Initiating Array****
    	public  void inti(){
    		/*
    		 0=blnk
    		 1=fire
    		 2=smoke
    		 3=wumpus
    		 4=gold
    		 */
    	
    	int rand= (int) (Math.random()*5)+1;
    	System.out.print(rand);
    	if(rand==1){
    		System.out.print(rand);
    		logic = new int[][]  {  {1,2,0,4,2},
    		                        {2,0,2,1,1},
    		                        {2,0,0,2,2},
    		                        {1,2,0,0,2},
    		                        {2,0,3,2,1}
    		                      };
    	   }                   			            
    	if(rand==2){
    	System.out.print(rand);	
    	logic = new int[][] {  {2,0,0,3,1},
    		                   {1,2,0,0,2},
    		                   {2,1,2,2,0},
    		                   {0,2,2,1,2},
    		                   {0,0,0,2,4}
    		                };
    	    }
    	if(rand==3){
    	System.out.print(rand);
         logic = new int[][] {  {4,2,0,2,1},
    		                    {2,1,2,0,2},
    		                    {0,2,0,0,0},
    		                    {0,0,0,2,2},
    		                    {0,0,2,1,3}
    		                 };
    	    }
    	if(rand==4){
    	System.out.print(rand);
         logic = new int[][] {  {2,1,2,0,0},
    		                    {0,2,3,2,0},
    		                    {2,1,4,1,2},
    		                    {0,2,0,2,0},
    		                    {0,0,2,1,2}
    		                 };
    	    }	
    	if(rand==5){
    	System.out.print(rand);	
    	logic = new int[][] {  {2,0,0,2,1},
    		                   {1,2,0,2,3},
    		                   {2,1,2,0,2},
    		                   {0,2,0,2,0},
    		                   {2,1,4,1,2}
    		                };
    	    }	
    		
    		
    		
    		
    		}//end of initiating array 
    	
    public void win(){
    	
    	   x1=2;
           y1=2;
           for(h=0;h<5;h++)
              {   
    	      for(k=0; k<5; k++){
    	           	  if(logic[h][k]==0){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("blankWin.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==1){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("fire2.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==2){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("smk.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==4){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("gold.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }  	         	
    	         	  if(logic[h][k]==3){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("wumpus.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	
    	         	    	            
                 
    	         x1+=labelBlck[h][0].getWidth()+1;
    	         }
                 x1=2;
                 y1+=labelBlck[h][0].getHeight()+1;
              }
         	
         	}//end of win methode
    	
    		
       
        public void lose(){
    	
    	   x1=2;
           y1=2;
           for(h=0;h<5;h++)
              {   
    	      for(k=0; k<5; k++){
    	           	  if(logic[h][k]==0){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("blankLose.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==1){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("fire2.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==2){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("smk.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	  if(logic[h][k]==4){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("gold.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }  	         	
    	         	  if(logic[h][k]==3){
    	         	  labelBlck[h][k].setIcon(new ImageIcon("wumpus.PNG"));
    	         	  labelBlck[h][k].setSize(100,100);
    	              labelBlck[h][k].setLocation(x1,y1);
    	              labelBlck[h][k].setVisible(true);
    	              panelT.add(labelBlck[h][k]);
    	         	  }
    	         	
    	         	    	            
                 
    	         x1+=labelBlck[h][0].getWidth()+1;
    	         }
                 x1=2;
                 y1+=labelBlck[h][0].getHeight()+1;
              }
         	
         	}//end of Lose methode
    	
   
       
        
}//end of class Wumpus    