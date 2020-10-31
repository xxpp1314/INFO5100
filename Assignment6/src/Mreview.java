import java.util.*;

public class Mreview implements Comparable<Mreview>
{
    // instance variables
    private String title;   // title of the movie
    private ArrayList<Integer> ratings; // list of ratings stored in a Store object

    // methods
    public Mreview(){
        title = "";
        ratings = new ArrayList<Integer>();
    }

    public Mreview(String ttl){
        title = ttl;
        ratings = new ArrayList<Integer>();
    }

    public Mreview(String ttl, int firstRating){
        title = ttl;
        ratings = new ArrayList<Integer>(1);
        ratings.add(firstRating);
    }

    public void addRating(int r){
        ratings.add(r);
    }

    public double aveRating(){
        int length = ratings.size();
        int sum = 0;
        for(int i = 0; i < length; i++){
            sum += ratings.get(i);
        }
        double res;
        res = (double) sum / length;
        return res;
    }

    @Override
    public int compareTo(Mreview obj) {

        return getTitle().compareTo(obj.getTitle());
    }

    @Override
    public boolean equals(Object obj){
        Mreview another = (Mreview) obj;
        boolean res = getTitle().equals(another.getTitle());
        return res;
    }

    public String getTitle(){
        return title;
    }

    public int numRatings(){
        int size = ratings.size();
        return size;
    }

    public String toString(){
        return  getTitle() + ", average " + aveRating() + " out of " + numRatings() + " ratings";
    }

    public static void main(String[] args) {
        Mreview movie = new Mreview("Kill Bill");
        movie.addRating(3);
        movie.addRating(4);
        movie.addRating(5);
        System.out.println("The average ratings is " + movie.aveRating());
        System.out.println(movie);
    }
}


