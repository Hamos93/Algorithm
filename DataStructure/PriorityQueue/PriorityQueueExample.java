import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueExample {
	public static void main(String[] args) {
		/* 우선순위 큐(min heap) 생성 */
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.offer(500);
		pq.offer(400);
		pq.offer(300);
		pq.offer(200);
		pq.offer(100);

		System.out.println("pq.peek(): " + pq.peek());
		
		while(!pq.isEmpty()) System.out.print(pq.poll() + " ");

		System.out.println("\n===================================");
		
		/* 우선순위 큐(max heap) 생성 */
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
	
		pq2.offer(500);
		pq2.offer(400);
		pq2.offer(300);
		pq2.offer(200);
		pq2.offer(100);
		
		System.out.println("pq2.peek(): " + pq2.peek());
		
		while(!pq2.isEmpty()) System.out.print(pq2.poll() + " ");

		System.out.println("\n===================================");
	}
}