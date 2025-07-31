class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        for(int i =0 ;i < isConnected.length ; i++){
            if(visited[i] == 0){
                count ++;
                dfs(i,isConnected,visited);
            }
        }
        return count;
    }

    private void dfs(int node, int[][] connected, int[] visited){
        visited[node] = 1;
        for(int j = 0; j < connected.length ; j ++){
            if(visited[j]!=0){
                continue;
            }
            else if(connected[node][j] == 1){
                visited[j] = 1;
                dfs(j,connected, visited);
            }
        }
    }
}