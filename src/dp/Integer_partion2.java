package dp;

import java.util.Scanner;

public class Integer_partion2 {//��һ��������m�ֳ�n���������ĺͣ��ж����ַַ���
	
	public static int partion(int m,int n){//(6,3) = 4+1+1,3+2+1,2+2+2
		if(m == n || n == 1)
			return 1;	
		if(m < n || m == 0 || n == 0)
			return 0;
 		/*(6,3) = 4+1+1,3+2+1,2+2+2
 		 * 4+1+1��3+2+1ͬʱ����1����4+1,3+2,��(5,2)
 		 * 2+2+2ÿ���ȥ1����1+1+1����(3,1)*/
		return partion(m-1,n-1)+partion(m-n,n);	
	}
	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);
		
		int m = input.nextInt();
		int n = input.nextInt();
	
		System.out.println(partion(m,n));
	
		input.close();
	}

}
