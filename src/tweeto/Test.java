
package tweeto;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String [] args){
        double m = System.currentTimeMillis();

        try{
            Scanner scan = new Scanner(System.in);
            String fName = "1000000.txt";
            System.out.println("Please enter your choice");
            int choice = scan.nextInt();
            String user = scan.next();
            String keyword = scan.next();
            readFile(fName,user,keyword,choice);
        } catch (Exception e) {System.out.println(e);}
        double m2 = System.currentTimeMillis();
        System.out.println("Total time: "+(m2-m));
    }//end main

    public static void readFile(String fileName, String user, String keyword,int choice)throws Exception{
        FileReader file = new FileReader(fileName);
        Scanner scan = new Scanner(file);
        switch (choice){
            case 1: //using Array list to store and search the data
                TweetoAL TwAL = new TweetoAL();
                while(scan.hasNext()){
                    String line = scan.nextLine();
                    if (!line.contains("Wed Dec"))
                        while (!line.contains("Wed Dec"))
                            line = line.concat(scan.nextLine());
                    TwAL.insert(new Tweeto(line));
                }
                scan.close(); // finish reading and inserting

                System.out.println("Total Tweets: "+TwAL.search(user,keyword));
                break;
            case 2: // using hash table to store and search the data
                TweetoHT TwHt = new TweetoHT();
                while(scan.hasNext()){
                    String line = scan.nextLine();
                    if (!line.contains("Wed Dec"))
                        while (!line.contains("Wed Dec"))
                            line = line.concat(scan.nextLine());
                    TwHt.insert(new Tweeto(line));
                }
                scan.close(); // finish reading and inserting
                System.out.println("Total Tweets: "+TwHt.search(user,keyword));
                break;
            case 3:
                TweetoBH.capacity = Integer.parseInt(fileName.substring(0,fileName.indexOf(".")));
                TweetoBHHT bh = new TweetoBHHT();
                while(scan.hasNext()){
                    String line = scan.nextLine();
                    if (!line.contains("Wed Dec"))
                        while (!line.contains("Wed Dec"))
                            line = line.concat(scan.nextLine());
                    bh.insert(new Tweeto(line));
                }
                scan.close(); // finish reading and inserting
                System.out.println("Total Tweets: "+bh.search(user,keyword));
                break;
                default:
                    System.out.println("Error, you must enter a number between 1-3");
        }
    }
}
