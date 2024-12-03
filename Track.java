//Depends on Duration
//Provide a readable presentation of the track

public class Track {
    private String title; // Track name
    private Duration duration; // Duration of the track

    // Constructor
    public Track(String title, Duration duration) {
        this.title = title;
        this.duration = duration;
    }

    // Getters - retreive value
    public String getTitle() {
        return title;
    }

    public Duration getDuration() {
        return duration;
    }

    // Setters - set value
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    // Splitting lines of text
    public static Track fromString(String line) {
        String[] parts = line.split(" - ", 2); // Split on " - " to separate duration and title
        Duration duration = Duration.fromString(parts[0]);
        String title = parts[1]; // Extract the title
        return new Track(title, duration);
    }

    // Overriding toString for display
    @Override
    public String toString() {
        return duration + " - " + title; 
    }

    // Testing the Track class
    public static void main(String[] args) {
        String line = "0:03:22 - Foxy Lady";
        Track track = Track.fromString(line); // Parse from text
        System.out.println("Parsed Track: " + track); // Output: "00:03:22 - Foxy Lady"

        // Display individual attributes
        System.out.println("Track Title: " + track.getTitle());
        System.out.println("Track Duration: " + track.getDuration());
    }
}
