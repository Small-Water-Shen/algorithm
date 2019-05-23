package algorithm;

/*
 * ��ת�����е�m���ڵ㵽��n���ڵ�Ĳ���,m��n����1 �� m �� n �� ������
 * ����: 1->2->3->4->5->NULL, m = 2 and n = 4, 
 * ���: 1->4->3->2->5->NULL.
 */
public class ��ת����2 {

	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			this.val = x;
			this.next = null;
		}
	}
	
	// ͷ�巨
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
    	if (head == null) {
			return null;
		}
    	if (m == n) {
			return head;
		}
    	// ����mΪ1�����
    	ListNode L = new ListNode(0);
    	L.next = head;
    	head = L;
    	// �ҵ�mλ��
    	for (int i = 1; i < m; ++i) {
			head = head.next;
		}
    	/* ��head��������֣�
    	 * preλ�ڷ�ת���ֵ�ǰ�棬endλ�ڷ�ת���ֵĺ���
    	 */
    	ListNode pre = head, end = head.next;
    	// pΪ��ת���֣�qΪ��ת���ֺ���Ľڵ�, tΪ��ʱ����
    	ListNode p = head.next, q = p.next, t = null;
    	for (int i = m; i < n; i++) {
    		// ͷ�巨
    		t = q.next; // q����p����һ���ڵ�
    		q.next = p; // �Ƚ�q��ǰ��next�ڵ�ָ��p��next�ڵ�
    		p = q; // q�ڵ�ӵ�p�ڵ��
    		q = t; // ���µ���
		}
    	// ƴ��
    	pre.next = p;
    	end.next = q;
    	return L.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		ListNode res = reverseBetween(l1, 2, 4);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
