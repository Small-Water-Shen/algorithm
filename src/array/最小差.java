package array;

/*
 * ���������������飨��һ�������� A���ڶ��������� B���������� A ��ȡ A[i]��
 * ���� B ��ȡ B[j]��A[i] �� B[j]���ߵĲ�ԽСԽ��(|A[i] - B[j]|), ������С�
 * ����: A = [1, 2, 3, 4], B = [7, 6, 5]
 * ���: 1 ����: B[2] - A[3] = 1
 * ʱ�临�Ӷ� O(n log n)
 */
public class ��С�� {

	public static int smallestDifference(int[] A, int[] B) {
		// write your code here
    	sort(A, 0, A.length - 1, new int[A.length]);
    	sort(B, 0, B.length - 1, new int[B.length]);
		// ���������ָ������ʼλ�ã��ĸ�С�ͽ�����ǰ�ƶ�
		int min = Integer.MAX_VALUE, p1 = 0, p2 = 0;
		while (p1 < A.length && p2 < B.length) {
			if (A[p1] == B[p2]) {
				min = 0;
				break;
			} else if (A[p1] > B[p2]) {
				min = ((A[p1] - B[p2])) < min ? (A[p1] - B[p2]) : min;
				++p2;
			} else {
				min = ((B[p2] - A[p1])) < min ? (B[p2] - A[p1]) : min;
				++p1;
			}
		}
		return min;
	}
	
    // �鲢����
    // divide
	public static void sort(int[] nums, int i, int j, int[] temp) {
		if (i < j) {
			int mid = (i + j) >> 1;
			sort(nums, i, mid, temp);
			sort(nums, mid + 1, j, temp);
			merger(nums, i, j, mid, temp);
		}
	}

	// merger
	public static void merger(int[] nums, int left, int right, int mid, int[] temp) {
		int front = left, end = mid + 1, t = 0;
		while (front <= mid && end <= right) {
			if (nums[front] > nums[end]) {
				temp[t++] = nums[end++];
			} else {
				temp[t++] = nums[front++];
			}
		}
		// duplicate the remain elements of left array
		while (front <= mid) {
			temp[t++] = nums[front++];
		}
		// duplicate the remain elements of right array
		while (end <= right) {
			temp[t++] = nums[end++];
		}
		// duplicate the temp to nums
		t = 0;
		while (left <= right) {
			nums[left++] = temp[t++]; 
		} 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(smallestDifference(new int[] { 10, 25, 55, 34 }, new int[] { 18, 47, 46, 42 }));
	}

}
