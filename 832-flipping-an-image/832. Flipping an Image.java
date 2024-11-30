class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0 ; i < A.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int z = 0 ; z < A[i].length; z++){
                if(A[i][z] == 0){
                    sb.append(1);
                }
                else{
                    sb.append(0);
                }
            }
            sb.reverse();
            String curr = sb.toString();
            for(int z = 0 ; z < A[i].length; z++){
                A[i][z] = Integer.parseInt(curr.substring(z,z+1));
            }
            sb = new StringBuilder();
        }
        return A;
    }
}