package com.tianli.chenhuishen.myui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3533278001754025857L;
	
	private JButton btn_exit;	  							//退出按钮
	private JButton btn_login;    							//登入按钮
	
	private JTextField txt_name;  							//姓名输入框
	private JPasswordField txt_pwd;							//密码输入框
	
	private JLabel lab_pwd;									//密码标签
	private JLabel lab_name;								//姓名标签
	
	/***
	 * 构造函数
	 * 初始化窗口和子控件
	 */
	public LoginFrame(){
		this.setSize(300,300);
		this.setLayout(null);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setTitle("my second ui java");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.InitSubView();
	 }

     /***
	 * 私有 初始化子控件函数
	 */
	private void InitSubView(){
		this.btn_login=new JButton("login");
		this.btn_login.setBounds(50,200,75,35);
		this.btn_login.addActionListener(this);
		
		this.btn_exit=new JButton("exit");
		this.btn_exit.setBounds(175,200,75,35);
		this.btn_exit.addActionListener(this);
		
		this.txt_name=new JTextField("chen");
		this.txt_name.setBounds(100, 105, 150, 20);
		
		this.txt_pwd=new JPasswordField("1234");
		this.txt_pwd.setBounds(100, 140, 150, 20);
		
		this.lab_name=new JLabel("账号：");
		this.lab_name.setBounds(50,105,40,20);
		
		this.lab_pwd=new JLabel("密码：");
		this.lab_pwd.setBounds(50,140,40,20);
		
		this.add(this.btn_login);
		this.add(this.btn_exit);
		this.add(this.lab_pwd);
		this.add(this.lab_name);
		this.add(this.txt_pwd);
		this.add(this.txt_name);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btn_login){
			if(this.txt_name.getText().equals("chen")&&this.txt_pwd.getText().equals("1234")){
				MainGameFrame idf=new MainGameFrame();
				idf.setVisible(true);
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "账号密码错误！","error!",JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource()==this.btn_exit){
			System.exit(0);
		}
		
	}

}
