package dp;

import java.util.*;

/**
 * A��B�Ĺ����������г�����ģ�����Ԫ�����ģ�����A��B�Ĺ��������С�
   A����1,3,5,4,2,6,8,7
   B����1,4,8,6,7,5
     ���ǵ�������������ǣ�
   1,4,8,7
   1,4,6,7
     ����������еĳ�����4 ��
     ��ע��: ����������в�Ψһ��
 *
 */
public class ����������� {

	static int [] data1;
	static int [] data2;
	static int n1;
	static int n2;
	/* 
 		ת�Ʒ��̣�

		dp[i,j] = 0                               i=0 || j=0

		dp[i,j] = dp[i-1][j-1]+1                  i>0,j>0, a[i] = b[j]       

		dp[i,j] = max(dp[i-1][j],dp[i][j-1])      i>0,j>0, a[i] != b[j]
	 * */
	public static void DP(){
		int [][] dp = new int [n1+1][n2+1];
		int [][] path = new int [n1+1][n2+1];
		int max = 0;
		for(int i=1;i<=n1;i++){
			for(int j=1;j<=n2;j++){
				if(data1[i] == data2[j]){
					dp[i][j] = dp[i-1][j-1] + 1;//�������ڶ�ά�������ǶԽ��߹���
					path[i][j] = 1;
					if(dp[i][j] > max) max = dp[i][j];
				}
				else if(dp[i-1][j] <= dp[i][j-1]){
					dp[i][j] = dp[i][j-1];//ȡ��ߵ�ֵ
					path[i][j] = 2;//���
				}
				else{
					dp[i][j] = dp[i-1][j];//ȡ�ϱߵ�ֵ
					path[i][j] = 3;//���
				}
			}
		}
		System.out.println(max);
		Export(path, n1, n2);
	}
	//-----���·��-----
	public static void Export(int[][] path, int i, int j) {
		if(i==0 || j==0){
			return;
		}
		if(path[i][j] == 1){
			System.out.print(data1[i]+" ");
			Export(path, i-1, j-1);			
		}
		//������
		if(path[i][j] == 2){
			Export(path, i, j-1);	
		}
		//������
		if(path[i][j] == 3){
			Export(path, i-1, j);	
		}
	}
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		//-----��һ������---------
		n1 = input.nextInt();
		data1 = new int [n1+1];
		for(int i=1;i<=n1;i++) data1[i] = input.nextInt();
		//------�ڶ�������--------
		n2 = input.nextInt();
		data2 = new int [n2+1];
		for(int i=1;i<=n2;i++) data2[i] = input.nextInt();
		DP();
		input.close();
		System.exit(0);
	}
}
