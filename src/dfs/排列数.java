package dfs;

import java.util.Scanner;

/**
 * ��������
����0��1��2�������ֵ�ȫ���������֣�������ĸ���������£�
����012��021��102��120��201��210
��������һ����n
������0~9ʮ������ȫ�����еĵ�n������1��Ϊ0123456789����
	�����ʽ
	����һ�У�����һ������n
	�����ʽ
	����һ�У�����һ��10�����ֵ�ȫ����
	��������
	1
	�������
	0123456789
	���ݹ�ģ��Լ��
	����0 < n <= 10!
 *
 */
public class ������ {
	
	static int [] a = new int [10];
	static boolean [] vis = new boolean [10];
	static int count = 0;
	static int n;
	
	public static void check() {
		if(count == n){
			for(int i=0;i<=9;i++){
				System.out.print(a[i]);
			}
			System.exit(0);
		}
	}
	public static void dfs(int deep){
		if(deep >= 10){
			count++;
			check();
			return;
		}
		for(int i=0;i<=9;i++){
			if(!vis[i]){
				a[deep] = i;
				vis[i] = true;
				dfs(deep+1);
				vis[i] = false;
			}
		}
	}
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		dfs(0);
		input.close();
	}
}
