package union_find_sets;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ����һ��N���㣬M���ߵ�����ͼ�����ж��ٵ��(u,v)(u<v)������u�ܵ���v��vҲ�ܵ���u��
 * ��һ������������N,M����ʾ�����������������M�У���i������������ui,vi����ʾһ����ui��vi�ıߣ���֤ui��vi��
 * һ��һ����������ʾ���������
 * Input: 
 * 3 3
 * 1 2
 * 2 3
 * 3 2 
 * Output:
 * 1
 */
public class ��� {
	
	public static int find(int[] pre, int x) {
		/*
		int r = x;
		while(pre[r] != r){
			r = pre[r];
		}
		// ·��ѹ���㷨
		int i = x, j;
		while(pre[i] != r){
			j = pre[i];
			pre[i] = r;
			i = j;
		}
		return r;
		*/
		// ·��ѹ���ݹ�
		if (pre[x] == x) return x;
		return pre[x] = find(pre, pre[x]); 
	}
	
	public static void union(int[] pre, int x, int y) {
		int a = find(pre, x);
		int b = find(pre, y);
		if (a != b) pre[a] = b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt(), M = input.nextInt();
		int[] pre = new int[N + 1];
		// initialize
		for (int i = 1; i <= N; i++) pre[i] = i; 
		for (int i = 1; i <= M; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			union(pre, a, b);
		}
		System.out.println(Arrays.toString(pre));
		int res = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (pre[i] == pre[j]) ++res;
			}
		}
		System.out.println(res);
		input.close();
	}

}
