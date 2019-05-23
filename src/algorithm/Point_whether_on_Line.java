package algorithm;

import java.util.Scanner;
/*
 * �жϵ��Ƿ����߶���
 * ��������������
 * ��(Q-P1)*(P2-P1)=0; 
 * 	  x��:(Q.x-P1.x) (P2.x-P1.x)
 *    y��:(Q.y-P1.y) (P2.y-P1.y)
 *    ���в��:(Q.x-P1.x)*(P2.y-P1.y)==(Q.y-P1.y)*(P2.x-P1.x)
 * ����,
 *    б��p2p1 == б��p1Q 
 *    ��: (P2.y-P1.y)/(P2.x-P1.x) == (Q.y-P1.y)/(Q.x-P1.x) 
 * �� Q ���� P1,P2 Ϊ�ԽǶ���ľ����ڡ� 
 */
public class Point_whether_on_Line {
	
	int x;
	int y;
	
	public static boolean judge(Point_whether_on_Line Q,Point_whether_on_Line P1,Point_whether_on_Line P2){
		if((Q.x-P1.x)*(P2.y-P1.y)==(Q.y-P1.y)*(P2.x-P1.x)
				&& (Math.min(P1.x, P2.x)<=Q.x && Math.min(P1.y, P2.y)<=Q.y)
				&& (Math.max(P1.x, P2.x)>=Q.x && Math.max(P1.y, P2.y)>=Q.y))
			return true;
		
		return false;
	}
	
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		Point_whether_on_Line Q = new Point_whether_on_Line();
		Point_whether_on_Line P1 = new Point_whether_on_Line();
		Point_whether_on_Line P2 = new Point_whether_on_Line();

			System.out.print("�������Q��");
			Q.x = input.nextInt();
			Q.y = input.nextInt();	
			System.out.print("������˵�P1��");
			P1.x = input.nextInt();
			P1.y = input.nextInt();
			System.out.print("������˵�P2��");
			P2.x = input.nextInt();
			P2.y = input.nextInt();
			
			if(judge(Q,P1,P2))
				System.out.println("Q�����߶���");
			else
				System.out.println("Q�㲻���߶���");

			input.close();
	}
}
