
/* Node 클래스 */
class Node {
	Object data;
	Node leftLink;
	Node rightLink;

	public Node(Object data) {
		this.data = data;
		this.leftLink = null;
		this.rightLink = null;
	}
	
	public Object getData() {
		return this.data;
	}
}

//      n1
//     /  \
//   n2    n3
//  /  \  /  \
//  n4 n5 n6  n7

/* Tree 클래스 */
public class Tree {
	Node root;
	
	public Tree() {
		this.root = null;
	}
	
	public void setRoot(Node node) {
		this.root = node;
	}
	
	public Object getRoot() {
		return this.root.getData();
	}
	
	/* 노드 삽입 */
	public Node addNode(Node leftNode, Object data, Node rightNode) {
		// 노드 생성
		Node node = new Node(data);
		
		// 부모와 자식 노드 간의 연결
		node.leftLink = leftNode;
		node.rightLink = rightNode;
	
		return node;
	}
	
	/* 중위순회 */
	public void inorder(Node root) {
		if(root != null) {
			inorder(root.leftLink); // 왼쪽 서브트리 순회
			System.out.print(root.getData() + " "); // 노드 방문
			inorder(root.rightLink); // 오른쪽 서브트리 순회
		}
	}
	
	/* 전위순회 */
	public void preorder(Node root) {
		if(root != null) {
			System.out.print(root.getData() + " "); // 노드 방문
			preorder(root.leftLink); // 왼쪽 서브트리 순회
			preorder(root.rightLink); // 오른쪽 서브트리 순회
		}
	}
	
	/* 후위순회 */
	public void postorder(Node root) {
		if(root != null) {
			postorder(root.leftLink); // 왼쪽 서브트리 순회
			postorder(root.rightLink); // 오른쪽 서브트리 순회
			System.out.print(root.getData() + " "); // 노드 방문
		}
	}
	
	public static void main(String[] args) {
		/* 트리 생성 */
		Tree tree = new Tree();
		
		Node n7 = tree.addNode(null, 7, null);
		Node n6 = tree.addNode(null, 6, null);
		Node n5 = tree.addNode(null, 5, null);
		Node n4 = tree.addNode(null, 4, null);
		
		Node n3 = tree.addNode(n6, 3, n7);
		Node n2 = tree.addNode(n4, 2, n5);
		Node n1 = tree.addNode(n2, 1, n3);
		
		/* 루트노드 지정 */
		tree.setRoot(n1);
		
		System.out.println("[Root Node: " + tree.getRoot() + "]");
		System.out.println("[n1: " + n1.getData() + "] leftChilderen: " + n1.leftLink.getData() + ", rightChilderen: " + n1.rightLink.getData());
		System.out.println("[n2: " + n2.getData() + "] leftChilderen: " + n2.leftLink.getData() + ", rightChilderen: " + n2.rightLink.getData());
		System.out.println("[n3: " + n3.getData() + "] leftChilderen: " + n3.leftLink.getData() + ", rightChilderen: " + n3.rightLink.getData());
		System.out.println("\n====================================================\n");

		/* 중위순회(inorder traversal) */
		System.out.print("[중위순회]: ");
		tree.inorder(n1);
		
		System.out.println();
		
		/* 전위순회(preorder traversal) */
		System.out.print("[전위순회]: ");
		tree.preorder(n1);
		
		System.out.println();
		
		/* 후위순회(postorder traversal) */
		System.out.print("[후위순회]: ");
		tree.postorder(n1);
	}
}