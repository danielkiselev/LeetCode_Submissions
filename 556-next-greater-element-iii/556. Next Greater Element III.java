class Solution {
    public int nextGreaterElement(int n) {
        String data = Integer.toString(n);
        if(data.length()<2 || data.length()>10){
            return -1;
        }
        int [] holder = new int [data.length()];
        for(int i = 0; i<data.length(); i++){
            holder[i] = Integer.parseInt(data.substring(i, i+1));
        }
        int stop = -1;
        for(int i = data.length()-1; i>0; i--){
            if(holder[i-1] < holder[i]){
                int min = i;
                for(int z = i+1; z<data.length(); z++){
                    if(holder[z]<holder[min] && holder[z]>holder[i-1]){
                        min = z;
                    }
                }
                int temp = holder[i-1];
                holder[i-1] = holder[min];
                holder[min] = temp;
                stop = i;
                break;
            }
        }
        if(stop == -1){
            return -1;
        }
        int [] preSort = Arrays.copyOfRange(holder, stop, data.length());
        Arrays.sort(preSort);
        int counter = 0;
        for(int i = stop; i<data.length(); i++){
            holder[i] = preSort[counter];
            counter++;
        }
        StringBuilder sb = new StringBuilder ();
        for(int i = 0; i<data.length(); i++){
            sb.append(holder[i]);
        }
        try{
             return Integer.parseInt(sb.toString());
        }
        catch(Exception e){
            return -1;
        }
    }
}