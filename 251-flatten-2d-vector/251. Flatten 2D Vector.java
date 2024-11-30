public class Vector2D implements Iterator<Integer> {

    ArrayDeque <Integer> queue = new ArrayDeque <Integer>();
    public Vector2D(List<List<Integer>> vec2d) {
        for(List<Integer> l : vec2d){
            for(Integer val : l){
                queue.add(val);
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        if(queue.peek() == null){
            return false;
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */