import java.util.HashSet;

public class UnionIntersection {
    public static void main(String[] args) {
        int arr1[] = {3,5,6,3,9,8};
        int arr2[]={8,3,6,7,9,1,8};

        HashSet<Integer> set = new HashSet<>();
        // for union
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        System.out.println("Number of unique elements in both arrays (or union) : "+set.size());

        set.clear();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        int countInter=0;
        for(int j=0;j<arr2.length;j++){
            if(set.contains(arr2[j])){
                countInter++;
                set.remove(arr2[j]);
            }
        }
        System.out.println("Intersection or common elements are : "+countInter);
    }
}
