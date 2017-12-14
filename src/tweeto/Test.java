
package tweeto;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    
    public static void main(String [] args) throws Exception{
//        FileReader file = new FileReader("1000.txt");
//        Scanner scan = new Scanner(file);
//        ArrayList <Tweeto> tw = new ArrayList<Tweeto>();
//        int count = 0;
//        while(scan.hasNext()){
//            String line = scan.nextLine();
//            if(!line.contains("Wed Dec"))
//                while(!line.contains("Wed Dec"))
//                    line = line.concat(scan.nextLine());
//            tw.add(new Tweeto(line));
//            System.out.println(tw.get(count));
//            count++;
//        }
//        scan.close();
//        System.out.println(count);

        String arr[] = new String[37];
        String letter = "Z";
        int place = letter.charAt(0) - '0' - 7;
        arr[place] = letter;
        System.out.println(arr[place]+ " "+ place);
        String m = "3";


















    }
}
