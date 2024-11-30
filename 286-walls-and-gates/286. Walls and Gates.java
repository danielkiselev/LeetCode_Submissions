class Solution {
    int ySize;
    int xSize;
    public void wallsAndGates(int[][] rooms) {
        try{
            ySize = rooms.length;
            xSize = rooms[0].length; 
        }
        catch(Exception e){
            return;
        }
        int [][] visited = new int [ySize][xSize];
        for(int y = 0; y<ySize; y++){
            for(int x = 0; x<xSize; x++){
                if(rooms[y][x] == 0){
                    rooms = update(rooms, y, x, 0,visited);
                }
            }
        }
    }
    
    private int[][] update(int[][] rooms, int y, int x, int distance, int [][] visited){
        if(rooms[y][x] == -1){
            return rooms;
        }
        if(distance != 0 && rooms[y][x] == 0){
            return rooms;
        }
        if(rooms[y][x] != 0){
            if(distance < rooms[y][x]){
                rooms[y][x] = distance;
            }
        }
        visited[y][x] = 1;
        if(y > 0){
            if(visited[y-1][x] == 0){
                visited[y-1][x] = 1;
                rooms = update(rooms, y-1, x, distance+1,visited);
                visited[y-1][x] = 0;
            }
        }
        if(y < (ySize-1)){
            if(visited[y+1][x] == 0){
                visited[y+1][x] = 1;
                rooms = update(rooms, y+1, x, distance+1,visited);
                visited[y+1][x] = 0;
            }
        }
        
        if(x > 0){
            if(visited[y][x-1] == 0){
                visited[y][x-1] = 1;
                rooms = update(rooms, y, x-1, distance+1,visited);
                visited[y][x-1] = 0;
            }
        }
        if(x < (xSize-1)){
            if(visited[y][x+1] == 0){
                visited[y][x+1] = 1;
                rooms = update(rooms, y, x+1, distance+1,visited);
                visited[y][x+1] = 0;

            }
        }
        return rooms;
    }
}