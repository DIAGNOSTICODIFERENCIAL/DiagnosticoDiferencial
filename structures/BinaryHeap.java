public class BinaryHeap<E extends Comparable<? super E>> {

    private int capacity;
    private int Size;
    private E arr[];

    public BinaryHeap() {
        this.capacity = 20;
        arr = (E[]) new Comparable[capacity];

    }

    public BinaryHeap(int capacity) {
        Size = 0;
        arr = (E[]) new Comparable[capacity + 1];
    }

    public void insert(E x) {

        if (Size == arr.length - 1)
            resize(2);

        // Percolate up
        int hole = ++Size;
        for (arr[0] = x; x.compareTo(arr[hole / 2]) < 0; hole /= 2)

            arr[hole] = arr[hole / 2];
        arr[hole] = x;
    }

    private void resize(int mult) {
        E[] newArray = (E[]) new Comparable[mult * this.Size];
        for (int i = 0; i < this.Size; i++)
            newArray[i] = this.arr[i];
        this.capacity *= mult;
        this.arr = newArray;
    }

    private boolean isEmpty() {
        return this.Size == 0;
    }

    public E findMin() {
        if (isEmpty()) {
            System.out.println("Error: Monticulo vacíon");
        }
        return arr[1];
    }

    public E deleteMin() {
        if (isEmpty())
            System.out.println("Error: Monticulo vacío");

        E minItem = findMin();
        arr[1] = arr[Size--];
        percolateDown(1);

        return minItem;
    }

    private void percolateDown(int hole) {
        int child;
        E tmp = arr[hole];
        for (; hole * 2 <= Size; hole = child) {
            child = hole * 2;
            if (child != Size && arr[child + 1].compareTo(arr[child]) < 0)
                child++;
            if (arr[child].compareTo(tmp) < 0)
                arr[hole] = arr[child];
            else
                break;

        }
        arr[hole] = tmp;
    }

    public String toString() {
        String content = "";
        for (int i = 0; i < this.Size; i++) {
            content = content + this.arr[i] + " ";
        }
        return content;
    }

}
