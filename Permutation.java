import java.util.Arrays;

public class Permutation {
	private static int[] data;
	private static int[] res;
	private static boolean[] visit;
	
	// 순열(Permutation): 순서가 중요하고 (123 != 321), 중복을 허용하지 않는 경우
	private static void permutation(int n, int r, int depth){
		if(depth == r){
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for(int i=0;i<n;i++){
			if(!visit[i]){
				visit[i] = true;
				res[depth] = data[i];
				
				permutation(n, r, depth + 1);
				
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		int N = 5;
		int R = 3;
		
		data = new int[]{ 1, 2, 3, 4, 5 };
		res = new int[R];
		visit = new boolean[N];
		
		permutation(N, R, 0);
	}
}