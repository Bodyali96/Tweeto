
package tweeto;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String [] args){
        try{
            TweetoHT TwHt = new TweetoHT();
            FileReader file = new FileReader("1000.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNext()){
                String line = scan.nextLine();
                if (!line.contains("Wed Dec"))
                    while (!line.contains("Wed Dec"))
                        line = line.concat(scan.nextLine());
                TwHt.insert(new Tweeto(line));
            }
            scan.close();
            System.out.println(TwHt.search("ATVIAssist","Thank "));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void usingArrayList()throws Exception {
        // this function to read the txt file and store the info to a simple array list
        FileReader file = new FileReader("1000.txt");
        Scanner scan = new Scanner(file);
        ArrayList<Tweeto> tw = new ArrayList<Tweeto>();
        int count = 0;
        while (scan.hasNext()) {
            String line = scan.nextLine();
            if (!line.contains("Wed Dec"))
                while (!line.contains("Wed Dec"))
                    line = line.concat(scan.nextLine());
            tw.add(new Tweeto(line));
            System.out.println(tw.get(count));
            count++;
        }
        scan.close();
        System.out.println(count);
    }
}
