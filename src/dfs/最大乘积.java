package dfs;

/*
 * ����1~9�ľŸ����֣��������м����˺ţ����ǵĳ˻�Ҳ������1~9��ɵ�һ�����У��磺
 * 132 * 965874 = 127495368
 * 135627 * 948 = 128574396
 * 612 * 954783 = 584327196
 * ��ô�����ǵĳ˻�����Ƕ��١�
 */
public class ���˻� {
	
	static int max = 0;
	static int[] nums = new int[10];
	static boolean[] vis = new boolean[10];
	
	public static void dfs(int pos) {
		// �õ����кõ�9����
		if (pos > 9) {
			// �����в���˺Ų��Ƚ���ֵ
			for (int i = 1; i <= 8; i++) {
				int value = getMultiply(i);
				max = (value > max) ? value : max;
			}
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (!vis[i]) {
				vis[i] = true;
				nums[pos] = i;
				dfs(pos + 1);
				vis[i] = false; 
			}
		}
	}

	public static int getMultiply(int i) {
		int left = 0, right = 0;
		for (int j = 1; j <= 9; j++) {
			if (j <= i) {
				left = left * 10 + nums[j];
			} else {
				right = right * 10 + nums[j];
			}
		}
		return left * right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dfs(1);
		System.out.println(max);
	}

}
