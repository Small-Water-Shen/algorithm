package bit;

/*
 * ���Ҫ������nת��Ϊm����Ҫ�ı���ٸ�bitλ��
 * Example 1:
	Input: n = 31, m = 14
	Output:  2
	Explanation:
	(11111) -> (01110) there are two different bits.
Example 2:
	Input: n = 1, m = 7
	Output:  2
	Explanation:
	(001) -> (111) will change two bits.
 */
public class ������Aת��ΪB {

    public static int bitSwapRequired(int a, int b) {
        // write your code here
    	int diff = a ^ b, cnt = 0;
    	while (diff != 0) {
			++cnt;
			diff &= (diff - 1);
		}
    	return cnt;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bitSwapRequired(31, 14));
	}

}
