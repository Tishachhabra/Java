import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args){

        String pattern = "<([^>]+)>([^<>]+)</\\1>";
        Pattern r = Pattern.compile(pattern);

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases > 0){
            String line = in.nextLine();

            Matcher m = r.matcher(line);
            boolean findMatch = true;
            while(m.find( )){
                System.out.println(m.group(2));                              // Will extract 2nd group text
                findMatch = false;
            } 
            if(findMatch) {
                System.out.println("None");
            }
            testCases--;
        }
    }
}
