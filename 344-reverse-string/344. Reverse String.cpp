class Solution {
public:
    void reverseString(vector<char>& s) {
        for(int i = 0; i<(s.size()/2); i++){
            char t0 = s[i];
            char t1 = s[(s.size()-1)-i];
            s[i] = t1;
            s[(s.size()-1)-i] = t0;
        }
        
    }
};