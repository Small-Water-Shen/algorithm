package array;

/*
 * ��1-1000�ŵ�����Ϊ1001��������,ֻ��һ��Ԫ���ظ�,���ҳ���
 * ����Ҫ�������ÿ��Ԫ��ֻ�ܷ���һ��,����ʹ�ø����ռ�
 * */
public class Ψһ�ظ�Ԫ�� {

	static int[] elements = new int[1001];

	static {
		for (int i = 0; i < elements.length - 1; i++) {
			elements[i] = (i + 1); 
		}
		elements[elements.length - 1] = 666;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �ܼ�, ����֪��Χ�����ۺ�, �������������Ԫ�غ�, ������ɵõ��ظ�Ԫ��
		int sum = (1 + 1000) * 1000 / 2, curSum = 0;
		for (int i = 0; i < elements.length; i++) {
			curSum += elements[i];
		}
		System.out.println("Repeat Element: " + (curSum - sum));
	}

}
