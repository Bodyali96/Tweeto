package tweeto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TweetoHT {
    // a class to hold all the tweets inside a hash table implemented as an array.

    Tweeto HT[];
    int size;
    //initialize the variables
    public TweetoHT() {
        HT = new Tweeto[37];
        this.size = 0;
    }

    public int hash(String id){
        // we consider that the ID starts with number
        return Character.isDigit(id.charAt(1))?(id.charAt(1)-'0')%37:
                //we consider that the ID starts with letters,
                // the 7 are for ignoring the symbols between letters and numbers
                Character.isLetter(id.charAt(1))?(Character.toUpperCase(id.charAt(1))-'0'-7)%37: 36;
    }

    public void insert(Tweeto T){
        int position = hash(T.getID());

        if(HT[position] == null)
        {
            HT[position] = new Tweeto(T.getID(), T.getTweet());
            return;
        }

        Tweeto temp = HT[position];

        while(temp.getNext() != null)
        {
            temp = temp.getNext();
        }

        temp.setNext(new Tweeto(T.getID(),T.getTweet()));
        }

    public int search(String user, String keyword){
        int position = hash(user);

        for(Tweeto t = HT[position] ; t != null ; t = t.getNext())
        {
            if(user.equalsIgnoreCase(t.getID()) && t.getTweet().toLowerCase().contains(keyword.toLowerCase())){
                size++;
            }
        }//end for loop

        return size;
    }

    public void readme(String fileName){
        try {
            Scanner input = new Scanner(new File(fileName));

            while(input.hasNextLine())
            {

                String file = input.nextLine();// read the line
                String [] text =file.split(" "); // split based on spaces
                String id = text[1].substring(1);// store the id without @
                String content = "";


                for(int i = 2 ; i<file.length()-1 ; i++) // sotre the content
                {
                    if(!text[i].equalsIgnoreCase("Wed")){
                        if(!text[i].equalsIgnoreCase("RT")){
                            if(!text[i].contains("@")){
                                content +=""+text[i];
                            }
                        }
                    }
                    else
                        break;
                }// end for loop

                insert(new Tweeto(id,content));

                /**
                 * after finishing adding the tweet id & content to the H.T.
                 * we need to make the array empty again
                 */
                for(int i = 0 ; i <text.length-1 ; i++)
                {
                    text[i] = "";
                }

            }// end while loop

        } catch (FileNotFoundException ex) {

            System.out.println("Error Read");
        }


    }





}
