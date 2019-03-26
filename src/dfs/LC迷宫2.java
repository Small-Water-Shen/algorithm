package dfs;

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
	static int minDist;
	
    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if (maze == null || maze.length == 0) {
			return -1;
		}
        boolean[][] vis = new boolean[maze.length][maze[0].length];
        vis[start[0]][start[1]] = true;
        minDist = Integer.MAX_VALUE;
        dfs(maze, vis, start[0], start[1], destination, maze.length, maze[0].length, 0, -1);
        return (minDist != Integer.MAX_VALUE) ? minDist : -1; 
    }
    
    /*
     * С����Ҫײ��ǽ�ſ���ѡ���ķ���
     */
    public static void dfs(int[][] maze, boolean[][] vis, int i, int j, int[] destination, int n, int m, int distance, int lastDir) {
    	if (i == destination[0] && j == destination[1]) {
			minDist = (minDist > distance) ? distance : minDist;
			return;
		}
    	for (int k = 0; k < 4; k++) {
			// �Ż��� �����෴�ķ�����(��һ�������£���ξͲ�Ҫ������)
			if (lastDir == 0 && k == 1 || lastDir == 1 && k == 0
					|| lastDir == 2 && k == 3 || lastDir == 3 && k == 2) {
				continue;
			}
			int x = i, y = j, dis = distance;
			while (check(maze, x + dir[k][0], y + dir[k][1], n, m)) {
				x += dir[k][0];
				y += dir[k][1];
				dis++;
			}
			if (!vis[x][y]) {
				vis[x][y] = true;
				dfs(maze, vis, x, y, destination, n, m, dis, k);
				vis[x][y] = false;  // ��Ҫ���ݣ�Ѱ������ֵ
			}
		}
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
