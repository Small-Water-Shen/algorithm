package dfs;

import java.util.*;

/**
	��������
	����ͼ��ʾ��3 x 3 �ĸ�������д��һЩ������
	
	+--*--+--+
	|10* 1|52|
	+--****--+
	|20|30* 1|
	*******--+
	| 1| 2| 3|
	+--+--+--+
	��������ͼ�е��Ǻ��߼������õ��������֣�ÿ�����ֵ����ֺͶ���60��
	
	�����Ҫ������������ж����Ը�����m x n �ĸ����е��������Ƿ���Էָ�Ϊ�������֣�ʹ����������������ֺ���ȡ�
	
	������ڶ��ֽ��������������ϽǸ��ӵ��Ǹ���������ĸ��ӵ���С��Ŀ��
	
	����޷��ָ����� 0��
	
	�����ʽ
	�����ȶ����������� m n �ÿո�ָ� (m,n<10)��
	
	��ʾ���Ŀ�Ⱥ͸߶ȡ�
	
	��������n�У�ÿ��m�����������ÿո�ֿ���ÿ������������10000��
	
	�����ʽ
	���һ����������ʾ�����н��У��������Ͻǵķָ������ܰ�������С�ĸ�����Ŀ��
	��������1
	3 3
	10 1 52
	20 30 1
	1 2 3
	�������1
	3
	��������2
	4 3
	1 1 1 1
	1 30 80 2
	1 1 1 100
	�������2
	10
	
	problem ���������������
	3 3
	10 10 10
	10 1 1
	10 10 58
	
	2 2
	1 1
	1 3
 *
 */
public class ������ {

	static int [][] data;
	static boolean [][] vis;
	static int [] dir_x = {1, 0, -1, 0};
	static int [] dir_y = {0, 1, 0, -1};
	static int sum = 0;
	static int count = 0;

	//˼·�������Ͻ�dfs�������ۼӵ�ǰ��ֵ�����������������һ��ʱ�������ǰ�ݹ�����
	public static void dfs(int x, int y, int value, int step) {
		if(value == sum){
			if(count < step){//�ҳ����п����е���С��
				count = step;
			}
			return;
		}
		//���������ĸ�������
		for(int i=0;i<4;i++){
			int nx = x + dir_x[i];
			int ny = y + dir_y[i];
			if(check(nx, ny, value)){
				if(!vis[nx][ny]){
					vis[nx][ny] = true;
					dfs(nx, ny, value + data[nx][ny], step + 1);
					vis[nx][ny] = false;
				}
			}
		}
	}
	public static boolean check(int nx, int ny, int value) {
		if(nx >= 0 && nx < data.length && ny >=0 && ny < data[0].length){
			if(value + data[nx][ny] > sum){
				return false;
			}
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();// ��
		int n = input.nextInt();// ��
		data = new int [n][m];
		vis = new boolean [n+1][m+1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				data[i][j] = input.nextInt();
				vis[i][j] = false;
				sum += data[i][j];
			}
		}
		//��������ƽ��
		if(sum % 2 != 0) System.out.println(0);
		else{
			sum /= 2;
			vis[0][0] = true;//���Ͻ��׵����
			dfs(0, 0, data[0][0], 1);
			System.out.println(count);
		}
		input.close();
	}

}
