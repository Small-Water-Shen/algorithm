package bfs;

/*
 * ��һ�� 01 ������ͬ�ĵ���ĸ�����
 * 0 ������1 ������������� 1 ���ڣ���ô������ 1 ����ͬһ����������ֻ������������Ϊ���ڡ�
 * ���룺
	[
	  [1,1,0,0,0],
	  [0,1,0,0,1],
	  [0,0,0,1,1],
	  [0,0,0,0,0],
	  [0,0,0,0,1]
	]
	����� 3
 */
public class ������� {

	public static int numIslands(boolean[][] grid) {
		return Bfs(grid);
	}

	// ****************Bfs*********************
	public static int Bfs(boolean[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int count = 0;
		int height = grid.length, width = grid[0].length;
		int[][] dir = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// ����С���Ϳ�ʼbfs
				if (grid[i][j]) {
					grid[i][j] = false;
					bfs(grid, dir, i, j);
					count++;
				}
			}
		}
		return count;
	}
	
	public static void bfs(boolean[][] grid, int[][] dir, int i, int j) {
		for (int k = 0; k < 4; k++) {
			int x = i + dir[k][0];
			int y = j + dir[k][1];
			if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y]) {
				grid[x][y] = false;
				bfs(grid, dir, x, y);  // ��������ͨ�ĵ�����false
			}
		}
	}
	
	
	// ****************Dfs**************
	public static int Dfs(boolean[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// ����С���Ϳ�ʼbfs
				if (grid[i][j]) {
					dfs(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}
	
	public static void dfs(boolean[][] grid, int i, int j) {
		int height = grid.length, width = grid[0].length;
		// overstep
		if (i < 0 || i >= height || j < 0 || j >= width || !grid[i][j]) {
			return;
		}
		// visited
		grid[i][j] = false;
		// dfs with four directions
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}
	
	// ****************���鼯**************
	public static int unionFind(boolean[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int height = grid.length, width = grid[0].length;
		int[] pre = new int[height * width];
		// initialize
		for (int i = 0; i < pre.length; i++) {
			pre[i] = i;  // �Գ�һ�� 
		}
		/* �Զ�ά������0��ʼ�������ң����ϵ��£����յ�height*width-1
		 * ÿ��(i,j)��Ӧ������Ϊ�� i*height+j
		 */
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// ���ڵ�index
				int root = i * width + j;
				int right = root + 1;  // ����
				int down = root + width;  // ����
				// ͬ�༯��
				if (j + 1 < width && grid[i][j] == grid[i][j + 1])	unionPre(pre, root, right);
				if (i + 1 < height && grid[i][j] == grid[i + 1][j])	unionPre(pre, root, down);
			}
		}
		// get count
		int count = 0;
		for (int i = 0; i < pre.length; i++) {
			if (pre[i] == i && grid[i / width][i % width]) {
				count++;
			}
		}
		return count;
	}
	
	public static int findPre(int[] pre, int x) {
		int r = x;
		while (pre[r] != r) {
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
	}
	
	public static void unionPre(int[] pre, int x, int y) {
		int a = findPre(pre, x);
		int b = findPre(pre, y);
		if (a != b) {
			pre[a] = b;  // union father root with child 
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] map = new boolean[][] {
			{ true, true, false, false, false }, 
			{ false, true, false, false, true },
			{ false, false, false, true, true }, 
			{ false, false, false, false, false },
			{ false, false, false, false, true }
			};
		// bfs
		System.out.println(numIslands(map));
		// dfs
		System.out.println(Dfs(map));
		// union find (more ineffcient than dfs or bfs) 
		System.out.println(unionFind(map));
	}

}
