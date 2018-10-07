package dp;
/*
 *
* You are given 2 eggs.

* You have access to a 100-storey building.

* Eggs can be very hard or very fragile means it may break if dropped from the first floor or may not even break if dropped from 100th floor. Both eggs are identical.

* You need to figure out the highest floor of a 100-storey building an egg can be dropped without breaking.

* Now the question is how many drops you need to make. You are allowed to break 2 eggs in the process

*/

public class Two_eggs {
	
	// Consider two trivial methods
	/* ��һ, �ӱ����ӵ�һ�㿪ʼ��, ����ֻ��һ���������ҵ��ٽ�ֵ, ����
	 * pass...
	 * */
	/* �ڶ�, ���ֲ���.
	 * �ȴ�50�㿪ʼ��, ������˾ʹӵ�һ�㿪ʼ���ٽ�ֵ; 
	 * û���ȥ��75��(����), ���75������, ���50��ʼ���ٽ�ֵ.
	 * �Դ�����, ��õ������7��: 50, 75, 88, 94, 97, 98, 99
	 * �˷������ȶ�.
	 */
	public static void dichotomy() {
		;;;
	}
	
	/* ���ǿ��Լ����һ��drop����10��, �������20��...100��,
	 * �������: 9��(10~90���һ��) + 10��(90~100��) = 19��
	 * ��Ȼ����������������õ�.
	 * ���ǲ��ø��ؾ���ķ���: ���ӵ�һ�������Ĵ�����Ӱ�쵽�ӵڶ��������Ĵ���
	 * ��, ����1����һ��, ����2������һ��.
	 * ����, ����1��һ����10����; �������, ����2�ʹӵ�һ�㿪ʼ��, ��10��(1~10), һ������1+10=11��;
	 * ���û��, ����1����10+(10-1)=19����, �������, ����2�ʹ�11�㿪ʼ��, ��9��(11~19), һ��2+9=11��
	 * �Դ�����...
	 * ��ʱ�輦��1��һ����x����, �õ�����: x+(x-1)+(x-2)+...+1 = 100
	 * �����ǵȲ���ʽ, ����Ϊ: x(x+1)/2 = 100 => x^2+x-200=0
	 * ���x=14(��)
	 * */
	// ��Ȼ���������2������, 100������������Ľ�. ���ö�̬�滮���һ��ͨ��ģ��
	public static void drop_eggs(int eggs, int floor) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		drop_eggs(2, 100);
	}

}
