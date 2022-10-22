package com.systemapp;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Loginh extends Thread{
		static String user1,pass1,try1,try2;
		static JTabbedPane tab1;
		static JFrame f1,f,f2,jl,jl1,f3;
		static JPanel p,p1,p2,p3,p4,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15;
		static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l,l11;
		static JTextField t2,t6;
		static JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
		static JTextField t1,t3,t4,t5;
		static JCheckBox ch1;
		static Dimension size,size1,size2;
		static Image icon,icon1;
		static String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,user,pass;
		static JDialog d;
		static Writer fw,fw1;
		static JMenuBar mb;
		static JMenu m1,m2,m3,m4,m5,m6;
		static JMenuItem mi;
		static File file,file1,file2,file3;
		static BufferedReader fr,fr1;
		public void run()
		{
		    f = new JFrame();
		   	f.setTitle("DataSecurity");
		   	f.setSize(900,500);
		   	
		   	p3 = new JPanel();
		   	p3.setBackground(Color.white);
		   	p3.setSize(900,500);
		   	f.add(p3);
		   	
		   	l9 = new JLabel();
		   	l9.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\SystemApp\\src\\com\\systemapp\\splash.png"));
		   	size1 = l9.getPreferredSize();
		   	l9.setBounds(0,0,900,500);
		   	p3.add(l9);
		   	
		   	icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\eclipse-workspace\\SystemApp\\src\\com\\systemapp\\1.png");
		   	f.setIconImage(icon);
		   	f.setLocationRelativeTo(null);
		   	f.setLayout(null);
		   	f.setVisible(true);
		   	f.setResizable(false);
		   	f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		   	
		   	try {
		   		Thread.sleep(3000);
		   		f.setVisible(false);
		   		f1.setVisible(true);
		   		
	    
	}
	catch (Exception ex) {
	}

		}
		public static void login()
		   {
		   	/*THc j = new THc();
		   	j.start();*/
		   	
		   	f1 = new JFrame();
		   	f1.setTitle("DataSecurity");
		   	f1.setSize(900,500);
		   	Image icon= Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\eclipse-workspace\\SystemApp\\src\\com\\systemapp\\1.png");
		   	f1.setIconImage(icon);
		   	
		   	p = new JPanel();
		   	p.setBackground(Color.white);
		   	p.setBounds(550,0,450,500);
		   	f1.add(p);
		   	
		   	l1 = new JLabel("Login");
		   	l1.setBounds(155,30,100,40);
		   	l1.setForeground(Color.BLUE);
		   	l1.setFont(new Font("Times New Roman",Font.BOLD,25));
		   	
		   	p.add(l1);
		   	
		   	l2 = new JLabel("Email and Username");
		   	l2.setBounds(80,120,150,10);
		   	l2.setForeground(Color.BLUE);
		   	p.add(l2);
		   	
		   	t1 = new JTextField();
		   	t1.setBounds(80,135,200,30);
		   	t1.setFont(new Font("Times New Roman",Font.PLAIN,16));
		   	p.add(t1);
		   	
		   	l3 = new JLabel("Enter Password");
		   	l3.setBounds(80,180,150,10);
		   	l3.setForeground(Color.blue);
		   	p.add(l3);
		   	
		   	t2 = new JTextField();
		   	t2.setBounds(80,195,200,30);
		   	t2.setFont(new Font("Times New Roman",Font.PLAIN,16));
		   	p.add(t2);
		   	
		   	ch1 = new JCheckBox("Agree To Term's And Conditions");
		   	ch1.setBounds(76,242,230,13);
		   	ch1.setBackground(Color.white);
		   	p.add(ch1);
		   	
		   	
		   	b1 = new JButton("LogIn");
		   	b1.setBorderPainted(true);
		   	b1.setForeground(Color.white);
		   	b1.setBackground(Color.BLUE);
		   	b1.setBounds(80,269,70,30);
		   	p.add(b1);
		   	
		   	b2 = new JButton("SignUp");
		   	b2.setBorderPainted(true);
		   	b2.setForeground(Color.white);
		   	b2.setBackground(Color.blue);
		   	b2.setBounds(185,269,90,30);
		   	p.add(b2);
		   	
		   	p.setLayout(null);
		   	p.setVisible(true);
		   	
		   	
		   	//SignUp Panel
		   	
		   	p1 = new JPanel();
		   	p1.setBackground(Color.white);
		   	p1.setBounds(550,0,450,500);
		   	f1.add(p1);
		   	
		   	
		   	l4 = new JLabel("SignUp");
		   	l4.setBounds(145,30,100,40);
		   	l4.setForeground(Color.BLUE);
		   	l4.setFont(new Font("Times New Roman",Font.BOLD,25));
		    //l4.setBounds(170,23,70,15);
		    p1.add(l4);
		    
		    l5 = new JLabel("Enter Name");
		    l5.setBounds(70,100,140,30);
		    l5.setForeground(Color.blue);
		    p1.add(l5);
		    
		    t3 = new JTextField();
		    t3.setBounds(70,130,230,30);
		    p1.add(t3);
		    
		    l6 = new JLabel("Enter Username");
		    l6.setForeground(Color.blue);
		    l6.setBounds(70,155,140,30);
		    p1.add(l6);
		    
		    t4 = new JTextField();
		    t4.setBounds(70,180,230,30);
		    p1.add(t4);
		    
		    l7 = new JLabel("Enter Email Address ");
		    l7.setForeground(Color.blue);
		    l7.setBounds(70,210,140,30);
		    p1.add(l7);
		    
		    t5 = new JTextField();
		    t5.setBounds(70,235,230,30);
		    p1.add(t5);
		    
		    l8 = new JLabel("Password");
		    l8.setForeground(Color.blue);
		    l8.setBounds(70,260,100,30);
		    p1.add(l8);
		    
		    t6 = new JTextField();
		    t6.setBounds(70,285,230,30);
		    p1.add(t6);
		    
			b3 = new JButton("Sign Up");
			b3.setBorderPainted(true);
		   	b3.setForeground(Color.white);
		   	b3.setBackground(Color.blue);
		   	b3.setBounds(145,330,100,30);
			p1.add(b3);
			
			
		   	p1.setLayout(null);
		   	p1.setVisible(false);
		   	
		   	
		   	b3.addActionListener(new ActionListener()
		   	{
		   		public void actionPerformed(ActionEvent e)
		   		{
		   			if(t3.getText().equalsIgnoreCase("")&&t4.getText().equalsIgnoreCase("")&&t5.getText().equalsIgnoreCase("")&&t6.getText().equalsIgnoreCase(""))
		   			{
		   				JOptionPane.showMessageDialog(jl,"Please Fill All The Details.","Error",JOptionPane.ERROR_MESSAGE);
		   			}
		   			else
		   			{
		   			try
		   			{
		   			file = new File("user.txt");
		   			file1 = new File("pass.txt");
		   			if(file.createNewFile())
		   			{
		   				if(file1.createNewFile())
		   				{
		   				System.out.println("File Created");
		   				}
		   			}
		   			else
		   			{
		   				System.out.println("File Already Exist");
		   			}
		   			}
		   			catch(Exception et)
		   			{
		   				System.out.println(et);
		   			}
		   			
		   			s1=t3.getText();
		   			s2=t4.getText();
		   			s3=t5.getText();
		   			s4=t6.getText();
		   			System.out.println(s1+s2+s3+s4);
		   			try
		   			{
		   			  fw = new FileWriter("user.txt");
		   			  fw1 = new FileWriter("pass.txt");
		   				fw.write(s2);
		   				fw1.write(s4);
		   				fw.close();
		   				fw1.close();
		   			
		   			}
		   			catch(Exception eg)
		   			{
		   				System.out.println(eg);
		   			}
		   		JOptionPane.showMessageDialog(jl,"SignUp SuccessFully.","Message",JOptionPane.INFORMATION_MESSAGE);
		   		JOptionPane.showMessageDialog(jl,"Username Is : "+s2+"\nPassowrd Is : "+s4,"Message",JOptionPane.INFORMATION_MESSAGE);
		   		p.setVisible(true);
		   		p1.setVisible(false);
		   			
		   			}
		   		}
		   	});
		   	
		   	
		   	b2.addActionListener(new ActionListener()
		   	{
		   		public void actionPerformed(ActionEvent e)
		   		{
		   			p.setVisible(false);
		   			p1.setVisible(true);
		   		}
		   	});
		   	
		   	
	 		b1.addActionListener(new ActionListener()
		   	{
		   		public void actionPerformed(ActionEvent e)
		   		{   user = t1.getText();
		   			pass = t2.getText();
		   			//String user1,pass1;
		   			try
		   			{
		   				file2 = new File("user.txt");
	                    fr	= new BufferedReader(new FileReader(file2));
		            	while ((user1 = fr.readLine()) != null)
						{System.out.println(user1);
						try1=user1;
						}
						
						
		   				file3 = new File("pass.txt");
	                    fr1	= new BufferedReader(new FileReader(file3));
		            	while ((pass1 = fr1.readLine()) != null)
						{System.out.println(pass1);
						try2=pass1;}
		   			}
		   			
		   			catch(Exception ie)
		   			{
		   				System.out.println(ie);
		   			}
		   			
		   			System.out.println(user1+pass1);
		   			if(user.equals(try1)&&pass.equals(try2))
		   			{
		   			  jl = new JFrame();
		   			 JOptionPane.showMessageDialog(jl,"Logged In SuccessFully.","Message",JOptionPane.INFORMATION_MESSAGE);	
		   			f1.setVisible(false);
		   			system s = new system();
		   			s.systemp();
		   			}
		   			else
		   			{
		   				JOptionPane.showMessageDialog(jl,"Login With Correct Details.","Error",JOptionPane.ERROR_MESSAGE);	
		   				System.out.println("Try Again");
		   			}
		   		}
		   	});
		   
		   		   	
		   	
		   	
		   	//Side Design
		   	
		   	p2 = new JPanel();
		   	p2.setBackground(Color.white);
		   	p2.setBounds(0,0,550,500);
		   	f1.add(p2);
		   	
		   	l = new JLabel();
		   	l.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\SystemApp\\src\\com\\systemapp\\we.jpg"));
		   	size = l.getPreferredSize();
		   	l.setBounds(0,0,size.width,size.height);
		   	p2.add(l);
		   	
		   	
		   	f1.setLocationRelativeTo(null);
		   	f1.setLayout(null);
		   	f1.setVisible(false);
		   	f1.setResizable(false);
		   	f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		   	//
		   	
		   }
		public static void main(String args[])
		{
		    Loginh h =  new Loginh();
		    Loginh.login();
		   	h.start();
		   }

}
