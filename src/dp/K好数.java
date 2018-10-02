package dp;

import java.util.*;

/**
 * ���һ����Ȼ��N��K���Ʊ�ʾ����������ڵ���λ���������ڵ����֣���ô���Ǿ�˵�������K������
 * 
 * ��LλK��������K��������Ŀ������K = 4��L = 2��ʱ������K����Ϊ11��13��20��22��30��31��33 ��7����
 * 
 * ���������Ŀ�ܴ������������1000000007ȡģ���ֵ��

	�����ʽ
	�������������������K��L��
	
	�����ʽ
	���һ����������ʾ�𰸶�1000000007ȡģ���ֵ��
	��������
	4 2
	�������
	7
	���ݹ�ģ��Լ��
	����30%�����ݣ�KL <= 106��
	
	����50%�����ݣ�K <= 16�� L <= 10��
	
	����100%�����ݣ�1 <= K,L <= 100��
 *
 */
public class K���� {

	static int k;
	static int l;
	static final int Mode = 1000000007;
	
	public static void func2(){
		int [][] dp = new int [l+1][k];//�б�ʾiλ�����б�ʾ��j��β����ά�����ֵ��ʾ�ж�����
		//һλ����ʱ����Է���������ֻ��һ��
		for(int j=0;j<k;j++){
			dp[1][j] = 1;
		}
		for(int i=2;i<=l;i++){
			for(int j=0;j<k;j++){
				int temp = 0;
				for(int x=0;x<k;x++){
					if(Math.abs(j-x)!=1){
						temp = (temp + dp[i-1][x])%Mode;
					}
				}
				dp[i][j] = temp;//�ȼ���������ٸ�ֵ����Ȼ����̫�����׳���
			}
		}
		long count = 0;
		for(int j=1;j<k;j++){
			count += dp[l][j];
			count %= Mode;
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		k = input.nextInt();
		l = input.nextInt();
		func2();
		input.close();
		System.exit(0);
	}
	//Ч�ʵ͵ķ���
	public static void func1(){
		int count = 0;
		for(int a=0;a<10000;a++){
			int data = transform(a);
			if(number(data) > l) break;
			if(number(data)!=l) continue;
			int [] aa = new int [l];
			int t = data;
			int k = 0;
			boolean flag = true;
			while(t!=0){
				aa[k++] = t%10;
				t /= 10;
			}
			//ð�ݷ��Ƚ�
			for(int i=0;i<aa.length-1;i++){
				for(int j=1;j<aa.length;j++){
					if(Math.abs(aa[i]-aa[j])==1){
						flag = false;
					}
				}
			}
			if(flag){
				count++;
			}
		}
		System.out.println(count%1000000007);
	}
	public static int transform(int i) {
		int [] a = new int [1000];
		int j = 0;
		int data = 0;
		while(i!=0){
			int temp = i%k;
			a[j++] = temp;
			i /= 4;
		}
		for(--j;j>=0;j--){
			data = a[j] + data*10;			
		}
		return data;
	}
	public static int number(int n){
		int x = 0;
		while(n!=0){
			x++;
			n /= 10;
		}
		return x;
	}
}
