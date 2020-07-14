
public class Queue {
	private int[] queue;
	private int front; // 삭제를 위한 변수, 큐의 첫 번째 요소를 가리킴
	private int rear;  // 삽입을 위한 변수, 큐의 마지막 요소를 가리킴
	private int size; // 큐의 크기

	/* 
	 * [선형 큐의 문제점]
	 * front와 rear의 값이 계속 증가만 하기 때문에 언젠가는 배열의 끝에 도달하게 되고
	 * 배열의 앞부분이 비어 있더라고 사용하지 못하는 문제가 발생
	 * 
	 * 따라서 주기적으로 모든 요소들을 왼쪽으로 이동시키면 문제는 해결되지만 매번 이동시키려면
	 * 상당한 시간이 걸리고 코딩이 복잡해짐
	 */
	public Queue() {
		this.front = -1;
		this.rear = -1;
		this.size = 20;
		this.queue = new int[size];
	}
	
	/* 삽입 연산 시 rear를 하나 증가하고 그 위치에 데이터가 저장 */
	public void enqueue(int value) {
		if(isFull()) {
			System.out.println("Queue is Full");
			return;
		};
		
		queue[++rear] = value;
	}
	
	/* 삭제 연산 시 front를 하나 증가하고 front가 가리키는 위치에 있는 데이터 삭제 */
	public int dequeue() {
		if(isEmpty()) throw new ArrayIndexOutOfBoundsException();
		else return queue[++front];
	}
	
	public int peek() {
		if(isEmpty()) throw new ArrayIndexOutOfBoundsException();
		else return queue[front + 1];
	}
	
	public boolean isFull() {
		if(rear == (size - 1)) return true;
		else return false;
	}
	
	public boolean isEmpty() {
		if(front == rear) return true;
		else return false;
	}
	
	public void print() {
		for(int i=front+1;i<=rear;i++)
			System.out.print(queue[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();

		/* enqueue */
		for(int i=1;i<=10;i++)
			queue.enqueue(i);
		
		queue.print();
		
		System.out.println();
		
		/* peek */
		System.out.println("peek(): " + queue.peek() + "\n");
		
		/* dequeue */
		System.out.println("dequeue(): " + queue.dequeue());
		System.out.println("dequeue(): " + queue.dequeue());
		System.out.println("dequeue(): " + queue.dequeue());
		
		/* peek */
		System.out.println("peek(): " + queue.peek() + "\n");
		
		/* enqueue */
		queue.enqueue(121);
		queue.enqueue(232);
		queue.enqueue(334);

		queue.print();
	}
}