package algorithm;

import java.util.HashSet;
import java.util.Set;

/*
 * дһ���㷨���ж�һ�����ǲ���"������"��
 * һ�����ǲ��ǿ�������ô����ģ�����һ����������
 * ÿһ�ν������滻Ϊ��ÿ��λ���ϵ����ֵ�ƽ���ͣ�Ȼ���ظ��������ֱ���������Ϊ1��
 * ��������ѭ����ʼ�ձ䲻��1��������Ա�Ϊ1����ô��������ǿ�������
 */

public class ������ {
	
    public static boolean isHappy(int n) {
        // write your code here
    	Set<Integer> map = new HashSet<>();
    	while (n != 1) {
    		int res = getMuti(n);
    		System.out.println(res);
    		if (map.contains(res)) {
				return false;
			}
			if (res != 1) {
				map.add(res);
			}
			n = res;
		}
    	return true;
    }
    
    public static int getMuti(int num) {
    	int sum = 0;
    	while (num != 0) {
			sum += Math.pow(num % 10, 2);
			num /= 10;
		}
    	return sum;
    }
    
    // �ҵ����ɣ� �ǿ������е�ѭ���б���4
    public static boolean isHappy1(int n) {
        // write your code here
    	while (n != 1 && n != 4) {
    		int res = getMuti(n);
    		System.out.println(res);
			n = res;
		}
    	return n == 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy1(19));
	}

}
