import java.util.Arrays;

public class BinarySearch {
	/* [ 재귀함수로 구현한 이진탐색 ] */
	public static int recursiveBinarySearch(int[] array, int target, int start, int end) {
		if(end < start) return -1;
		
		int mid = (start + end) / 2;
		
		/* 찾은 경우 중간점 인덱스 반환 */
		if(array[mid] == target) return mid;
		
		/* 중간점 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인 */
		if(target < array[mid]) return recursiveBinarySearch(array, target, start, mid - 1);
		
		/* 중간점 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인 */
		if(array[mid] < target) return recursiveBinarySearch(array, target, mid + 1, end);
		
		return -1;
	}
	
	/* [ 반복문으로 구현한 이진탐색 ] */
	public static int loopBinarySearch(int[] array, int target, int start, int end) {
		while(start <= end) {
			int mid = (start + end) / 2;
			
			/* 찾은 경우 중간점 인덱스 반환 */
			if(array[mid] == target) return mid;
			
			/* 중간점 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인 */
			if(target < array[mid]) end = mid - 1;
			
			/* 중간점 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인 */
			if(array[mid] < target) start = mid + 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = { 55, 23, 61, 34, 10, 65, 98, 77, 2, 15  };
		
		/* 이진탐색은 항상 정렬된 리스트에만 적용이 가능한 알고리즘 */
		System.out.println("정렬 전: " + Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("정렬 후: " + Arrays.toString(array));
		
		/* 재귀함수로 구현한 이진탐색 */
		int idx = recursiveBinarySearch(array, 34, 0, array.length - 1);
		
		if(idx == -1) System.out.println("해당 원소가 존재하지 않습니다.");
		else System.out.println((idx + 1) + "번째 원소");
	
		/* 반복문으로 구현한 이진탐색 */
		idx = loopBinarySearch(array, 34, 0, array.length - 1);
		
		if(idx == -1) System.out.println("해당 원소가 존재하지 않습니다.");
		else System.out.println((idx + 1) + "번째 원소");
	}
}