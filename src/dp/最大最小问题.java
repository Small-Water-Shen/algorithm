package dp;

import java.util.Scanner;

/**
 * ��ҵ�ϰ���һ����飬��Ҫ������ѡ���ص�һ����������Ա������ѡ�����һ���һλ��ͨԱ����
 *
 */
public class �����С���� {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int [] a = new int [n];
		for(int i=0;i<n;i++) a[i] = input.nextInt();
		int max = a[0];
		int min = a[0];
		for(int i=1;i<n;i++){
			if(a[i] > max) max = a[i];
			if(a[i] < min) min = a[i];
		}
		System.out.println(max+" "+min);
		input.close();
	}
}
