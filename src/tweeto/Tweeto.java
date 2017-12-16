
package tweeto;

public class Tweeto {
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
    public Tweeto(String ID,String tweet){
        setLine(ID.concat(" ").concat(tweet));
    }

    // A function to convert the whole line to a new line without the numbers in the beginning
    private void setLine(String line) {
        this.line = line.substring(line.indexOf("@"));
    }

    public String getLine(){ return this.line;}

    public String getID() {
        return ID;
    }

    // using String methods to trim the ID that starts with @ until the white space
    private void setID() {
        this.ID = getLine().substring(0,getLine().indexOf(" "));
    }

    public String getTweet() {
        return Tweet;
    }
    // storing the tweet's content without the date in the end
    private void setTweet() {
        if(getLine().contains("RT @"))
            this.Tweet = line.substring(line.indexOf(":")+2,line.indexOf("Wed Dec"));
        else if(getLine().lastIndexOf("@") != 0){
            line = line.substring(line.lastIndexOf("@"))
        }
        this.Tweet = line.substring(0,line.indexOf("Wed Dec"));
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
}
