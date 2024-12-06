//Duration will be used to manage and display duration times - track length, album length
//duration class, declare variables
public class Duration {

    private int hours;
    private int minutes;
    private int seconds;

    // Constructor
    public Duration(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        normalise();
    }

    // Normalise time values
    private void normalise() {
        if (seconds >= 60) {
            minutes += seconds / 60;
            seconds = seconds % 60;
        }
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        }
    }

    // split Duration from string
    public static Duration fromString(String durationString) {
        String[] parts = durationString.split(":"); // Split into hours, minutes, and seconds
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        int second = Integer.parseInt(parts[2]);
        return new Duration(hour, minute, second);
    }

    //Getters
    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    //Setters
    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
        normalise();
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
        normalise();
    }

    //Convert duration to total seconds
    public int toSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    // Overriding toString for display
    // How and when to use @Override implemented from stackoverflow - https://stackoverflow.com/questions/28929579/overriding-an-extending-class/28929624#28929624
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    //Compare durations
    public static int compare(Duration d1, Duration d2) {
        return Integer.compare(d1.toSeconds(), d2.toSeconds());
    }

}
