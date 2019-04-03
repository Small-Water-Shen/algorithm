package array;

import java.util.Arrays;

/*
 * ����һ��δ������������飬�ҵ�����λ����
 * ��λ���������������м�ֵ���������ĸ�����ż�������򷵻����������ĵ�N/2����
 * �����С������10000
 */
public class ��λ�� {
	
    public static int median(int[] nums) {
        // write your code here
    	int len = nums.length;
    	if (len <= 2) return nums[0];
    	int mid = len / 2; 
    	// ��λ����λ��
    	mid += ((len & 1) == 1) ? 1 : 0;
    	return quickSort(nums, 0, len - 1, mid - 1);
    }
    
	public static int quickSort(int[] nums, int low, int high, int mid) {
		int i = low, j = high, r = nums[low];
		while (i < j) {
			while (i < j && r <= nums[j]) --j;
			if (i < j) nums[i++] = nums[j];
			while (i < j && r > nums[i]) ++i;
			if (i < j) nums[j--] = nums[i];
		}
		if (i > mid) return quickSort(nums, low, i - 1, mid);
		else if (i < mid) return quickSort(nums, i + 1, high, mid);
		return r;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { -1,-2,-3,-100,-1,-50 };
		System.out.println(median(arr));
		System.out.println(Arrays.toString(arr));
	}

}
