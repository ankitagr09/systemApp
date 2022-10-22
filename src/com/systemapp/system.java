package com.systemapp;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import javazoom.jl.player.Player;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;  
import java.net.*; 
public class system extends MusicPlayer
{
    
    
	static JFrame f2,f4;
	static Image icon;
	static JTabbedPane tab1;
	static JPanel p6,p7,p8,p9,p10,p11,p12;
	static JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	static JButton b1,b2,b3,b4,b6,b7,b8,b9;
	static JTextField t1,t2,t3,t4,t5;
	//static JScrollPane scrollpane1;
	static JTextArea ta;
	static String s1,s2;

	
	
	
	static  JFrame frame;

    //Creating Label for printing the selected song name
    static JLabel songName;

    //Creating button for selecting a song
    static JButton select;

    //Creating Panels
     static JPanel playerPanel, controlPanel;

    //Creating icons for buttons
    static Icon iconPlay, iconPause, iconResume, iconStop;

    //Creating buttons
    static JButton play, pause, resume, stop;

    //Creating FileChooser for choosing the music mp3 file
   static  JFileChooser fileChooser;
  static  FileInputStream fileInputStream;
    static BufferedInputStream bufferedInputStream;
   static File myFile = null;
   static  String filename, filePath;
   static long totalLength, pauseLength;
  static  Player player;
    Thread playThread, resumeThread;

	
	
	
    public system() {

        //Calling initUI() method to initiliaze UI
        initUI();
        //Calling addActionEvents() methods to add actions
        addActionEvents();
        //Calling Threads
        playThread = new Thread(runnablePlay);
        resumeThread = new Thread(runnableResume);

    }

