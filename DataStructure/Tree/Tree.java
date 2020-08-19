
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
}

//		n1
//	   /  \
//	 n2    n3
//  /  \  /  \
//  n4 n5 n6  n7   

/* Tree 클래스 */
public class Tree {
	
	/* 트리 순회 함수 */
	
	public static void main(String[] args) {
		/* 노드 생성 */
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
	
		/* 부모와 자식 노드 간의 연결 */
		n1.leftLink = n2;
		n1.rightLink = n3;
		
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		n2.leftLink = n4;
		n2.rightLink = n5;
		
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		
		n3.leftLink = n6;
		n3.rightLink = n7;
		
		System.out.println("[n1: " + n1.data + "] leftChilderen: " + n1.leftLink.data + ", rightChilderen: " + n1.rightLink.data);
		System.out.println("[n2: " + n2.data + "] leftChilderen: " + n2.leftLink.data + ", rightChilderen: " + n2.rightLink.data);
		System.out.println("[n3: " + n3.data + "] leftChilderen: " + n3.leftLink.data + ", rightChilderen: " + n3.rightLink.data);
	}
}