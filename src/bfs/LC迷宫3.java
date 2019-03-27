package bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ���Թ�����һ���������пյĿռ��ǽ�ڡ������ͨ����up (u)��down (d)��left (l)����right (r)�������յĿռ䣬��������ֹͣ����ֱ��ײ��ǽ�ϡ�����ֹͣʱ��������ѡ����һ������������Թ��ﻹ��һ�������������������ͻ�������
 * �������λ�á�����λ�ú��Թ����ҳ������ͨ���ƶ���̾������붴�ڡ��������������ʼλ��(���ų�)����(����)���߹��Ŀտռ������������ġ��á�u������d������l���͡�r��������ƶ��ķ������ڿ����м��ֲ�ͬ�����·����������Ӧ�������ĸ˳���У��ƶ�˳���У���̵ķ����������򲻽����������impossible����
 * �Թ��ɶ�ά�����ʾ��1��ʾǽ��0��ʾ�յĿռ䡣����Լ����Թ��ı߽綼��ǽ����Ϳ��������к��е�������ʾ��
 * 1.�Թ���ֻ��һ�����һ������
 * 2.��Ͷ���������һ���յĿռ��У�����������ᴦ����ͬ��λ�á�
 * 3.�������Թ��������߿�(����ͼƬ�еĺ�ɫ����)����������Լ����Թ��ı߽綼��ǽ��
 * 4.�Թ���������2���յĿռ䣬�Թ��Ŀ�Ⱥ͸߶Ȳ��ᳬ��30��
	�ɶ�ά�����ʾ���Թ���
	0 0 0 0 0
	1 1 0 0 1
	0 0 0 0 0
	0 1 0 0 1
	0 1 0 0 0
	������(rowBall, colBall) = (4,3)
	������(roall, colHole) = (0,1)
	���:��lul��
 */
public class LC�Թ�3 {
	
	// ���ֵ�˳�����ߣ� D -> L -> R -> U
	static final int[][] dir = { {1, 0}, {0, -1}, {0, 1}, {-1, 0} }; 
	// �ַ��Է����ӳ��
	static final char[] direction = new char[] { 'd', 'l', 'r', 'u'};
	
    public static String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        // write your code here
    	if (ball.length == 0 || hole.length == 0 || maze.length == 0) {
			return "";
		}
    	return bfs(maze, ball, hole, maze.length, maze[0].length);
    }

    /*
     * distance���飬��¼��(i,j)ʱ�Ĳ�������ʼΪMAX
     * path���飬��¼��ǰ(i,j)�ķ��򣬳�ʼ��Ϊ����
     * ������Թ�1,2ʡȥ��vis���飬���Զ�η���·��
     */
	public static String bfs(int[][] maze, int[] ball, int[] hole, int n, int m) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] distance = new int[n * m];  // ��άӳ��һά��steps
		String[] path = new String[n * m];  // ��άӳ��һά��path
		// initialize
		for (int i = 0; i < n * m; i++) {
			distance[i] = Integer.MAX_VALUE;
			path[i] = ""; 
		}
		// ���Ԫ�أ� ��ǰ���꣬��һ״̬�ķ���
		queue.offer(new int[] {ball[0], ball[1], -1});
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int i = pos[0], j = pos[1], lastDir = pos[2];
			int p = i * m + j;  // ��άӳ��һά
			int step = distance[p];  // ��¼�Ĳ���
			for (int k = 0; k < 4; k++) {
				int x = i, y = j, curStep = step;
				String trail = path[p];
				// ���߻�ͷ·
				if (lastDir == 0 && k == 3 || lastDir == 3 && k == 0 
						|| lastDir == 2 && k == 1 || lastDir == 1 && k == 2) {
					continue;
				}
				// �Ƿ���Խ��������ƶ�
				while (check(maze, x + dir[k][0], y + dir[k][1], n, m)) {
					x += dir[k][0];
					y += dir[k][1];
					curStep++;
					if (x == hole[0] && y == hole[1]) {
						break;
					}
				}
				// ����
				trail += direction[k];
				int np = x * m + y;
				// ��Ӹ���
				if (distance[np] > curStep) {
					distance[np] = curStep; 
					path[np] = trail; 
					if (!(x == hole[0] && y == hole[1])) {
						queue.offer(new int[] {x, y, k});
					}
				}
				// ������ȾͱȽ��ֵ�˳��, ��ǰ�ֵ�˳����ʱ��ͼ������
				else if (distance[np] == curStep && path[np].compareTo(trail) > 0) {
					path[np] = trail; 
					if (!(x == hole[0] && y == hole[1])) {
						queue.offer(new int[] {x, y, k});
					}
				}
			}
		}
		return path[hole[0] * m + hole[1]].equals("") ? "impossible" : path[hole[0] * m + hole[1]];
	}

	public static boolean check(int[][] maze, int i, int j, int n, int m) {
		if (i < 0 || j < 0 || i >= n || j >= m) {
			return false;
		}
		return maze[i][j] == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[][] map = new int[][] {
    		{0, 0, 0, 0, 0},
    		{1, 1, 0, 0, 1},
    		{0, 0, 0, 0, 0},
    		{0, 1, 0, 0, 1},
    		{0, 1, 0, 0, 0}
    	};
    	int[] start = new int[] {4, 3}, end = new int[] {0, 1};
    	System.out.println(findShortestWay(map, start, end));
	}

}
