//Albums class is used to store and represent contents of the album

public class Albums {

    private String artist; //Artist of the album
    private String title; //Title of the album
    private int year; //Release year of the album
    private Track[] tracks; //Array to store tracks
    private int trackCount; //Keeps track of the number of tracks added

    // Constructor
    public Albums(String artist, String title, int year, int maxTracks) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.tracks = new Track[maxTracks]; // Set a fixed size
        this.trackCount = 0; // Start with 0 tracks
    }

    // Get artist
    public String getArtist() {
        return artist;
    }

    //get title
    public String getTitle() {
        return title;
    }

    //get year
    public int getYear() {
        return year;
    }

    //get track count
    public int getTrackCount() {
        return trackCount;
    }

    //get tracks
    public Track[] getTracks() {
        return tracks;
    }

    // Add a track to the album
    public boolean addTrack(Track track) {
        if (trackCount < tracks.length) { //checks space in track array
            tracks[trackCount] = track; //Add track to the array
            trackCount++; //Increment track count
            return true; //Track added
        } else {
            return false; //Track not added
        }
    }

    // Get the total duration of the album
    public Duration getTotalDuration() {
        int totalSeconds = 0;

        for (int i = 0; i < trackCount; i++) { //loop through all tracks
            totalSeconds += tracks[i].getDuration().toSeconds(); //add the seconds of all tracks together
        }
        return new Duration(0, 0, totalSeconds);
    }

    //Get longest track in the album
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

        result.append("Artist: ").append(artist).append("\n"); //append artist into result
        result.append("Title: ").append(title).append("\n"); //append title into result
        result.append("Year: ").append(year).append("\n"); //append year into result
        result.append("Tracks:\n"); //append tracks into result

        for (int i = 0; i < trackCount; i++) { //loop through all tracks
            result.append("  ").append(i + 1).append(". ").append(tracks[i]).append("\n");//number the tracks
        }
        return result.toString();
    }

    // Testing the Album class
    // public static void main(String[] args) {
    //     Albums album = new Albums("The Jimi Hendrix Experience", "Are You Experienced?", 1967, 5);
    //     // Add tracks
    //     album.addTrack(new Track("Foxy Lady", new Duration(0, 3, 22)));
    //     album.addTrack(new Track("Manic Depression", new Duration(0, 3, 46)));
    //     album.addTrack(new Track("Red House", new Duration(0, 3, 53)));
    //     // Display album
    //     System.out.println(album);
    //     // Total duration
    //     System.out.println("Total Duration: " + album.getTotalDuration());
    //     // Longest track
    //     System.out.println("Longest Track: " + album.getLongestTrack());
    // }
}
