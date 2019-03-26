package bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ���Թ�����һ���������пյĿռ��ǽ�ڡ������ͨ�����ϣ��£�������ƶ�����������ֹͣ����ֱ��ײ��ǽ�ϡ�����ֹͣʱ��������ѡ����һ������
 * ���������ʼλ�ã�Ŀ����Թ����ҵ���̾���������յ�ͣ�����������������ʼλ��(���ų�)��Ŀ�ĵ�(����)���߹��Ŀտռ������������ġ��������ͣ��Ŀ�ĵأ�����-1��
 * �Թ��ɶ�ά�����ʾ��1��ʾǽ��0��ʾ�յĿռ䡣����Լ����Թ��ı߽綼��ǽ����ʼ��Ŀ���������к���������ʾ��
 * 1.���Թ���ֻ��һ�����һ��Ŀ�ĵء�
 * 2.���Ŀ�ĵض�������һ���յĿռ��У�����������ᴦ����ͬ��λ�á�
 * 3.�������Թ��������߿�(����ͼƬ�еĺ�ɫ����)����������Լ����Թ��ı߽綼��ǽ��
 * 5.�Թ���������2���յĿռ䣬�Թ��Ŀ�Ⱥ͸߶ȶ����ᳬ��100��
	����:  
	(rowStart, colStart) = (0,4)
	(rowDest, colDest)= (4,4)
	0 0 1 0 0
	0 0 0 0 0
	0 0 0 1 0
	1 1 0 1 1
	0 0 0 0 0
	���:  12
	����:
	(0,4)->(0,3)->(1,3)->(1,2)->(1,1)->(1,0)->(2,0)->(2,1)->(2,2)->(3,2)->(4,2)->(4,3)->(4,4)
 */
public class LC�Թ�2 {
	
	static int[][] dir = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if (maze == null || maze.length == 0) {
			return -1;
		}
        boolean[][] vis = new boolean[maze.length][maze[0].length];
        return bfs(maze, vis, start, destination, maze.length, maze[0].length);
    }
    
    /*
     * С����Ҫײ��ǽ�ſ���ѡ���ķ���
     * bfs�ҵ���·���϶�����̵�
     */
    public static int bfs(int[][] maze, boolean[][] vis, int[] start, int[] destination, int n, int m) {
    	Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {start[0], start[1], 0, -1});
		vis[start[0]][start[1]] = true; 
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			// convert to (x, y)
			int x = pos[0];
			int y = pos[1];
			int count = pos[2];
			int lastDir = pos[3];  // record last direction
			for (int k = 0; k < 4; k++) {
				// �Ż��� �����෴�ķ�����(��һ�������£���ξͲ�Ҫ������)
				if (lastDir == 0 && k == 1 || lastDir == 1 && k == 0
						|| lastDir == 2 && k == 3 || lastDir == 3 && k == 2) {
					continue;
				}
				int cur_x = x, cur_y = y, curCount = count;
				// һֱ����ǰ������
				while (check(maze, cur_x + dir[k][0], cur_y + dir[k][1], n, m)) {
					curCount++;
					cur_x += dir[k][0];
					cur_y += dir[k][1];
				}
				// reaching at end
				if (cur_x == destination[0] && cur_y == destination[1]) {
					return curCount;
				}
				if (!vis[cur_x][cur_y]) {
					// convert and offer
					vis[cur_x][cur_y] = true; 
					queue.offer(new int[] {cur_x, cur_y, curCount, k});
				}
			}
		}
        return -1;
    }

	public static boolean check(int[][] maze, int i, int j, int n, int m) {
		if (i < 0 || j < 0 || i >= n || j >= m) {
			return false;
		}
		return maze[i][j] == 0;
	}

	public static void main(String args[]) {
    	int[][] map = new int[][] {
    		{0, 0, 1, 0, 0},
    		{0, 0, 0, 0, 0},
    		{0, 0, 0, 1, 0},
    		{1, 1, 0, 1, 1},
    		{0, 0, 0, 0, 0}
    	};
    	int[] start = new int[] {0, 4}, end = new int[] {4, 4};
    	System.out.println(shortestDistance(map, start, end));
    }

}
