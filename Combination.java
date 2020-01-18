import java.util.Arrays;

public class Combination {
	private static int[] data;
	private static int[] res;
	private static boolean[] visit;
	
	// 조합(combination): 순서가 중요하지 않고 (123 == 321), 중복을 허용하지 않는 경우
	private static void combination(int n, int r, int depth, int start){
		if(depth == r){
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for(int i=start;i<n;i++){
			if(!visit[i]){
				visit[i] = true;
				res[depth] = data[i];
				
				combination(n, r, depth + 1, i);
				
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
		
		combination(N, R, 0, 0);
	}
}