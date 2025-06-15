public class binaryString{

    public static void printbinarystring(String str, int lastPlace, int n){
        //base case
        if(n==0){
            System.out.println(str);
            return;
        }
        //choice
        // if(lastPlace==0){
        //     printbinarystring(str+"0",0,n-1);
        //     printbinarystring(str+"1", 1, n-1);
        // }
        // else{
        //     printbinarystring(str+"0",0,n-1);
        // }
        //short version
        printbinarystring(str+"0",0,n-1);
        if(lastPlace == 0){
            printbinarystring(str+"1", 1, n-1);
        }
    }
    public static void main(String[] args) {
        String str="";
        printbinarystring(str, 0, 3);
    }
}