package dp;

import java.util.Scanner;

public class Integer_partion1_b {

	public static void partion(int [] array,int num,int k){
		
		if(num == 0){//��ӡ
			for(int i=0;i<k;i++)
				if(i == k-1)
					System.out.print(array[i]);
				else
					System.out.print(array[i]+"+");
			System.out.println();
		}
		/* 5+partion(1)
		 * 4+partion(2)...
		 * */
		for(int i=num;i>0;i--){
			if(k > 0 && i > array[k-1])//��ֹ�ظ�Ԫ��
				continue;
			array[k] = i;
			partion(array,num-i,k+1);
		}
	}
	
	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		int [] array = new int [num];
	
		partion(array,num,0);
	
		input.close();
	}
}
