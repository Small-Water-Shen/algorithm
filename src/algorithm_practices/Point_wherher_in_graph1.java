package algorithm_practices;

import java.util.Scanner;

public class Point_wherher_in_graph1 {//�жϵ��Ƿ�����������

	static class point{
		int x;
		int y;
	}
	/* 
	 * ��֪���������
	 * ����AB:(B.x-A.x,B.y-A.y)
	 * ����AC:(C.x-A.x,C.y-A.y)
	 * ���: 1/2*((B.x-A.x)*(C.y-A.y)-(B.y-A.y)*(C.x-A.x))
	 * */
	public static int area(point A,point B,point C){
		return (int)((1.0/2)*Math.abs((B.x-A.x)*(C.y-A.y)-(B.y-A.y)*(C.x-A.x)));
	}
	
	public static boolean judge(point A,point B,point C,point Q){
		
		if(area(A,B,Q)==0 || area(A,C,Q)==0 || area(B,C,Q)==0 || area(A,B,C)==0)
			return false;
		
		if(area(A,B,Q)+area(A,C,Q)+area(B,C,Q) - area(A,B,C) < 0.00001)
			return true;
		
		return false;
	}
	
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
	
		point A = new point();
		point B = new point();
		point C = new point();
		point Q = new point();

		System.out.println("��ֱ����������ε��������㣺");
		A.x = input.nextInt();
		A.y = input.nextInt();
		B.x = input.nextInt();
		B.y = input.nextInt();
		C.x = input.nextInt();
		C.y = input.nextInt();
		System.out.println("�������Q��");
		Q.x = input.nextInt();
		Q.y = input.nextInt();
		
		if(judge(A,B,C,Q))
			System.out.println("��Q����������");
		else
			System.out.println("��Q������������");

		input.close();
	}
}
