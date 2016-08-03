package com.tianli.chenhuishen.myui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainGameFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3976958387949988710L;
	private GamePanel gamePanel;
	private JButton btn_start;
	private JButton btn_goback;
	
	public MainGameFrame(){
		this.setSize(800,650);
		this.setLayout(null);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setTitle("my game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initSubViews();
		this.setVisible(true);
	}

	private void initSubViews() {
		btn_start=new JButton("start");
		btn_start.setBounds(660, 30, 80,20);
		btn_start.addActionListener(this);
		
		btn_goback=new JButton("back");
		btn_goback.setBounds(660, 60, 80,20);
		btn_goback.addActionListener(this);
		
		this.gamePanel=new GamePanel(4,4);
		ImageIcon[] icons=new ImageIcon[16];
		for(int i=0;i<16;i++){
			 icons[i]=new ImageIcon("images/4x4/02/"+(i+1)+".png");
		}
		this.gamePanel.setIcons(icons);
		this.gamePanel.setBounds(10, 10, 600, 600);
		this.add(this.gamePanel);
		this.add(this.btn_start);
		this.add(this.btn_goback);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btn_start){
			this.gamePanel.start();
		}else if(e.getSource()==this.btn_goback){
			this.gamePanel.backOneStep();
		}else{
			
		}
		/*for (Point p : this.gamePanel.recoverSteps) {
			System.out.println("x:"+p.x+"\ty:"+p.y);
		}*/
		
	}
	
	
}
