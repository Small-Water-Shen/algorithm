package union_find_sets;

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
	
	static final int EMPTY = 0, BLACK = 1, HIT = 2;
	static int[] pre, length;
	static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    
    public static void init(int n, int m) {
        pre = new int[n * m + 1];
        length = new int[n * m + 1];
        for (int i = 0; i <= n * m; i++) {
            pre[i] = i;
            length[i] = 1;
        }
    }

    public static int[] hitBricks(int[][] grid, int[][] hits) {
    	if (grid == null) return null;
    	if (grid.length == 0) return new int[] {};
    	int[] res = new int[hits.length];
        int n = grid.length, m = grid[0].length;
        init(n, m);
        // remove all hits
        for (int[] hit : hits) {
            int x = hit[0], y = hit[1];
            grid[x][y] = (grid[x][y] == BLACK) ? HIT : BLACK;
        }
        // union
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == BLACK) unionRound(grid, i, j, n, m);
            }
        }
        // reserving add hits
        int cnt = length[find(0)];
        for (int i = hits.length - 1; i >= 0; --i) {
            int x = hits[i][0], y = hits[i][1];
            if (grid[x][y] == HIT) {
            	unionRound(grid, x, y, n, m);
            	grid[x][y] = BLACK; 
            }
            int nCnt = length[find(0)];
            res[i] = (nCnt - cnt > 0) ? nCnt - cnt - 1 : 0;
            cnt = nCnt;
        }
        return res;
    }

    public static void unionRound(int[][] grid, int i, int j, int n, int m) {
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k][0];
            int y = j + dirs[k][1];
            if (x < 0 || x >= n || y < 0 || y >= m) continue;
            if (grid[x][y] == BLACK) union(i * m + j, x * m + y);
        }
        if (i == 0) union(i * m + j, 0);
    }

    public static int find(int x) {
        while (pre[x] != x) x = pre[x];
        return x;
    }

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) {
            pre[a] = b;
            length[b] += length[a]; // recode length of b
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[][] { {1, 0, 1}, {1, 1, 1} };
		int[][] hits = new int[][] { {0, 0}, {0, 2}, {1, 1} };
		System.out.println(Arrays.toString(hitBricks(grid, hits)));
	}

}