package algorithm;

/**
 * ���ܱ�����8���ܵ���
 * �˶�Ա���ʱ��Ҫ���飬Ҫ��
 * 1.���������ܵ���
 * 2.ÿ�����������쾡������
 * ���磺9�ˣ�����5,4
 *      26�ˣ�����7,7,6,6��
 */

import java.util.*;

public class �˶�Ա���� {
	
	static final int N = 8;

	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int x = input.nextInt();
			int sum = x/N+1;//������
			int n = x/sum;//ÿ��ƽ���ֵ�����
			int m = x%sum;//ƽ��֮�������
			//���
			for(int i=0;i<m;i++){
				System.out.print(n+1+" ");
			}
			//���ʣ�µ�
			for(int i=0;i<sum-m;i++){
				System.out.print(n+" ");
			}
			System.out.println();
		}
		input.close();
	}

}
