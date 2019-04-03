package array;

import java.util.Arrays;

/*
 * ����һ��û����������飬�뽫ԭ����͵���������������������
 * nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * ��͵��������飬��Ҫ���ⶨ������.
 * ����: [3, 5, 2, 1, 6, 4]
 * ���: [1, 6, 2, 5, 3, 4]
 * ����: �����������ж��ִ�, [2, 6, 1, 5, 3, 4] ͬ������.
 * ����: [1, 2, 3, 4]
 * ���: [2, 1, 4, 3]
 */
public class �ڶ����� {
	
    public static void wiggleSort(int[] nums) {
        // write your code here
    	int len = nums.length;
    	if (len <= 1) {
    		return;
    	}
    	if (len == 2) {
    		swap(nums, 0, 1);
    		return;
    	}
//    	func1(nums, len);
    	func2(nums, len);
    }
    
    
    /* ˼·2�� �ҹ���, ����Ҫ�����ڵ�ż��С��ż��Ҫ�����ڵ�������
     * ��lenΪ����ʱ�����㣺 nums[0] <= nums[1] >= nums[2] <= nums[3] >= nums[4] 
     * ��lenΪż��ʱ�����㣺 nums[0] => nums[1] <= nums[2] >= nums[3] 
     * ����iΪż��ʱ����Ҫ����nums[i-1] <= nums[i]
     *   ��iΪ����ʱ����Ҫ����nums[i-1] => nums[i]
     */
    public static void func2(int[] nums, int len) {
		for (int i = 1; i < len; i++) {
			if ((i & 1) == 1 && nums[i - 1] > nums[i]
					|| (i & 1) == 0 && nums[i - 1] < nums[i]) {
				swap(nums, i - 1, i);
			}
		}
	}

	// ˼·1�� ������ã��ٴ�1��ʼ��������,ʱ�临�Ӷ�ΪO(nlogn)
    public static void func1(int[] nums, int len) {
    	quickSort(nums, 0, len - 1);
    	// ��������
    	for (int i = 0; i < len - 1; i += 2) {
			swap(nums, i, i + 1);
		}
    }

	public static void quickSort(int[] nums, int low, int high) {
		if (low >= high) return;
		int i = low, j = high, r = nums[i];
		while (i < j) {
			while (i < j && r <= nums[j]) --j;
			if (i < j) nums[i++] = nums[j]; 				
			while (i < j && r > nums[i]) ++i;				
			if (i < j) nums[j--] = nums[i]; 
		}
		nums[i] = r;
		quickSort(nums, low, i - 1);
		quickSort(nums, i + 1, high);
	}
	
	public static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j]; 
		nums[j] = t; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 3, 5, 2, 1, 6, 4 };
		wiggleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
