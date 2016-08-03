package com.tianli.chenhuishen.util;

import java.util.Random;


public class RandomUtil {
	public static int lastDirection=-100;       //上一次点的位置
	private Random random;						//产生随机数的对象
	private int[] randomArray;					//存放不同种类点的所有可能移动方向
	
	public RandomUtil(){
		this.random=new Random();
	}
	
	
	/**
	 * 判断点的类型
	 * @param x			x坐标 
	 * @param y 		y坐标
	 * @param row 		行数
	 * @param column  	列数
	 * */
	private void judgePointType(int x,int y,int row,int column){
		//左上角
		if(x==0 && y==0){
			randomArray=new int[]{Constant.MOVE_DOWN,Constant.MOVE_RIGHT};
		}
		//右上角
		if(x==0 && y==column-1){
			randomArray=new int[]{Constant.MOVE_DOWN,Constant.MOVE_LEFT};
		}
		//左下角
		if(x==row-1 && y==0){
			randomArray=new int[]{Constant.MOVE_UP,Constant.MOVE_RIGHT};
		}
		//右下角
		if(x==row-1 && y==column-1){
			randomArray=new int[]{Constant.MOVE_UP,Constant.MOVE_LEFT};
		}
		
		//上边
		if(x==0 && (y>0 && y<column-1)){
			randomArray=new int[]{Constant.MOVE_DOWN,Constant.MOVE_RIGHT,Constant.MOVE_LEFT};
		}
		
		//下边
		if(x==row-1 && (y>0 && y<column-1)){
			randomArray=new int[]{Constant.MOVE_UP,Constant.MOVE_RIGHT,Constant.MOVE_LEFT};
		}
		
		//左边
		if((x>0 && x<row-1) && y==0){
			randomArray=new int[]{Constant.MOVE_UP,Constant.MOVE_DOWN,Constant.MOVE_RIGHT};
		}
		
		//右边
		if((x>0 && x<row-1) && y==column-1){
			randomArray=new int[]{Constant.MOVE_UP,Constant.MOVE_DOWN,Constant.MOVE_LEFT};
		}
		
		//中间
		if((x>0 && x<row-1) && (y>0 && y<column-1)){
			randomArray=new int[]{Constant.MOVE_UP,Constant.MOVE_DOWN,Constant.MOVE_LEFT,Constant.MOVE_RIGHT};
		}
	}
	
	/**
	 * 根据点的类型随机产生一个方向（与上一次得到方向的反方向不同）
	 * @param x			x坐标 
	 * @param y 		y坐标
	 * @param row 		行数
	 * @param column  	列数
	 *  */
	public int createRandomDirection(int x,int y,int row,int column){
		this.judgePointType(x, y, row, column);
		if(lastDirection!=-100){
			int[] temp=new int[randomArray.length-1];
			for(int i=0,j=0;i<randomArray.length;i++){
				if(randomArray[i]!=lastDirection){
					temp[j]=randomArray[i];
					j++;
				}
			}
			randomArray=temp;
		}
		int currentDirection=random.nextInt(randomArray.length);
		lastDirection=randomArray[currentDirection] * -1;
		return randomArray[currentDirection];
	}
	
	/**
	 * 产生int型随机数组
	 * @param nlen 维度*/
	/*public static int[] createRandomArrays(int nlen){
		int len=nlen*nlen;
		int[] randomArray=new int[len];
		int randpom=0;
		int count =0;
		int flag=0;
		Random rdm=new Random();
		while(count<len){
			randpom=rdm.nextInt(len);
			for(int i=0;i<count;i++){
				if(randomArray[i]==randpom){
					flag=1;
					break;
				}else{
					flag=0;
				}
			}
			if(flag==0){
				randomArray[count]=randpom;
				count++;
				System.out.print(randpom+" ");
				
			}
		}
		return randomArray;
	}*/

	
	/**
	 * 判断数组是否为偶序列
	 * @param in[] array*/
	/*public static boolean isRecover(int[] array){
		int count=0;
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]>array[j]){
					count++;
				}
			}
		}
		if(count%2==0){
			return true;
		}else{
			return false;
		}
	}*/
}
