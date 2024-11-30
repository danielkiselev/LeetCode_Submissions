class Solution {
    public String nextClosestTime(String time) {
        String hS = time.substring(0,2);
        String mS = time.substring(3,5);
        int [] hour = {Character.getNumericValue(hS.charAt(0)),Character.getNumericValue(hS.charAt(1))};
        int [] min = {Character.getNumericValue(mS.charAt(0)),Character.getNumericValue(mS.charAt(1))};
        HashSet <Integer> dupCheck = new HashSet <Integer>();
        dupCheck.add(hour[0]);
        dupCheck.add(hour[1]);
        dupCheck.add(min[0]);
        dupCheck.add(min[1]);
        int [] digits = new int [dupCheck.size()];
        int index = 0;
        for(Integer i : dupCheck){
            digits[index] = i;
            index++;
        }
        Arrays.sort(digits);
        for(int i = 0; i<digits.length; i++){
            if(digits[i] == min[1]){
                if(i+1<digits.length){
                    if(((min[0]*10)+digits[i+1]) < 60){
                        StringBuilder sb = new StringBuilder(time.substring(0,4));
                        sb.append(digits[i+1]);
                        return sb.toString();
                    }
                    break;
                }
                break;
            }
        }
        min[1] = digits[0];
        for(int i = 0; i<digits.length; i++){
            if(digits[i] == min[0]){
                if(i+1<digits.length){
                    if(((digits[i+1]*10)+min[1]) < 60){
                        StringBuilder sb = new StringBuilder(time.substring(0,3));
                        sb.append(digits[i+1]);
                        sb.append(min[1]);
                        return sb.toString();
                    }
                    break;
                }
                break;
            }
        }
        min[0] = digits[0];
        for(int i = 0; i<digits.length; i++){
            if(digits[i] == hour[1]){
                if(i+1<digits.length){
                    if(((hour[0]*10)+digits[i+1]) < 24){
                        StringBuilder sb = new StringBuilder();
                        sb.append(hour[0]);
                        sb.append(digits[i+1]);
                        sb.append(":");
                        sb.append(min[0]);
                        sb.append(min[1]);
                        return sb.toString();
                    }
                    break;
                }
                break;
            }
        }
        hour[1] = digits[0];
        for(int i = 0; i<digits.length; i++){
            if(digits[i] == hour[0]){
                if(i+1<digits.length){
                    if(((digits[i+1]*10)+hour[1]) < 24){
                        StringBuilder sb = new StringBuilder();
                        sb.append(digits[i+1]);
                        sb.append(hour[1]);
                        sb.append(":");
                        sb.append(min[0]);
                        sb.append(min[1]);
                        return sb.toString();
                    }
                    break;
                }
                break;
            }
        }
        hour[0] = digits[0];
        StringBuilder sb = new StringBuilder();
        sb.append(hour[0]);
        sb.append(hour[1]);
        sb.append(":");
        sb.append(min[0]);
        sb.append(min[1]);
        return sb.toString();
        
    }
}