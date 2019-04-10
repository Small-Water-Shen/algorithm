package array;

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

	/* array: -3  1  1  -3  5
	 * pair : -3 -2 -1  -4  1
	 * pair[2]=-2��ʾǰ2��֮��Ϊ-2, ��ʼpair[0]=0
	 * ��Ҫ��2��4�����pair[4]-pair[1]��ʾ
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
    	for (int i = 1; i <= len; i++) {
			pairs[i] = new pair(pairs[i - 1].sum + nums[i - 1], i); 
		}
    	// sort by sum, ascending order
    	Arrays.sort(pairs, new Comparator<pair>() {
			@Override
			public int compare(pair o1, pair o2) {
				// TODO Auto-generated method stub
				return o1.sum - o2.sum;
			}
		});
    	// find minimum value
    	int min = Integer.MAX_VALUE;
    	for (int i = 1; i <= len; i++) {
    		// ������pairs��pairs[i]-pairs[i-1]һ��������
			if (min > pairs[i].sum - pairs[i - 1].sum) {
				// update
				min = pairs[i].sum - pairs[i - 1].sum;
				// index-1���õ���ʵindex
				int[] temp = new int[] {pairs[i].index - 1, pairs[i - 1].index - 1};
				// ��֤index������
				Arrays.sort(temp);
				/* ���index��Ҫ+1�õ���ʵ���
				 * �磺pair[4]-pair[1]��ʾ��ʵ��1~3�±�
				 */
				res[0] = temp[0] + 1;
				res[1] = temp[1];
			}
		}
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(subarraySumClosest(new int[] { -3, 1, 1, -3, 5 })));
	}

}
