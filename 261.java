public class Solution {
    public boolean DFS(int id, boolean[] node, boolean[] edge, int[][] edges){
    	if(node[id])
    		return false;
    	node[id] = true;
    	for(int i = 0; i < edges.length; i++){
    		if(edges[i][0] == id && !edge[i]){
    			edge[i] = true;
    			if(!DFS(edges[i][1], node, edge, edges))
    				return false;
    		}
    		else if(edges[i][1] == id && !edge[i]){
				edge[i] = true;
				if(!DFS(edges[i][0], node, edge, edges))
    				return false;
    		}
    	}
    	return true;
    }

    public boolean check(boolean[] arr){
        for(boolean a:arr){
            if(!a)
        		return false;
        }   
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
		int num_edge = edges.length;
		boolean[] stepthrough = new boolean[num_edge];
		boolean[] visited = new boolean[n];
		return DFS(0, visited, stepthrough, edges) && check(visited);
    }
}