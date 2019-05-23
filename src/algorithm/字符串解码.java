package algorithm;

import java.util.*;

public class �ַ������� {
	/**
	 * ����һ�����ʽ s���˱��ʽ�������֣���ĸ�Լ������š�
	 * �ڷ�����ǰ�����ֱ�ʾ���������ݵ��ظ�����(�����ڵ����ݿ������ַ�������һ�����ʽ)��
	 * �뽫������ʽչ����һ���ַ�����
	 * S = abc3[a] ���� abcaaa
     * S = 3[abc] ���� abcabcabc
     * S = 4[ac]dy ���� acacacacdy
     * S = 3[2[ad]3[pf]]xyz ���� adadpfpfpfadadpfpfpfadadpfpfpfxyz
	 * @param s: an expression includes numbers, letters and brackets
	 * @return: a string
	 */
	public static String expressionExpand(String s) {
		// write your code here
		/*
		 * ˼·: ���ַ�����ͷ��ʼ��ջ,����]���ջ,������ջԪ�ر���Ϊbuffer, ֱ��[,Ȼ�س�ջ[ǰ�������number,��Ϊnumber��temp,
		 * �ٽ��µ�buffer��ջ,���������ַ������ջ���м���.
		 */
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c != ']') {
				stack.push(c);
			}
			else {
				String buffer = "";
				while(stack.peek() != '[') {
					buffer = String.valueOf(stack.pop()) + buffer;
				}
				stack.pop();//��ջ[
				//��ջ[ǰ������,����Ϊ��λ���߶�λ
				String num = "";
				while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
					num = String.valueOf(stack.pop()) + num;
				}
				int number = Integer.parseInt(num);
				//��number��buffer��ջ
				for(int j=0;j<number;j++) {
					for(int k=0;k<buffer.length();k++) {
						char temp = buffer.charAt(k);
						stack.push(temp);
					}
				}
			}
		}
		String result = "";
		while(!stack.isEmpty()) {
			result = String.valueOf(stack.pop()) + result;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(expressionExpand("5[10[abcd]Ac20[abcde]]"));
	}
}
