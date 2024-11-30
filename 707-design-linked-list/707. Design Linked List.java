class MyLinkedList {

    /** Initialize your data structure here. */
    Node root;
    public MyLinkedList() {
        root = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node curr = root;
        for(int i =0; i<index; i++){
            if(curr == null){
                return -1;
            }
            else{
                curr = curr.next;
            }
        }
        if(curr != null){
            return curr.val;
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node temp = root;
        Node n = new Node(val);
        n.next = temp;
        root = n;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node n = new Node(val);
        if(root == null){
            root = n;
        }else{
            Node curr = root;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = n;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node n = new Node(val);
        Node curr = root;
        if(index == 0){
            n.next = curr;
            root = n;
            return;
        }
        if(curr == null){
            return;
        }
        for(int i =0; i<index-1; i++){
            if(curr == null){
                return;
            }
            else{
                if(curr.next == null){
                    return;
                }
                curr = curr.next;
            }
        }
        if(curr.next != null){
            n.next = curr.next;
        }
        curr.next = n;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node curr = root;
        if(curr == null){
            return;
        }
        if(index == 0){
            root = curr.next;
            return;
        }
        for(int i=0; i<index-1; i++){
            if(curr == null){
                return;
            }
            else{
                if(curr.next == null){
                    return;
                }
                curr = curr.next;
            }
        }
        if(curr.next != null){
            Node temp = curr.next.next;
            curr.next = temp;
        }
        return;
    }
}

class Node{
    int val;
    Node next = null;
    public Node(int val){
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */