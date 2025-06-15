public class recursion_basics {
    public static Integer Fact(int n){
        if(n==0){
            return 1;
        }
        int x = Fact(n-1);
        int f = n * x;
        
        return f;
    }
    public static Integer Sum(int n){
        if(n==0){
            return 0;
        }
        int x = Sum(n-1);
        int s = n+x;
        return s;
    }
    public static Integer Fib(int n){
        if(n==1 || n==0){
            return n;
        }
        return (Fib(n-1)+Fib(n-2));
    }
    // public static  Integer sortedArray(int arr[],int i){
        
    // }

    public static int firstOcc(int arr[],int idx,int key){
        if(arr.length==idx){
            return -1;
        }
        if(key==arr[idx]){
            return idx;
        }
        return firstOcc(arr, idx+1, key);

    }
    public static int lastOcc(int arr[],int idx,int key){
        if(arr.length==idx){
            return -1;
        }
        if(key==arr[idx]){
            return idx;
        }
        return lastOcc(arr, idx-1, key);

    }
    
    public static int Power(int base,int pow){
        if(pow==0){
            return 1;
        }

        int result = base * Power(base, pow-1);
        return result;
    }

    public static int PowerOpm(int base,int pow){
        if(pow==0){
            return 1;
        }
        
        int half = PowerOpm(base, pow/2);
        int halfpowersq = half * half;

        if(pow % 2 != 0){
            halfpowersq = base * halfpowersq;
        }
        return halfpowersq;
        
    }

    public static void main(String[] args) {
        int key = 3;
        int arr[] = {1,2,4,3,4,2,3};
        System.out.println("this is O(n)->"+Power(2, 10));
        System.out.println("this is O(logn)->"+PowerOpm(2, 10));
    }
}
