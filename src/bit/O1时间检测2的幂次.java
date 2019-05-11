package bit;

/*
 * �� O(1) ʱ�������� n �Ƿ��� 2 ���ݴΡ�
 * 
 */
public class O1ʱ����2���ݴ� {

	// 2^nһ���Ƕ�������ֻ��һ��1, ȥ���ٿ��Ƿ�Ϊ0
    public static boolean checkPowerOf2(int n) {
        // write your code here
    	if (n <= 0) return false;
    	return (n & (n - 1)) == 0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPowerOf2(16));
	}

}
