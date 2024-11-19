//Duration will be used to manage and display duration times - track length, album length


public class Duration {
    int hours;
    int minutes;
    int seconds;

//Constructor
public duration(int hours, int minutes, int seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
    normalize.();
    
}

//Normalise time values
private void normalize() {
        if (seconds >= 60) {
            minutes += seconds / 60;
            seconds = seconds % 60;
        }
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        }
    }

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
    normalize();
}

public void setSeconds(int seconds) {
    this.seconds = seconds;
    normalize();
}

//Converts the duration to total seconds for comparison or calculation
public int toSeconds() {
    return hours * 3600 + minutes * 60 + seconds;
}



//Display duration
    //    public String toString() {
    //         return (hours + ":" + minutes + ":" + seconds);
    //     }
    //     public static void Duration(String[] args){
            
    //    }

@Override
public String toString() {
    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
}

//Compare durations
public static int compare(Duration d1, Duration d2) {
    return Integer.compare(d1.toSeconds(), d2.toSeconds());
}

public int compareTo(){
    int thisTotalSeconds = this.hours * 3600 + this.minutes * 60 + this.seconds;
    int otherTotalSeconds = other.hours * 3600 + other.minutes * 60 + other.seconds;

    return Integer.compare(thisTotalSeconds, otherTotalSeconds);
}