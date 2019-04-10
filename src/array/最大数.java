package array;

/*
 * ����һ��Ǹ������������������ǵ�˳����������һ������������
 * ���Ľ�����ܴܺ��������Ƿ���һ���ַ������������������
 * ����:[1, 20, 23, 4, 8]
 * ���:"8423201"
 * �� O(nlogn) ��ʱ�临�Ӷ�����ɡ�
 */
public class ����� {

    public static String largestNumber(int[] nums) {
        // write your code here
    	String res = "";
    	sort(nums, 0, nums.length - 1);
    	for (int i : nums) {
    		if (res.equals("0") && i == 0) 	break;
    		res += i;
    	}
    	return res;
    }
    
	public static void sort(int[] nums, int low, int high) {
		// TODO Auto-generated method stub
		if (low >= high) return;
		int i = low, j = high, r = nums[low];
		while (i < j) {
			while (i < j && compare(r, nums[j]) >= 0) --j;
			if (i < j) nums[i++] = nums[j];  
			while (i < j && compare(r, nums[i]) <= 0) ++i;
			if (i < j) nums[j--] = nums[i]; 
		}
		nums[i] = r;
		sort(nums, low, i - 1);
		sort(nums, i + 1, high);
	}

	// ��: �Ƚ�23��8��������ֵ => 823 > 238
	public static int compare(int t1, int t2) {
		// TODO Auto-generated method stub
		String s1 = "" + t1 + t2;
		String s2 = "" + t2 + t1;
		return s1.compareTo(s2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(largestNumber(new int[] { 1, 20, 23, 4, 8 }));
	}

}
