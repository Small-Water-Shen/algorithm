package bit;

/*
 * ����һ��������32λ�з�����������дһ�������ж���������Ƿ�Ϊ4�ĳ˷���
 */
public class �ĵĳ˷� {

	/* 
	 * ���ж��Ƿ����0����2����, 
	 * Ȼ����4�ĳ˷�������˸�ʽ:1010101010101010101010101010101
	 * ��0x55555555����&�Ƿ��Ǳ�����
	 * ��һ�ַ���: ֻҪ��4�Ĵη�������1֮����Ա�3����
	 */
    public static boolean isPowerOfFour(int num) {
        // Write your code here
//    	System.out.println(Integer.toBinaryString(0x55555555));
    	return num > 0 && ((num - 1) & num) == 0 && (num & 0x55555555) == num;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfFour(16));
	}

}
