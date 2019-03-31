package array;

/*
 * �������е������������ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ�����飬����������������Ե�������
 * ���������a[i] > a[j] �� i < j�� a[i] �� a[j] ����һ������ԡ�
 * ����: A = [2, 4, 1, 3, 5]
 * ���: 3
 * ����:(2, 1), (4, 1), (4, 3) �������
 */
public class ����� {
	
	// ��ͨ������˫ָ��ɨ��ʱ�临�Ӷȸ�
	public static int func(int[] arr) {
		int len = arr.length;
		int count = 0;
		for (int i = len - 1; i > 0; --i) {
			for (int j = i - 1; j >= 0; --j) {
				if (arr[i] < arr[j]) count++;
			}
		}
		return count;
	}
	
	static long count;
	
	// �鲢����
    public static long reversePairs(int[] A) {
        // write your code here
    	if (A.length <= 1) {
			return 0;
		}
    	int[] temp = new int[A.length];
    	count = 0;
    	divide(A, 0, A.length - 1, temp);
        return count;
    }
    
    // ��
    public static void divide(int[] arr, int left, int right, int[] temp) {
    	if (left < right) {
    		int mid = (left + right) >> 1;
			divide(arr, left, mid, temp);
			divide(arr, mid + 1, right, temp);
			merge(arr, left, mid, right, temp);
		}
    }

    // ��
	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int t = 0; // index of temp
		int leftFlag = left; // ��ߵ�ָ��
		int rightFlag = mid + 1; // �ұߵ�ָ��
		while (leftFlag <= mid && rightFlag <= right) {
			if (arr[leftFlag] > arr[rightFlag]) {
				temp[t++] = arr[rightFlag++];
				/* �������ߵ�����
				 * ��4 3   1 2�� 3>1ʱ��4��ȻҲ����1,����Ҫ������ߵ��Ѿ��жϹ�����
				 */
				count += (mid - leftFlag + 1);
			} else {
				temp[t++] = arr[leftFlag++];
			}
		}
		// remained of left part
		while (leftFlag <= mid) {
			temp[t++] = arr[leftFlag++];
		}
		// remained of right part
		while (rightFlag <= right) {
			temp[t++] = arr[rightFlag++];
		}
		// duplicate the temp to crude array
		t = 0;
		while (left <= right) {
			arr[left++] = temp[t++]; 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 2, 4, 1, 3, 5 };
		System.out.println(reversePairs(arr));
//		System.out.println(Arrays.toString(arr));
	}

}
