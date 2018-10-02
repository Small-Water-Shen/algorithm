package union_find_sets;

import java.util.*;

/**
 * @author ��Сˮ
 *
 *         �������������л��в�಻����k��������������ͬһ�����͡� �������������Ҫ������������
 * 
 *         sample input:
 *         2
 *         3 5 
 *         1 1 
 *         10 6 
 *         15 20 
 *         2 5
 *         1 1
 *         7 7
 *         sample output:
 *         1 
 *         2
 * 
 */
public class Balloons {

	static int[] pre;//���鼯����
	static boolean[] root;//���ڵ�����

	//����ṹ�壬����x, y
	public static class position {
		int x;
		int y;

		public position(int a, int b) {
			this.x = a;
			this.y = b;
		}
	}

	public static class myCompare implements Comparator<position> {
		/*
		 * Returns a negative integer, zero, or a positive integer as the first
		 * argument is less than, equal to, or greater than the second.
		 */
		@Override
		public int compare(position o1, position o2) {
			// TODO Auto-generated method stub
			// ����
			int s1 = o1.x + o1.y;
			int s2 = o2.x + o2.y;
			if(s1 > s2){
				return 1;
			}
			else if(s1 < s2){
				return -1;
			}
			else{
				return 0;			
			}
		}
	}
	
	public static int find_root(int x){
		int r = x;
		while(pre[r] != r){
			r = pre[r];
		}
		//·��ѹ��
		int i = x, j;
		while(pre[i] != r){
			j = pre[i];
			pre[i] = r;
			i = j;
		}
		return r;
	}

	public static void join(int a, int b){
		int x = find_root(a);
		int y = find_root(b);
		if(x != y){
			pre[x] = y;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = input.nextInt();
			int k = input.nextInt();
			// init
			position[] p = new position[n];
			pre = new int[n];
			root = new boolean[n];
			for(int i=0;i<n;i++){
				pre[i] = i;
			}
			//input
			for (int i = 0; i < n; i++) {
				int x = input.nextInt();
				int y = input.nextInt();
				p[i] = new position(x, y);
			}
			// �� x+y ����
			Arrays.sort(p, new myCompare());
			//���ڱȽ�
			for(int i=0;i<n-1;i++){
				for(int j=i+1;j<=i+1;j++){
					if(Math.abs(p[i].x - p[j].x) <= k || Math.abs(p[i].y - p[j].y) <= k){
						join(i, j);
					}
				}
			}
			for(int i=0;i<n;i++){
				root[find_root(i)] = true;
			}
			int sum = 0;
			for(boolean i : root){
				sum += i ? 1 : 0;
			}
//			System.out.println(Arrays.toString(root));
//			System.out.println(Arrays.toString(pre));
			System.out.println(sum);
		}
		input.close();
	}

}
