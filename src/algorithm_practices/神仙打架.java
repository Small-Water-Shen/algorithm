package algorithm_practices;

import java.util.Scanner;

/*
 * ţ���¿���һ��ϵ������һ��ϵ������m�����������������ǽ�����Խ������Խǰ��
 * ���ǰ�������������һ����Ტ�е�һ��
 * ��n�����ɶ��������μ���m�������������м��������ù���һ����
 * ��������:��һ��������������n,m,��ʾ����������m��������
 * ������n������һ�����־���ÿ��m�������ַ���ʾÿ�������Ľ�������1<=n,m<=100
 * �������:���һ��������ʾ�ù���һ���Ķ�������
 * ʾ��1
 * ����
 * 3 5
 * 91728
 * 11828
 * 11111
 * ��� 3
 */
public class ���ɴ�� {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt(), cnt = 0;
        String[] matrix = new String[n];
        int[] max = new int[m];
        boolean[] win = new boolean[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = input.next();
            for (int j = 0; j < m; ++j) {
                max[j] = Math.max(max[j], matrix[i].charAt(j) - '0');
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (win[j]) continue;
                if ((matrix[j].charAt(i) - '0') == max[i]) win[j] = true;
            }
        }
        for (boolean b : win) if (b) ++cnt;
        System.out.println(cnt);
        input.close();
    }

}
