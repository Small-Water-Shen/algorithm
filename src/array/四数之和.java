package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * ��һ������n��������������S����S���ҵ�����ʹ�ú�Ϊ��������target����Ԫ��(a, b, c, d)��
 * ��Ԫ��(a, b, c, d)�У���Ҫ����a <= b <= c <= d
 * ���в����԰����ظ�����Ԫ��
 * ����:[1,0,-1,0,-2,2],0
 * ���:
 * [[-1, 0, 0, 1]
 * ,[-2, -1, 1, 2]
 * ,[-2, 0, 0, 2]]
 */
public class ����֮�� {

    public static List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numbers == null || numbers.length == 0) return res;
		// sort
		Arrays.sort(numbers);
		detectorOp(numbers, target, res);
		return res;
    }
    
	public static void detectorOp(int[] numbers, int target, List<List<Integer>> res) {
		// TODO Auto-generated method stub
		int len = numbers.length;
		List<Integer> temp;
		for (int n = 0; n < len - 1; n++) {
			for (int m = n + 1; m < len; m++) {
				int i = m + 1, j = len - 1;
				int remain = target - numbers[n] - numbers[m];
				while (i < j) {
					if (numbers[i] + numbers[j] == remain) {
						temp = new ArrayList<Integer>();
						temp.add(numbers[n]);
						temp.add(numbers[m]);
						temp.add(numbers[i]);
						temp.add(numbers[j]);
						if (!res.contains(temp)) res.add(temp);
						// ȥ��
						while (i < j && numbers[i] == numbers[i + 1]) ++i;
						while (i < j && numbers[j] == numbers[j - 1]) --j;
						++i;
						--j;
					} else if (numbers[i] + numbers[j] < remain) {
						++i;
					} else {
						--j;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, -2));
	}

}
