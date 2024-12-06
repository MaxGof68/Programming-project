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
        normalise(); // Ensure the values are normalised on creation
    }

    // Normalise time values, ensure values like minutes and seconds are valid
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

    // Static method to split a Duration from a string
    public static Duration fromString(String durationString) {
        String[] parts = durationString.split(":"); // Split into hours, minutes, and seconds
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return new Duration(h, m, s); // Create and return a Duration object, h m and s to represent the time values
    }

    // Get seconds
    public int getSeconds() {
        return seconds;
    }

    // get minutes
    public int getMinutes() {
        return minutes;
    }

    //get hours
    public int getHours() {
        return hours;
    }

    // Set hours
    public void setHours(int hours) {
        this.hours = hours;
    }

    //set minutes
    public void setMinutes(int minutes) {
        this.minutes = minutes;
        normalise(); // Re-check normalisation
    }

    //set seconds
    public void setSeconds(int seconds) {
        this.seconds = seconds;
        normalise(); // Re-check normalisation
    }

    // Converts the duration to total seconds, useful for calculating total track time
    public int toSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    // Overriding toString for display
    // How and when to use @Override implemented from stackoverflow - https://stackoverflow.com/questions/28929579/overriding-an-extending-class/28929624#28929624
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    // Static method to compare two Duration objects, useful when finding longest and shortest track
    public static int compare(Duration d1, Duration d2) {
        return Integer.compare(d1.toSeconds(), d2.toSeconds());
    }

    // Testing the class
    /*public static void main(String[] args) {
        // Create a duration with unnormalised values
        Duration duration1 = new Duration(0, 59, 75); // 75 seconds = 1 minute + 15 seconds
        System.out.println("Normalized Duration 1: " + duration1); // Output: 01:00:15

        // Add seconds and normalise
        duration1.setSeconds(130); // 130 seconds = 2 minutes + 10 seconds
        System.out.println("After Adding Seconds: " + duration1); // Output: 01:02:10

        // Create another duration
        Duration duration2 = new Duration(1, 2, 10); // Already normalised
        System.out.println("Duration 2: " + duration2);

        // Compare durations using the static compare method
        int comparisonResult = Duration.compare(duration1, duration2);
        if (comparisonResult < 0) {
            System.out.println("Duration 1 is shorter than Duration 2");
        } else if (comparisonResult > 0) {
            System.out.println("Duration 1 is longer than Duration 2");
        } else {
            System.out.println("Duration 1 and Duration 2 are equal");
        }

        // Display total seconds of a duration
        System.out.println("Total seconds of Duration 1: " + duration1.toSeconds());
    }
    */
}

