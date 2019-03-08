package violence;

import java.util.Arrays;

/*
 * ��n��ֽƬ����ֽ��, �����ȡ4��, �ж��Ƿ���֮���Ƿ�Ϊm, ���yes
 * */

public class �����Ż� {

	static int n = 10, m = 20;
	static int[] data = { 2, 5, 6, 7, 1, 9, 10, 3, 4, 8 };

	// violence
	public static void notOpti() {
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				for (int c = 0; c < n; c++) {
					for (int d = 0; d < n; d++) {
						if (data[a] + data[b] + data[c] + data[d] == m) {
							System.out.println("Yes");
							return;
						}
					}
				}
			}
		}
	}

	public static boolean BinarySearch(int[] arr, int i, int j, int value) {
		// ���ֲ���
		while (i <= j) {
			int mid = (i + j) / 2;
			if (arr[mid] == value) {
				return true;
			} else if (arr[mid] < value) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		return false;
	}

	// �ȶ�data�����, �����ö��ֲ���
	public static void Opti1() {
		Arrays.sort(data);
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				for (int c = 0; c < n; c++) {
					int remain = m - data[a] - data[b] - data[c];
					// ���ֲ���
					if (BinarySearch(data, 0, data.length - 1, remain)) {
						System.out.println("Yes");
						return;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		notOpti();
		Opti1();
	}

}
