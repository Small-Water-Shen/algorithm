package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * ����һ���ѡ����(C)��Ŀ������(T),�ҳ�C�����е���ϣ�ʹ��������ֵĺ�ΪT��C��ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�
 * ���е�����(����Ŀ������)��Ϊ��������
 * Ԫ�����(a1, a2, �� , ak)�����Ƿǽ���(ie, a1 �� a2 �� �� �� ak)��
 * �⼯���ܰ����ظ�����ϡ�
 * ����һ�����ӣ���ѡ���ּ���Ϊ[10,1,6,7,2,1,5] ��Ŀ������ 8  ,
 * �⼯Ϊ��[[1,7],[1,2,5],[2,6],[1,1,6]]
 */
public class �������2 {
	
    public static List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
    	List<List<Integer>> res = new ArrayList<>();
    	if (num == null || num.length == 0) {
			return res;
		}
    	Arrays.sort(num);
    	dfs(res, new ArrayList<>(), num, 0, 0, target);
    	return res;
    }
    
    // ע��ȥ�ز���
	public static void dfs(List<List<Integer>> res, ArrayList<Integer> temp, int[] num, int index, int sum, int target) {
		if (sum > target) {
			return;
		}
		if (sum == target) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = index; i < num.length; i++) {
			// ȥ��
			if (i != 0 && num[i - 1] == num[i] && i > index) {
				continue;
			}
			temp.add(num[i]);
			// i + 1 ��ֹ�ظ�Ԫ��
			dfs(res, temp, num, i + 1, sum + num[i], target);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum2(new int[] { }, 1));
	}

}
