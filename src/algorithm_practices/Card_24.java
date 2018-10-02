package algorithm_practices;
/*
 * ���������˿��ƣ�1~10
 * �� + - * / ���㣬�������Ϊ24
 * */
import java.util.*;

public class Card_24 {
	
	final static int N = 1000*100;
	
	public static String rand(int r){
		if(r == 1)
			return "+";
		if(r == 2)
			return "-";
		if(r == 3)
			return "*";
		
		return "/";
	}

	// 4 3 5 7 + - * ��������,ǰ��4��Ϊ���������,����3����������
	public static void func(Deque <Integer> date){
		int r;
		Deque <String> ch = new ArrayDeque<String>();
		for(int i=0;i<3;i++){
			r = (int) (Math.random()*4+1);//1~4
			ch.offer(rand(r));//���ν�����������
		}
		int sum=0;
		while(ch.isEmpty() || date.isEmpty()){
			String c = ch.pollFirst();//���ӵĵ�һ��Ԫ��
			int a = date.removeFirst();//��ջdate�е�Ԫ��
			int b = date.removeFirst();//�ٳ�ջһ��
			if(c.equals("+"))	sum +=b;
			if(c.equals("-"))	sum -=b;
			if(c.equals("*"))	sum *=b;
			if(c.equals("/"))	sum /=b;
		}
	}
	
	public static void main(String [] args){
		Scanner input = new Scanner (System.in);
		Deque <Integer> date = new ArrayDeque<Integer>();
		
		for(int i=0;i<4;i++)
			date.push(input.nextInt());//��ջ1~10

		for(int k=0;k<N;k++)
			func(date);
		
		input.close();
	}
}
