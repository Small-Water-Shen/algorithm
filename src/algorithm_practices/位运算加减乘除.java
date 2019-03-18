package algorithm_practices;

public class λ����Ӽ��˳� {

	/* ��λ����ʵ�ּӷ�
	 * �����ļӷ���2+1=3 => 10&01=11
	 * �۲��֪�� ��û�н�λ������£��ӷ���ʵ���ǽ���^����
	 * �жϽ�λ������� 3+2=5 => 11+10=100
	 * ��&���ж��Ƿ���Ҫ��λ�� 
	 * 1 & 1 = 1 (��λ) 		1 ^ 1 = 0 (��Ӧ�ļӷ�)
	 * 1 & 0 = 0	 		1 ^ 0 = 1
	 * 0 & 1 = 0			0 ^ 1 = 1
	 * 0 & 0 = 0			0 ^ 0 = 0
	 * ��λ����: (1&1)<<1
	 * �磺 3+2=5 
	 *  => 11 ^ 10 = 01 (�Ƚ��мӷ�)
	 *  => (11 & 10) << 1 = 100 (��λ)
	 *  ��ʱֻ��Ҫ��01+100=101���ɵõ��𰸣�������ʹ��+�������ٽ���һ����������
	 *  => 01 ^ 100 = 101 (�Ƚ��мӷ�)
	 *  => (01 & 100) << 1 = 100 (��λ��Ч��������Ҫ��λ) => 101
	 */
	public static int add(int a, int b) {
		int addOp = a ^ b;  // �ӷ�����
		int bitOp = a & b;  // �ж��Ƿ��λ
		// ����Ҫ��λ����ֹ
		while (bitOp != 0) {
			int addOpTmp = addOp;  // ��¼��һ�μӷ���ֵ
			int addBit = bitOp << 1;  // ��λ��õ���ֵ�����������
			addOp ^= addBit;  // �ٴν���^���ӷ���
			bitOp = addBit & addOpTmp;  // �ٴ��ж��Ƿ���Ҫ
		}
		return addOp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(-5, 1));
	}

}
