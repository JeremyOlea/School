import java.io.PrintWriter;
import java.io.IOException;
//import java.util.PriorityQueue;

class Graph {
	int n;
	int[][] adj;

	public Graph(int[][] _adj) {
		adj = _adj;
		n = adj.length;
	}

	public void printGraph(String outFile) throws IOException {
		PrintWriter pr = new PrintWriter(outFile);
		pr.println("Edge\t\tWeight");
		boolean[] vis = new boolean[n];
		this.DFS(0, vis, pr);
		pr.close();
	}

	private void DFS(int u, boolean[] vis, PrintWriter pr) {
        vis[u] = true;
        for(int i = 0; i < n; i++) {
            if(!vis[i] && adj[u][i] != 0) {
                pr.println(u + " - " + i + "\t\t" + adj[u][i]);
                this.DFS(i, vis, pr);
            }
        }
	}

	public void printMST(String outFile) throws IOException {
		PrintWriter pr = new PrintWriter(outFile);
		pr.println("Edge\t\tWeight");
		this.prim(0, pr);
		pr.close();
	}

	private void prim(int s, PrintWriter pr) {
        int[] minSpanningTree = new int[n];
        int[] key = new int[n];
        boolean[] mySet = new boolean[n];

        for(int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            mySet[i] = false;
        }

        minSpanningTree[0] = -1;
        key[0] = 0;
        for(int i = 0; i < n-1; i++) {
            int min = minKey(key, mySet);
            mySet[min] = true;

            for(int j = 0; j < n; j++) {
                if(adj[min][j] != 0 && mySet[j] == false && adj[min][j] < key[j]) {
                    minSpanningTree[j] = min;
                    key[j] = adj[min][j];
                }
            }
        }
        this.printMST(minSpanningTree, pr);
    }
    
    private int minKey(int[] key, boolean[] mySet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < n; i++) {
            if(mySet[i] == false && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void printMST(int[] minSpanningTree, PrintWriter pr) 
    { 
        for (int i = 1; i < n; i++) 
            pr.println(minSpanningTree[i]+" - "+ i+"\t\t"+ adj[i][minSpanningTree[i]]); 
    } 
}