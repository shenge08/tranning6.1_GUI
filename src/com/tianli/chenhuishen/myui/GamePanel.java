package com.tianli.chenhuishen.myui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import com.tianli.chenhuishen.util.Constant;
import com.tianli.chenhuishen.util.RandomUtil;

class Point{
	public int x;
	public int y;
	
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
}


public class GamePanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2935972874193848353L;
	private PointButton[][] btns;
	private ImageIcon[] icons;
	private RandomUtil ru=new RandomUtil();
	public 	LinkedList<Point> recoverSteps;
	
	private int nu_x;
	private int nu_y;
	
	public void setIcons(ImageIcon[] icons) {
		this.icons = icons;
		recoverSteps=new LinkedList<Point>(); 
	}

	public GamePanel(int row ,int column){
		this.setLayout(new GridLayout(row,column));
		initSubviews(row ,column);
		nu_x=-1;
		nu_y=-1;
	}
	
	/**
	 * 初始化子控件
	 */
	private void initSubviews(int row,int column) {
		btns=new PointButton[row][column];
		icons=new ImageIcon[row*column];

		//按钮数组元素和图片数组元素的初始化
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				btns[i][j]=new PointButton(i,j);
				btns[i][j].addActionListener(this);
				this.add(btns[i][j]);
			}
		}
		btns[btns.length-1][0].setIcon(null);
	
	}

	/**
	 * 打乱图片
	 */
	public void start() {
		recoverSteps.removeAll(recoverSteps);
		
		for(int i=0;i<btns.length;i++){
			for(int j=0;j<btns[0].length;j++){
				int temp = i*btns[0].length+j;
				btns[i][j].setIcon(icons[temp]);
			}
		}
		btns[btns.length-1][0].setIcon(null);
		RandomUtil.lastDirection=-100;
		
		 nu_x=btns.length-1;
		 nu_y=0;
		
		for(int i=0;i<10;i++){
			
			int direction=ru.createRandomDirection(nu_x, nu_y,btns.length , btns[0].length);
			if(direction==Constant.MOVE_UP){
				ImageIcon iconTemp=(ImageIcon)btns[nu_x-1][nu_y].getIcon();
				btns[nu_x-1][nu_y].setIcon(null);
				btns[nu_x][nu_y].setIcon(iconTemp);
				Point point=new Point(nu_x,nu_y);
				recoverSteps.add(point);
				nu_x=nu_x-1;
			}
			
			if(direction==Constant.MOVE_DOWN){
				ImageIcon iconTemp=(ImageIcon)btns[nu_x+1][nu_y].getIcon();
				btns[nu_x+1][nu_y].setIcon(null);
				btns[nu_x][nu_y].setIcon(iconTemp);
				Point point=new Point(nu_x,nu_y);
				recoverSteps.add(point);
				nu_x=nu_x+1;
				
			}
			
			if(direction==Constant.MOVE_LEFT){
				ImageIcon iconTemp=(ImageIcon)btns[nu_x][nu_y-1].getIcon();
				btns[nu_x][nu_y-1].setIcon(null);
				btns[nu_x][nu_y].setIcon(iconTemp);
				Point point=new Point(nu_x,nu_y);
				recoverSteps.add(point);
				nu_y=nu_y-1;
				
			}
			
			if(direction==Constant.MOVE_RIGHT){
				ImageIcon iconTemp=(ImageIcon)btns[nu_x][nu_y+1].getIcon();
				btns[nu_x][nu_y+1].setIcon(null);
				btns[nu_x][nu_y].setIcon(iconTemp);
				Point point=new Point(nu_x,nu_y);
				recoverSteps.add(point);
				nu_y=nu_y+1;
				
			}
		}
		
		
	}
	
	/**根据集合记录的步数进行删除
	 * */
	public void backOneStep(){
		if(recoverSteps.size()==0){
			return;
		}else{
			int last_x=recoverSteps.getLast().x;
			int last_y=recoverSteps.getLast().y;
			
			ImageIcon iconTemp=(ImageIcon)btns[last_x][last_y].getIcon();
			btns[last_x][last_y].setIcon(null);
			btns[nu_x][nu_y].setIcon(iconTemp);
			nu_x=last_x;
			nu_y=last_y;
			if(recoverSteps.size()>0){
				recoverSteps.removeLast();
			}
		}
		
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int x=-1;
		int y=-1;
	
		PointButton pButton=(PointButton)e.getSource();
		x=pButton.x;
		y=pButton.y;
		
		//通过算法判断空白按钮是否要和用户点击按钮交换
		if((nu_x==x&&Math.abs(nu_y-y)==1)||(nu_y==y&&Math.abs(nu_x-x)==1)){
			ImageIcon iconTemp=(ImageIcon)btns[x][y].getIcon();
			btns[x][y].setIcon(null);
			btns[nu_x][nu_y].setIcon(iconTemp);
			Point p=new Point(nu_x, nu_y);
			nu_x=x;
			nu_y=y;
			recoverSteps.add(p);
		}
				
		
	}



}
