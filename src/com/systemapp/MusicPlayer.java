/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systemapp;
/**
 *
 * @author NARENDER KESWANI
 */
import javazoom.jl.player.Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MusicPlayer implements ActionListener {

    //Creating Frame
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

    public MusicPlayer() {

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
     //  frame.setTitle("Music Player");

        //Adding panels in Frame
       frame.add(playerPanel, BorderLayout.NORTH);
      frame.add(controlPanel, BorderLayout.SOUTH);

        //Setting Frame background color
       frame.setBackground(Color.white);
      frame.setSize(400, 200);
       frame.setVisible(true);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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


    public static void main(String[] args) {
        MusicPlayer mp = new MusicPlayer();
    }
}