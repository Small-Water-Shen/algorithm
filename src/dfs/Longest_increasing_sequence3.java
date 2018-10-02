package dfs;

import java.util.*;

public class Longest_increasing_sequence3 {
	static int [] a;
	static int [] b;//��¼����������
	static int max=0;

	public static void dfs(int pos_a,int pos_b,int count){
		if(pos_a >= a.length){//���������Ⱦ͸�ֵ��max������
			if(count > max)	max=count;
			return;
		}
		for(int i=pos_a;i<a.length;i++){
			if(pos_b==0 || b[pos_b-1] < a[i]){
				b[pos_b]=a[i];
				dfs(i+1,pos_b+1,count+1);
				//����,���س���
			}
		}
	}
	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		a = new int [n];
		b = new int [n];
		for(int i=0;i<n;i++) a[i]=input.nextInt();
		dfs(0,0,0);
		System.out.println(max);
		input.close();
	}
}