package structures;
import src.diagnosisTools.enfermedad;

public class BinaryHeap<Anytipe extends Comparable<? super Anytipe>> {

    private int capacity;
    private int Size;
    private Anytipe arr[];

    public BinaryHeap() {
        this.capacity = 20;
        arr = (Anytipe[]) new Comparable[capacity];

    }
    

    public BinaryHeap(int capacity) {
        Size = 0;
        arr = (Anytipe[]) new Comparable[capacity + 1];
    }



    public void insert(Anytipe x) {

        if (Size == arr.length - 1)
            resize(2);

        // Percolate up
        int hole = Size++;
        for (arr[0] = x; x.compareTo(arr[hole / 2]) < 0; hole /= 2){
            arr[hole] = arr[hole / 2];
        }
        arr[hole] = x;
    }

    private void resize(int mult) {
        Anytipe[] newArray = (Anytipe[]) new Comparable[mult * this.Size];
        for (int i = 0; i < this.Size; i++)
            newArray[i] = this.arr[i];
        this.capacity *= mult;
        this.arr = newArray;
    }

    private boolean isEmpty() {
        return this.Size == 0;
    }

    public Anytipe findMin() {
        if (isEmpty()) {
            System.out.println("Error: Monticulo vacíon");
        }
        return arr[1];
    }

    public Anytipe deleteMin() {
        if (isEmpty())
            System.out.println("Error: Monticulo vacío");

        Anytipe minItem = findMin();
        arr[1] = arr[Size--];
        percolateDown(1);

        return minItem;
    }

    private void percolateDown(int hole) {
        int child;
        Anytipe tmp = arr[hole];
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

}
