import java.util.ArrayList;
import java.util.Scanner;

public class RepeatedDigits {
    public static ArrayList<String> string = new ArrayList<String>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            string.add(sc.nextLine());
        }
        for (String x : string){
            if (x.startsWith("A")){
                Integer[] c = CleanUp(x);
                if (c==null) System.out.println("Bad line: " + x);
                else {
                    String value = AOperation(c);
                    if (value == null){
                        System.out.println("Bad line: " + x);
                    } else {
                    System.out.println(value);
                    }
                    }
                }
            else if (x.startsWith("B")){
                Integer[] c = CleanUp(x);
                if (c==null) System.out.println("Bad line: " + x);
                else System.out.println(BOperation(c));
            }
            else System.out.println("Bad line: " + x);
        }
    }
    public static Integer[] CleanUp(String x){
        String[] stringArray = x.split("\\s+");
        Integer[] newStringArray = new Integer[2];
        if (stringArray.length == 3){
            for (int i = 1; i < 3;i++){
                try {
                    newStringArray[i-1] = Integer.parseInt(stringArray[i]); 
                } catch(NumberFormatException e) {
                    return null;

                }
                
            }
            return newStringArray;
        }
        return null;
    }
    public static String AOperation(Integer[] c){
        int base = c[0];
        int intN = c[1];
        int count = 0;
        int topCount = 0;
        int bestIndex = 0;
        for (int i = 1; i < intN; i++){
            String value = Integer.toString(i,base);
            if (containsDuplicates(value)){
                count++;
                if (count > topCount){
                    topCount = count;
                    bestIndex = (i+1) - topCount;
                }
            } else {
                count = 0;
            }
        }
        String string = bestIndex + " " + topCount;
        return string;
    }
    public static Integer BOperation(Integer[] c){
        int baseB = c[0];
        int baseC = c[1];
        for (int i = 0; i < (i+1);i++){
            if (containsDuplicates(Integer.toString(i,baseB))&&containsDuplicates(Integer.toString(i,baseC))){
                return i;
            }
            
        }
        return null;
    }
    
    public static boolean containsDuplicates(String string){
        for(int i = 0; i < string.length() - 1; i++){
            for(int j = i + 1; j < string.length(); j ++){
                if(string.charAt(i) == string.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }
    
}
