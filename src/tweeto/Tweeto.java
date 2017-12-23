
package tweeto;

public class Tweeto implements Comparable<Tweeto>{
    // this variable to store the ID #Note : started with @
    private String ID;
    // this variable to store the content of the tweet itself, including the mentions/RT
    private String Tweet;
    // this variable is the link to the next Tweeto object in the hash table
    private Tweeto next;
    // this is just a line used to read a single line each time from the txt file
    private String line = "";

    // default constructor
    public Tweeto(){ ID = Tweet = null ; next = null;}

    // full argument constructor using setters
    public Tweeto(String line){
       setLine(line);
       setID();
       setTweet();
    }

    // A function to convert the whole line to a new line without the numbers in the beginning
    private void setLine(String line) {
        this.line = line.substring(line.indexOf("@"));
    }

    public String getLine(){ return this.line;}

    public String getID() {
        return ID;
    }

    // using String methods to trim the ID that starts with @ until the first space
    private void setID() {
        this.ID = getLine().substring(0,getLine().indexOf(" "));
    }

    public String getTweet() {
        return Tweet;
    }
    // storing the tweet's content without the date in the end
    private void setTweet() {
        String l = getLine().substring(line.indexOf(" ")+1);
        //if the user retweeted the tweet
        if(l.startsWith("RT @"))
            this.Tweet = line.substring(line.indexOf(":")+2,line.lastIndexOf("Wed Dec"));
        // if the tweet has mentions
        else if(l.startsWith("@")){
            while(l.startsWith("@"))
                l = l.substring(l.indexOf(" ")+1);
            this.Tweet = l.substring(0,l.lastIndexOf("Wed Dec"));
        }// the normal case, when there is no re tweet or mention
        else
        this.Tweet = l.substring(0,l.lastIndexOf("Wed Dec"));
    }

    public Tweeto getNext() {
        return next;
    }

    // this method will used in binary heap or hash tables, but it won't used in array list
    public void setNext(Tweeto next) {
        this.next = next;
    }

    // A string representation for the object
    @Override
    public String toString() {
        return String.format("%s %s",ID,Tweet);
    }


    /** Sorting based on the alphabetic order, where : a < b < c < d and so on.
     * return num > 0 if this.ID > o.ID
     * return num < 0 if this.ID < o.ID
     * return  0 if this.ID == o.ID */
    @Override
    public int compareTo(Tweeto o) {
        return this.getID().compareTo(o.getID());
    }
}
