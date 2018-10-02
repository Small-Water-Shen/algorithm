package dp;

import java.util.Scanner;

/**
 * ��M��С������԰�棬��Ʊ��1Ԫ������N��С������ǮΪ1Ԫ��K��С������ǮΪ2Ԫ��
 * ��ƱԱû����Ǯ������ЩС�����ж������Ŷӷ�����ʹ����ƱԱ�����ҵÿ���Ǯ��
 * ע�⣺������һԪ��Ǯ��С�������ǵ�λ�û�����Ҳ����һ���µ��ŷ�����M<=10��
	
	����һ�У�M,N,K(����M=N+K,M<=10).
	
	���һ�У��ܵ��Ŷӷ�����
	
	Sample Input
	4 2 2 
	Sample Output
	8
*/
public class �Ŷ���Ʊ {
	//����ȫ����
	public static int sum(int x){
		int sum = 1;
		for(int i=x;i>0;i--){
			sum *= i;
		}
		return sum;
	}
	//��̬�滮
	public static void dp(int m, int n, int k){
		int [][] dp = new int [20][20];
		dp[1][0] = 1;//1һ��Ԫ�ĺ�0��2Ԫ�ģ�ֻ��һ��
		dp[1][1] = 1;//1һ��Ԫ�ĺ�1��2Ԫ�ģ�ֻ��һ��
		//i=1�ѳ�ʼ�������Դ�i=2��ʼ
		for(int i=2;i<=n;i++){
			for(int j=0;j<=i;j++){
				for(int e=0;e<=j;e++){
					dp[i][j] += dp[i-1][e];
				}
			}
		}
		System.out.println(dp[n][k]*sum(n)*sum(k));
	}
	//�ݹ�
	public static int func(int n, int k) {
		//û����1Ԫ�ĺ���û������
		if(n==0){
			return 0;
		}
		//1Ԫ�ĺ���С��2Ԫ�ĺ��ӵ�����ʱ��û������
		if(n < k){
			return 0;
		}
		//��û��2Ԫ�ĺ���ʱ����ȫ��1Ԫ�ĺ��ӣ���һ���ŷ�
		if(k==0){
			return 1;
		}
		return func(n, k-1)+func(n-1, k);
	}
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		int k = input.nextInt();
		if(n < k || m!=(n+k) || m>10)
			System.out.println("Error");
		else{
//			dp(m, n, k);
			System.out.println(func(n, k)*sum(n)*sum(k));
		}
		input.close();
		System.exit(0);
	}

}
