package violence;

import java.util.Arrays;
import java.util.Comparator;

/*
 * ����һ���������飬�ҵ�һ������ӽ�����������顣���ص�һ��������һ��ָ����
 * ��Ĵ���Ӧ�÷�������Ҫ������������ʼλ�úͽ���λ��
 * ����[-3, 1, 1, -3, 5]������[0, 2]��[1, 3]�� [1, 1]�� [2, 2] ���� [0, 4]��
 * O(nlogn)��ʱ�临�Ӷ�
 */
public class ��ӽ����������� {
	
	// �洢ǰindex��Ԫ�صĺ�sum
	public static class pair {
		int sum;
		int index;
		public pair(int sum, int index) {
			this.index = index;
			this.sum = sum;
		}
	}

	/* ǰ׺��+��ȡ��
	 * array: -3  1  1  -3  5
	 * pair : -3 -2 -1  -4  1
	 * pair[2]=-2��ʾǰ2��֮��Ϊ-2, ��ʼpair[0]=0
	 * ��Ҫ��2��4�����pair[4]-pair[1]��ʾ
	 * �����������ĺͣ�����Ԥ����
	 * ���������ҳ�һ�����䣬���������ĺʹ��ڵ���t��ʱ��ֹͣ����Ϊ�����Ҳ�ֵ�͸����ˡ�
	 * Ȼ�����ƶ���˵��Լ�������ĺ͡�
	 */
    public static int[] subarraySumClosest(int[] nums) {
        // write your code here
    	if (nums == null || nums.length == 0) return new int[] {};
    	int len = nums.length;
    	int[] res = new int[2]; // store the minimum index of start and end
    	pair[] pairs = new pair[len + 1];
    	// initialize
    	pairs[0] = new pair(0, 0);
    	// ���ǰi��֮��
    	for (int i = 1; i <= len; i++) pairs[i] = new pair(pairs[i - 1].sum + nums[i - 1], i); 
    	// sort by sum, ascending order
    	Arrays.sort(pairs, new Comparator<pair>() {
			public int compare(pair o1, pair o2) { return o1.sum - o2.sum; }
		});
    	// find minimum value
    	int min = Integer.MAX_VALUE, l = 0, r = 1;
    	while (r <= len) {
    		// �����pairs[i]-pairs[i-1]һ��������
    		int v = pairs[r].sum - pairs[l].sum;
			if (min > v) {
				min = v; // update
				// index-1���õ���ʵindex
				// �磺pair[4]-pair[1]��ʾ��ʵ��1~3�±�
				res[0] = pairs[l].index - 1;
				res[1] = pairs[r].index - 1;
		    	// ����˳��
		    	if (res[0] > res[1]) {
		    		int t = res[0];
		    		res[0] = res[1];
		    		res[1] = t;
		    	}
		    	// ���index��Ҫ+1�õ���ʵ���
		    	res[0]++;
			}
			if (v < 0) ++r;
			else if (v > 0) ++l;
			else break;
			if (l == r) ++r;
		}
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(subarraySumClosest(new int[] { 101, 33, 44, 55, 67, 78, -101, 33, -44, 55, -67, 78, -100, 200, -1000, 22, 100, 200, 1000, 22 })));
	}

}
