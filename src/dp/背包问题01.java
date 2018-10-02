package dp;

import java.util.*;

public class ��������01 {

	static int n;//��Ʒ����
	static int W;//�����������
	static int i;//�����������
	static goods [] g = null;
	
	static class goods{
		int value;
		int weight;
	}
	public static void fun1(){
	/* DP�����̿���������⣺����ǰi����Ʒ������ʣ������Ϊjʱ����ȡ�õ�����ֵ����ʱ��Ϊ״̬3��ֻ����������״̬��

	      ״̬1��ǰi-1����Ʒ������ʣ������Ϊj���ڸ�״̬�£�ֻҪ��ѡ��i����Ʒ���Ϳ���ת����״̬3��

	      ״̬2��ǰi-1����Ʒ������ʣ������Ϊj-w[i]���ڸ�״̬�£�ѡ��i����Ʒ��Ҳ����ת����״̬3��

	      ��Ϊ������Ҫ������ֵ������ֻҪ��״̬1��״̬2��ѡ������ֵ�ϴ��һ�����ɡ� 
	*/
		int [][] dp = new int [n+1][W+1];//���ö�ά�������
		int [] a = new int [n+1];//Ѱ��ѡ�����Ʒ
		for(int i=1;i<g.length;i++){
			for(int j=1;j<=W;j++){
				if(j < g[i].weight){
					dp[i][j] = dp[i-1][j];
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-g[i].weight]+g[i].value);
				}
			}
		}
		/*
		for(int i=1;i<g.length;i++){
			for(int j=1;j<=W;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}*/
		int temp = W;
		for(int i=n;i>=1;i--){
			if(dp[i][temp] > dp[i-1][temp]){
				a[i] = 1;
				temp -= g[i].weight;
			}
		}
		System.out.print("Case "+i+": ");
		//�����Ʒ���
		for(int i=0;i<a.length;i++){
			if(a[i]==1)
				System.out.print(i+" ");
		}
		//����ܼ�ֵ
		System.out.println(dp[n][W]);

	}
	/*
	 * ��������ʱѡ�����Ʒ�ܶ࣬�����������ܴ���ʱҪ�ö�ά���������ǲ���ʵ�ġ�
	 * ������һ�����������Խ��пռ�ѹ����Ȼ��ʹ��һά����ʵ�֡�
	 * Ҫʹ��һά���飬��������Ҫ���õ��򣬼�w--->1, ֻ���������ڷ���dp[j] = Max(dp[j], dp[j-w[i]]) + v[i])
	 * ���ܴﵽ��ʽ��߲ű�ʾi,����ʽ�ұ߱�ʾi-1��Ч����*/
	public static void fun2(){
		int [] dp = new int [W+1];
		for(int i=1;i<g.length;i++){
			for(int j=W;j>=g[i].weight;j--){
				dp[j] = Math.max(dp[j], dp[j-g[i].weight]+g[i].value);
			}
		}
		for(int i=0;i<dp.length;i++){
			System.out.print(dp[i]+" ");
		}
	}
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		i = 1;
		while(input.hasNext()){
			n = input.nextInt();
			W = input.nextInt();
			g = new goods [n+1];
			for(int i=0;i<g.length;i++){
				g[i] = new goods();//ʵ����ÿһ����������
			}
			for(int i=1;i<g.length;i++){
				g[i].value = input.nextInt();
				g[i].weight = input.nextInt();
			}
			fun1();
			i++;
		}
		input.close();
		System.exit(0);
	}
}
