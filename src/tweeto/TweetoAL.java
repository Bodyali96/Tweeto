package tweeto;

import java.util.ArrayList;

public class TweetoAL {
    private ArrayList<Tweeto> list;
    private int results;

    public TweetoAL() {
        this.list = new ArrayList<>();
        results = 0;
    }
    public void insert(Tweeto obj){this.list.add(obj);}
    public int search(String id,String keyword){
        if(!id.startsWith("@"))
            id = "@".concat(id.toLowerCase());
        for(Tweeto obj : list) {
            if (obj.getID().toLowerCase().startsWith(id.toLowerCase()) &&
                obj.getTweet().toLowerCase().contains(keyword.toLowerCase()))
                results++;
        }
        return results;
    }

}
