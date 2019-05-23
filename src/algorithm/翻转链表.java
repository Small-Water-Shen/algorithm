package algorithm;

/*
 * ��תһ������
 * �������� 1->2->3, ��ת����Ϊ 3->2->1
 */
public class ��ת���� {
	
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			this.val = x;
			this.next = null;
		}
	}
	
	// ͷ�巨
    public static ListNode reverse(ListNode head) {
        // write your code here
    	// ��֤���ٺ����������ݽڵ�
    	if (head == null) {
			return null;
		}
    	if (head != null && head.next == null) {
			return head;
		}
    	// LΪreverse�������pΪ��ǰ�ڵ㣬q����p����һ���ڵ�
    	ListNode L = null, p = head, q = null; 
     	while (p != null) {
     		q = p.next; // q����p����һ���ڵ�
 			p.next = L; // �Ƚ�p��ǰ��next�ڵ�ָ��L��next�ڵ�
 			L = p; // p�ڵ�ӵ�L�ڵ��
 			p = q;
 		}
     	return L;
//    	return recursion(head);
    }
    
    /*
     * 1->2->3->null => null<-1<-2<-3
     */
    public static ListNode recursion(ListNode head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	ListNode p = recursion(head.next); // �����ڶ����ڵ�
    	head.next.next = head; // �����һ���ڵ�ָ�����ڶ����ڵ�
    	head.next = null; // �������ڶ����ڵ������ϣ���ֹ�γɻ���
    	return p;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		ListNode res = reverse(l1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
