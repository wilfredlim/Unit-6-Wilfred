public class Album {
    private String title;
    private String artist;
    private int tracks;
    private double runTime;

    public Album(String title, String artist, int tracks, double runTime){
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
        this.runTime = runTime;
    }

    public String toString(){
        String result ="";
        result += title + " - " + artist+" "+tracks+" tracks, "+runTime+"min";
        return result;
    }

    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return artist;
    }
}
