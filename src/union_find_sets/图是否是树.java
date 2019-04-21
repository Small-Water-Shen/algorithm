package union_find_sets;

/*
 * ���� n ���ڵ㣬��ŷֱ�� 0 �� n - 1 ���Ҹ���һ�� ���� �ߵ��б� (����ÿ���ߵ���������), 
 * дһ������ȥ�ж����ţ������ͼ�Ƿ���һ����
 * ����Լ������ǲ�������ظ��ı��ڱߵ��б���. ����ߡ�[0, 1] �� [1, 0]����ͬһ���ߣ� 
 * ������ǲ���ͬʱ���������Ǹ���ıߵ��б���
 */
public class ͼ�Ƿ����� {

    public static boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n - 1 != edges.length) return false;
        int[] pre = new int[n];
        for (int i = 1; i < n; ++i) {
            pre[i] = i;
        }
        for (int i = 0; i < edges.length; ++i) {
            if (!union(pre, edges[i][0], edges[i][1])) {
                return false;
            }
        } 
        return true;
    }
    
    public static int find(int[] pre, int x) {
        if (pre[x] == x) return x;
        return pre[x] = find(pre, pre[x]);
    }

    private static boolean union(int[] pre, int i, int j) {
        int a = find(pre, i);
        int b = find(pre, j);
        if (a != b) {
            pre[a] = b;
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	System.out.println(validTree(5, new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
	}

}
