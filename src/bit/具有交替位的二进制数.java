package bit;

/*
 * ��һ����������������Ķ����Ʊ�ʾ�Ƿ���н���λ�������������ڵ�λ���Ǿ��в�ͬ��ֵ��
 * ����: 5
 * ���: True
 * ����: 5 �Ķ����Ʊ�ʾΪ: 101
 */
public class ���н���λ�Ķ������� {

    public static boolean hasAlternatingBits(int n) {
        if (n <= 0) return false;
        n ^= (n >> 1); // ��λ
        return ((n + 1) & n) == 0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hasAlternatingBits(7));
	}

}
