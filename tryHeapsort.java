import java.util.Arrays;

public class tryHeapsort {
    static void swap (String []arr, int i, int j ){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void heapify (String []arr, int n, int i ){
        int largest = i;
        int left = 2 * i +1;
        int right = 2 * i +2;

        if (left<n && arr[left].compareTo(arr[largest])>0){
            largest = left;
        }
        if (right<n && arr[right].compareTo(arr[largest])>0){
            largest =right;
        }
        if(largest!=i){
            swap(arr,i,largest);
            heapify(arr,n,largest);
        }
    }

    static void buildHeapBottomUP(String[]arr){
        int n = arr.length;

        for (int i = n /2-1; i>=0;i--){
            heapify(arr,n,i);
        }
    }
    static void insert (String[]heap,int index){
        while (index >0){
            int parent = (index-1)/2;

            if(heap[index].compareTo(heap[parent])>0){
                swap(heap,index,parent);
                index = parent;
            }else{
                break;
            }
        }
    }
    static void buildHeapTopDown(String[]arr){
        for(int i = 1; i< arr.length;i++){
            insert(arr,i);
        }
    }

    static void heapSort (String []arr){
        int n = arr.length;

        buildHeapBottomUP(arr);

        for (int i = n-1;i>0;i--){
            swap(arr,0,i);
            heapify(arr,i,0);
        }
    }
    public static void main (String[]args){
        String []words = {
                "pants","tops","sweater","jacket","shirt","vest","watch","pajamas"
        };
        String[] bottomUpArray=words.clone();
        String[] topDownArray=words.clone();

        long firstStart = System.nanoTime();

        buildHeapBottomUP(bottomUpArray);
        heapSort(bottomUpArray);

        long firstEnd = System.nanoTime();

        long secondStart = System.nanoTime();

        buildHeapTopDown(topDownArray);
        heapSort(topDownArray);

        long secondEnd = System.nanoTime();

        System.out.println("Heap sort from bottom-up:"+ Arrays.toString(bottomUpArray));
        System.out.println("Heap sort time for bottom-up:"+(firstEnd-firstStart)+"ns");
        System.out.println("Heap sort from top down :"+ Arrays.toString(topDownArray));
        System.out.println("Heap sort time for top down:"+(secondEnd-secondStart)+"ns");


    }
}

