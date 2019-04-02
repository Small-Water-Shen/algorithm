package string;

/*
 * ����һ���ַ����������ת�ַ����е�ÿ�����ʡ�
 * ���ʵĹ��ɣ��޿ո���ĸ����һ�����ʣ���Щ����ĩβ����б�����
 * �����ַ����Ƿ����ǰ������β��ո񣿿��԰��������Ƿ�ת����ַ����ܰ���
 * ��δ����������ʼ�Ķ���ո��ڷ�ת�ַ����м�ո���ٵ�ֻ��һ��
 * ����:  "the sky is blue"
 * ���:  "blue is sky the"
 */
public class ��ת�ַ����еĵ��� {
	
	/*
	 * �ȶ���ÿһ�����ʽ��з�ת����������ת
	 * �磺 the sky is blue 
	 *   => eht yks si eulb
	 *   => blue is sky the
	 */
    public static String reverseWords(String s) {
        // write your code here
        if (s.trim().equals("")) {
			return s;
		}
    	if (s.length() == 1) {
			return s;
		}
    	s = s.trim(); // ȥ��λ�ո�
    	char[] ss = s.toCharArray();
        int len = ss.length;
    	reverse(ss, 0, len - 1);
    	// ���η�תÿ������
    	int i = 0, j = 0;
    	while (i < len) {
    		// �ҵ����ʿ�ͷ��λ��i�ͽ���λ��j
    		while (i < j || i < len && ss[i] == ' ') i++;
    		while (j < i || j < len && ss[j] != ' ') j++;
    		reverse(ss, i, j - 1);
    	}
    	// ȥ������֮��Ŀո�
//    	String res = String.valueOf(ss);
//    	String[] results = res.split(" +");
//		res = "";
//		for (String item : results) {
//			res += item + " ";
//		}
//    	return res.trim();
    	return delSpace(ss, len);
    }
    
    public static String delSpace(char[] ss, int len) {
    	int i = 0, j = 0;
    	while (i < len) {
    		// �ҵ����ʿ�ͷ��λ��i
    		while (i < len && ss[i] == ' ') i++;
    		// �ѵ������η�����λ
    		while (i < len && ss[i] != ' ') ss[j++] = ss[i++];
			// add a space
			if (i < len) ss[j++] = ' ';
    	}
    	return String.valueOf(ss).substring(0, j);
	}

	public static void reverse(char[] s, int low, int high) {
    	while (low < high) {
			char c = s[low];
			s[low++] = s[high];
			s[high--] = c;
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("the    sky is blue"));
	}
	
}
