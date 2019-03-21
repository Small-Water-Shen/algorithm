package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * ��һ��������'0'��'1'�������ַ�����ÿ�����ִ���һ����ĸ���뷵�������п��ܵ���ĸ��ϡ�
 * ��ͼ���ֻ�����ͼ���ͱ�ʾ��ÿ�����ֿ��Դ������ĸ��
    1    2    3
        ABC  DEF

    4    5    6
   GHI  JKL  MNO

    7    8    9 
   PQRS TUV  WXYZ

    *    0    #
  ���ϵĴ��ǰ��մʵ��׫˳���������ģ���������������ʱ����Ҳ��������ѡ����ϲ�������˳��
  ����: "23"
  ���: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
  ����: '2' ������ 'a', 'b' �� 'c', '3' ������ 'd', 'e' �� 'f'
 */
public class �绰�������ĸ��� {
	
	static Map<Character, String> board = new HashMap<Character, String>();
	
	public static void init() {
		board.put('2', "abc");
		board.put('3', "def");
		board.put('4', "ghi");
		board.put('5', "jkl");
		board.put('6', "mno");
		board.put('7', "pqrs");
		board.put('8', "tuv");
		board.put('9', "wxyz");
	}

    public static List<String> letterCombinations(String digits) {
        // write your code here
    	List<String> res = new ArrayList<>();
    	if (digits == null || digits.length() == 0) {
			return res;
		}
    	init();
    	dfs(res, digits, "", 0);
    	return res;
    }
    
    // dfs
    public static void dfs(List<String> res, String digits, String result, int pos) {
    	if (result.length() == digits.length()) {
    		res.add(result);
			return;
		}
    	// get board's values
    	String value = board.get(digits.charAt(pos));
    	for (int i = 0; i < value.length(); i++) {
			dfs(res, digits, result + value.charAt(i), pos + 1);
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombinations("").toString());
	}

}
