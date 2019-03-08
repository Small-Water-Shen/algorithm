package array;

import java.util.Scanner;

/*
	��������N �� N��ϡ�����A��B�����о���A��P��Ԫ�ط�0������B��Q��Ԫ�ط�0��
	�������������ĳ˻�C = A �� B�������C�����з�0��Ԫ�ء�
	����
	��һ�а�����������N, P, Q    
	
	����P��ÿ����������i, j, k��ʾA�����һ����0Ԫ�أ�Aij = k  
	
	����Q��ÿ����������i, j, k��ʾB�����һ����0Ԫ�أ�Bij = k  
	
	����80%�����ݣ�1 �� N, P, Q �� 200  
	
	����100%������, 1 �� N, P, Q �� 2000, 1 �� i, j �� N, 0 �� k �� 100
	
	���
	��������У������к��е�˳���������C��ÿһ����0Ԫ��  
	
	ÿ����������i, j, k��ʾC�����һ����0Ԫ�أ�Cij = k
	
	��������
	2 2 4  
	1 1 1  
	2 2 1  
	1 1 1  
	1 2 2  
	2 1 3  
	2 2 4
	�������
	1 1 1  
	1 2 2  
	2 1 3  
	2 2 4
 * */
public class Matrix_Dot {

	static int[] A;
	static int[] B;
	static int N, P, Q;

	public static void input() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		P = input.nextInt();
		Q = input.nextInt();
		// initialize
		A = new int[N * N];
		B = new int[N * N];
		// input of A
		for (int p = 0; p < P; ++p) {
			int i = input.nextInt();
			int j = input.nextInt();
			int k = input.nextInt();
			A[(i - 1) + (j - 1)] = k;
		}
		// input of B
		for (int p = 0; p < Q; ++p) {
			int i = input.nextInt();
			int j = input.nextInt();
			int k = input.nextInt();
			B[(i - 1) + (j - 1)] = k;
		}
		input.close();
	}

	// ������Strassen�㷨�Ż�Ч��
	public static void dot() {
		// length of A's row
		for (int i = 0; i < N; ++i) {
			// length of B's column
			for (int j = 0; j < N; ++j) {
				int value = 0; // sum of one value
				// length of A's column
				for (int k = 0; k < N; ++k) {
					value += A[i + k] * B[k + j];
				}
				if (value != 0) {
					System.out.println((i + 1) + " " + (j + 1) + " " + value);
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		dot();
	}

}
