
package tweeto;

public class Tweeto {
    private String ID;
    private String Tweet;
    private Tweeto next;
    private String line = "";
    
    public Tweeto(){ ID = Tweet = null ; next = null;}

    public Tweeto(String line){
       setLine(line);
       setID();
       setTweet();
    }

    public void setLine(String line) {
        this.line = line.substring(line.indexOf("@"));

    }

    public String getLine(){ return this.line;}

    public String getID() {
        return ID;
    }

    private void setID() {
        this.ID = getLine().substring(0,getLine().indexOf(" "));
    }

    public String getTweet() {
        return Tweet;
    }

    private void setTweet() {
        this.Tweet = line.substring(0,line.indexOf("Wed Dec"));
    }

    public Tweeto getNext() {
        return next;
    }

    public void setNext(Tweeto next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.format("%s %s",ID,Tweet);
    }
}
