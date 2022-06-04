/*
 * @author Kola Ladipo
 */



public class ShortestPath {
    public int dijkstra(int graph[][], int a, int b){
        int bandwidth[] = new int[graph.length];

        boolean visited[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            visited[i] = false;
            bandwidth[i] = 0;
        }

        bandwidth[a] = Integer.MAX_VALUE;

        for(int j = 0; j < graph.length; j++){
            int max = max(bandwidth,visited);
            visited[max] = true;
            for(int l = 0; l < graph.length; l++)
            {
                if(!visited[l] && graph[max][l] != 0 && bandwidth[max] != 0 && Math.min(bandwidth[max], graph[max][l]) > bandwidth[l]){
                    bandwidth[l] = Math.min(bandwidth[max], graph[max][l]);
                }
            }
        }
        return bandwidth[b];
    }

    public int max(int bandwidth[], boolean visited[]){
        int max = 0, index = -1;
        for(int k = 0; k < bandwidth.length; k++){
            if(!visited[k] && bandwidth[k] >= max){
                max = bandwidth[k];
                index = k;
            }
        }
        return index;
    }

    public static void main(String args[]) {
        int[][] graph = {{0,85,217,0,173,0,0,0,0,0},
        		         {85,0,0,0,0,80,0,0,0,0},
        		         {217,0,0,0,0,0,186,103,0,0},
        		         {0,0,0,0,0,0,0,183,0,0},
        		         {173,0,0,0,0,0,0,0,0,502},
        		         {0,80,0,0,0,0,0,0,250,0},
        		         {0,0,186,0,0,0,0,0,0,0},
        		         {0,0,103,183,0,0,0,0,0,0},
        		         {0,0,0,0,0,250,0,0,0,84},
        		         {0,0,0,0,502,0,0,167,84,0}};

        ShortestPath p = new ShortestPath();
        System.out.println("Maximum bandwidth between switching centers a and b: " + p.dijkstra(graph, 0,9));
    }
}
