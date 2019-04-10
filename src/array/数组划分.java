package array;

import java.util.Arrays;

/*
 * ����һ���������� nums ��һ������ k���������飨���ƶ����� nums �е�Ԫ�أ���ʹ�ã�
 * ����С��k��Ԫ���Ƶ����
 * ���д��ڵ���k��Ԫ���Ƶ��ұ�
 * �������黮�ֵ�λ�ã��������е�һ��λ�� i������ nums[i] ���ڵ��� k��
 * ����:
 * [3,2,2,1],2
 * ���:1 ����: ��ʵ������Ϊ[1,2,2,3].���Է��� 1
 * ʹ�� O(n) ��ʱ�临�Ӷ��������Ͻ��л��֡�
 * ��Ӧ�������Ļ������� nums����������ֻ�Ǽ���� k С����������������� nums �е�����Ԫ�ض��� k С���򷵻� nums.length��
 */
public class ���黮�� {
	
    public static int partitionArray(int[] nums, int k) {
        // write your code here
    	int c = sort(nums, 0, nums.length - 1, k);
    	System.out.println(Arrays.toString(nums));
    	return c;
//    	return twoPoints(nums, k);
    }

    public static int twoPoints(int[] nums, int k) {
		// TODO Auto-generated method stub
    	int left = 0, right = nums.length - 1;
    	while (left <= right) {
			if (left <= right && nums[left] < k) ++left;
			else if (left <= right && nums[right] >= k) --right;
			else if (left <= right) swap(nums, left, right);
			else if (nums[left] < k) ++left;
		}
		return left;
	}

	// ����˼��
	public static int sort(int[] nums, int left, int right, int k) {
		// TODO Auto-generated method stub
		int i = left, j = right;
		while (i < j) {
			while (i < j && k <= nums[j]) --j;
			while (i < j && k > nums[i]) ++i;
			if (i < j) swap(nums, i, j);
			else if (nums[i] < k) i++;
		}
		return i;
	}

	public static void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int t = nums[i];
		nums[i++] = nums[j]; 
		nums[j--] = t; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partitionArray(new int[] { 7, 7, 9, 8, 6, 6, 8, 7, 9, 8, 6, 6 }, 10));
	}

}
