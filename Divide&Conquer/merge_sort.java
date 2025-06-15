public class merge_sort {
    public static void printmergesort(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return;
    }

    public static void mergesort(int arr[] , int si,int ei){
        if(si>=ei){
            return;
        }
        int mid = si + ((ei-si)/2);
        mergesort(arr,si,mid);//left part
        mergesort(arr,mid+1,ei);//right part
        merge(arr, si, mid, ei);//merging the both left and right part
    }   

    public static void merge(int arr[],int si,int mid,int ei){
        int temp[] = new int[ei-si+1];
        int i =si;//left ppart
        int j=mid+1;//right part
        int k = 0;//temp array
        while(i<=mid  && j<=ei){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=ei){
            temp[k++] = arr[j++];
        }

        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i] = temp[k];
        }

    }
    public static void main(String[] args) {
        int arr[] = {6,3,9,5,2,8,-9,70};
        mergesort(arr, 0, arr.length-1);
        printmergesort(arr);
    }
}
