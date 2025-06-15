public class searching_in_rotatedarray {

    public static int search(int arr[],int target,int si,int ei){
        if(si>ei){
            return -1;
        }
        int mid = si + ((ei-si)/2);
        // if mid is the target
        if(arr[mid]==target){
            return mid;
        }
        // mid lies on L1
        if(arr[si]<=arr[mid]){
            //case a : left part
            if(arr[si]<=target && target<=arr[mid]){
                return search(arr, target, si, mid-1);
            }//case B : right part
            else{
                return search(arr, target, mid+1, ei);
            }
        }
        //mid lies on L2
        else{
            //case c : right part
            if(arr[mid]<=target && target<=arr[ei]){
                return search(arr,target,mid+1,ei);
            }//case d : left part
            else{
                return search(arr, target, si, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int target =6;
        int arr[] = {4,5,6,7,0,1,2};
        int targetIdx = search(arr, target, 0, arr.length-1);
        System.out.println(targetIdx);
    }
}
