package algorithm_practices;

import java.util.HashMap;
import java.util.Map;

/*
 * ������άƽ���ϵ�n���㣬������ж��ٵ���ͬһ��ֱ���ϡ�
 * ����:(1,2),(3,6),(0,0),(1,3).
 * ���:3
 * ���� 2:
 * ����:(1,2),(2,3),(3,2).
 * ���:2
 */
public class ����ж��ٸ�����һ��ֱ���� {

	static class Point {
		int x;
		int y;

		public Point() {
			this.x = 0;
			this.y = 0;
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	// calculate every each points's k
	public static int maxPoints(Point[] points) {
		// write your code here
		if (points == null || points.length == 0) {
			return 0;
		}
		int len = points.length, max = 0, MAX = Integer.MAX_VALUE;;
		if (len == 1) {
			return 1;
		}
		if (len == 2) {
			return 2;
		}
		// hash table
		Map<Double, Integer> hash = new HashMap<Double, Integer>();
		for (int i = 0; i < len - 1; i++) {
			int same = 0; // �غϵĵ�
			hash.clear(); // ��ֹ�ظ�
			hash.put((double) MAX, 1); // Ԥ��1,ȫΪ��ͬ��ʱ����
			for (int j = i + 1; j < len; j++) {
				int x1 = points[i].x, y1 = points[i].y;
				int x2 = points[j].x, y2 = points[j].y;
				if (x1 == x2 && y1 == y2) {
					same++;
					continue;
				}
				// ��б�ʲ�����(ƽ����y)������ΪMAX
				double k = (x1 == x2) ? MAX : (1.0 * (y2 - y1)) / (1.0 * (x2 - x1));
				if (hash.containsKey(k)) {
					hash.put(k, hash.get(k) + 1);
				} else {
					hash.put(k, 2); // �������һ��ֱ��
				}
			}
			System.out.println(hash.toString());
			// ʵʱ�������ֵ
			for (double k : hash.keySet()) {
				int value = same + hash.get(k);
				if (value > max) {
					max = value;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] points = new Point[4];
		points[0] = new Point(0, 0);
		points[1] = new Point(0, 0);
		points[2] = new Point(0, 0);
		points[3] = new Point(0, 0);
		System.out.println(maxPoints(points));
	}

}
