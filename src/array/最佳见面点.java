package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * ��һȺס�ڲ�ͬ�ط������ѣ����������ϣ���Ҫ��ĳ�ؼ��棬Ҫ������ȥ��Ŀ�ĵص�·�̺���̡����ڸ�һ��0��1��ɵĶ�ά���飬1��ʾ�˵���һ���˾�ס��
 * ʹ�������پ�����Ϊ�����ܾ��룬��ʽΪ��(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|
 * ����: 
 * [[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * ���: 6
 * ����: ��(0, 2)����Ѽ���ص㣬��С��·���ܺ�Ϊ2+2+2=6������6��
 */
public class ��Ѽ���� {
	
	/*
	 * �����е�A,B�� A 0 0 0 0 B
	 * A��B����֮������ľ����P��������[A,B],����P���ģ�����֮�Ͷ���A,B֮��ľ��롣
	 * �ټ�������C,D�� C 0 A 0 0 0 B 0 0 D
	 * ������֪��P�����λ����������[A,B]������������һ��(��[A,B]֮��)�������������롣
	 * ���Ծ������A,B�ľ���֮�ͼ���C,D�ľ���֮��
	 * ��ô��A,B�ľ���֮��C,D�ľ���֮���أ�
	 * �Ȱ���1��������뼯�ϣ������ü����е����һ����ȥ�����еĵ�һ�����ɵ�CD���룬
	 * ����..�����ڶ�����ȥ�ڶ������ɵ�AB����..
	 * �����һά��������꣬�ٽ����һά���ɵö�ά���
	 */
    public static int minTotalDistance(int[][] grid) {
        // Write your code here
    	List<Integer> x = new ArrayList<>();
    	List<Integer> y = new ArrayList<>();
    	for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					x.add(j);
					y.add(i);
				}
			}
		}
    	return minDistance(x) + minDistance(y);
    }
    
    public static int minDistance(List<Integer> point) {
    	Collections.sort(point);
    	int former = 0, latter = point.size() - 1;
    	int dis = 0;
    	while (former < latter) {
			dis += point.get(latter--) - point.get(former++);
		}
    	return dis;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[][] { 
									{ 1, 1, 0, 0, 1 },
									{ 1, 0, 1, 0, 0 },
									{ 0, 0, 1, 0, 1 }
									};
		System.out.println(minTotalDistance(grid));
	}

}
