package dp;

import java.util.*;

public class ʯ�Ӻϲ� {

	static int n;
    static int [] data;

    //˼�룺dp[i][j]��ʾ��ǰ�ϲ�����С���ۣ�����Ϊ��i��ʼ����Ϊj������ϲ�
    public static void DP() {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        data = new int [n*n];
    	int [][] dp = new int [n+1][n+1];
    	int [][] sum = new int [n+1][n+1]; 
    	for (int i=1;i<=n;i++) data[i] = input.nextInt();
    	//��ʼ��sum����ʾ��i��ʯ�ӵ���j��ʯ��ȫ���ϲ�����ʯ����
    	for(int i=1;i<=n;i++){
    		for(int j=1;j<=n;j++){
    			sum[i][j] = sum[i][j-1] + data[i+j-1];
    		}
    	}
    	for(int len=2;len<=n;len++){
    		for(int i=1;i<=n-len+1;i++){
    			dp[i][len] = Integer.MAX_VALUE;
    			for(int j=1;j<len;j++){
    				dp[i][len] = Math.min(dp[i][len], dp[i][j]+dp[i+j][len-j]+sum[i][len]);
    			}
    		}
    	}
    	System.out.println(dp[1][n]); 
    	input.close();
    }
    
    public static void DP1(){
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        data = new int [n+1];
    	int [][] dp = new int [n+1][n+1];
    	int [] sum = new int [n*n]; 
    	for (int i=1;i<=n;i++){
    		data[i] = input.nextInt();
    		sum[i] = sum[i-1] + data[i];
    	}
    	
    	System.out.println(dp[1][n]);
    	input.close();
    }

    public static void main(String[] args) {
    	DP();
//    	DP1();
    }
}
