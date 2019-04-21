package array;

import java.util.*;

/*
 * Сy��һ�鳤��Ϊn�Ĳ�ƥ����ɫȫ��Ϊ0����Ҫ�������ƥȾɫ�����ܹ���m��Ⱦ�ϡ�Сy��Ϊһ��Ⱦ���ö���ǲ���г�ġ�����ÿ��Ⱦ�ϻᱻ�øպ�һ�Ρ�
 * Ҳ����˵СyҪ����鲼ƥȾm��ɫ����i�λ��Li��Ri�������Ⱦ����ɫi�����ڸ������ղ�ƥÿ�ε���ɫ���������һ��Ⱦɫ���������ݱ�֤�н�
 * ���빲���С�
 * ��һ��������������n,m����ʾ��ƥ�ĳ��Ⱥ�Ⱦ�ϵ����� 
 * �ڶ���n���ÿո����������������i������ai��ʾ��i����ƥ����ɫ
 * Input: 
 * 3 3
 * 1 2 3
 * Output:
 * 1 3
 * 2 3
 * 3 3 
 */
public class ��ƥȾɫ {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        // ��������洢m����ɫ����������
        int[] left = new int[m + 1];
        int[] right = new int[m + 1];
        for (int i = 1; i <= n; i++) {
			int color = input.nextInt();
			if (left[color] == 0) {
				left[color] = i; // color start with i
			} else {
				right[color] = i; // color end with i
			}
		}
        // processing and merger
        for (int i = 1; i <= m; i++) {
        	// ��right����,˵����i��color�϶�����������
			if (right[i] == 0) {
				// ���߶�û�����ҵ�,˵����ǰi��color���ջᱻ���һ��color����
				if (left[i] == 0) {
					left[i] = left[m]; 
					right[i] = right[m]; 
				} 
				// ֻ��left point, ˵��ֻ����һ������
				else {
					right[i] = left[i]; 
				}
			} 
		}
        // output
        for (int i = 1; i <= m; i++) {
			System.out.println(left[i] + " " + right[i]);
		}
        input.close();
    }
}