public class Node{
    private int key;
    private int value;
    private Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class HashTable {
    private int capacity;
    private int size;
    private Node[] table;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new Node[this.capacity];
    }

    public int hashFunction(int key) {
        return key % this.capacity;
    }

    public void insert(int key, int value) {
        int index = this.hashFunction(key);
        Node node = this.table[index];
        if(node == null) {
            this.table[index] = new Node(key, value);
            this.size++;
        } 
        else {
            Node prev = null;
            while(node != null){
                if(node.key == key) {
	                node.value = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node(key, value);
            this.size++;
        }

        if((double) size / capacity >= 0.5) resize();
    }

    public boolean remove(int key) {
    	int index = hashFunction(key);
	    Node node = this.table[index];
	    Node prev = null;
	    while(node != null) {
	        if(node.key == key) {
                if(prev != null) {
                    prev.next = node.next;
                }
                else {
	                this.table[index] = node.next;
                }
                this.size--;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }

    public int get(int key) {
    	int index = hashFunction(key);
	    Node node = this.table[index];
	    while(node != null) {
	        if(node.key == key) {
	            return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
	    int newCapacity = this.capacity * 2;
	    Node newTable[] = new Node[newCapacity];

        for(Node node : this.table) {
            while(node != null) {
                int newIndex = node.key % newCapacity;
                if(newTable[newIndex] == null) {
                    newTable[newIndex] = new Node(node.key, node.value);
                }
                else {
                    Node newNode = newTable[newIndex];
                    while(newNode.next != null) {
                        newNode = newNode.next;
                    }
                    newNode.next = new Node(node.key, node.value);
                }
                node = node.next;
            }
        }
        this.capacity = newCapacity;
        this.table = newTable;
    }
}
