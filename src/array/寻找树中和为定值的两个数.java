package array;

import java.util.Vector;

// ע����Ŀ����˼��Ҫ��ͷ��㵽Ҷ�ӵ�·��
public class Ѱ�����к�Ϊ��ֵ�������� {

	// ʵ�����ڵ�
	static class Node {
		int data;
		Node left;
		Node right;

		public Node() {
		}

		public Node(int data) {
			this.data = data;
		}

		public void display() {
			System.out.println(this.data);
		}
	}

	// ʵ�ֶ�����
	static class Tree {
		// ���ڵ�
		Node root;

		public Tree() {
		}

		// insert
		public boolean insert(int data) {
			Node node = new Node(data);
			// ����, ֱ����Ϊ���ڵ�
			if (this.root == null) {
				this.root = node;
				return true;
			} else {
				Node current = this.root;
				Node parentNode = null;
				// �������
				while (current != null) {
					parentNode = current;
					// �Ƚ��½ڵ�����ڵ�Ƚ�, ��С���������,�ϴ��������
					if (current.data >= data) {
						current = current.left;
						// �����������
						if (current == null) {
							parentNode.left = node;
							return true;
						}
					} else {
						current = current.right;
						// �����������
						if (current == null) {
							parentNode.right = node;
							return true;
						}
					}
				}
			}
			return false;
		}

		// �������
		public void prePrint(Node node) {
			if (node != null) {
				node.display();
				prePrint(node.left);
				prePrint(node.right);
			}
		}

		// �������
		public void midPrint(Node node) {
			if (node != null) {
				midPrint(node.left);
				node.display();
				midPrint(node.right);
			}
		}

		// �������
		public void lastPrint(Node node) {
			if (node != null) {
				lastPrint(node.left);
				lastPrint(node.right);
				node.display();
			}
		}
	}

	// ����·����vector
	static Vector<Integer> path = new Vector<>();

	// ��ǰ�ڵ��Ƿ�����Ҷ�ڵ�
	public static boolean isLeaf(Node node) {
		return (node.left == null) || (node.right == null);
	}

	// ��ӡ·��
	public static void printPath() {
		for (Integer integer : path) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}

	public static void find(Node node, int cur_num, int number) {
		if (node == null) {
			return;
		}
		int data = node.data;
		path.add(data);
		cur_num += data;
		// check
		if (cur_num == number && isLeaf(node)) {
			printPath();
			// ע��, �����ӡ����Ҫ����.
			// ...
		}
		// ��ݹ����
		if (node.left != null) {
			find(node.left, cur_num, number);
		}
		// �ҵݹ����
		if (node.right != null) {
			find(node.right, cur_num, number);
		}
		// ����
		path.remove(path.size() - 1);  // ɾ������ӵ�Ԫ��
		cur_num -= data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree = new Tree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(12);
		tree.insert(4);
		tree.insert(7);
		tree.prePrint(tree.root);
		find(tree.root, 0, 22);
	}

}
