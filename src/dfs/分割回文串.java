package dfs;

import java.util.ArrayList;
import java.util.List;

/*
 * ����һ���ַ���s����s�ָ��һЩ�Ӵ���ʹÿ���Ӵ����ǻ��Ĵ���
 * ����s���п��ܵĻ��Ĵ��ָ����
 * s = "aab"������[["aa", "b"], ["a", "a", "b"]]
 */
public class �ָ���Ĵ� {

    public static List<List<String>> partition(String s) {
        // write your code here
    	List<List<String>> res = new ArrayList<>();
    	if (s == null || s.length() == 0) {
			return res;
		}
        dfs(res, s, new ArrayList<>(), 0);
    	return res;
    }
    
    public static void dfs(List<List<String>> res, String s, ArrayList<String> temp, int index) {
    	if (index >= s.length()) {
    		res.add(new ArrayList<>(temp));
    		return;
		}
    	for (int i = index; i < s.length(); i++) {
			String string = s.substring(index, i + 1);
			if (check(string)) {
				temp.add(string);
				dfs(res, s, temp, i + 1);
				temp.remove(temp.size() - 1);  // back
			}
		}
    }
    
    // ��ͷָ�����м�ɨ
    public static boolean check(String str) {
    	int front = 0, back = str.length() - 1;
    	while (front < back) {
			if (str.charAt(front) != str.charAt(back)) {
				return false;
			}
			front++;
			back--;
		}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partition("aab"));
	}

}
