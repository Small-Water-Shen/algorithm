package array;

import java.util.Arrays;

/*
 * ����һ��ֻ������ĸ���ַ�����������Сд��ĸ���д��ĸ��˳���������
 * Сд��ĸ���ߴ�д��ĸ����֮�䲻һ��Ҫ������ԭʼ�ַ����е����λ�á�
 * ����:  "abAcD"
 * ���:  "acbAD"
 * ��ԭ��ɨ��һ�����
 */
public class �ַ���Сд���� {
	
    public static void sortLetters(char[] chars) {
        // write your code here
    	if (chars == null || chars.length == 0) return;
    	// two Points
    	int low = 0, high = chars.length - 1;
    	char record = chars[low];
    	while (low < high) {
//    		Character.isUpperCase(chars[high]);
			while (low < high && (int) (chars[high]) >= 65 && (int) (chars[high]) <= 90) --high;
			if (low < high) chars[low++] = chars[high];
			while (low < high && (int) (chars[low]) >= 97 && (int) (chars[low]) <= 122) ++low;
			if (low < high) chars[high--] = chars[low];
		}
    	chars[low] = record;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chars = "abAcD".toCharArray();
		sortLetters(chars);
		System.out.println(Arrays.toString(chars));
	}

}
