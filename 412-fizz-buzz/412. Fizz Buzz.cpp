class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector <string> res;
        for(int i = 1; i<=n; i++ ){
            string t = "";
            if(i%3 == 0){
                t = "Fizz";
            }
            if(i%5 == 0){
                t += "Buzz";
            }
            if(t == ""){
                t = to_string(i);
            }
            res.push_back(t);
        }
        return res;
        
    }
};