package dfs;

import java.util.Arrays;

/*
 * ������һ����1��0��ɵ����񣺵�Ԫ���е�1��ʾש�顣 ���ҽ���ש��ֱ�����ӵ����񶥲�ʱ��������������һ���������ڵ�ש�鲻�����ʱ��ש�鲻����䡣
 * ���ǽ���˳�����һЩ������ ÿ��������Ҫ����(i, j)λ�õ�ש��ʱ����λ���ϵ�ש�飨������ڣ�����ʧ��Ȼ����������������һЩש��Ҳ���ܻ���䡣
 * ����һ�����飬��ʾÿ�����������ζ�����ש������
 * 1.��������з�ΧΪ [1, 200]��
 * 2.�����ķ�Χ���ᳬ������ķ�Χ��
 * 3.ÿ�����������ǲ��ظ��ģ�����������Χ�ڡ�
 * 4.ĳ��������ש����ܲ����ڡ����ȷʵ�����ڣ���ôû��ש�����䡣
 * ����: 
 * grid = [[1,0,0,0],[1,1,1,0]]
 * hits = [[1,0]]
 * ���: [2]
 * ����: ����������(1, 0)����ש��ʱ, λ��(1, 1) �� (1, 2)��ש��Ҳ����䣬���Է���2.
 * ����: 
 * grid = [[1,0,0,0],[1,1,0,0]]
 * hits = [[1,1],[1,0]]
 * ���: [0,0]
 * ����: ����������(1, 0)����ש��ʱ, λ��(1, 1) ����һ���ƶ����Ѿ������ˡ������������û������κ�ש����䡣ע��(1, 0)��Ϊ�Ѿ������ש�鲻���뿼�ǡ�
 */
public class ��ש�� {
	
	static final int TOP = 2, BLACK = 1, EMPTY = 0;
	static int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
	/*
	 * �Ȱ�Ҫhits�ĵ�remove�����ڴӶ���dfs��������ͨ�����ĵ���ΪTOP��
	 * ��ʣ�¿��Ա���ȥ�ĵ㣬�ٴ�dfsͳ�Ƹ������ɡ�
	 */
    public static int[] hitBricks(int[][] grid, int[][] hits) {
    	if (grid == null) return null;
    	if (grid.length == 0) return new int[] {};
    	int n = grid.length, m = grid[0].length;
    	int[] res = new int[hits.length];
    	// remove all hits points
    	for (int i = 0; i < hits.length; i++) {
			grid[hits[i][0]][hits[i][1]]--; // ���hits��������Ϊ-1
		}
    	// can not drop if it starts with TOP
    	for (int i = 0; i < m; i++) {
    		if (grid[0][i] == 1) dfs(grid, 0, i, n, m);
		}
    	// print map
    	for (int[] i : grid) System.out.println(Arrays.toString(i));
    	// reversing add hits points and counter
    	for (int i = hits.length - 1; i >= 0 ; --i) {
    		int x = hits[i][0];
    		int y = hits[i][1];
    		grid[x][y]++; // ���֮ǰΪ-1,�Ͳ���ͳ����
    		if (grid[x][y] == BLACK && isConnect(grid, x, y, n, m)) {
				res[i] = dfs(grid, x, y, n, m) - 1; 
			}
		}
    	return res;
    }

	public static int dfs(int[][] grid, int i, int j, int n, int m) {
		if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != BLACK) return 0;
		grid[i][j] = TOP;
		return dfs(grid, i + 1, j, n, m) +
			   dfs(grid, i - 1, j, n, m) + 
			   dfs(grid, i, j + 1, n, m) +
			   dfs(grid, i, j - 1, n, m) + 1;
	}

	// ���������TOP������һЩ����drop
	public static boolean isConnect(int[][] grid, int x, int y, int n, int m) {
		if (x == 0) return true; // λ�ڶ���
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == TOP) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[][] { {1, 0, 1}, {1, 1, 1} };
		int[][] hits = new int[][] { {0, 0}, {0, 2}, {1, 1} };
		System.out.println(Arrays.toString(hitBricks(grid, hits)));
	}

}