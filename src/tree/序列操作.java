package tree;
import java.util.Scanner;

/*
 * ����һ������Ϊn�����У���ʼΪ1,2,3...n���������m�β�����
 * ���������֣�
 * 1 l r  ��ʾ������[l,r]�� [1,2...r-l+1] ����
 * 2 l r ��ѯ[l,r]�������
 * ��������: ��һ�а���2�����֣�n,m��1 <= n,m <= 1e5�� ����������m�У���ʽ��������ʾ
 * �������: ����ÿ������2�����һ��һ��������ʾ��
 * ����
 * 10 5
 * 2 1 10
 * 1 3 6
 * 2 1 10
 * 1 1 10
 * 2 1 10
 * ��� 55 47 55
 */
public class ���в��� {
    
    static int n, m;
    static int[] arr = new int[1000005];
    
    // ǰ׺�� (TLE)
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        for (int i = 1; i <= n; ++i) arr[i] = arr[i - 1] + i;
        while (m-- > 0) {
            int op = input.nextInt();
            int l = input.nextInt();
            int r = input.nextInt();
            if (op == 1) {
                int p = 1;
                for (int i = l; i <= n; ++i) {
                	if (i <= r) arr[i] = arr[i - 1] + (p++);
                	else arr[i] -= (r - l + 1);
                }
            } else if (op == 2) {
                System.out.println(arr[r] - arr[l - 1]);
            }
        }
        input.close();
    }
}