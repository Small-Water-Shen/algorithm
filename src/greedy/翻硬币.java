package greedy;

import java.util.*;

/**
 * �������� С��������һ������Ӳ�ҡ�����Ϸ��
 * 
 * ���Ϸ����ų�һ�ŵ�����Ӳ�ҡ������� * ��ʾ���棬�� o ��ʾ���棨��Сд��ĸ�������㣩��
 * 
 * ���磬���������ǣ�**oo***oooo
 * 
 * ���ͬʱ��ת��ߵ�����Ӳ�ң����Ϊ��oooo***oooo
 * 
 * ����С���������ǣ������֪�˳�ʼ״̬��Ҫ�ﵽ��Ŀ��״̬��ÿ��ֻ��ͬʱ��ת���ڵ�����Ӳ��,��ô���ض��ľ��棬����Ҫ�������ٴ��أ�
 * 
 * ����Լ�����ѷ������ڵ�����Ӳ�ҽ���һ����������ôҪ��
 * 
 * �����ʽ ���еȳ����ַ������ֱ��ʾ��ʼ״̬��Ҫ�ﵽ��Ŀ��״̬��ÿ�еĳ���<1000
 * 
 * �����ʽ һ����������ʾ��С����������
 * 
 * ��������1
 * **********
 * o****o****
 * �������1 
 * 5 
 * 
 * ��������2 
 * o**o***o*** 
 * o***o**o*** 
 * �������2 
 * 1
 *
 */
public class ��Ӳ�� {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String init = input.next();
		String target = input.next();
		// ���Ȳ���Ƚ���
		if (init.length() != target.length()) {
			System.out.println(0);
			System.exit(0);
		}
		// �ҳ���������ȵ�λ�ã�������ã����ۼӵ������
		int[] temp = new int[2];
		int len = 0;
		int result = 0;
		for (int i = 0; i < init.length(); i++) {
			if (init.charAt(i) != target.charAt(i)) {
				temp[len++] = i;
				if (len >= 2) {
					result += temp[1] - temp[0];
					len = 0;
				}
			}
		}
		System.out.println(result);
		input.close();
	}
}
