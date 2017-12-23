package tweeto;

public class TweetoBHHT {
   private TweetoBH [] BHHT;
   private int results;
   public TweetoBHHT(){
       BHHT = new TweetoBH[37];
       results = 0;
   }

    private int hash(String id){
        // we consider that the ID starts with number
        return Character.isDigit(id.charAt(1))?(id.charAt(1)-'0')%37:
                //we consider that the ID starts with letters,
                // the 7 are for ignoring the symbols between letters and numbers
                Character.isLetter(id.charAt(1))?(Character.toUpperCase(id.charAt(1))-'0'-7)%37: 36;
    }

    public void insert(Tweeto T){
        int position = hash(T.getID());
        if(BHHT[position] == null)
        {
            BHHT[position] = new TweetoBH();
            BHHT[position].insert(T);
        }
        else
            BHHT[position].insert(T);
    }
    public Tweeto remove(String user){
        int position;
        if(user.startsWith("@"))
            position = hash(user);
        else if(!user.startsWith("@") && (Character.isDigit(user.charAt(0)) || Character.isLetter(user.charAt(0)) || user.startsWith("_"))) {
            user = "@".concat(user);
            position = hash(user);
        }
        else
            throw new IllegalArgumentException("Wrong ID");
        Tweeto obj;
        if(BHHT[position] != null) {
             obj = BHHT[position].remove();
            return obj;
        }
        else {
            BHHT[position] = new TweetoBH();
            obj = BHHT[position].remove();
            return obj;
        }

    }
    public int search(String user, String keyword){
        int position;
        if(user.startsWith("@"))
            position = hash(user);
        else if(!user.startsWith("@") &&
            (Character.isDigit(user.charAt(0)) || Character.isLetter(user.charAt(0)) || user.startsWith("_"))) {
            user = "@".concat(user);
            position = hash(user);
        }
        else
            throw new IllegalArgumentException("ID Is wrong");
        int index = 0;
        if(BHHT[position] != null)
        while(index < BHHT[position].getSize())
        {
            Tweeto obj = remove(user);
            if(obj.getID().toLowerCase().startsWith(user.toLowerCase()) && obj.getTweet().toLowerCase().contains(keyword.toLowerCase())){
                this.results++;
            }
        }
        else
            throw new NullPointerException("The list is empty, there is nothing to search");
        return this.results;
    }

    @Override
    public String toString(){
        return "";
    }
}
