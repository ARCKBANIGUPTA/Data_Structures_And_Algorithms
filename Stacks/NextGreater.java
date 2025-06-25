import java.util.*;
public class NextGreater {
    

    //time complexity is O(n)
    public static void main(String[] args) {
        int arr[] = {6,3,9,5,2,8};
        Stack<Integer> s = new Stack<>();//storing the index of the elements in array
        int NextG[] = new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){
            //while
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            //if-else
            if(s.isEmpty()){
                NextG[i] = -1;
            }
            else{
                NextG[i] = arr[s.peek()];
            }
            //push the element
            s.push(i);
        }

        for(int i=0;i<NextG.length;i++){
            System.out.print(NextG[i]+" ");
        }

    }
}
