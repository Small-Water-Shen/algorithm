package dp;

import java.util.*;

/**
 * ����һ������ΪN�����飬�ҳ�һ����ĵ������������У���һ������������˳�����ң���
 * ���磺����һ������Ϊ6������A{5�� 6�� 7�� 1�� 2�� 8}��
 * ������ĵ�������������Ϊ{5��6��7��8}������Ϊ4.
 *
 */
public class ����������� {

	static int [] data;
	static int n;
	
	/*
	 * �����зֳ�С���У�����Ϊn��������ǰn-1������n-2...
	 * ����,1 7 3 5 
	 * a(0)�ǵ�һ��,a(0)=1,���г���:1
	 * a(1)��1��,a(1)=a(0)+1,���г���:1 7 
	 * a(2)��1���ұ�7С,a(2)=a(1)+1,���г���:1 3
	 * a(3)��1,3��,��7С,a(3)=a(1)+1+1���г���:1 3 5
	 * */
	
	public static void DP(){
		int [] dp = new int [n];
		int max = 0;
		for(int i=0;i<n;i++){
			dp[i] = 1;//ÿ���������Ӵ�������������Ϊһ������
			for(int j=0;j<i;j++){
				//��Ҫ��ǰ��Ĵ��ҳ���Ҫ��ǰ��ĳ���С
				dp[i] += ((data[i] > data[j]) && (dp[i] <= dp[j]+1)) ? 1 : 0;
				if(dp[i] > max){//��¼���ֵ
					max = dp[i];
				}
			}
		}
		System.out.println(max);
	}
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		data = new int [n];
		for(int i=0;i<n;i++) data[i] = input.nextInt();
		DP();
		input.close();
	}
}
