package dfs;

import java.util.ArrayList;
import java.util.List;

/*
 * ��һ���ַ���,�����ѡ����һ���ַ������������ַ�֮�����ַ���,ʹ�ַ����ɽ�һ���ַ��������ַ����,������п��ܵĽ��
 * ���룺 "123"
 * ����� [["1","2","3"],["12","3"],["1","23"]]
 */
public class �ָ��ַ��� {

    public static List<List<String>> splitString(String s) {
        // write your code here
    	List<List<String>> res = new ArrayList<>();
    	if (s == null || s.length() == 0) {
    		res.add(new ArrayList<>());
			return res;
		}
    	dfs(res, new ArrayList<>(), 0, s);
    	return res;
    }
	
	public static void dfs(List<List<String>> res, ArrayList<String> temp, int index, String s) {
		if (index >= s.length()) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = index; i < s.length(); i++) {
			// neglect the length which more than 2
			if ((i + 1) - index > 2) {
				continue;
			}
			String string = s.substring(index, i + 1);
			temp.add(string);
			dfs(res, temp, i + 1, s);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(splitString("123").toString());
	}

}
