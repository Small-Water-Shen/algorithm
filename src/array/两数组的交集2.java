package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * �����������飬������������Ľ���
 * ÿ��Ԫ�س��ִ����ú���������һ��,�𰸿���������˳�����
 * nums1 = [1, 2, 2, 1], nums2 = [2, 2]
 * ���: [2, 2]
 * nums1 = [1, 1, 2], nums2 = [1]
 * ���: [1]
 * -��������������Ѿ���������ô��?����Ż��㷨?
 * -���nums1�Ĵ�С��num2��С��ô��?�����㷨����?
 * -���nums2��Ԫ�ش洢�ڴ����ϣ������ڴ��ܵ����ƣ������ڲ���һ�ν�����Ԫ�ؼ��ص��ڴ��У�����ô��?
 */
public class ������Ľ���2 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
//    	return hashDetector(nums1, nums2);
    	return twoPoints(nums1, nums2);
//    	return counter(nums1, nums2);
    }

    /* ������, ���nums2��Ԫ�ش洢�ڴ����ϣ������ڴ��ܵ����ƣ������ڲ���һ�ν�����Ԫ�ؼ��ص��ڴ���
     * ���Ƚ�nums1�����ã��ٻ����ȡnums2������
     */
	public static int[] counter(int[] nums1, int[] nums2) {
		// TODO Auto-generated method stub
		int[] counters = new int[nums1.length];
		int[] temporary = new int[nums1.length];
		int t = 0;
		for (int i : nums1) {
			counters[i]++;
		}
		for (int i : nums2) {
			if (counters[i] != 0) {
				temporary[t++] = i;
				counters[i]--; 
			}
		}
		int[] res = new int[t];
		for (int i = 0; i < t; i++) {
			res[i] = temporary[i]; 
		}
		return res;
	}

	// ˫ָ�뷢��more efficient
	public static int[] twoPoints(int[] nums1, int[] nums2) {
		// TODO Auto-generated method stub
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	int p1 = 0, p2 = 0, t = 0;
    	int[] temporary = new int[nums1.length];
    	while (p1 < nums1.length && p2 < nums2.length) {
    		if (nums1[p1] == nums2[p2]) {
				temporary[t++] = nums1[p1];
				++p1;
				++p2;
			} else if (nums1[p1] < nums2[p2]) {
				++p1;
			} else {
				++p2;
			}
    	}
    	int[] res = new int[t];
    	for (int i = 0; i < t; i++) {
			res[i] = temporary[i]; 
		}
		return res;
	}

	// hash map
	public static int[] hashDetector(int[] nums1, int[] nums2) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for (int i : nums1) {
			Integer value = hash.get(i);
			hash.put(i, (value == null) ? 1 : value + 1);
		}
		for (int i : nums2) {
			if (hash.containsKey(i) && hash.get(i) != 0) {
				result.add(i);
				hash.put(i, hash.get(i) - 1);
			}
		}
		int[] res = new int[result.size()];
		int p = 0;
		for (int i : result) {
			res[p++] = i;
		}			
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(intersection(new int[] {1, 2, 2, 1}, new int[] {2,2})));
	}

}
