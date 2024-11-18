Public Class duration {
    int hours;
    int minutes;
    int seconds;

Public duration(int hours, int minutes, int seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
    
}
Public getSeconds() {
    return seconds;
}
Public getMinutes() {
    return minutes;
}
Public getHours() {
    return hours;
}
Public toString() {
    return (hours + ":" + minutes + ":" + seconds);
}
Public static void Duration(String[] args){
    seconds = 13;
    minutes = 04;
    hours = 00;
    toString()
}
} 