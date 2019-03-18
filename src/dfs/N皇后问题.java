package dfs;

import java.util.ArrayList;
import java.util.List;

/*
  * n�ʺ������ǽ�n���ʺ������n*n�������ϣ��ʺ�˴�֮�䲻���໥������
  * ����һ������n���������в�ͬ��n�ʺ�����Ľ��������
  * ÿ�������������һ����ȷ��n�ʺ���ò��֣����С�Q���͡�.���ֱ��ʾһ��Ů����һ����λ�á� 
 * ����:4
 * ���:
[
  // Solution 1
  [".Q..",
   "...Q",
   "Q...",
   "..Q."
  ],
  // Solution 2
  ["..Q.",
   "Q...",
   "...Q",
   ".Q.."
  ]
]
  */
public class N�ʺ����� {
	
	static int count = 0;
	
    public static List<List<String>> solveNQueens(int n) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	int[] queens = new int[n + 1]; // ����Ϊ��, ֵΪ��
    	solve(result, queens, n, 1);
    	return result;
    }
    
    public static void solve(List<List<String>> result, int[] queens, int n, int pos) {
    	if (pos > n) {
			// add to result
    		List<String> tmp = new ArrayList<String>();
    		String str;
    		for (int i = 1; i <= n; i++) {
    			str = "";
				for (int j = 1; j <= n; j++) {
					str += (j == queens[i]) ? "Q" : "."; 
				}
				tmp.add(String.valueOf(str));
			}
    		result.add(tmp);
    		count++;
			return;
		}
    	// ���õ���
    	for (int j = 1; j <= n; j++) {
    		// �ж��Ƿ���Է���
			if (check(queens, pos, j)) {
				queens[pos] = j;
				solve(result, queens, n, pos + 1);
				queens[pos] = 0; // ���� 
			}
		}
    }
    
    // iΪ��Ҫ���õ�����, jΪ��Ҫ���õ�����
    public static boolean check(int[] queens, int i, int j) {
    	// k < i : �����ѷ��õ�queens
    	for (int k = 1; k < i; k++) {
    		// ͬ��
			if (queens[k] == j) {
				return false;
			}
			// ͬ�Խ���
			if (Math.abs(k - i) == Math.abs(queens[k] - j)) {
				return false;
			}
		}
    	return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solveNQueens(4).toString());
		System.out.println(count);
	}

}
