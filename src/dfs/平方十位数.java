package dfs;

/**
 * @author ��Сˮ
 * 
 *         ���⣺ƽ��ʮλ��
 * 
 *         ��0~9��10�����ֲ��ظ�������©��������ɺܶ�10λ���֡�
 * 
 *         ������Ҳ�кܶ�ǡ����ƽ��������ĳ������ƽ������
 * 
 *         ���磺1026753849������������С��һ��ƽ������
 * 
 *         �����ҳ���������һ��ƽ�����Ƕ��٣�
 *
 */
public class ƽ��ʮλ�� {

	static boolean[] vis = new boolean[10];
	static boolean flag = false;

	public static boolean check(double num_sqrt) {
		return ((int) num_sqrt == num_sqrt) ? true : false;
	}

	public static void dfs(int n, String num) {

		if (flag) {
			return;
		}

		if (n >= 10) {
//			if(num.startsWith("0")) return;
			double number = Double.parseDouble(num);
			double num_sqrt = Math.sqrt(number);
			if (check(num_sqrt)) {
				System.out.println(num);
				System.out.println((int) num_sqrt);
				flag = true;
			}
			return;
		}

		for (int i = 9; i >= 0; i--) {
			if (!vis[i]) {
				vis[i] = true;
				dfs(n+1, num + ("" + i));
				vis[i] = false;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dfs(0, "");
	}
	
	/*  ��set���ϵĲ��ظ�������
	 * 
	 * 	public static void main(String [] args){
        BigInteger x;  
        BigInteger y = new BigInteger("10");  
        BigInteger[] a = new BigInteger[10];  
        String s = "100000";  
        String s2 = "32043";  
        BigInteger t = new BigInteger(s2);  
        for (BigInteger b = new BigInteger(s); b.compareTo(t) >= 0; b = b.subtract(new BigInteger("1"))) {  
            x = b.multiply(b);  
            for (int m = 9; m >= 0; m--) {  
                a[m] = x.remainder(y);  
                x = x.divide(y);  
            }  
            Set set = new HashSet();  
            for (int i = 0; i < a.length; i++) {  
                set.add(a[i]);  
            }  
            if (set.size() == a.length) {  
                System.out.println(b);  
                break;  
            }  
        }  
    } 
    */

}
