package bit;

/*
 * ����һ����������������Ĳ����������ǽ�ԭ�����ֵĶ����Ʊ�ʾ��λȡ�����ٻ���ʮ���ƺ�õ���������
 * ������������֤��32λ�з��������ķ�Χ�ڡ�
 * ����һ���������Ķ����Ʊ�ʾ������ǰ����
 * ���룺5
 * �����2
 * ˵����5�Ķ����Ʊ�ʾΪ101��������ǰ���㣩�����Ĳ���Ϊ010���������Ҫ���2��
 */
public class ���� {

	// ��ȡ���λ��1, ����Ȼ��-1ʹ�÷�ǰ���Ϊ1, ����num������򼴿ɵ�ȡ��
    public static int findComplement(int num) {
        // Write your code here
    	return ((Integer.highestOneBit(num) << 1) - 1) ^ num;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findComplement(-5));
	}

}
