package union_find_sets;

public class ������� {

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
		// union find (more ineffcient than dfs or bfs) 
		System.out.println(unionFind(map));
	}

}
