package dfs;

public class Eight_Queens {

	final static int num = 8;

	static int[] queens = new int[10];// ����ʺ����꣬�±�Ϊ�У�ֵΪ��
	static int count = 0, k = 1;

	public static void print() {
		System.out.println("��" + (k++) + "��:");
		for (int i = 1; i <= num; i++) {
			switch (queens[i]) {
			case 1:
				System.out.println("* - - - - - - -");
				break;
			case 2:
				System.out.println("- * - - - - - -");
				break;
			case 3:
				System.out.println("- - * - - - - -");
				break;
			case 4:
				System.out.println("- - - * - - - -");
				break;
			case 5:
				System.out.println("- - - - * - - -");
				break;
			case 6:
				System.out.println("- - - - - * - -");
				break;
			case 7:
				System.out.println("- - - - - - * -");
				break;
			case 8:
				System.out.println("- - - - - - - *");
				break;
			}
		}
	}

	public static boolean check(int n, int m) {// check��ǰλ��(n,m)�ܲ��ܷŻʺ�
		for (int i = 1; i < n; i++)// �����ѷ��õĻʺ�
			if ((queens[i] == m)// ͬ��
					|| (Math.abs(n - i) == Math.abs(m - queens[i])))// �����Խ���
				return false;
		return true;
	}

	public static void Queen(int n) {
		if (n > num) {// ���һ��ݹ���n+1(8+1)
			count++;
			print();
			return;
		} // ִ������֮����л���
		for (int i = 1; i <= num; i++) {// 1-8��
			if (check(n, i)) {// nΪ�У�iΪ��
				queens[n] = i;// ���ûʺ���(n,i)
				Queen(n + 1);// ����֮�������һ���ʺ��λ���ж�
			} // ִ������֮����л���
		}
	}

	public static void main(String[] args) {
		Queen(1);
		System.out.println("sum:" + count);
	}
}
