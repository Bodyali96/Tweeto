package tweeto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TweetoHT {
    // a class to hold all the tweets inside a hash table implemented as an array.

    private Tweeto HT[];
    private int result;
    //initialize the variables
    public TweetoHT() {
        // an array to store 10 digits (0-9) and 27 character (a-z, _ )
        HT = new Tweeto[37];
        this.result = 0;
    }

    public Tweeto[] getHT() {
        return HT;
    }

    public int getResult() {
        return result;
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
        //if the position if empty, the node will be the root of the chain
        if(HT[position] == null)
        {
            HT[position] = T;
            T.setNext(null);
            return;
            }

        // inserting in the beginning
        Tweeto temp = HT[position];
        HT[position] = T;
        T.setNext(temp);
        }

    public int search(String user, String keyword) throws Exception{
        int position;
        if(user.startsWith("@"))
            position = hash(user);
        else if(!user.startsWith("@") && (Character.isDigit(user.charAt(0)) || Character.isLetter(user.charAt(0)) || user.startsWith("_"))) {
            user = "@".concat(user);
            position = hash(user);
        }
        else
            throw new Exception("Invalid ID");
        Tweeto temp = HT[position];
        while(temp != null){

            if(temp.getID().equalsIgnoreCase(user) && temp.getTweet().toLowerCase().contains(keyword.toLowerCase())){
                result++;
            }
            temp = temp.getNext();
        }

        return result;
    }





}
