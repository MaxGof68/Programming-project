//Depends on Duration
//Provide a readable presentation of the track

public class Track {

    private String title; // Track name
    private Duration duration;

    // Constructor
    public Track(String title, Duration duration) {
        this.title = title;
        this.duration = duration;
    }

    //Getters
    public String getTitle() {
        return title;
    }

    public Duration getDuration() {
        return duration;
    }

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


}
