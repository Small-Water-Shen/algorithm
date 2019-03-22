package dfs;

import java.util.ArrayList;
import java.util.List;

/*
 * ��һ����������ɵ��ַ������������ָܻ�Ϊ������IP��ַ��
 * (����������������ַ��������������, ʹ����Ϊһ���Ϸ���IP��ַ. �������п��ܵ�IP��ַ.)
 * ����: "25525511135"
 * ���: ["255.255.11.135", "255.255.111.35"]
 * ����: ["255.255.111.35", "255.255.11.135"] ͬ������.
 * ����: "1116512311"
 * ���: ["11.165.123.11","111.65.123.11"]
 */
public class �ָ�IP��ַ {

	public static List<String> restoreIpAddresses(String s) {
		// write your code here
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return res;
		}
		dfs(res, s, 0, 0, "");
		return res;
	}

	/*
	 * count => number of '.' index => char of s
	 */
	public static void dfs(List<String> res, String s, int count, int index, String str) {
		// '.'����index�������� or '.'û����index�ͱ�������
		if (count >= 4 && index < s.length() || count < 4 && index >= s.length()) {
			return;
		}
		if (count >= 4 && index >= s.length()) {
			System.out.println(str);
			res.add(str);
			return;
		}
		int value = 0;
		boolean firstZero = false;
		while (index < s.length() && !firstZero) {
			value = 10 * value + (s.charAt(index) - '0');
			index++;
			// ��λ��Ϊ0, ֻѭ��һ�Σ���һ��'.'���߽�����
			if (value == 0) {
				firstZero = true;
			}
			if (value < 256) {
				if (count == 3) {
					dfs(res, s, count + 1, index, str + value);
				} else {
					dfs(res, s, count + 1, index, str + value + ".");
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(restoreIpAddresses("010010").toString());
	}

}
