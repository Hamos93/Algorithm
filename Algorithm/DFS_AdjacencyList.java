import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DFS_AdjacencyList {
	private static int N;
	private static List<Integer>[] adjList;
	private static boolean[] visit;
	
	private static void dfs(int node){
		visit[node] = true;
		System.out.print(node + " ");
		
		for(int next:adjList[node])
			if(!visit[next]) dfs(next);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 정점의 개수
		N = Integer.parseInt(st.nextToken());
		// 시작 정점
		int startNode = Integer.parseInt(st.nextToken());

		// ArrayList 1차원 배열 생성
		adjList = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		for(int i=1;i<N+1;i++)
			adjList[i] = new ArrayList<Integer>();
		
		while(true){
			st = new StringTokenizer(br.readLine(), " ");
			
			// 정점 간 연결 관계
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			// 입력 끝
			if(u == -1 && v == -1) break;
			
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		dfs(startNode);
	}
}