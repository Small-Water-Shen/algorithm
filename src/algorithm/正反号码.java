package algorithm;
/*
 * ����
СHi�μ���һ�������������˶��ᣬ��ͻȻ������ǰ��һλ�����߱���ĺ��뾹Ȼ���Լ�һ����Ҳ��666����ϸһ����ԭ����λ�����߰��Լ���������(��ת180��)�ˣ��������999����ȥ����˺���666��  

СHi֪�����������һ����N�������ߣ�����������1~N�������ҳ����п�����Ϊ��������������ĺ�����  

һ������K���ܲ������嵱�ҽ�����ת֮��ĺ����ǺϷ�������K'����������1 �� K' �� N��K' �� K��  

���磺

3û�����壬��Ϊ����֮���ǺϷ������֡�  

100û�����壬��Ϊ001��0��ͷ�����ǺϷ����롣  

101Ҳû�����壬��Ϊ����֮����101����  

����N=10000000����1025689�����壬��Ϊ����֮����6895201�����N=2000000����1025689û�����壬��Ϊ6895201����N��

����
һ������N��(1 �� N �� 100000)

���
��С�������1~N֮������������ĺ��롣ÿ������һ�С�

��������
10
�������
6
9
 * */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class �������� {

	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	private static void init() {
		// TODO Auto-generated method stub
		map.put(0, 0);
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, -1);
		map.put(4, -1);
		map.put(5, 5);
		map.put(6, 9);
		map.put(7, -1);
		map.put(8, 8);
		map.put(9, 6);
	}

	private static void find(int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= n; i++) {
			StringBuilder buffer = new StringBuilder(String.valueOf(i));
			buffer = buffer.reverse();
			boolean flag = true;
			boolean exists = true;
			for (int k = 0; k < buffer.length(); k++) {
				int key = buffer.charAt(k) - '0';
				int value = map.get(key);
				// ��ͷ����Ϊ0
				if (k == 0 && key == 0) {
					flag = true;
					break;
				}
				if (value == -1) {
					exists = false;
					break;
				} else if (key != value) {
					flag = false;
				}
			}
			if (!flag && exists) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		init();
		find(n);
		input.close();
	}
}
