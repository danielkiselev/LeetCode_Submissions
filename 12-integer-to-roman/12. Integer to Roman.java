class Solution {
    public String intToRoman(int num) {
        
        StringBuilder sb = new StringBuilder();
        
        int M = num/1000;
        num = num-(M*1000); 
        System.out.println("M "+M);
        for(int i = 0; i<M; i++){
            sb.append("M");
        }
        
        int D = num/500;
        num = num-(D*500);
        System.out.println("D" +D);
        for(int i = 0; i<D; i++){
            sb.append("D");
        }

        int C = num/100;
        num = num-(C*100);
        System.out.println("C" +C);
        if(C == 4){
            sb.append("CD");
        }else{
            for(int i = 0; i<C; i++){
                sb.append("C");
            }
        }
        
        int L = num/50;
        num = num-(L*50); 
        System.out.println("L "+L);
        for(int i = 0; i<L; i++){
            sb.append("L");
        }
        
        int X = num/10;
        num = num-(X*10);
        System.out.println("X" +X);
        if(X == 4){
            sb.append("XL");
        }else{
            for(int i = 0; i<X; i++){
                sb.append("X");
            }
        }

        int V = num/5;
        num = num-(V*5);
        System.out.println("V" +V);
        for(int i = 0; i<V; i++){
            sb.append("V");
        }
        
        int K = num/1;
        num = num-(K*1);
        System.out.println("I" +K);
        if(K == 4){
            sb.append("IV");
        }else{
            for(int i = 0; i<K; i++){
                sb.append("I");
            }
        }

        
        return sb.toString();
    }
}