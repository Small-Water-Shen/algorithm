package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * ����N���˶�Ա�ĵ÷֣��ҵ����ǵ���Եȼ��ͻ����߷�ǰ�������ˣ����ǽ���ý��ƣ������ơ��������ơ��͡�ͭ�ơ���
 * ����: [5, 4, 3, 2, 1]
 * ���: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * ˵����ǰ�����˶�Ա���ǰ������߷֣���˻�á����ơ��������ơ��͡�ͭ�ơ���
 * ���ں������˶�Ա����ֻ��Ҫ�������ǵķ���������ǵ���Եȼ�
 */
public class ������� {

    public static String[] findRelativeRanks(int[] nums) {
        // write your code here
    	int len = nums.length;
    	if (nums == null || len == 0) return null;
    	String[] res = new String[len];
    	int[] temp = Arrays.copyOf(nums, len);
    	heapSort(temp, len);
    	System.out.println(Arrays.toString(temp));
    	// hash map
    	Map<Integer, String> hash = new HashMap<Integer, String>();
    	for (int i = 0; i < len; i++) {
			if (i == 0) {
				hash.put(temp[i], "Gold Medal"); 
			} else if (i == 1) {
				hash.put(temp[i], "Silver Medal");
			} else if (i == 2) {
				hash.put(temp[i], "Bronze Medal"); 
			} else {
				hash.put(temp[i], "" + (i + 1));  
			}
		}
//    	System.err.println(hash.toString());
    	for (int i = 0; i < len; i++) res[i] = hash.get(nums[i]); 
    	return res;
    }
    
	// ������
    public static void heapSort(int[] nums, int len) {
		// TODO Auto-generated method stub
		for (int i = len; i > 1; --i) {
			creatHeapOp(nums, 0, i); // �Ѷ�Ԫ����С
			swap(nums, 0, i - 1); // ����СԪ�طŵ�ĩβ
		}
	}

	// ������С��
    public static void creatHeap(int[] nums, int root, int len) {
    	int i, j;
    	// k��ʼΪ���һ����Ҷ�ӽڵ�
    	for (int k = len / 2 - 1; k >= root; --k) {
        	i = k;
        	j = 2 * i + 1; // j is left child of i
        	while (j < len) {
        		// find the smaller between left and right children
    			while (j + 1 < len && nums[j] > nums[j + 1]) ++j;
    			// swap the i with j
    			if (nums[i] > nums[j]) {
        			swap(nums, i, j);
        			// deal with subtree
        			i = j;
        			j = 2 * i + 1;
    			} else {
					break;
				}
    		}
		}
    }
    
    // ������С��, do not use swap
    public static void creatHeapOp(int[] nums, int root, int len) {
    	int i, j, t;
    	// k��ʼΪ���һ����Ҷ�ӽڵ�
    	for (int k = len / 2 - 1; k >= root; --k) {
    		i = k;
    		t = nums[i]; // temporary
    		j = 2 * i + 1; // j is left child of i
    		while (j < len) {
    			// find the smaller between left and right children
    			while (j + 1 < len && nums[j] > nums[j + 1]) ++j;
    			// swap the i with j
    			if (t > nums[j]) {
    				nums[i] = nums[j]; 
    				// deal with subtree
    				i = j;
    				j = 2 * i + 1;
    			} else break;
    		}
    		nums[i] = t; 
    	}
    }
    
    public static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(findRelativeRanks(new int[] {1, 2})));
	}

}
