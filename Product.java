import java.util.Arrays;

public class Product {
	private static int[] data;
	private static int[] res;
	
	// 중복순열(Product): 순서가 중요하고 (123 != 321), 중복을 허용하는 경우
	private static void product(int n, int r, int depth){
		if(depth == r){
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for(int i=0;i<n;i++){
			res[depth] = data[i];
			product(n, r, depth + 1);
		}
	}
	
	public static void main(String[] args) {
		int N = 5;
		int R = 3;
		
		data = new int[]{ 1, 2, 3, 4, 5 };
		res = new int[R];
		
		product(N, R, 0);
	}
}