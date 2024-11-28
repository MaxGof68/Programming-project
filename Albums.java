public class Albums {
    private String artist;          // Artist of the album
    private String title;           // Title of the album
    private int year;               // Release year of the album
    private Track[] tracks;         // Array to store tracks
    private int trackCount;         // Keeps track of the number of tracks added

    // Constructor
    public Albums(String artist, String title, int year, int maxTracks) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.tracks = new Track[maxTracks]; // Initialize the array with a fixed size
        this.trackCount = 0;                // Start with no tracks
    }

    // Getters
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

    // Add a track to the album
    public boolean addTrack(Track track) {
        if (trackCount < tracks.length) {
            tracks[trackCount] = track; // Add track to the array
            trackCount++;               // Increment track count
            return true;                // Track successfully added
        } else {
            System.out.println("Track list is full. Cannot add more tracks.");
            return false;               // Track list is full
        }
    }

    // Get the total duration of the album
    public Duration getTotalDuration() {
        int totalSeconds = 0;
        for (int i = 0; i < trackCount; i++) {
            totalSeconds += tracks[i].getDuration().toSeconds();
        }
        return new Duration(0, 0, totalSeconds);
    }

    // Get the longest track in the album
    public Track getLongestTrack() {
        if (trackCount == 0) return null; // No tracks in the album

        Track longest = tracks[0];
        for (int i = 1; i < trackCount; i++) {
            if (Duration.compare(tracks[i].getDuration(), longest.getDuration()) > 0) {
                longest = tracks[i];
            }
        }
        return longest;
    }

    // Overriding toString for display
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Artist: ").append(artist).append("\n");
        result.append("Title: ").append(title).append("\n");
        result.append("Year: ").append(year).append("\n");
        result.append("Tracks:\n");
        for (int i = 0; i < trackCount; i++) {
            result.append("  ").append(i + 1).append(". ").append(tracks[i]).append("\n");
        }
        return result.toString();
    }

    // Testing the Album class
    public static void main(String[] args) {
        Albums album = new Albums("The Jimi Hendrix Experience", "Are You Experienced?", 1967, 5);

        // Add tracks
        album.addTrack(new Track("Foxy Lady", new Duration(0, 3, 22)));
        album.addTrack(new Track("Manic Depression", new Duration(0, 3, 46)));
        album.addTrack(new Track("Red House", new Duration(0, 3, 53)));

        // Display album
        System.out.println(album);

        // Total duration
        System.out.println("Total Duration: " + album.getTotalDuration());

        // Longest track
        System.out.println("Longest Track: " + album.getLongestTrack());
    }
}
