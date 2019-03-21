package string;

import java.util.ArrayList;
import java.util.List;

public class ȫ���� {
	
    public static List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        
        // ********recurion***********
//        recurion(res, nums, 0, nums.length - 1);
        
        // ********�ֵ�����**********
        int sum = 1, len = nums.length, temp = len;
        while (temp > 0) {
			sum *= temp--;
		}
        for (int i = 0; i < sum; i++) {
			if (i != 0) {
				dictionary(nums, len);
			}
			res.add(getList(nums));
		}
        return res;
    }

    /*
     * �� 21453, �ȴ��������ҵ��������λx
     * ���ҵ��ұ�һϵ����������С�ĵ��Ǳ�x�����y
     * ����x,y. �ٽ�x����ķ�ת���ɵ�23145
     */
    public static void dictionary(int[] nums, int len) {
		int x = len - 2;
		while (x >= 0 && nums[x] > nums[x + 1]) {
			x--;
		}
		// over
		if (x < 0) {
			return;
		}
		int y = len - 1;
		while (y > x && nums[x] > nums[y]) {
			y--;
		}
		swap(nums, x, y);
		reverse(nums, x + 1, len - 1);
	}

	public static void recurion(List<List<Integer>> res, int[] nums, int start, int end) {
        if (start == end) {
            List<Integer> t = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                t.add(nums[i]);
            }
            res.add(t);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            recurion(res, nums, start + 1, end);
            swap(nums, i, start);
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
    
    public static void reverse(int[] nums, int start, int end) {
    	while (start < end) {
			int t = nums[start];
			nums[start++] = nums[end];
			nums[end--] = t;
		}
    }
    
    public static List<Integer> getList(int[] nums) {
    	List<Integer> res = new ArrayList<>();
    	for (int i = 0; i < nums.length; i++) {
			res.add(nums[i]);
		}
    	return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permute(new int[] {0, -1, 1}).toString());
	}

}
