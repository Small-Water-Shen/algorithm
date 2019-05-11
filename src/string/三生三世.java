package string;

import java.util.Scanner;

/*
 * �ػʵ��ĺ�������س��Ÿ軽����ˮ�ϵ����������յ������ɳ̲�����˽�ơ�
 * BD����ɳ̲��������һ������ӡ��ͻȻ��������һ��ʯ����������š�HQDB�������滹д��һ�����ϵ���ݡ�BD�粻�ɵ��������Լ���ID��QBDH
 * �����IDҲ̫�����˰ɣ��ѵ�����������������磬�Ǹ���ݾ�����һ�����ҽ��ٻ�����ȥ��ʱ�䣿��BD�粻�ɵ�˼����������
 * ������û�а�ǳҹ�����������İ��飬��һ���������������Ҳ����ɷ���˰����������ʮ�����BD���롣
 * BD����Ϊ�����ĳһ��ID������ID��ȫ���е�һ�֣��Һ�����ID��һ����
 * ����Ϊ���ID������ǰ�������ڸ��������ID��BD���ID�������æ�жϣ����ID�ǲ�������ǰ����
 * ��������: ����ĵ�һ�а���һ������n�������ַ���ID�ĳ��ȡ�(n<=2e5) 
 * ���������зֱ����һ������Ϊn���ַ��������ܰ������д�д��ĸ��Сд��ĸ���ȸ���BD���ID����һ�и�����Ҫ�жϵ�ID��
 * �������: ���yes�������ID��BD���ǰ����no�����ǡ�
 * ����
 * 4
 * QBDH
 * BQDH
 * ��� yes
 * ����
 * 5
 * jwjnb
 * jwjnb
 * ��� no
 */
public class �������� {
	
	// ӳ�����
	public static boolean check(long n, String iD, String target) {
		// TODO Auto-generated method stub
		if (iD.equals(target)) return false;
		int[] map = new int[58];
		for (int i = 0; i < n; i++) {
			++map[iD.charAt(i) - 'A']; 
		}
		for (int i = 0; i < n; i++) {
			--map[target.charAt(i) - 'A'];
		}
		for (int i = 0; i < n; i++) {
			if (map[iD.charAt(i) - 'A'] != 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
		String ID = input.next();
		String target = input.next();
		System.out.println(check(n, ID, target) ? "yes" : "no");
		input.close();
	}

}
