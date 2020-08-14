
/* Node 클래스 */
class Node {
	Object data;
	Node link;

	public Node(Object data) {
		this.data = data;
		this.link = null;
	}
}

/* LinkedList 클래스 */
public class LinkedList {
	/* 헤드노드: 첫 번째 노드를 가리키는 하나의 변수, 헤드노드로 리스트 전체의 노드에 접근 */
	Node headNode;
	int len;

	public LinkedList() {
		this.headNode = new Node(null);
		this.len = 0;
	}

	/* 삽입연산 */
	public void add(Object data, int idx) {
		if(len < idx) throw new IndexOutOfBoundsException("Index Error");
		
		Node newNode = new Node(data);
		Node preNode = null;
		
		/* 공백리스트인 경우 */
		if(headNode.link == null) {
			headNode.link = newNode;
			len++;
			
			return;
		}

		/* 특정 위치에 노드를 삽입하는 경우 */
		preNode = getNode(idx - 1);

		newNode.link = preNode.link;
		preNode.link = newNode;

		len++;
		
		return;
	}

	/* 삭제연산: 특정 위치에 노드를 삭제 */
	public void remove(int idx) {
		if(len < idx) throw new IndexOutOfBoundsException("Index Error");
		
		Node removeNode = getNode(idx); 
		Node preNode = getNode(idx - 1);
		
		preNode.link = removeNode.link;
		removeNode.link = null;

		len--;
	}
	
	/* 특정 위치에 노드 반환 */
	public Node getNode(int idx) {
		/* 헤드노드를 통해 특정 노드에 접근 */
		if(idx == -1) return headNode;
		
		Node node = headNode.link;
		
		for(int i=0;i<idx;i++)
			node = node.link;
		
		return node;
	}

	public void print() {
		/* 헤드노드를 통해 리스트 전체 노드에 접근 */
		Node node = headNode.link;

		if(node == null) {
			System.out.println("[공백리스트]");
			return;
		}

		System.out.println("[노드 " + len + "개를 저장한 연결리스트 출력]");
		for(int i=0;i<len;i++) {
			System.out.print(node.data + " ");
			node = node.link;
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
	
		list.print();
		
		System.out.println("=======================");
		
		list.add(1, 0);
		list.add(2, 1);
		list.add(3, 2);
		list.add(4, 3);
		list.add(5, 4);
		
		list.print();
		
		System.out.println("=======================");

		list.add("가", 1);
		list.add("나", 3);
		list.add("다", 5);
		
		list.print();

		System.out.println("=======================");
		
		list.add(true, 0);
		list.add(false, 9);
		
		list.print();
		
		System.out.println("=======================");
		
		System.out.println("1번째 노드 출력: " + list.getNode(1 - 1).data);
		System.out.println("3번째 노드 출력: " + list.getNode(3 - 1).data);
		System.out.println("5번째 노드 출력: " + list.getNode(5 - 1).data);
		System.out.println("7번째 노드 출력: " + list.getNode(7 - 1).data);
		
		System.out.println("=======================");
		
		list.remove(3);
		list.remove(1);
		list.remove(list.len - 1);
		list.remove(0);
		
		list.print();
	}
}