package union_find_sets;

import java.util.Arrays;

/*
 * ����������У�����һ�����ӵġ��޻�������ͼ��
 * ������������һ��ͼ�Σ����Ծ���N���ڵ㣨���в�ͬ��ֵ1,2��...��N��������ʼ���������һ������ıߡ� ��ӵı���������ͬ�Ķ��㣨��1��N��ѡ�񣩣����Ҳ����Ѿ����ڵıߡ�
 * �õ���ͼ���Թ��ڱߵ� 2D-�������ʽ������ �ߵ�ÿ��Ԫ����һ��[u��v]������u <v�����ʾ���ӽڵ�u��v������ߡ�
 * ����Ҫ�������ɾ���ıߣ��Ա����ɵ�ͼ��һ��N���ڵ������ ����ж���𰸣��򷵻ظ���2D�����������ֵĴ𰸱ߡ� �𰸱�[u��v]Ӧ�ò�����ͬ�ĸ�ʽ��u <v��
 * ����2D����Ĵ�С������3��1000֮�䡣
 * 2D�����е�ÿ����������1��N֮�䣬����N����������Ĵ�С��
 */
public class ��������� {

    public static int[] findRedundantConnection(int[][] edges) {
        // write your code here
    	if (edges == null || edges.length == 0) return new int[] {};
    	int n = edges.length; // n��nodes
    	int[] pre = new int[n + 1];
    	int[] res = new int[2];
    	for (int i = 1; i <= n; i++) pre[i] = i;
    	for (int i = 0; i < n ; i++) {
			if (!union(pre, edges[i][0], edges[i][1])) {
				res[0] = edges[i][0];
				res[1] = edges[i][1];
			}
		}
    	return res;
    }
    
    public static int find(int[] pre, int x) {
    	if (x == pre[x]) return x;
    	return pre[x] = find(pre, pre[x]); 
    }
    
    public static boolean union(int[] pre, int x, int y) {
    	int a = find(pre, x);
    	int b = find(pre, y);
    	if (a == b) return false;
    	pre[a] = b;
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = new int[][] { {1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5} };
		System.out.println(Arrays.toString(findRedundantConnection(edges)));
	}

}
