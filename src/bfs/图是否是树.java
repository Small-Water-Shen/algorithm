package bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * ���� n ���ڵ㣬��ŷֱ�� 0 �� n - 1 ���Ҹ���һ�� ���� �ߵ��б� (����ÿ���ߵ���������), 
 * дһ������ȥ�ж����ţ������ͼ�Ƿ���һ����
 * ����Լ������ǲ�������ظ��ı��ڱߵ��б���. ����ߡ�[0, 1] �� [1, 0]����ͬһ���ߣ� 
 * ������ǲ���ͬʱ���������Ǹ���ıߵ��б���
 */
public class ͼ�Ƿ����� {

	// bfs is more efficient than dfs. 
    public static boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n - 1 != edges.length) return false;
        if ((edges == null || edges.length == 0) && n == 1) return true;
        if ((edges == null || edges.length == 0) && n >= 2) return false;
        Map<Integer, HashSet<Integer>> neighbor = initGraph(n, edges);
        // bfs
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[n];
        queue.offer(0); // start with 0, �����0��ʼû�У��Ϳ϶�������
        vis[0] = true;
        while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (!neighbor.containsKey(cur)) continue;
			for (int child : neighbor.get(cur)) {
				// �����ڽӱ�����ԣ���Ҫȥ��
				if (vis[child]) continue;
				queue.offer(child);
				vis[child] = true;
			}
		}
        for (boolean b : vis) if (!b) return false;
        return true;
    }
    
    // �����ڽӾ���
    public static Map<Integer, HashSet<Integer>> initGraph(int n, int[][] edges) {
    	Map<Integer, HashSet<Integer>> neighbor = new HashMap<>();
        for (int i = 0; i < n; ++i) {
        	neighbor.put(i, new HashSet<>());
        }
        for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			neighbor.get(u).add(v);
			neighbor.get(v).add(u);
		}
        return neighbor;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	System.out.println(validTree(5, new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
	}

}
