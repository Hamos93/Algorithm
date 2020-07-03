import java.util.Arrays;

public class Permutation_loop {
	private static int[] data;

	private static void swap(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	private static boolean nextPermutation(int n) {
		// 1. A[i - 1] < A[i]를 만족하는 가장 큰 i 찾기
		int i = n - 1;
		while(0 < i && data[i] <= data[i-1]) i--;
		if(i <= 0) return false; // 마지막 순열인 경우

		// 2. A[i - 1] < A[j]를 만족하는 가장 큰 j 찾기
		int j = n - 1;
		while(data[j] <= data[i-1]) j--;

		// 3. swap(A[i-1], A[j])
		swap(i-1, j);

		// 4. A[i]부터 순열 뒤집기
		j = n - 1;
		while(i < j) {
			swap(i, j);
			i++; j--;
		}

		return true; // 다음순열이 존재하는 경우
	}

	private static boolean previousPermutation(int n) {
		int i = n - 1;
		while(0 < i && data[i-1] <= data[i]) i--;
		if(i <= 0) return false;

		int j = n - 1;
		while(data[i-1] <= data[j]) j--;

		swap(i-1, j);

		j = n - 1;
		while(i < j) {
			swap(i, j);
			i++; j--;
		}

		return true;
	}

	public static void main(String[] args) {
		data = new int[] { 1, 3, 2, 4 };
		int len = data.length;

		System.out.println("순열: " + Arrays.toString(data) + "\n");
		
		if(nextPermutation(len)) {
			System.out.print("다음순열: ");
			System.out.println(Arrays.toString(data));
		}else System.out.println("마지막 순열");

		System.out.println();
		data = new int[] { 1, 3, 2, 4 };

		if(previousPermutation(len)) {
			System.out.print("이전순열: ");
			System.out.println(Arrays.toString(data));
		}else System.out.println("첫번째 순열");
	}
}