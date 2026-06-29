class DynamicArray {
    int[] arr;
    int length;
    int capacity;
    
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.arr = new int[this.capacity];
    }

    public int get(int i) {
        return this.arr[i];
    }

    public void set(int i, int n) {
        this.arr[i] = n;
    }

    public void pushback(int n) {
        if(length == capacity) {
            resize();
        }
        arr[length] = n;
        length++;
    }

    public int popback() {
        if(length > 0) {
            length--;
        }
        return this.arr[length];
    }

    private void resize() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        for(int i = 0; i < length; i++) {
            newArray[i] = this.arr[i];
        }
        arr = newArray;
    }

    public int getSize() {
        return this.length;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
