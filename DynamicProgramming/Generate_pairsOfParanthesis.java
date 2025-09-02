public class Generate_pairsOfParanthesis {

    public static void Printer(char paran[]){
        for(int i=0;i<paran.length;i++){
            System.out.print(paran[i]);
        }
        System.out.println();
    }
    
    public static void Generate(char paran[],int pos,int open,int close,int n){
        if(close==n){
            Printer(paran);
            return;
        }
        else{
            if(close<open){
            //include close brackett
            paran[pos] = '}';
            Generate(paran, pos+1, open, close+1,n);
            }

            if(open<n){
            //inlcude open bracket
            paran[pos] = '{';
            Generate(paran, pos+1, open+1, close,n);
            }
        }
        

    }

    public static void main(String[] args) {
        int n=4;
        char paran[] = new char[2*n];
        Generate(paran,0,0,0,n);
    }
}
