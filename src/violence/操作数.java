package violence;

import java.util.Scanner;

/*
 * Bonnie�õ���һ������n�����������������ֲ��ϵ���һ�ֲ�����
 * ���n�����һλ������0����ô���Ͱ�n����10�������������������1��
 * ֱ��n��Ϊһ��������1����������n������Bonnie��Ҫ�����ٴβ�����
 */

public class ������ {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        while (T-- > 0) {
            int n = input.nextInt();
            int cnt = 0;
            while (n > 1) {
                long r = n % 10;
                if (r == 0) {
                    ++cnt;
                    n /= 10;               
                }
                else {
                    cnt += (11 - r);
                    n /= 10;
                    n++; // �ӵ�10,����һλ��Ҫ+1
                }
            }
            System.out.println(cnt);   
        }
        input.close();
    }
 
}