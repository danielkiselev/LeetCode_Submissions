class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        ArrayDeque <Integer> procQueue = new ArrayDeque <Integer>();
        procQueue.add(0);
        int counter = 0;
        int index = 1; 
        while(!procQueue.isEmpty()){
            int visiting = procQueue.poll();
            visited[visiting] = true;
            for(int j = 0; j<visited.length; j++){
                if(visited[j]){
                    continue;
                }
                else if(isConnected[visiting][j] == 1){
                    procQueue.add(j);
                    visited[j] = true;
                }
            }
            if(procQueue.isEmpty()){
                counter++;
                for(int i = index; i<visited.length; i++){
                    if(!visited[i]){
                        procQueue.add(i);
                        visited[i] = true;
                        index = i;
                        break;
                    }
                }
            }
        }
        return counter;
        
    }
}