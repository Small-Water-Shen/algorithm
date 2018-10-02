package algorithm_practices;
/**
 * ˮ�ɻ�����Narcissistic number��Ҳ����Ϊ
 * ����ȫ���ֲ������� PPDI����
 * ������������������ķ˹׳����ķ˹��������Armstrong number����
 * ˮ�ɻ�����ָһ�� n λ����n��3 ��������ÿ��λ�ϵ����ֵ� n ����֮�͵���������
 * �����磺1^3 + 5^3+ 3^3 = 153��
 * */
import java.math.*;
import java.util.*;

public class Pluperfect_digital_invariant {
	
	static BigInteger [] array = new BigInteger [10];//������0~9��21�η�
	
	public static BigInteger pow(int m,int n){
		BigInteger a = BigInteger.ONE;
		for(int i=0;i<n;i++)
			a = a.multiply(BigInteger.valueOf(m));//n��21�η�
		return a;
	}
	
	//���Ե�ǰ���ִ����Ƿ�����
	public static void text(int [] vis,int n){
		BigInteger sum = BigInteger.ZERO;
		
		for(int i=0;i<vis.length;i++){
			//array����0~9��n�η�,��array�е������϶�Ӧvis�г��ֵĴ����õ�����
			sum=sum.add(array[i].multiply(BigInteger.valueOf(vis[i])));
		}

		String str = sum.toString();//���õ�������ת��Ϊ�ַ���
		
		if(str.length()!=n)//���Ȳ���ֱ������
			return;
		
		int [] record = new int [10];//��¼������Ӧλ�õĳ��ִ���

		for(int j=0;j<str.length();j++)
			record[str.charAt(j)-'0']++;//�����ж�Ӧλ�ó��ֵĴ���
		
		for(int k=0;k<vis.length;k++){
			if(vis[k]!=record[k])//���vis�еĴ����������г��ֵĴ����Բ��Ͼ�pass
				return;
		}
		System.out.println(sum);
	}
	
	//vis��¼��Ӧarrayλ�õ������ֵĴ���,posΪ��ǰλ��,nΪ�η�,sumΪ�η���(�ܹ�����n��)
	public static void method(int [] vis,int pos,int sum,int n){
		
		if(pos == vis.length-1){
			vis[pos]=sum;//����������ʱ����δ�������sum��ֵ
			text(vis,n);
			return;
		}
		if(sum == 0){
			text(vis,n);
			return;
		}
		for(int i=0;i<=sum;i++){//ѭ����sum��Ϊֹ
			vis[pos]=i;
			method(vis,pos+1,sum-i,n);
			vis[pos]=0;
		}
	}
		
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();//1-21
		
		for(int i=0;i<array.length;i++)//���0~9��num�η�
			array[i]=pow(i,n);

		int [] vis = new int [10];
		
		//˼·:��ÿ������21�η����ֵĴ����͵���21ʱ���Ϳ����ж�
		//����:1^3 + 5^3 + 3^3 = 153
		method(vis,0,n,n);
		
		input.close();
	}
}
