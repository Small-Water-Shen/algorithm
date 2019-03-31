package algorithm_practices;

/*
 * ����������������������������ÿ���ڵ����һ�����֡����ִ洢������ԭ���������෴��˳��
 * ʹ�õ�һ������λ������Ŀ�ͷ��д��һ������������������ӣ���������ʽ���غ͡�
 * 	����: 7->1->6->null, 5->9->2->null
	���: 2->1->9->null
	��������:
	617 + 295 = 912
	912 ת��������:  2->1->9->null
 */
public class ������� {
	
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			this.val = x;
			this.next = null;
		}
	}
	
    public static ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
    	if (l1 == null && l2 == null) {
			return null;
		}
    	ListNode temp = new ListNode(0);
    	ListNode res = temp; // ���ڼ�¼������Ȼ�ᶪʧ��ʱ����
    	int sum = 0;
    	while (l1 != null || l2 != null) {
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			if (sum >= 10) {
				temp.val = (sum - 10);
				sum = 1;
			} else {
				temp.val = sum;
				sum = 0;
			}
			if (l1 != null || l2 != null) {
				temp.next = new ListNode(0);
				temp = temp.next;
			}
		}
    	if (sum >= 1) {
			temp.next = new ListNode(1);
		}
    	return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(7), l2 = new ListNode(5);
		l1.next = new ListNode(1);
		l1.next.next = new ListNode(6);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(2);
		ListNode res = addLists(l1, l2);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
