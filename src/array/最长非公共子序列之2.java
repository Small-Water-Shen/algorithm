package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
 * ����һ���ַ���������Ҫ�ҵ������ַ�������ķǹ��������С���ķǹ��������б�����Ϊ��Щ�ַ���֮һ��������У����Ҵ������в�Ӧ���������ַ����������С�
 * �������ǿ���ͨ��ɾ��һЩ�ַ������ı�����Ԫ�ص�˳���һ�����е��������С�����˵���κ��ַ�����������������У����ַ������κ��ַ����������С�
 * ���뽫���ַ����б������Ҫ����ķǹ��������еĳ��ȡ� �����ķǹ��������в����ڣ��򷵻�-1��
 */
public class ��ǹ���������֮2 {

    public static int findLUSlength(String[] strs) {
        // write your code here
    	if (strs == null || strs.length < 2) return -1;
    	// establish hash
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	for (String item : strs) {
    		if (!map.containsKey(item)) {
    			map.put(item, 1);
			} else {
				map.put(item, map.get(item) + 1);
			}
		}
    	// order by length of strings
    	Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.length() - o1.length();
			}
		});
    	System.out.println(Arrays.toString(strs));
    	int max = -1;
    	for (int i = 1; i < strs.length; i++) {
    		// �˴���ȥ�ز��ܵ�������
			if (map.get(strs[i]) <= 1 && check(strs, i)) {
				max = (strs[i].length() > max) ? strs[i].length() : max;
			} 
			// ȡ��һ��
			else if (i == 1 && map.get(strs[0]) <= 1) {
				max = strs[0].length();
			}
		}
    	return max;
    }
    
    // check subsequence
	public static boolean check(String[] strs, int i) {
		// TODO Auto-generated method stub
		int p1, p2;
		for (int k = i - 1; k >= 0; --k) {
			p1 = 0;
			p2 = 0;
			while (p1 < strs[i].length() && p2 < strs[k].length()) {
				if (strs[i].charAt(p1) == strs[k].charAt(p2)) {
					++p1;
					++p2;
				} else {
					p2++;
				}
			}
			if (p1 >= strs[i].length()) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLUSlength(new String[] { "aabbcc","aabbcc","cb" }));
	}

}
