package algorithm_practices;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 *  1    2    3
        ABC  DEF

    4    5    6
   GHI  JKL  MNO

    7    8    9 
   PQRS TUV  WXYZ

    *    0    #
����֪���绰�����������ֻ���������ĸ��Ӧ������2��ӦABC��7��ӦPQRS��

������Ϊ�ڱ�����������������һЩ�� ˾�����Ѵ�������ҵ���ơ���Ʒ���ơ���ҵ���Ƶȵ��ض�Ӣ�ĵ��ʻ���ĸ���Ƕ����绰�����С����磬ƻ����˾�����̵�Apple Store�Ķ����绰�ǣ�1-800-MY-APPLE (1-800-692-7753)��������������ҪĿ������������˾��־���ұ������ڼ����ʹ�á���Ȼ����Ӣ����ҵ�������˵��Ӣ�ĵ���Ҫ�����ҵ����ָ� ����ʶ�ǡ�

�����ĸ��Ͽ��ܻ��Ӧͬһ�����룬�Ӷ��������������HIHO��IGGO����Ӧ4446��  

���ڸ���N����ĸ����Լ�M�����룬���ÿһ����������ж��ٸ���ĸ��϶�Ӧ����

����
��һ�а�����������N��M��  

����N��ÿ��һ����ĸ��ϡ�

��֮��M��ÿ��һ�����ֺ��롣  

����30%�����ݣ�1 �� N, M �� 100  

����100%�����ݣ�1 �� N, M �� 50000�� ��ĸ��Ϻͺ���ĳ��ȶ�������10��ֻ������д��ĸ������2-9��

���
���M�С����������˳���������ÿһ�������ж�����ĸ��϶�Ӧ��

��������
3 2
HIHO  
IGGO
CODER
4446  
26337
�������
2  
1
 * */
public class �������� {

	static Map<Character, Integer> map = new HashMap<Character, Integer>();

	private static void init() {
		// TODO Auto-generated method stub
		int count = 2;
		for (char c = 'A'; c <= 'Z'; c++) {
			if (c == 'D' || c == 'G' || c == 'J' || c == 'M' || c == 'P' || c == 'T' || c == 'W')
				count++;
			map.put(c, count);
		}
	}

	private static void find(int n, int m, String[] values, String[] numbers) {
		// TODO Auto-generated method stub
		for (int i = 0; i < m; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (numbers[i].length() != values[j].length())
					continue;
				// �������
				boolean flag = true;
				for (int index = 0; index < numbers[i].length(); index++) {
					if (map.containsKey(values[j].charAt(index))
							&& map.get(values[j].charAt(index)) !=  numbers[i].charAt(index)-'0') {
						flag = false;
					}
				}
				if (flag)
					count++;
			}
			if (count != 0)
				System.out.println(count);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		String[] values = new String[n];
		String[] numbers = new String[m];
		for (int i = 0; i < n; i++) {
			values[i] = input.next();
		}
		for (int i = 0; i < m; i++) {
			numbers[i] = input.next();
		}
		init();
		find(n, m, values, numbers);
		input.close();
	}
}
