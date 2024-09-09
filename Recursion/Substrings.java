public class Substrings {

    private static void printSubstrings(String str, int start, int end){
        //base case
        //start=length -> all cases exhausted
        if(start == str.length()){
            return;
        }

        if(end == str.length()+1){
            printSubstrings(str, start+1, start+2);
        }else{
            System.out.println(str.substring(start, end));
            printSubstrings(str, start, end+1);
        }
    }
    public static void main(String[] args) {
        String str = "abcd";
        printSubstrings(str, 0, 1);
    }
}
