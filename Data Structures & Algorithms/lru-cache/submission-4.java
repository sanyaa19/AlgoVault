public class Node{
    Node next;
    Node prev;
    int key;
    int data;

    Node(){}

    Node(int key , int data){
        this.next = null;
        this.prev = null;
        this.key = key;
        this.data = data;
    }
}

class LRUCache {
    HashMap<Integer , Node> map = new HashMap<>();

    int capacity;
    int size = 0;

    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(size == 0) return -1;

        if(map.containsKey(key)){
            Node curr = map.get(key);
            if(curr == tail || head == tail) return curr.data;
            else if(curr == head){
                head = head.next;
                head.prev = null;
            }
            else{
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            }

            tail.next = curr;
            curr.prev = tail;
            curr.next = null;
            tail = tail.next;

            return curr.data;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node curr = map.get(key);

            if(curr == tail || head == tail){
                curr.data = value;
            }
            else{
                if(curr == head){
                    head = head.next;
                    head.prev = null;
                }
                else{
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }

                tail.next = curr;
                curr.prev = tail;
                curr.next = null;
                curr.data = value;
                tail = tail.next;
            }
        }

        else{
            Node newNode = new Node(key , value);
            map.put(key, newNode);

            if(size == capacity){
                map.remove(head.key);
                if(tail == head){
                    tail = null;
                }

                head = head.next;
                if(head != null) head.prev = null;
                size--;
            }

            if(head == null){
                head = newNode;
                tail = newNode;
                size++;
            }

            else{
                tail.next = newNode;
                newNode.prev = tail;
                tail = tail.next;
                size++;
            }
        }
    }
}
