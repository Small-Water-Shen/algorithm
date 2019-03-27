package dfs;

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
    	int n = maze.length, m = maze[0].length;
    	int[] distance = new int[n * m];
    	String[] path = new String[n * m];
    	// initialize
    	for (int i = 0; i < n * m; i++) {
			distance[i] = Integer.MAX_VALUE;
			path[i] = ""; 
		}
    	dfs(maze, distance, path, ball[0], ball[1], hole, maze.length, maze[0].length, -1);
    	String res = path[hole[0] * m + hole[1]];
    	return res.equals("") ? "impossible" : res;
    }

	/*
     * distance���飬��¼��(i,j)ʱ�Ĳ�������ʼΪMAX
     * path���飬��¼��ǰ(i,j)�ķ��򣬳�ʼ��Ϊ����
     * ������Թ�1,2ʡȥ��vis���飬���Զ�η���·��
     * (˼·ͬbfs�����ǵõ���·����һ������̵ģ����Բ�������dfs)
     */
    public static void dfs(int[][] maze, int[] distance, String[] path,
    		int i, int j, int[] hole, int n, int m, int lastDir) {
    	if (i == hole[0] && j == hole[1]) {
			return;
		}
    	int pos = i * m + j;  // flat into one dimension
    	for (int k = 0; k < 4; k++) {
    		// ���߻�ͷ·
    		if (lastDir == 0 && k == 3 || lastDir == 3 && k == 0 || lastDir == 1 && k == 2 || lastDir == 2 && k == 1) {
				continue;
			}
			int x = i, y = j, step = distance[i * m + j];
			String tempPath = path[pos];
			while (check(maze, x + dir[k][0], y + dir[k][1], n, m)) {
				x += dir[k][0];
				y += dir[k][1];
				step++;
				if (x == hole[0] && y == hole[1]) {
					break;
				}
			}
			int npos = x * m + y;
			tempPath += direction[k];  // add direction
			if (distance[npos] > step) {
				distance[npos] = step;
				path[npos] = tempPath;
				dfs(maze, distance, path, x, y, hole, n, m, k);
			} 
			// ������ȵ�ʱ�򣬱Ƚ��ֵ�˳�����
			else if (distance[npos] == step && path[npos].compareTo(tempPath) > 0) {
				path[npos] = tempPath;
				dfs(maze, distance, path, x, y, hole, n, m, k);
			}
		}
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
		int[] start = new int[] { 4, 3 }, end = new int[] { 0, 1 };
		System.out.println(findShortestWay(map, start, end));
	}

}
