package array;

import java.util.Arrays;

/*
 * ����һ��δ����������飬���ҳ������������������Ҫ�ص�����ࡣ
 * ��������е�Ҫ������ 2 �����뷵�� 0. ���Լٶ������е�����Ҫ�ض��ǷǸ�����������󲻳��� 32 λ������
 * �������� [1, 9, 2, 5]���������Ϊ [1, 2, 5, 9]�������ļ������ 5 �� 9 ֮�䣬= 4.
 * ������ķ��������������ǱȽϼ򵥵ķ��������������ʱ�临�Ӷ���O(nlogn), 
 * �ܷ�ʹ�����Ե�ʱ��Ϳռ临�Ӷȵķ�������������
 */
public class ����� {
	
    public static int maximumGap(int[] nums) {
        // write your code here
    	if (nums == null || nums.length < 2) return 0;
    	return sortMethod(nums);
    }


	private static int sortMethod(int[] nums) {
		// TODO Auto-generated method stub
		return bucketSort(nums);
//		Arrays.sort(nums);
//		int max = 0;
//		for (int i = 1; i < nums.length; i++) {
//			int value = nums[i] - nums[i - 1];
//			max = (value > max) ? value : max;
//		}
//		return max;
	}
	
	// bucket sort, less time, more memery
	public static int bucketSort(int[] nums) {
		// find minimum and maximum
		int max = nums[0], min = nums[0], len = nums.length;
		for (int i : nums) {
			max = (max < i) ? i : max;
			min = (min > i) ? i : min;
		}
		// counts of bucket 
		int bucketNum = len - 1;
		// capacity of every bucket
		int bucketCapacity = (max - min) / bucketNum + 1;
		// create buckets
		int[] bucketMax = new int[bucketNum];
		int[] bucketMin = new int[bucketNum];
		// initialize
		Arrays.fill(bucketMax, Integer.MIN_VALUE);
		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		// put number into bucket
		for (int i : nums) {
	        // skip the minimum and maximum
            if (i == min || i == max) continue;
            int index = (i - min) / bucketCapacity;
            bucketMin[index] = Math.min(i, bucketMin[index]);
            bucketMax[index] = Math.max(i, bucketMax[index]);
		}
        // �Ƚ����gap����ΪmaxGap�϶����������ͬindex��bucket��(uniform capacity)
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < bucketNum; i++) {
            // empty
            if (bucketMax[i] == Integer.MIN_VALUE || bucketMin[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - previous);
            previous = bucketMax[i];
        }
        // last update
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maximumGap(new int[] { 1, 9, 2, 5 }));
	}

}