    public void initUI() {

        //Setting songName Label to center
        songName = new JLabel("", SwingConstants.CENTER);

        //Creating button for selecting a song
        select = new JButton("Select Mp3");

        //Creating Panels
        playerPanel = new JPanel(); //Music Selection Panel
        controlPanel = new JPanel(); //Control Selection Panel

        //Creating icons for buttons
        iconPlay = new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\SystemApp\\src\\com\\systemapp\\play-button.png");
        iconPause = new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\SystemApp\\src\\com\\systemapp\\pause-button.png");
        iconResume = new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\SystemApp\\src\\com\\systemapp\\resume-button.png");
        iconStop = new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\SystemApp\\src\\com\\systemapp\\stop-button.png");

        //Creating image buttons
        play = new JButton(iconPlay);
        pause = new JButton(iconPause);
        resume = new JButton(iconResume);
        stop = new JButton(iconStop);

        //Setting Layout of PlayerPanel
        playerPanel.setLayout(new GridLayout(2, 1));

        //Addings components in PlayerPanel
        playerPanel.add(select);
        playerPanel.add(songName);

        //Setting Layout of ControlPanel
        controlPanel.setLayout(new GridLayout(1, 4));

        //Addings components in ControlPanel
        controlPanel.add(play);
        controlPanel.add(pause);
        controlPanel.add(resume);
        controlPanel.add(stop);

        //Setting buttons background color
        play.setBackground(Color.WHITE);
        pause.setBackground(Color.WHITE);
        resume.setBackground(Color.WHITE);
        stop.setBackground(Color.WHITE);

       //Initialing the frame
       frame = new JFrame();

        //Setting Frame's Title
      frame.setTitle("Music Player");

        //Adding panels in Frame
       frame.add(playerPanel, BorderLayout.NORTH);
      frame.add(controlPanel, BorderLayout.SOUTH);

        //Setting Frame background color
       frame.setBackground(Color.white);
     // frame.setLayout(null);
      frame.setVisible(false);
      frame.setSize(600,600);
      frame.setLocationRelativeTo(null);
     frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void addActionEvents() {
        //registering action listener to buttons
        select.addActionListener(this);
        play.addActionListener(this);
        pause.addActionListener(this);
        resume.addActionListener(this);
        stop.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(select)) {
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users"));
            fileChooser.setDialogTitle("Select Mp3");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setFileFilter(new FileNameExtensionFilter("Mp3 files", "mp3"));
            if (fileChooser.showOpenDialog(select) == JFileChooser.APPROVE_OPTION) {
                myFile = fileChooser.getSelectedFile();
                filename = fileChooser.getSelectedFile().getName();
                filePath = fileChooser.getSelectedFile().getPath();
                songName.setText("File Selected : " + filename);
            }
        }
        if (e.getSource().equals(play)) {
            //starting play thread
            if (filename != null) {
                playThread.start();
                songName.setText("Now playing : " + filename);
            } else {
                songName.setText("No File was selected!");
            }
        }
        if (e.getSource().equals(pause)) {
            //code for pause button
            if (player != null && filename != null) {
                try {
                    pauseLength = fileInputStream.available();
                    player.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        if (e.getSource().equals(resume)) {
            //starting resume thread
            if (filename != null) {
                resumeThread.start();
            } else {
                songName.setText("No File was selected!");
            }
        }
        if (e.getSource().equals(stop)) {
            //code for stop button
            if (player != null) {
                player.close();
                songName.setText("");
            }

        }

    }

    Runnable runnablePlay = new Runnable() {
        @Override
        public void run() {
            try {
                //code for play button
                fileInputStream = new FileInputStream(myFile);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                player = new Player(bufferedInputStream);
                totalLength = fileInputStream.available();
                player.play();//starting music
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    Runnable runnableResume = new Runnable() {
        @Override
        public void run() {
            try {
                //code for resume button
                fileInputStream = new FileInputStream(myFile);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                player = new Player(bufferedInputStream);
                fileInputStream.skip(totalLength - pauseLength);
                player.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    
    
    
    
    
	public void systemp()
	{
 	    f2 = new JFrame();
	   	f2.setTitle("DataSecurity");
	   	f2.setSize(1366,768);
	   	icon = Toolkit.getDefaultToolkit().getImage("1.png");
	   	f2.setIconImage(icon);
	   	
	   	l1=new JLabel();
	   	l1.setText("WELCOME TO ADVANCE DATA SYSTEM");
	   	l1.setBounds(450,5,550,29);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		l1.setForeground(new Color(51, 0, 51));
		
		f2.add(l1);
				
				
	   	tab1 = new JTabbedPane();
	   	tab1.setBounds(0,37,1366,768);
	   	tab1.setFont(new Font("Times New Roman",Font.BOLD,16));
		tab1.setForeground(new Color(102, 102, 255));
	   	
	   	p6 = new JPanel();
	   	p6.setBackground(Color.white);
	    p6.setLayout(null);
	   	tab1.add("HOME",p6);
	   	
	   	p7 = new JPanel();
	   	p7.setBackground(Color.white);
	    p7.setLayout(null);
	   	tab1.add("TOOLS",p7);
	   	
	   	l2=new JLabel();
	   	l2.setText("Search Available Tools");
		l2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		l2.setForeground(new Color(102, 102, 255));
		l2.setBounds(1206,12,133,19);
		p7.add(l2);

					//---- textField1 ----
		t1=new JTextField();
		t1.setText("Search Here");
		t1.setForeground(new Color(102, 102, 255));
		t1.setBounds(1204,37,142,34);
		p7.add(t1);

					//---- button1 ----
		b1=new JButton();
		b1.setText("SUBMIT");
		b1.setForeground(new Color(102, 102, 255));
		b1.setBackground(new Color(204, 204, 255));
		b1.setBounds(1229,83,97,26);
		p7.add(b1);
		
		b1.addActionListener(new ActionListener()
	   	{
	   		public void actionPerformed(ActionEvent e)
	   		{ 
	   		}
				
			}); 
			
			

	   	
	   	p8 = new JPanel();
	   	p8.setBackground(Color.white);
	    p8.setLayout(null);
	   	tab1.add("GET SOURCE",p8);
	   	
	   	ta = new JTextArea();
	   	JScrollPane scrollpane1 = new JScrollPane(ta);
	   	scrollpane1.setBounds(5,44,1345,625);
	   	ta.setFont(new Font("Times New Roman", Font.BOLD, 17));
	   // ta.setBounds(0,5,1335,575);
	   	ta.setForeground(new Color(153, 153, 255));

		//---- textField2 ----
		t2=new JTextField();
		t2.setText("https://www.");
		t2.setBounds(19,13,294,24);

		//---- button2 ----
		b2=new JButton();
		b2.setText("SUBMIT");
		b2.setBounds(325,12,92,26);
	   	
	   	p8.add(scrollpane1);
	   	//scrollpane1.add(ta);
	   	p8.add(t2);
	   	p8.add(b2);
	   	
	   	l3=new JLabel();
	   	l3.setText("IP Adress is: ");
		l3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l3.setBounds(600,12,192,26);
		p8.add(l3);
		
		l4=new JLabel();
	   	//l4.setText(ip);
		l4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l4.setBounds(722,12,192,26);
		p8.add(l4);
		
    
		b2.addActionListener(new ActionListener()
	   	{
	   		public void actionPerformed(ActionEvent e)
	   		{
	   			
             String s=t2.getText();  
        if(s==null){}  
        else{  
            try{  
            URL u=new URL(s);  
            URLConnection uc=u.openConnection();  
          
            InputStream is=uc.getInputStream();  
            int i;  
            StringBuilder sb=new StringBuilder();  
            while((i=is.read())!=-1){  
                sb.append((char)i);  
            }  
            String source=sb.toString();  
            ta.setText(source);  
            }catch(Exception ex){JOptionPane.showMessageDialog(f4,"Exception: "+ex);}  
        } 
	   		
	   			
			}});
	b2.addActionListener(new ActionListener()
	   	{
	   		public void actionPerformed(ActionEvent e)
	   		{
	   			String url=t2.getText();  
    try {  
        InetAddress ia=InetAddress.getByName(url);  
        String ip=ia.getHostAddress();  
        JOptionPane.showMessageDialog(f4,ip); 
        	l4.setText(ip); 
    } catch (UnknownHostException e1) {  
        JOptionPane.showMessageDialog(f4,e1.toString());  
    }  
	   		}
	   	});
	   	
	   	
	   	
	   	p9 = new JPanel();
	   	p9.setBackground(Color.white);
	    p9.setLayout(null);
	   	tab1.add("DOWNLOADER",p9);
	   	
	   	l5= new JLabel();
	   	l5.setText("Enter URL To Download File: ");
	   	l5.setFont(new Font("Times New Roman", Font.BOLD, 22));
	   	l5.setBounds(450,130,350,50);
	   	l5.setForeground(new Color(153, 153, 255));
	   	p9.add(l5);
	   	
	   	t3=new JTextField();
		t3.setText("Paste URL");
		t3.setBounds(450,185,550,40);
		t3.setForeground(new Color(153, 153, 255));
		
		l6= new JLabel();
	   	l6.setText("Enter Location TO Save File: ");
	   	l6.setFont(new Font("Times New Roman", Font.BOLD, 22));
	   	l6.setBounds(450,230,350,50);
	   	l6.setForeground(new Color(153, 153, 255));
	   	p9.add(l6);
		
		t4=new JTextField();
		t4.setText("Enter File Location");
		t4.setBounds(450,285,550,40);
		t4.setForeground(new Color(153, 153, 255));
		
		p9.add(t3);
		p9.add(t4);
		
		b3 = new JButton();
		b3.setText("Download Now");
		b3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		b3.setForeground(new Color(153, 153, 255));
		b3.setBackground(Color.white);
		b3.setBounds(625,345,200,30);
		p9.add(b3);
		
		l7= new JLabel();
	   	//l7.setText("Enter Location TO Save File: ");
	   	l7.setFont(new Font("Times New Roman", Font.BOLD, 22));
	   	l7.setBounds(550,400,550,50);
	   	l7.setForeground(new Color(153, 153, 255));
	   	p9.add(l7);
	   	
	   	l8= new JLabel();
	   	//l8.setText("Enter Location TO Save File: ");
	   	l8.setFont(new Font("Times New Roman", Font.BOLD, 22));
	   	l8.setBounds(580,470,550,50);
	   	l8.setForeground(new Color(153, 153, 255));
	   	p9.add(l8);
	   	
		b3.addActionListener(new ActionListener()
	   	{
	   		public void actionPerformed(ActionEvent e)
	   		{ 
	   		   String link =t3.getText();
	   		   File out = new File(t4.getText());
	   		   new Thread(new Download(link,out)).start();
	   			
	   		}
				
			});
	   	
	   	
	   	
	   	
	   	p10 = new JPanel();
	   	p10.setBackground(Color.white);
	   	p10.setLayout(null);
	   	tab1.add("MUSIC UTILITY",p10);
	   	
	   	b4 = new JButton();
	   	b4.setText("MUSIC PLAYER");
	   	b4.setFont(new Font("Times New Roman", Font.BOLD, 35));
	   	b4.setBounds(0,0,1345,625);

	   	b4.setForeground(new Color(153, 153, 255));
	   	
	   	
	   	b4.addActionListener(new ActionListener()
	   	{
	   		public void actionPerformed(ActionEvent e)
	   		{ 
	   		  frame.setVisible(true);
	   		
	   		}
				
			});
	   	p10.add(b4);
	   	
	   	p11 = new JPanel();
	   	p11.setBackground(Color.white);
	   	p11.setLayout(null);
	   	tab1.add("BROWSER",p11);
	   	
	   	t5 = new JTextField();
	   	t5.setText("Enter URL Here ");
	   	t5.setBounds(10,5,550,25);
	   	t5.setForeground(new Color(153, 153, 255));
	   	p11.add(t5);
	   	
	   	b6 = new JButton();
	   	b6.setText("Submit");
	   	b6.setBounds(590,5,100,25);
	   	b6.setForeground(new Color(153, 153, 255));
	   	p11.add(b6);
	   	
	   	b7 = new JButton();
	   	b7.setText("Windows Explorer");
	   	b7.setBounds(730,5,100,25);
	   	b7.setForeground(new Color(153, 153, 255));
	   	p11.add(b7);
	   	
	   	b8 = new JButton();
	   	b8.setText("Microsoft Browser");
	   	b8.setBounds(820,5,100,25);
	   	b8.setForeground(new Color(153, 153, 255));
	   	p11.add(b8);
	   	
	   	b9 = new JButton();
	   	b9.setText("FireFox");
	   	b9.setBounds(920,5,100,25);
	   	b9.setForeground(new Color(153, 153, 255));
	   	p11.add(b9);
	   	
	   	b7.addActionListener(new ActionListener()
	   	{
	   		public void actionPerformed(ActionEvent e)
	   		{ 
	   		  try {
	   			  Runtime r = Runtime.getRuntime();
	   			  Process p = r.exec("explorer.exe");
	   			  system.exit(0);
	   		  }
	   		  catch(Throwable t)
	   		  {
	   			  t.printStackTrace();
	   	
	   		  }
	   		
	   		}
				
			});
	   	b8.addActionListener(new ActionListener()
	   	{
	   		public void actionPerformed(ActionEvent e)
	   		{ 
	   		  try {
	   			  Runtime r2 = Runtime.getRuntime();
	   			  Process p1 = r2.exec("firefox.exe:https://www.google.com");
	   			  system.exit(0);
	   		  }
	   		  catch(Throwable t)
	   		  {
	   	
	   	             t.printStackTrace();
	   		  }
	   		
	   		}
				
			});
	   	b9.addActionListener(new ActionListener()
	   	{
	   		public void actionPerformed(ActionEvent e)
	   		{ 
	   		 try {
	   			  Runtime r3 = Runtime.getRuntime();
	   			  Process p2 = r3.exec("microsoft-edge:https://www.google.com");
	   			  system.exit(0);
	   		  }
	   		  catch(Throwable t)
	   		  {
	   			  t.printStackTrace();
	   	
	   		  }
	   		
	   		}
				
			});
	   	
	   	
	   	
	   	
	   	p12 = new JPanel();
	   	p12.setBackground(Color.white);
	    p12.setLayout(null);
	   	tab1.add("HELP",p12);
	   		
	   	
	   	

	   	
	   	f2.add(tab1);
	   	
	   	
	   	f2.setLocationRelativeTo(null);
	   	f2.setLayout(null);
	   	f2.setVisible(true);
	   	f2.setResizable(false);
	   	f2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	

	protected static void exit(int i) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[])
	{
		
		
		system s= new system();
		s.systemp();
	}
}	  