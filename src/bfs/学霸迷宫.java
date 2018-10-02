package bfs;

import java.util.*;

public class ѧ���Թ� {

	static int n, m;
	static String [] str;
	static int[][] map;
	static boolean[][] vis;
	static int[] count;//��¼����
	static int[] path;//��¼·��
	static int[] dir_x = { 1, 0, -1, 0 };// �����ƶ�
	static int[] dir_y = { 0, 1, 0, -1 };// �����ƶ�
	
	//��ֵ��ͼ
	public static void init(){
		for (int i = 0; i < n; i++) {
			String s = str[i];
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}
	}
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean flag = false;
		int p = 0, np = 0;
		// ������
		q.offer(0);
		vis[0][0] = true;
		while (!q.isEmpty()) {
			p = q.poll();
			int x = p / n;
			int y = p % m;
			for (int i = 0; i < 4; i++) {
				int nx = x + dir_x[i];
				int ny = y + dir_y[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m// �߽�����
						&& !vis[nx][ny] && map[nx][ny] == 0) {
					np = nx * n + ny;
					vis[nx][ny] = true;
					q.offer(np);
					count[np] = count[p] + 1;
					path[np] = p;
					if (nx == n - 1 && ny == m - 1) {
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}
			if (flag)
				break;
		}
		if (flag) {
			// ����
			System.out.println(count[np]);
			// ·��
			show(np);
		}
	}

	public static void show(int np) {
		Stack<Character> s = new Stack<Character>();
		// ������·��
		int x = n-1;
		int y = m-1;
		int x1, y1;
		while (true) {
			if (x == 0 && y == 0) break;
			np = path[np];
			x1 = np / n;
			y1 = np % m;
			if (x - x1 == 1) {
				s.push('D');
			} else if (x - x1 == -1) {
				s.push('U');
			} else if (y - y1 == 1) {
				s.push('R');
			} else if (y - y1 == -1) {
				s.push('L');
			}
			x = x1;
			y = y1;
		}
		while(!s.isEmpty()){
			System.out.print(s.pop());
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		// initialization
		str = new String [n];
		map = new int[n][m];
		vis = new boolean[n][m];
		count = new int[n * m];
		path = new int[n * m];
		// input
		for(int i=0;i<n;i++) str[i] = input.next();
		init();
		bfs();
		input.close();
	}
}
