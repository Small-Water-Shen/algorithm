package dfs;

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
	static boolean isReaching;
	
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if (maze == null || maze.length == 0) {
			return false;
		}
        boolean[][] vis = new boolean[maze.length][maze[0].length];
        isReaching = false;
        dfs(maze, vis, start[0], start[1], destination, maze.length, maze[0].length);
        return isReaching;
    }
    
    /*
     * С����Ҫײ��ǽ�ſ���ѡ���ķ���
     */
    public static void dfs(int[][] maze, boolean[][] vis, int i, int j, int[] destination,int n, int m) {
    	if (isReaching) {
			return;
		}
    	if (i == destination[0] && j == destination[1]) {
			isReaching = true;
		}
    	for (int k = 0; k < 4; k++) {
    		// ע��������Ҫ���ı�ԭ������������µ����굽��һ��
        	int x = i, y = j;
			while (check(maze, x + dir[k][0], y + dir[k][1], n, m)) {
				x += dir[k][0];
				y += dir[k][1];
			}
			if (!vis[x][y]) {
				vis[x][y] = true; 
				dfs(maze, vis, x, y, destination, n, m);
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
    	int[] start = new int[] {0, 4}, end = new int[] {3, 2};
    	System.out.println(hasPath(map, start, end));
    }

}
