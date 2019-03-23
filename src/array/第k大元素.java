package array;

import java.util.Arrays;

/*
 * ���������ҵ��� k ���Ԫ�ء�
 * ����Խ��������е�Ԫ�ص�λ��
 * Ҫ��ʱ�临�Ӷ�ΪO(n) ������ʹ�ÿ��ţ�ʱ�临�Ӷ�̫�ߣ�
 * �ռ临�Ӷ�ΪO(1)��(��˲���ά��һ������Ϊk������) 
 */
public class ��k��Ԫ�� {
	
	/*
	 * ���ÿ���˼�뺯����
	 * ���ҵ�һ��������ʹ������Ķ�������ߣ�����С�Ķ��������ұߣ����߿���������󷵻����������λ��
	 * Ȼ��Ƚ����������λ����n-1�Ĵ�С���������n-1������������ǵ�k�����
	 * �����������λ��С��n-1,�������Ұ벿����
     * �������λ�ô���n-1,��������벿����
	 */
    public static int kthLargestElement(int n, int[] nums) {
        // write your code here
    	int a = quickSort(nums, 0, nums.length - 1, n);
    	// ����
    	System.out.println(Arrays.toString(nums));
    	return a;
    }
    
    public static int quickSort(int[] nums, int start, int end, int n) {
    	int temp = nums[start];
    	int i = start, j = end;
    	while (i < j) {
    		// find j which less than temp
    		while (i < j && nums[j] <= temp) j--;
    		if (i < j) nums[i++] = nums[j]; 
    		// find i which more than temp
    		while (i < j && nums[i] > temp) i++;
    		if (i < j) nums[j--] = nums[i]; 
    	}
    	if (i == n - 1) return temp;
    	if (i >= n - 1) return quickSort(nums, start, i - 1, n);	
    	return quickSort(nums, i + 1, end, n);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(kthLargestElement(3, new int[] { 9, 3, 2, 4, 8 }));
	}

}