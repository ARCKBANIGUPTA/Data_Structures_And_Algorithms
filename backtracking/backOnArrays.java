public class backOnArrays {

    public static void insertVal(int arr[],int idx,int val){
        //base case
        if(idx == arr.length){
            printArr(arr);
            return;
        }
        //kaam
        arr[idx] = val;
        insertVal(arr, idx+1, val+1);// fnc call step
        arr[idx] = arr[idx] - 2;// backtracking step

    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return;
    }
    public static void main(String[] args) {
        int arr[] = new int[5];
        insertVal(arr, 0, 1);
        printArr(arr);
    }
}
