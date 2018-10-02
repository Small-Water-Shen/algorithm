package dp;//�ݹ龭��+��̬�滮
/*
 * such as : 6
 * = 6+0
 * = 5+1
 * = 4+2,4+1+1
 * = 3+3,3+2+1,3+1+1+1
 * ......*/
import java.util.Scanner;

public class Integer_partion1_a {
	
	public static int partion(int n,int m){//��n�������Ϊm�Ļ��ָ���,����(6,6)������6+0
		if(n == 1 || m == 1)//����1ʱ����Ȼ����1+1+1...
			return 1;
		if(n == m)
			return partion(n,m-1)+1;//��(6,6)ʱ������(6,5)+1,��5+1
		if(n < m)
			return partion(n,n);//����(2,4)����������4�����ڲ��ܳ���2��������(2,2)
		/* ���������
		 * (6,3) = 3+2+1,3+1+1+1
		 * ͬʱԼ�����е�3(����3+2+1ÿ���ȥ1)����2+1,1+1+1,��(3,2)
		 * ͬʱ����������1����3+2��3+1+1����(5,3)
		 * ��(6,3) = (5,3)+(3,2)*/
		return partion(n-m,m)+partion(n,m-1);
	}
	
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		System.out.println(partion(num,num));
		input.close();
	}
}
