
public class Stack {
	private int[] stack;
	private int top; // 가장 최근에 입력되었던 자료를 가리키는 변수
	private int size; // 스택의 크기
	
	public Stack() {
		this.top = -1;
		this.size = 10;
		this.stack = new int[size];
	}
	
	public void push(int value) {
		if(isFull()) return;
		
		stack[++top] = value;
	}
	
	public int pop() {
		if(isEmpty()) throw new IndexOutOfBoundsException();
		else return stack[top--];
	}
	
	public int peek() {
		if(isEmpty()) throw new IndexOutOfBoundsException();
		else return stack[top];
	}
	
	public boolean isFull() {
		if(top == (size - 1)) return true;
		else return false;
	}
	
	public boolean isEmpty() {
		if(top == -1) return true;
		else return false;
	}
	
	public void print() {
		for(int i=0;i<=top;i++)
			System.out.print(stack[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();

		/* push */
		for(int i=1;i<=10;i++)
			stack.push(i);

		stack.print();
		
		System.out.println();
		
		/* peek */
		System.out.println("peek(): " + stack.peek() + "\n");
	
		/* pop */
		System.out.println("pop(): " + stack.pop());
		System.out.println("pop(): " + stack.pop());
		System.out.println("pop(): " + stack.pop());
		
		/* push */
		stack.push(121);
		stack.push(232);
		stack.push(334);
	
		System.out.println();

		stack.print();
	}
}