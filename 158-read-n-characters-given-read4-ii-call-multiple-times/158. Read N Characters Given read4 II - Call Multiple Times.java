/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] buf;
    int index = 0;
    public int read(char[] buf, int n) {
        if(buf.length == 0){
            return (int)buf[0];
        }
        this.buf = buf;
        if((buf.length-index)-n > 0){
            index+=n;
            return n;
        }
        else if((buf.length-index)>0){
            index = buf.length;
            return (buf.length-index);
        }
        return 0;
    }
}