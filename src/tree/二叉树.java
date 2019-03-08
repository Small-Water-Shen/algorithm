package tree;

public class ������ {

	static Object[] arr = { "A", "B", "#", "D", "#", "#", "C", "E", "#", "#", "F", "#", "#" };
	static int pos = 0;

	static class TreeNode {
		public Object value;
		public TreeNode left, right;

		public TreeNode() {
			// TODO Auto-generated constructor stub
		}

		public TreeNode(Object value) {
			// TODO Auto-generated constructor stub
			this.value = value;
			this.left = this.right = null;
		}

		// ��ͨ������
		public void add(TreeNode val) {
			if (this.left == null) {
				this.left = val;
			} else if (this.right == null) {
				this.right = val;
			} else if (this.left != null) {
				this.left.add(val);
			} else {
				this.right.add(val);
			}
		}

		// ���������
		public void insert(TreeNode val) {
			// ����������
			if ((int) val.value < (int) this.value) {
				if (this.left == null) {
					this.left = val;
				} else {
					this.left.insert(val);
				}
			}
			// ����������
			else {
				if (this.right == null) {
					this.right = val;
				} else {
					this.right.insert(val);
				}
			}
		}

		public void visit() {
			System.out.print(this.value + " ");
		}
	}

	// �������
	public static void prePrint(TreeNode node) {
		if (node != null) {
			node.visit();
			prePrint(node.left);
			prePrint(node.right);
		}
	}

	// �������
	public static void midPrint(TreeNode node) {
		if (node != null) {
			midPrint(node.left);
			node.visit();
			midPrint(node.right);
		}
	}

	// �������
	public static void afterPrint(TreeNode node) {
		if (node != null) {
			afterPrint(node.left);
			afterPrint(node.right);
			node.visit();
		}
	}

	// �����������������, #Ϊ����
	public static TreeNode createTree() {
		if (pos >= arr.length) {
			return null;
		}
		TreeNode node;
		if (arr[pos].equals("#")) {
			node = null;
			pos++;
		} else {
			node = new TreeNode(arr[pos]);
			pos++;
			node.left = createTree();
			node.right = createTree();
		}
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode();
		root = createTree();
		prePrint(root);
		/*
		 * Object[] arr = { 4, 3, 7, 5, 8 }; TreeNode root = new TreeNode(arr[0]); for
		 * (int i = 1; i < arr.length; i++) { root.insert(new TreeNode(arr[i])); }
		 * prePrint(root);
		 */
	}

}
