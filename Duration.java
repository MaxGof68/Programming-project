class duration {
    int hours;
    int minutes;
    int seconds;

public duration(int hours, int minutes, int seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
    
}
public int getSeconds() {
    return seconds;
}
public int getMinutes() {
    return minutes;
}
public int getHours() {
    return hours;
}
public String toString() {
    return (hours + ":" + minutes + ":" + seconds);
}
public static void Duration(String[] args){
    
}
} 