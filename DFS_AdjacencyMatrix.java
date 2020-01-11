import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_AdjacencyMatrix {
	private static int N;
	private static int[][] adjMatrix;
	private static boolean[] visit;
	
	private static void dfs(int node){
		visit[node] = true;
		// 방문한 정점 순서대로 출력
		System.out.print(node + " ");
		
		for(int next=1;next<N+1;next++)
			if(!visit[next] && adjMatrix[node][next] == 1) dfs(next);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 정점의 개수
		N = Integer.parseInt(st.nextToken());
		// 시작 정점
		int startNode = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		while(true){
			st = new StringTokenizer(br.readLine(), " ");
			
			// 정점 간 연결 관계
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			// 입력 끝
			if(u == -1 && v == -1) break;
			
			adjMatrix[u][v] = adjMatrix[v][u] = 1;
		}
	
		dfs(startNode);
	}
}