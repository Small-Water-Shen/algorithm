package algorithm_practices;

import java.util.Scanner;

/**
 * @author ��Сˮ
 *
 *         �ڱ�����һ��rabbit���ֱ�tortoise����m�׼������ϣ����ͻ�ͣ������Ϣt�롣����ÿ��rabbitϰ�߲�ͬ��
 *         ���Զ��ڲ�ͬ��rabbit��m��t��ͬ��tortoise��ϰ�߶�����ͬ�ģ����ǻ�һֱ�����յ㡣
 * 
 *         �������㷢��ֻҪ֪����rabbit��tortoise���ٶ�v1,v2���Լ���ֻrabbit��Ӧ��m��t��ֵ�������ĳ���s��
 *         ���ܵó������Ľ���ˡ��������Թ��ֵ��ӿƼ���ѧ�������ĸ߲��������дһ������������������
 * 
 *         ����
 *         ����һ�У������ÿո���������������v1��v2��m��t��s������(v1,v2<=100;m<=300;t<=10;s<=10000��Ϊv1
 *         ,v2�Ĺ�����)��
 * 
 * 
 * 
 *         ��� ������У��������һ����ĸ��R������rabbit��ʤ��T������tortoise��ʤ��D������ƽ�֡�
 *         Ȼ�����һ������������ʾ��ʤ�ߣ�����˫��ͬʱ�������յ����õ���ʱ�䡣
 * 
 *         ���뷶�� 10 5 5 2 20
 * 
 *         10 5 5 1 20
 * 
 *         ������� D 4
 * 
 *         R 3
 */
public class �������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int v1, v2, m, t, s;
		int s1, s2, time;
		while(input.hasNext()){
			v1 = input.nextInt();
			v2 = input.nextInt();
			m = input.nextInt();
			t = input.nextInt();
			s = input.nextInt();
			s1 = 0;
			s2 = 0;
			time = 0;
			while (s1 < s && s2 < s) {
				s1 += v1;
				s2 += v2;
				time++;
				if (s1 >= s || s2 >= s)
					break;
				if ((s1 - s2) >= m) {
					s2 += t * v2;
					time += t;
				}
			}
			if (s2 > s1)
				System.out.println("T\n" + time + "\n");
			else if (s2 < s1)
				System.out.println("R\n" + time + "\n");
			else
				System.out.println("D\n" + time + "\n");
		}
		input.close();
	}

}
