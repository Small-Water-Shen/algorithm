package algorithm;

import java.util.Arrays;
import java.util.Scanner;

/*
 * СHi��֯��һȺС���ȥ����Ӱ�������ӰԺ��������ǿ��ʵ���������Բ���������λ��Χ�����岥����һȦ�ķ�ʽ���á�
	������һ����N����λ������˳ʱ���˳���1��N��ţ�ע����Ϊ1����λ�ͱ��ΪN����λҲ�����ڵġ�
	��N����λ���Ѿ������ɸ���λ��ռ�ã�����СHi����ָ��һ����λΪ����㣨�����λ�����Ǳ�ռ�õģ���������������û�б�ռ�õ���λ����ѡȡ�뼯����������λʹ�á�
	����СHiϣ���ܹ�ѡȡһ��ǡ���ļ���㣬ʹ�������˵������ľ���֮�;���С��
	
	����
	��һ�а�����������N��M���ֱ��ʾ��λ��������СHi��С������������
	
	�ڶ��а���N�����������α�ʾÿ����λ�����������Ϊ1��ʾ����λ�Ѿ���ռ�ã�0��ʾ����λ��û�б�ռ�á�
	
	����30%�����ݣ�����1<=N,M<=103
	
	����100%�����ݣ�����1<=N,M<=105
	
	���
	���һ��������ʾ�����˵���λ�������ľ���֮�͵���Сֵ������������κκϷ�����λ�����������-1��
	
	��������
	6 2
	1 0 1 0 1 0
	�������
	2
 * */

public class �������ֵ {

	static int[] state;
	static int N, M, mid;

	public static void input() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		state = new int[N];
		mid = N / 2;
		int valueCount = 0;
		for (int i = 0; i < N; ++i) {
			state[i] = input.nextInt();
			if (state[i] == 1) {
				++valueCount;
			}
		}
		if (M < valueCount) {
			System.out.println(-1);
			System.exit(0);
		}
		input.close();
	}

	public static int search(int pos) {
		int sum = 0;
		int[] temp = Arrays.copyOf(state, N);
		for (int m = M; m > 0; --m) {
			// ������˳ʱ����λ��
			if (m % 2 != 0) {
				for (int i = pos, time = 0;; ++i, ++time) {
					// ֻ��һ��
					if (time >= N)
						break;
					if (time < N && i >= N)
						i = 0;
					if (temp[i] == 0) {
						temp[i] = 1;
						sum += (time > mid) ? (N - time) : time;
						break;
					}
				}
			}
			// ż������ʱ����λ��
			else {
				for (int i = pos, time = 0;; --i, ++time) {
					if (time >= N)
						break;
					if (time < N && i < 0)
						i = N - 1;
					if (temp[i] == 0) {
						temp[i] = 1;
						sum += (time > mid) ? (N - time) : time;
						break;
					}
				}
			}
		}
//		System.out.println(sum);
		return sum;
	}

	public static void get() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; ++i) {
			int distance = search(i);
			min = (distance < min) ? distance : min;
		}
		System.out.println(min);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		get();
	}
}
