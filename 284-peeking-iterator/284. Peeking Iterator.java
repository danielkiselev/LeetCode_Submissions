// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Integer nextVal = null;
    Iterator<Integer> iterator;

	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iterator = iterator;
        nextVal = iterator.next();
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextVal;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer res = nextVal;
        if(iterator.hasNext()){
            nextVal = iterator.next();
        }
        else{
            nextVal = null;
        }
        return res;
	}

	@Override
	public boolean hasNext() {
	    if(nextVal != null){
            return true;
        }
        return false;
	}
}