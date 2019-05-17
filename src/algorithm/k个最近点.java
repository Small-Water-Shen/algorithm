package algorithm;

import java.util.*;

/*
 * ����һЩ points ��һ�� origin���� points ���ҵ� k ���� origin ����ĵ㡣���վ�����С���󷵻ء�
 * �������������ͬ���룬����xֵ��������xֵҲ��ͬ�����ٰ���yֵ����
 * */
public class k������� {
	/**
	 * @param points: a list of points
	 * @param origin: a point
	 * @param k: An integer
	 * @return: the k closest points
	 */
	static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}

		public String toString() {
			return "" + x + ", " + y;
		}
	}

	public static Point[] kClosest(Point[] points, Point origin, int k) {
		// write your code here
		int origin_x = origin.x;
		int origin_y = origin.y;
		// ��д����
		Arrays.sort(points, new Comparator<Point>() {
			// ������ǱȽ�˭��˭С����С�ķ���ǰ�棬��ķ��ں��档
			// ���統���ظ�����ʱ�򣬱�����һ����Ӧ�����ڵڶ�����������
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				// ŷʽ����
				int first = (Math.abs(o1.x - origin_x) * Math.abs(o1.x - origin_x))
						+ (Math.abs(o1.y - origin_y) * Math.abs(o1.y - origin_y));
				int second = (Math.abs(o2.x - origin_x) * Math.abs(o2.x - origin_x))
						+ (Math.abs(o2.y - origin_y) * Math.abs(o2.y - origin_y));
				int diff = first - second;
				// ��һ�����ȵڶ�����С
				if (diff < 0) {
					return -1;
				}
				// ��һ�����ȵڶ�������
				else if (diff > 0) {
					return 1;
				}
				// ŷʽ������ȵ������
				else {
					// �ȱȽ�x
					if (o1.x < o2.x) {
						return -1;
					} else if (o1.x > o2.x) {
						return 1;
					}
					// x��ȵ�������ٱȽ�y
					else if (o1.y < o2.y) {
						return -1;
					} else if (o1.y > o2.y) {
						return 1;
					}
				}
				return 0;
			}
		});
		Point[] result = new Point[k];
		for (int i = 0; i < k; ++i) {
			result[i] = points[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Point[] points = new Point[5];
		points[0] = new Point(4, 6);
		points[1] = new Point(4, 7);
		points[2] = new Point(4, 4);
		points[3] = new Point(2, 5);
		points[4] = new Point(1, 1);
		Point origin = new Point();
		Point[] a = kClosest(points, origin, 3);
		for (int i = 0; i < 3; ++i) {
			System.out.println(a[i].toString());
		}
	}
}
