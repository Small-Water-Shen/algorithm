package bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ��վ��һ�����������ϵ� 0 λ�á���λ��Ŀ������һ��Ŀ�ꡣ
 * ��ÿһ�������У��������������ҡ��ڵ�n���ƶ���(��1��ʼ)��������n����
 * ���ص���Ŀ�ĵ��������С��������
 * Ŀ�꽫��һ�������������Χ[-10^9, 10^9]��
 *  ����: target = 3
	���: 2
	����: �ڵ�һ�������Ǵ�0��1���ڵڶ��������Ǵ�1��3��
	����: target = 2
	���: 3
	����: �ڵ�һ�������Ǵ�0��1���ڵڶ��������У����Ǵ�1��-1���ڵ���������-1��2��
 */
public class ����һ������ {

    public static int reachNumber(int target) {
        // Write your code here
    	if (target == 0) {
			return 0;
		}
    	return bfs(target);
    }
    
    // memory limit exceeded
    public static int bfs(int target) {
    	int steps = 1, l, r;
    	Queue<Integer> queue = new LinkedList<>();
    	queue.offer(0);
    	while (!queue.isEmpty()) {
    		int size = queue.size();  // ��Ҫ��ֵ��queue�Ĵ�С��仯
    		for (int i = 0; i < size; i++) {
    			int k = queue.poll();
    			l = k - steps;
    			r = k + steps;
    			if (l == target || r == target) {
    				return steps;
    			}
    			queue.offer(l);
    			queue.offer(r);
			}
    		steps++;
		}
    	return steps;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reachNumber(4710915));
	}

}
