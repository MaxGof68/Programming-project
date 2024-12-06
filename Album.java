//Albums class is used to store and represent contents of the album

public class Album {

    private String artist;
    private String title;
    private int year;
    private Track[] tracks;
    private int trackCount;

    // Constructor
    public Album(String artist, String title, int year, int maxTracks) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.tracks = new Track[maxTracks]; // Set a fixed size
        this.trackCount = 0;
    }

    //getters
    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public Track[] getTracks() {
        return tracks;
    }

    
    public boolean addTrack(Track track) {
        if (trackCount < tracks.length) { //checks space in track array
            tracks[trackCount] = track; //Add track to the array
            trackCount++; 
            return true; //Track added
        } else {
            return false; //Track not added
        }
    }

    
    public Duration getTotalDuration() {
        int totalSeconds = 0;

        for (int i = 0; i < trackCount; i++) { //loop through all tracks
            totalSeconds += tracks[i].getDuration().toSeconds(); //add the seconds of all tracks together
        }
        return new Duration(0, 0, totalSeconds);
    }

    
    public Track getLongestTrack() {
        if (trackCount == 0) {
            return null; //No tracks in the album
        }
        Track longest = tracks[0]; //initialise longest variable

        for (int i = 1; i < trackCount; i++) { //loop through all tracks
            if (Duration.compare(tracks[i].getDuration(), longest.getDuration()) > 0) { //compare track lengths
                longest = tracks[i]; //declare longest track
            }
        }
        return longest;
    }

    //Overriding toString for display
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();//create new result object

        //append variable to result
        result.append("Artist: ").append(artist).append("\n"); 
        result.append("Title: ").append(title).append("\n");
        result.append("Year: ").append(year).append("\n");
        result.append("Tracks:\n"); 

        for (int i = 0; i < trackCount; i++) {
            result.append("  ").append(i + 1).append(". ").append(tracks[i]).append("\n");//number the tracks
        }
        return result.toString();
    }

 
}
