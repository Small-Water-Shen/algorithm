package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * ����һ�������ظ����ֵ��б��ҳ��б����в�ͬ������
 * ���룺[1,1]
 * �����
 * [
   [1,1]
 * ]
 * ���룺[1,2,2]
 * �����
 * [
   [1,2,2],
   [2,1,2],
   [2,2,1]
 * ]
 */
public class ���ظ�Ԫ�ص����� {
	
    public static List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
    	int size = nums.length;
    	// sort
    	Arrays.sort(nums);
    	List<List<Integer>> result = new ArrayList<>();
		boolean[] vis = new boolean[size];
    	permute(nums, vis, size, new LinkedList<>(), result);
    	return result;
    }

    // �ݹ�
	public static void permute(int[] nums, boolean[] vis, int size, LinkedList<Integer> tmp, List<List<Integer>> result) {
		// TODO Auto-generated method stub
		if (tmp.size() >= size) {
			// ����Ҫ������µ��ڴ�,��Ȼoneֻ�ǵ���permute()֮ǰ��null
			result.add(new ArrayList<>(tmp));
			return;
		}
		for (int i = 0; i < size; i++) {
			// fliter repeat elements
			if (vis[i] || i > 0 && !vis[i - 1] && nums[i - 1] == nums[i]) {
				continue;
			}
			else {
				tmp.add(nums[i]);
				vis[i] = true;
				permute(nums, vis, size, tmp, result);
				vis[i] = false;
				tmp.remove(tmp.size() - 1); // delete last element
			}
		}
	}
	
	// �ǵݹ�

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 0, 3, 3};
		List<List<Integer>> result = permuteUnique(arr);
		System.out.println(result.toString());
	}

}
