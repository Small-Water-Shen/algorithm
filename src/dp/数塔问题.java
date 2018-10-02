package dp;

import java.util.Scanner;

/**
 * �������� ��Ҫ��Ӷ����ߵ��ײ㣬��ÿһ��ֻ���ߵ����ڵĽ�㣬�򾭹��Ľ�������֮������Ƕ��٣�
 *
 */
public class �������� {
	
	static int [][] dp;
	static int n;
	
	//״̬ת�Ʒ��̣�dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + dp[i][j];
	public static void DP1(){
		for(int i=2;i<=n;i++){
			for(int j=1;j<=i;j++){
				//�Ƚ����������������ļ��ϸ��ڵ�
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + dp[i][j];
			}
		}
		//�ҳ����һ�е����ֵ
		int max = 0;
		for(int i=1;i<=n;i++){
			if(dp[n][i] > max) max = dp[n][i];
		}
		System.out.println(max);
	}
	public static void DP2(){
		//���õ��˵ķ���
		for(int i=n;i>0;i--){
			for(int j=1;j<i;j++){
				dp[i-1][j] += (dp[i][j] > dp[i][j+1]) ? dp[i][j]: dp[i][j+1];
			}
		}
		System.out.println(dp[1][1]);
	}

	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		dp = new int [n+1][n+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				dp[i][j] = input.nextInt();
			}
		}
//		DP1();
		DP2();
		input.close();
		System.exit(0);
	}
}
