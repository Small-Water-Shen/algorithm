package array;

import java.util.Arrays;

/*
 * ��һ������ n ������������ S, �ҵ������������ target ��ӽ�����Ԫ�飬�������������ĺ͡�
 * ֻ��Ҫ������Ԫ��֮�ͣ����践����Ԫ�鱾��
 * ����:[-1,2,1,-4],1
 * ���:2 ����:-1+2+1=2
 * O(n^2) ʱ��, O(1) ����ռ䡣
 */
public class ��ӽ�������֮�� {

    public static int threeSumClosest(int[] numbers, int target) {
        // write your code here
    	if (numbers == null || numbers.length < 3) return 0;
    	int sum = numbers[0] + numbers[1] + numbers[2], len = numbers.length;
    	// sort
    	Arrays.sort(numbers);
    	// two points
    	for (int k = 0; k < len; k++) {
    		int i = k + 1, j = len - 1;
    		while (i < j) {
    			int s = numbers[k] + numbers[i] + numbers[j]; 
    			if (Math.abs(target - s) < Math.abs(target - sum)) sum = s;
    			if (s > target) --j;
    			else if (s < target) ++i;
    			else return s;
			}
		}
    	return sum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSumClosest(new int[] { 1,0,-1,0,-2,2,21,-15 }, -20));
	}

}
