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
	
	private JButton btn_exit;	  							//�˳���ť
	private JButton btn_login;    							//���밴ť
	
	private JTextField txt_name;  							//���������
	private JPasswordField txt_pwd;							//���������
	
	private JLabel lab_pwd;									//�����ǩ
	private JLabel lab_name;								//������ǩ
	
	/***
	 * ���캯��
	 * ��ʼ�����ں��ӿؼ�
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
	 * ˽�� ��ʼ���ӿؼ�����
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
		
		this.lab_name=new JLabel("�˺ţ�");
		this.lab_name.setBounds(50,105,40,20);
		
		this.lab_pwd=new JLabel("���룺");
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
				JOptionPane.showMessageDialog(this, "�˺��������","error!",JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource()==this.btn_exit){
			System.exit(0);
		}
		
	}

}
