class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        ArrayDeque <Integer> procQueue = new ArrayDeque <Integer>();
        procQueue.add(0);
        int counter = 0;
        while(!procQueue.isEmpty()){
            int visiting = procQueue.poll();
            visited[visiting] = 1;
            for(int j = 0; j<n; j++){
                if(visited[j] == 1){
                    continue;
                }
                else if(isConnected[visiting][j] == 1){
                    procQueue.add(j);
                    visited[j] = 1;
                }
            }
            if(procQueue.isEmpty()){
                counter++;
                for(int i = 0; i<n; i++){
                    if(visited[i] == 0){
                        procQueue.add(i);
                        visited[i] = 1;
                        break;
                    }
                }
            }
        }
        return counter;
        
    }
}