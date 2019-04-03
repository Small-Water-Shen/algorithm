package array;

/* �ò����������������
 * ����:  1->3->2->0->null
 * ��� :0->1->2->3->null
 */
public class ����������� {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode insertionSortList(ListNode head) {
		// write your code here
		if (head == null) {
			return null;
		}
		// ����һ���սڵ�,�ų���������
		ListNode res = new ListNode(0);
		ListNode pos, q;
		while (head != null) {
			pos = res; // ��λҪ�����λ�� 
			q = head.next; // ������һ���ڵ�
			// Ѱ�Ҳ���λ��
			while (pos.next != null && pos.next.val < head.val) {
				pos = pos.next;
			}
			head.next = pos.next; // ��Ҫ����Ľڵ�nextָ��ָ��res��nextλ��
			pos.next = head; // ��res��nextָ��ָ�����ڵ�
			head = q; // �������±���
		}
		return res.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(1);
		node.next = new ListNode(3);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(0);
		ListNode res = insertionSortList(node);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}

}
