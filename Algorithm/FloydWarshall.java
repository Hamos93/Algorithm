import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FloydWarshall {
	// 무한을 의미하는 값으로 10억 설정
	private static final int INF = (int) 1e9;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 노드, 간선 개수 입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 그래프 초기화
		int[][] graph = new int[N + 1][N + 1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i == j) graph[i][j] = 0;
				else graph[i][j] = INF;
			}
		}
		
		// 그래프 입력
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u][v] = w;
		}
		
		// 플로이드 워셜 알고리즘 수행
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++)
				for(int j=1;j<=N;j++)
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
		}
		
		// 결과 출력
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(graph[i][j] == INF) System.out.print(INF + " ");
				else System.out.print(graph[i][j] + " ");
			}
			
			System.out.println();
		}
	}
}