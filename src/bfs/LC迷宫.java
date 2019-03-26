package bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ���Թ�����һ���������пյĿռ��ǽ�ڡ������ͨ�����ϣ��£�������ƶ���
 * ��������ֹͣ����ֱ��ײ��ǽ�ϡ�����ֹͣʱ��������ѡ����һ������
 * ���������ʼλ�ã�Ŀ�ĵغ��Թ���ȷ�����Ƿ����ͣ���յ㡣
 * �Թ��ɶ�ά�����ʾ��1��ʾǽ��0��ʾ�յĿռ䡣����Լ����Թ��ı߽綼��ǽ����ʼ��Ŀ���������к���������ʾ��
 * 1.���Թ���ֻ��һ�����һ��Ŀ�ĵء�
 * 2.���Ŀ�ĵض�������һ���յĿռ��У�����������ᴦ����ͬ��λ�á�
 * 3.�������Թ��������߿�(����ͼƬ�еĺ�ɫ����)����������Լ����Թ��ı߽綼��ǽ��
 * 5.�Թ���������2���յĿռ䣬�Թ��Ŀ�Ⱥ͸߶ȶ����ᳬ��100��
 * ����:
	map = 
	[
	 [0,0,1,0,0],
	 [0,0,0,0,0],
	 [0,0,0,1,0],
	 [1,1,0,1,1],
	 [0,0,0,0,0]
	]
	start = [0,4]
	end = [3,2]
	���:
	false
	����:
	map = 
	[[0,0,1,0,0],
	 [0,0,0,0,0],
	 [0,0,0,1,0],
	 [1,1,0,1,1],
	 [0,0,0,0,0]
	]
	start = [0,4]
	end = [4,4]
	���:
	true
 */
public class LC�Թ� {
	
	static int[][] dir = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if (maze == null || maze.length == 0) {
			return false;
		}
        boolean[][] vis = new boolean[maze.length][maze[0].length];
        return bfs(maze, vis, start, destination, maze.length, maze[0].length);
    }
    
    /*
     * С����Ҫײ��ǽ�ſ���ѡ���ķ���
     * It's efficient to use DFS
     */
    public static boolean bfs(int[][] maze, boolean[][] vis, int[] start, int[] destination, int n, int m) {
    	Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(start);
		vis[start[0]][start[1]] = true; 
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			// convert to (x, y)
			int x = pos[0];
			int y = pos[1];
			for (int k = 0; k < 4; k++) {
				// ע�⣬������Ҫ�����±����Ų���Ӱ����
				int cur_x = x;
				int cur_y = y;
				// һֱ����ǰ������
				while (check(maze, cur_x + dir[k][0], cur_y + dir[k][1], n, m)) {
					cur_x += dir[k][0];
					cur_y += dir[k][1];
				}
				// reaching at end
				if (cur_x == destination[0] && cur_y == destination[1]) {
					return true;
				}
				if (!vis[cur_x][cur_y]) {
					// convert and offer
					vis[cur_x][cur_y] = true; 
					queue.offer(new int[] {cur_x, cur_y});
				}
			}
		}
        return false;
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
    	System.out.println(hasPath(map, start, end));
    }

}
