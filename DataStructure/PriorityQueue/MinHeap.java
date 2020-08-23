
/*
 * [최소 힙(min heap)]
 * - 부모노드의 키 값이 자식노드의 키 값보다 작거나 같은 완전이진트리
 * - key(부모노드) <= key(자식노드)
 * - 루트노드가 가장 작은 값
 * - 힙의 삽입, 삭제 연산은 연산 후 정렬이 필요
 */

import java.util.ArrayList;

class Heap {
	// 힙을 저장하는 표준적인 자료구조는 배열
	ArrayList<Integer> heap = new ArrayList<>();
	
	public Heap() {
		this.heap = new ArrayList<>();
		
		// 1번 인덱스부터 사용
		heap.add(Integer.MIN_VALUE);
	}
	
	/* 삽입 연산 */
	public void add(int value) {
		// 새 요소를 힙 마지막에 추가
		heap.add(value);
		int idx = heap.size() - 1;
		
		/* 히프 재구성 -> key(부모노드) <= key(자식노드) */
		while(1 < idx && heap.get(idx) < heap.get(idx / 2)) {
			int temp = heap.get(idx / 2);
			heap.set(idx/2, heap.get(idx));
			heap.set(idx, temp);
		
			idx /= 2;
		}
	}
	
	/* 삭제 연산 */
	public int remove() {
		if(heap.size() - 1 < 1) return Integer.MIN_VALUE;
	
		// 최소 힙에서 삭제연산은 최솟값을 가진 요소를 삭제
		int result = heap.get(1);
	
		// 마지막 노드를 루트로 이동
		heap.set(1, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		
		/* 히프 재구성 -> key(부모노드) <= key(자식노드) */
		int idx = 1;
		while((idx * 2) <= heap.size() - 1) {
			int min = heap.get(idx * 2);
			int minIdx = idx * 2;
			
			// 왼쪽과 오른쪽 자식 중 더 작은 값과 교환
			if(((idx * 2 + 1) <= heap.size() - 1) && heap.get(idx * 2 + 1) < min) {
				min = heap.get(idx * 2 + 1);
				minIdx = idx * 2 + 1;
			}
			
			if(heap.get(idx) < min) break;
			
			// 부모노드와 자식노드 교환
			int temp = heap.get(idx);
			heap.set(idx, heap.get(minIdx));
			heap.set(minIdx, temp);
			
			idx = minIdx;
		}
		
		return result;
	}
	
	public void print() {
		for(int i=1;i<=heap.size() - 1;i++)
			System.out.print(heap.get(i) + " ");
		System.out.println();
	}
}

public class MinHeap {
	public static void main(String[] args) {
		Heap heap = new Heap();
		
		heap.add(5);
		heap.add(4);
		heap.add(3);
		heap.add(2);
		heap.add(1);
		
		heap.print();
		System.out.println("====================================================");
		
		System.out.println("최솟값 삭제 -> " + heap.remove());
		heap.print();
		System.out.println("====================================================");

		System.out.println("최솟값 삭제 -> " + heap.remove());
		heap.print();
		System.out.println("====================================================");
		
		System.out.println("최솟값 삭제 -> " + heap.remove());
		heap.print();
		System.out.println("====================================================");
		
		heap.add(1);
		heap.add(2);
		heap.add(3);
		heap.print();
		System.out.println("====================================================");
	}
}
