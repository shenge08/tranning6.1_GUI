package com.tianli.chenhuishen.myui;

import javax.swing.JButton;

public class PointButton extends JButton {
	public int x;
	public int y;
	public PointButton(){
		super();
	}
	public PointButton(int x,int y){
		this.x=x;
		this.y=y;
	}
}
