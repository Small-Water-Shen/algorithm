package algorithm_practices;

import java.util.*;

public class Fibonacci {
	
	public static int Fib(int num){
		if(num <= 2)
			return 1;
		
		return Fib(num-1)+Fib(num-2);
	}
	
	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);
		
		//�ǵݹ�
		int n = input.nextInt(); 
		int a1 = 1, a2 = 1;	//��ʾf(1)=1 , f(2)=1
		int temp;		//�м�ֵ
		int sum = 0;	//��������ֵ
		
		for(int i=1;i<=n;i++){
			sum = a1;
			temp = a2;
			a2 = a1+a2;
			a1 = temp;
		}
		System.out.println(sum);
		//�ݹ�(Ч�ʵ�)
		System.out.println(Fib(n));
	
		input.close();
	}
}
