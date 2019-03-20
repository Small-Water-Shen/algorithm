package bfs;

/*
 * ��һ����ά�ľ��󣬰��� 'X' �� 'O', �ҵ����б� 'X' Χ�Ƶ����򣬲��� 'X' �滻�������е� 'O'��
 * ����:
	  X X X X
	  X O O X
	  X X O X
	  X O X X
   ���: 
	  X X X X
	  X X X X
	  X X X X
	  X O X X
 */
public class ��Χ�Ƶ����� {
	
	static int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	/*
	 * ��Ϊ�ӱ�Ե�����ǲ��ܱ���Χ�ģ�������bfs�����ܿ�ʼ̽�⣬����ͨ�ı��Ϊ*��
	 * Ȼ���ٱ���һ��ԭboard�����޸�
	 */
	public static void surroundedRegions(char[][] board) {
		// write your code here
		if (board == null || board.length == 0) {
			return;
		}
		int n = board.length, m = board[0].length;
		// ���ܽ��б���
		for (int i = 0; i < n; i++) {
			bfs(board, n, m, i, 0);
			bfs(board, n, m, i, m - 1);
		}
		for (int j = 0; j < m; j++) {
			bfs(board, n, m, 0, j);
			bfs(board, n, m, n - 1, j);
		}
		// �����޸�
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == '*') {
					board[i][j] = 'O'; 
				}
				else {
					board[i][j] = 'X'; 
				}
			}
		}
	}

	public static void bfs(char[][] board, int n, int m, int x, int y) {
		// �ȱ����̽��
		if (isValid(n, m, x, y) && board[x][y] == 'O') {
			board[x][y] = '*';
			// four directions
			for (int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
					bfs(board, n, m, nx, ny);
			}	
		}
	}
	
	public static boolean isValid(int n, int m, int x, int y) {
		return (x >= 0 && y >= 0 && x < n && y < m );
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] map = new char[][] {
			"XOOXXXOXXOOOOOOOOOOO".toCharArray(),"XOOXXOOXOOOXOXOXOOXO".toCharArray(),
			"OOOXXXXOXOXXOOOOXOXO".toCharArray(),"OOOXXOOXOOOXXXOOXOOX".toCharArray(),
			"OOOOOOOXXXOOOOOOOOOO".toCharArray(),"XOOOOXOXOXXOOOOOOXOX".toCharArray(),
			"OOOXOOOXOXOXOXOXOXOX".toCharArray(),"OOOXOXOOXXOXOXXOXXXO".toCharArray(),
			"OOOOXOOXXOOOOXOOOXOX".toCharArray(),"OOXOOXOOOOOXOOXOOOXO".toCharArray(),
			"XOOXOOOOOOOXOOXOXOXO".toCharArray(),"OXOOOXOXOXXOXXXOXXOO".toCharArray(),
			"XXOXOOOOXOOOOOOXOOOX".toCharArray(),"OXOOXXXOOOXXXXXOXOOO".toCharArray(),
			"OOXXXOOOXXOOOXOXOOOO".toCharArray(),"XOOXOXOOOOXOOOXOXOXX".toCharArray(),
			"XOXOOOOOOXOOOXOXOOOO".toCharArray(),"OXXOOOXXXOXOXOXXXXOO".toCharArray(),
			"OXOOOOXXOOXOXOOXOOXX".toCharArray(),"OOOOOOXXXXOXOOOXXOOO".toCharArray()
		};
		surroundedRegions(map);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
