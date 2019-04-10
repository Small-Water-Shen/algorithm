package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * ����һ����n������������S����S���ҵ���������a, b, c���ҵ�����ʹ��a + b + c = 0����Ԫ�顣
 * ����Ԫ��(a, b, c)��Ҫ��a <= b <= c��
 * ������ܰ����ظ�����Ԫ�顣
 * ����:[-1,0,1,2,-1,-4]
 * ���:[[-1, 0, 1],[-1, -1, 2]]
 */
public class ����֮�� {

	public static List<List<Integer>> threeSum(int[] numbers) {
		// write your code here
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numbers == null || numbers.length == 0) return res;
		// sort
		Arrays.sort(numbers);
//    	detector(numbers, res);
		detectorOp(numbers, res);
		return res;
	}

	// �Ż�
	public static void detectorOp(int[] numbers, List<List<Integer>> res) {
		// TODO Auto-generated method stub
		int len = numbers.length;
		List<Integer> temporary;
		for (int p = 0; p < len; p++) {
			// ��Ϊ���򣬵�ǰ����positive number��������Ȼ����positive��
			if (numbers[p] > 0) break;
			// ȥ��
			if (p > 0 && numbers[p] == numbers[p - 1]) continue;
			// ǰ������ָ����
			int i = p + 1, j = len - 1;
			int target = 0 - numbers[p];
			while (i < j) {
				if (numbers[i] + numbers[j] == target) {
					temporary = new ArrayList<Integer>();
					temporary.add(numbers[p]);
					temporary.add(numbers[i]);
					temporary.add(numbers[j]);
					res.add(temporary);
					// ȥ��
					while (i < j && numbers[i] == numbers[i + 1]) ++i;
					while (i < j && numbers[j] == numbers[j - 1]) --j;
					++i;
					--j;
				} else if (numbers[i] + numbers[j] < target) ++i;
				else --j;
			}
		}
	}

	// ����forѭ��+ȥ��
	public static void detector(int[] numbers, List<List<Integer>> res) {
		// TODO Auto-generated method stub
		int len = numbers.length;
		List<Integer> temporary;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				for (int k = j + 1; k < len; k++) {
					if (numbers[i] + numbers[j] + numbers[k] == 0) {
						temporary = new ArrayList<Integer>();
						temporary.add(numbers[i]);
						temporary.add(numbers[j]);
						temporary.add(numbers[k]);
						if (!res.contains(temporary)) res.add(temporary);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSum(new int[] { 1, 0, -1, -1, -1, -1, 0, 1, 1, 1 }).toString());
	}
	
}
