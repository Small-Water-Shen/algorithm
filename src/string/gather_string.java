package string;

import java.util.Scanner;
/*
 * �����԰����ֵ�����бȽϡ����磺
  abcd С�� abdc
 
  �������һ�������������������ĸ���������У����Եõ���಻ͬ�Ĵ�������Щ��ͬ�Ĵ��У�
  ��һ�����պø����Ĵ���΢��һЩ����ѧ��˵�����Ǵ�����֪�������д�����С�Ĵ���
  �������������������Դ�Ĵ�����
 
�������룺
���봮��
abfxy
���������
abfyx
 
�������룺
���봮��
ayyyxxff
���������
fafxxyyy
 
���ݹ�ģԼ����
  ����Ĵ�������1000���ַ���
 
������
  �����֪�Ĵ��Ѿ����������鴮�����ģ���ԭ�����������Ǹ�����
 * */
public class gather_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String s = input.next();
		int i = s.length() - 1;
		for (; i > 0; i--) {
			if (s.charAt(i) > s.charAt(i - 1))
				break;
		}
		if (i == 0) {
			System.out.println(s);
		} else {
			StringBuilder buffer = new StringBuilder(s.substring(i, s.length()));
			buffer = buffer.reverse();
			buffer.insert(1, s.charAt(i - 1));
			buffer.insert(0, s.substring(0, i - 1));
			System.out.println(buffer.toString());
		}
		input.close();
	}

}
