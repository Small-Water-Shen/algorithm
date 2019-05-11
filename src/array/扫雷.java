package array;

import java.util.Scanner;

/*
 * ɨ����Ϸ��һ��ʮ�־���ĵ���С��Ϸ����n��m�е���������һЩ���Ӻ��е��ף���֮Ϊ���׸񣩣��������Ӳ������ף���֮Ϊ�ǵ��׸񣩡�
 * ��ҷ���һ���ǵ��׸�ʱ���ø񽫻����һ�����֡�����ʾ��Χ�������ж��ٸ��ǵ��׸�
 * ���ڸ���n��m�е������еĵ��׷ֲ���������ÿ���ǵ��׸���Χ�ĵ��׸�����
 * ע��һ�����ӵ���Χ���Ӱ������ϡ��¡����ҡ����ϡ����ϡ����¡����°˸���������ֱ֮�����ڵĸ��ӡ�
 * ��һ��������������n,m ���ֱ��ʾ������������������
 * ������n�У�ÿ��m���ַ��������������еĵ��׷ֲ�������ַ���*����ʾ��Ӧ�����ǵ��׸��ַ���?����ʾ��Ӧ�����Ƿǵ��׸�
 * �����ַ�֮���޷ָ�����1<=n,m<=100
 * �������: �������n�У�ÿ��m���ַ������������������á�*����ʾ���׸�����Χ�ĵ��׸�����ʾ�ǵ��׸������ַ�֮���޷ָ���
 * ����
 * 3 3
 * *??
 * ???
 * ?*?
 * ���
 * *10
 * 221
 * 1*1
 */
public class ɨ�� {

	static int n, m;
	static char[][] map;
	
	public static void process() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '*') continue;
				map[i][j] = check(i, j);
			}
		}
		print();
	}
	
	public static char check(int i, int j) {
		int cnt = 0;
		if (judge(i + 1, j) && map[i + 1][j] == '*') ++cnt;
		if (judge(i - 1, j) && map[i - 1][j] == '*') ++cnt;
		if (judge(i, j + 1) && map[i][j + 1] == '*') ++cnt;
		if (judge(i, j - 1) && map[i][j - 1] == '*') ++cnt;
		if (judge(i + 1, j + 1) && map[i + 1][j + 1] == '*') ++cnt;
		if (judge(i + 1, j - 1) && map[i + 1][j - 1] == '*') ++cnt;
		if (judge(i - 1, j + 1) && map[i - 1][j + 1] == '*') ++cnt;
		if (judge(i - 1, j - 1) && map[i - 1][j - 1] == '*') ++cnt;
		return (char) (cnt + '0');
	}
	
	public static boolean judge(int i, int j) {
		return i >= 0 && i < n && j >= 0 && j < m;
	}
	
	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String line = input.next();
			map[i] = line.toCharArray(); 
		}
		process();
		input.close();
	}

}
