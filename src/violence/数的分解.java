package violence;

/*
 * ��2019 �ֽ��3 ��������ͬ��������(������0)֮�ͣ�����Ҫ��ÿ�������������������� 2 �� 4��һ���ж����ֲ�ͬ�ķֽⷽ����
 * ע�⽻��3��������˳����Ϊͬһ�ַ���������1000+1001+18 �� 1001+1000+18 ����Ϊͬһ�֡�
 */
public class ���ķֽ� {
	
	public static boolean judge(int num) {
		while (num != 0) {
			if (num % 10 == 2 || num % 10 == 4) {
				return false;
			}
			num /= 10;
		}
		return true;
	}
	
	public static void violence1() {
		int count = 0;
		for (int i = 1; i <= 2019; i++) {
			if (!judge(i)) {
				continue;
			}
			for (int j = i + 1; j <= 2019; j++) {
				if (i == j || !judge(j)) {
					continue;
				}
				for (int k = j + 1; k <= 2019; k++) {
					if (i == k || j == k || !judge(k)) {
						continue;
					}
					if (i + j + k == 2019) {
						count++;
						System.out.println(i + " + " + j + " + " + k);
					}
				}
			}
		}
		System.out.println(count);
	}
	
	public static void violence2() {
		int count = 0;
		for (int i = 1; i <= 2019; i++) {
			if (!judge(i)) {
				continue;
			}
			// j < (2019 - i - j)����������ȼ��������
			for (int j = i + 1; j < (2019 - i - j); j++) {
				int remain = 2019 - i - j;
				if (!judge(j) || !judge(remain)) {
					continue;
				}
				count++;
				System.out.println(i + " + " + j + " + " + (remain));
			}
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		violence2();
	}

}
