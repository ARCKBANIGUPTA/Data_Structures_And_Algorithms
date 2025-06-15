public class quick_sort {
    public static void printquicksort(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return;
    }

    public static int partition(int arr[],int si, int ei){
        int pivot = arr[ei];
        int i = si-1;//makes the space for elements smaller thant the pivot
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        //swap
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void quicksort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        //last element
        int  pidx = partition(arr, si, ei);
        quicksort(arr, si, pidx-1); // left part
        quicksort(arr, pidx+1, ei); // right part

    }
    public static void main(String[] args) {
        int arr[] = {6,3,8,9,2,5};
        quicksort(arr, 0, arr.length-1);
        printquicksort(arr);
    }
}
