package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * ����һ����ѡ���ֵ�set(C)��Ŀ������(T),�ҵ�C�����е���ϣ�ʹ�ҳ������ֺ�ΪT��C�е����ֿ����������ظ���ѡȡ��
 * ���е�����(����Ŀ������)��Ϊ��������
 * Ԫ�����(a1, a2, �� , ak)�����Ƿǽ���(ie, a1 �� a2 �� �� �� ak)��
 * �⼯���ܰ����ظ�����ϡ�
 * ������ѡset[2,3,6,7]��Ŀ������7
 * ���� [[7],[2,2,3]]
 */
public class ������� {
	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
    	List<List<Integer>> res = new ArrayList<>();
    	if (candidates == null || candidates.length == 0) {
			return res;
		}
    	Arrays.sort(candidates);
    	dfs(res, new ArrayList<>(), candidates, 0, 0, target);
    	return res;
    }

	public static void dfs(List<List<Integer>> res, ArrayList<Integer> temp, int[] candidates, int index, int sum, int target) {
		if (sum > target) {
			return;
		}
		if (sum == target) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (i != 0 && candidates[i - 1] == candidates[i] && i > index) {
				continue;
			}
			temp.add(candidates[i]);
			// ����i����ʹ���ظ�Ԫ��
			dfs(res, temp, candidates, i, sum + candidates[i], target);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum(new int[] { 2, 2, 3 }, 5));
	}

}
