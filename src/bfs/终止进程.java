package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * ���������. ÿ�����̶���һ��Ψһ�� PID(����id) �� PPID(������id)��ÿ������ֻ��һ�������̣���������һ�������ӽ��̣������һ�����νṹ������ֻ��һ�����̵�PPID��0������ζ���������û�и����̡����е�pid���ǲ�ͬ����������
 * ����ʹ�����������б�����ʾ�����б����е�һ���б����ÿ�����̵�PID���ڶ����б������Ӧ��PPID��
 * ���ڸ����������б��Լ�һ����Ҫ��ֹ(kill)�Ľ��̵�ID�����ؽ��������ֹ�Ľ��̵�PID�б�����һ�����̱���ֹʱ�����������ӽ��̽�����ֹ�����ص��б�û��˳��Ҫ��
 * ������kill idһ����PID�б��е�ĳ��id
 * ������PID�б������ٺ���һ������
 *  ����: PID = [1, 3, 10, 5], PPID = [3, 0, 5, 3], killID = 5
	���: [5, 10]
	����: ��ֹ����5ͬ������ֹ����10.
	     3
	   /   \
	  1     5
	       /
	      10
 */
public class ��ֹ���� {

    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // Write your code here
    	List<Integer> res = new ArrayList<>();
    	if (kill == 0) {
			return res;
		}
    	// HashSetӳ��
    	Map<Integer, List<Integer>> map = new HashMap<>();
    	for (int i = 0; i < pid.size(); i++) {
			int child = pid.get(i);
			int parent = ppid.get(i);
			// exist, get and add
			if (map.containsKey(parent)) {
				map.get(parent).add(child);
			} else {
				List<Integer> t = new ArrayList<>();
				t.add(child);
				map.put(parent, t);
			}
		}
    	Queue<Integer> queue = new LinkedList<>();
    	queue.offer(kill);  // add root process
    	while (!queue.isEmpty()) {
    		int k = queue.poll();
    		res.add(k);
    		if (!map.containsKey(k)) {
				continue;
			}
			for (int i : map.get(k)) {
				queue.offer(i);
			}
		}
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> pid = new ArrayList<>(Arrays.asList(8, 6, 7, 9, 2, 4));
		ArrayList<Integer> ppid = new ArrayList<>(Arrays.asList(9, 7, 0, 6, 7, 6));
		System.out.println(killProcess(pid, ppid, 7));
	}

}
