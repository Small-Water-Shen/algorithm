package algorithm_practices;

/**
 * @author ��Сˮ
 * 
 * �ھŽ����ű�  �ڶ���
 *
 */
public class ������� {

	// �������һ���޵ķ���������� * 4
	// ����ǰ��������Ͻ�������1/4Բ�ڣ�����Ϊһ����������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		int r = 1000;
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= r; j++) {
				// �����ŵ����壺�жϵ�ǰ���Ͻǵĵ��Ƿ���1/4Բ��
				double distance = Math.sqrt(i * i + j * j);
				if (distance <= r){
					count++;
				}
			}
		}
		System.out.println(count*4);
	}

}
