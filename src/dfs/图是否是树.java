package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        if ((edges == null || edges.length == 0) && n == 1) return true;
        if ((edges == null || edges.length == 0) && n >= 2) return false;
        // �����ڽӾ���
        Map<Integer, ArrayList<Integer>> neighbor = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
        	if (neighbor.containsKey(edges[i][0])) {
	        	neighbor.get(edges[i][0]).add(edges[i][1]);
			} else {
				ArrayList<Integer> t = new ArrayList<>();
				t.add(edges[i][1]);
	        	neighbor.put(edges[i][0], t);
			}
          	if (neighbor.containsKey(edges[i][1])) {
	        	neighbor.get(edges[i][1]).add(edges[i][0]);
			} else {
				ArrayList<Integer> t = new ArrayList<>();
				t.add(edges[i][0]);
	        	neighbor.put(edges[i][1], t);
			}
        }
        System.out.println(neighbor.toString());
        // �����������
        boolean[] vis = new boolean[n];
        /* 
         * dfs�����ڽӵ㣬����ظ�����˵���϶�����
         * ��0��ʼ�������0��ʼû�У��Ϳ϶�������
         */
        if (dfs(neighbor, vis, -1, 0)) return false;
        // ʣ��û�з��ʵ��ľ��ǵ�����һ�ɵ���(������)
        for (boolean i : vis) if (!i) return false;			
        return true;
    }
    
    // true is cycle(not tree)
    public static boolean dfs(Map<Integer, ArrayList<Integer>> neighbor, boolean[] vis, int parent, int child) {
    	if (vis[child]) return true;
    	vis[child] = true;
    	if (!neighbor.containsKey(child)) return false;
    	for (int value : neighbor.get(child)) {
    		// �ų�parent==value�������ڽӾ��������
			if (parent != value && dfs(neighbor, vis, child, value)) return true;
		}
    	return false;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	System.out.println(validTree(5, new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
	}

}
