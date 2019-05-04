package algorithm_practices;

import java.util.Scanner;

/*
 * ��֪����a,a3��192��������1��������[L,R]֮������������a���ۼӺ��Ƕ��٣�
 */
public class �����ж�_�Ȳ���� {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		while (T-- > 0) {
			long l = input.nextLong(), r = input.nextLong();
			long sum, low = 0, high = 0;
			// find start
			for (long i = l; i <= (l + 192); i++) {
				if (i % 192 == 1) {
					low = i;
					break;
				}
			}
			// find end
			for (long i = r; i >= (r - 192); --i) {
				if (i % 192 == 1) {
					high = i;
					break;
				}
			}
			// �Ȳ��������
			sum = (low + high) * ((high - low) / 192 + 1) / 2;
			System.out.println(sum);
		}
		input.close();
	}

}
