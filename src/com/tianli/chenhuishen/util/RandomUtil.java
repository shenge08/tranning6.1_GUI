package com.tianli.chenhuishen.util;

import java.util.Random;


public class RandomUtil {
	public static int lastDirection=-100;       //��һ�ε��λ��
	private Random random;						//����������Ķ���
	private int[] randomArray;					//��Ų�ͬ���������п����ƶ�����
	
	public RandomUtil(){
		this.random=new Random();
	}
	
	
	/**
	 * �жϵ������
	 * @param x			x���� 
	 * @param y 		y����
	 * @param row 		����
	 * @param column  	����
	 * */
	private void judgePointType(int x,int y,int row,int column){
		//���Ͻ�
		if(x==0 && y==0){
			randomArray=new int[]{Constant.MOVE_DOWN,Constant.MOVE_RIGHT};
		}
		//���Ͻ�
		if(x==0 && y==column-1){
			randomArray=new int[]{Constant.MOVE_DOWN,Constant.MOVE_LEFT};
		}
		//���½�
		if(x==row-1 && y==0){
			randomArray=new int[]{Constant.MOVE_UP,Constant.MOVE_RIGHT};
		}
		//���½�
		if(x==row-1 && y==column-1){
			randomArray=new int[]{Constant.MOVE_UP,Constant.MOVE_LEFT};
		}
		
		//�ϱ�
		if(x==0 && (y>0 && y<column-1)){
			randomArray=new int[]{Constant.MOVE_DOWN,Constant.MOVE_RIGHT,Constant.MOVE_LEFT};
		}
		
		//�±�
		if(x==row-1 && (y>0 && y<column-1)){
			randomArray=new int[]{Constant.MOVE_UP,Constant.MOVE_RIGHT,Constant.MOVE_LEFT};
		}
		
		//���
		if((x>0 && x<row-1) && y==0){
			randomArray=new int[]{Constant.MOVE_UP,Constant.MOVE_DOWN,Constant.MOVE_RIGHT};
		}
		
		//�ұ�
		if((x>0 && x<row-1) && y==column-1){
			randomArray=new int[]{Constant.MOVE_UP,Constant.MOVE_DOWN,Constant.MOVE_LEFT};
		}
		
		//�м�
		if((x>0 && x<row-1) && (y>0 && y<column-1)){
			randomArray=new int[]{Constant.MOVE_UP,Constant.MOVE_DOWN,Constant.MOVE_LEFT,Constant.MOVE_RIGHT};
		}
	}
	
	/**
	 * ���ݵ�������������һ����������һ�εõ�����ķ�����ͬ��
	 * @param x			x���� 
	 * @param y 		y����
	 * @param row 		����
	 * @param column  	����
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
	 * ����int���������
	 * @param nlen ά��*/
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
	 * �ж������Ƿ�Ϊż����
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
