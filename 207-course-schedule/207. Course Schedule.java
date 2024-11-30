public class Course
{
    // Instance Variables
    int number;
    ArrayList<Integer> egress = null;//requirement for these
    HashSet<Integer> ingress = null;//requires these
    // Constructor Declaration of Class
    public Course(int number){
        this.number = number; 
        this.ingress = new HashSet<Integer>();
        this.egress = new ArrayList<Integer>();
    }
    
    public void addEgress(Course c){
        this.egress.add(c.number);
    }
    public void addIngress(Course c){
        this.ingress.add(c.number);
    }
    
    
}

class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer,Course> courseDict = new HashMap<Integer,Course>();
        for(int i=0; i<prerequisites.length; i++){
            int currClass = prerequisites[i][0]; 
            int currPreq = prerequisites[i][1];
            if(currClass == currPreq){
                return false;
            }
            Course c1 = null;
            if(courseDict.containsKey(currClass)){
                c1 = courseDict.get(currClass);
            }
            else{
                c1 = new Course(currClass);
            }
            Course c2 = null;
            if(courseDict.containsKey(currPreq)){
                c2 = courseDict.get(currPreq);
            }
            else{
                c2 = new Course(currPreq);
            }
            c1.addIngress(c2);
            c2.addEgress(c1);
            courseDict.put(c1.number,c1);
            courseDict.put(c2.number,c2);
        }
        ArrayDeque<Integer> origin = new ArrayDeque<Integer>();
        for (Integer key : courseDict.keySet()) {
            Course c = courseDict.get(key);

            if(c.ingress.size() == 0 && c.egress.size()>0){
                origin.push(c.number);
            }
        }
        HashSet<Integer>visited = new HashSet<Integer>();
        while(origin.size()>0){
            Course curr = courseDict.get(origin.pop());
            visited.add(curr.number);
            for(Integer key: curr.egress){
                Course e = courseDict.get(key);
                e.ingress.remove(curr.number);
                if(e.ingress.size()==0 && !visited.contains(e.number) && e.egress.size()>0){
                    origin.push(e.number);
                }
            }
        }
        for (Integer key : courseDict.keySet()) {
            Course c = courseDict.get(key);
            if(c.ingress.size() > 0){
                return false;
            }
        }
        return true;

    }
}