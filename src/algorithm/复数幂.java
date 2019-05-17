package algorithm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.*;

/**
 * @author ��Сˮ
 *
 *         �ھŽ����ű� ������
 *
 *         ���⣺������ ��iΪ������λ����������������n��(2+3i)^n ��ʵ�����鲿���������� �� (2+3i)^123456 ���ڶ��٣�
 *         ��(2+3i)��123456���ݣ�������ֺܴ�Ҫ��ȷ��ʾ�� ��д�� "ʵ�����鲿i"
 *         ����ʽ��ʵ�����鲿���������������ÿ�ѧ��������ʾ���� �м��κεط������ӿո�ʵ��Ϊ��ʱǰ�治�����š� (2+3i)^2
 *         д��:-5+12i�� (2+3i)^5 ��д��: 122-597i
 * 
 *         ע�⣺��Ҫ�ύ����һ�����Ӵ�ĸ�������Ҫ��д�κζ������ݡ�
 */

public class ������ {
	
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream file = new PrintStream(new FileOutputStream("output.txt"));
		int n = 123456;
		final BigDecimal a = BigDecimal.valueOf(2);
		final BigDecimal b = BigDecimal.valueOf(3);
		BigDecimal va = BigDecimal.valueOf(2);
		BigDecimal vb = BigDecimal.valueOf(3);
		/* ����ÿһ��
		 * ���磺(2+3i)^5
		 *       ѭ��һ�Σ������(2+3i)^2 = (-5+12i)
		 *       ѭ���ڶ���ʱ����(-5+12i) * (2+3i)
		 *       ѭ��������ʱ����(-46+9i) * (2+3i)
		 *       ......
		 *       ֪�����Ĵμ��ɵó�ʵ�����鲿��ֵ
		 */			
		for(int i=1;i<n;i++){
			BigDecimal temp_va = va;
			va = va.multiply(a).subtract(vb.multiply(b));//va = va*a-vb*b
			vb = temp_va.multiply(b).add(vb.multiply(a));//vb = va*b+vb*a
		}
		System.setOut(file);
		System.out.print(va);
		System.out.println((vb.compareTo(BigDecimal.ZERO)>0)?"+":""+vb+"i");
		
	}

/*
	public static BigDecimal C(int m, int n) {
		if (m == n || m == 0) return BigDecimal.valueOf(1);
		BigDecimal a = BigDecimal.ONE;
		BigDecimal b = BigDecimal.ONE;
		for (int i = 1; i <= m; i++) {
			b = b.multiply(BigDecimal.valueOf(i));
		}
		for (; m >= 1; m--, n--) {
			a = a.multiply(BigDecimal.valueOf(n));
		}
		return a.divide(b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		BigDecimal a = BigDecimal.ZERO;
		BigDecimal b = BigDecimal.ZERO;
		BigDecimal temp;
		for (int i = 0; i <= n; i++) {
			temp = C(i, n).multiply(BigDecimal.valueOf(2).pow(n - i)).multiply(BigDecimal.valueOf(3).pow(i));
			if (i % 2 != 0) {// ����
				if ((i - 1) / 2 % 2 == 0) {// �ܴճ�ż����i^2
					b = b.add(temp);
				} else {
					b = b.subtract(temp);
				}
			} else {// iż��
				if ((i / 2) % 2 == 0) {// i^2�ĸ���Ϊż
					a = a.add(temp);
				} else {
					a = a.subtract(temp);
				}
			}
		}
		System.out.println(a + " " + b);
	}
	*/
}
