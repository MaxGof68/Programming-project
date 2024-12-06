import java.io.File;
import java.io.FileNotFoundException; //FileNotFoundException, how and when to use. Try and Catch handling. https://stackoverflow.com/questions/28553991/compiling-java-program-filenotfoundexception
import java.util.Scanner;

public class AlbumDatabase {

    private AlbumCollection collection;

    public AlbumDatabase(int maxAlbums) {
        this.collection = new AlbumCollection(maxAlbums);
    }

    private void readAlbumsFromFile(String filename) {
        Scanner fileScanner = null; //Declare the scanner outside the try block
        try {
            fileScanner = new Scanner(new File(filename)); //Initialise the scanner
            Albums currentAlbum = null;
    
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
    
                if (line.isEmpty()) {
                    continue; //Skip empty lines
                }
    
                if (line.matches(".+ : .+ \\(\\d{4}\\)")) { //Match album details format
                    if (currentAlbum != null) {
                        collection.addAlbum(currentAlbum);
                    }
    
                    String[] parts = line.split(":", 2);
                    String artist = parts[0].trim();
                    String[] titleAndYear = parts[1].split("\\(");
                    String title = titleAndYear[0].trim();
                    int year = Integer.parseInt(titleAndYear[1].replace(")", "").trim());
    
                    currentAlbum = new Albums(artist, title, year, 50); //Assume max 50 tracks per album
                } else if (currentAlbum != null) {
                    //Split and add a track to the current album
                    try {
                        Track track = Track.fromString(line);
                        currentAlbum.addTrack(track);
                    } catch (Exception e) {
                        System.out.println("Skipping invalid track format: " + line);
                    }
                }
            }
    
            // Add the last album
            if (currentAlbum != null) {
                collection.addAlbum(currentAlbum);
            }
        } catch (FileNotFoundException e) { //https://stackoverflow.com/questions/28553991/compiling-java-program-filenotfoundexception
            System.out.println("File not found: " + filename);
        } finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }
    }
    
    private void displayTotalPlaytimeForKraftwerk() {
        int totalSeconds = 0;
    
        for (int i = 0; i < collection.getAlbumCount(); i++) {
            Albums album = collection.getAlbums()[i];
            if (album.getArtist().equalsIgnoreCase("Kraftwerk")) {
                totalSeconds += album.getTotalDuration().toSeconds();
            }
        }
    
        Duration totalPlaytime = new Duration(0, 0, totalSeconds);
        System.out.println("\nTotal Playtime of Kraftwerk Albums: " + totalPlaytime);
    }
    
    private void displayShortestTitle() {
        Albums shortestTitleAlbum = null;
    
        for (int i = 0; i < collection.getAlbumCount(); i++) {
            Albums currentAlbum = collection.getAlbums()[i];
            if (shortestTitleAlbum == null || currentAlbum.getTitle().length() < shortestTitleAlbum.getTitle().length()) {
                shortestTitleAlbum = currentAlbum;
            }
        }
    
        if (shortestTitleAlbum != null) {
            System.out.println("\nAlbum with the Shortest Title: " + shortestTitleAlbum);
        } else {
            System.out.println("\nNo albums in the collection.");
        }
    }
    
    private void displayLongestTrack() {
        Track longestTrack = null;
    
        for (int i = 0; i < collection.getAlbumCount(); i++) {
            Track albumLongest = collection.getAlbums()[i].getLongestTrack();
            if (longestTrack == null || (albumLongest != null &&
                albumLongest.getDuration().toSeconds() > longestTrack.getDuration().toSeconds())) {
                longestTrack = albumLongest;
            }
        }
    
        if (longestTrack != null) {
            System.out.println("\nLongest Track in the Collection: " + longestTrack);
        } else {
            System.out.println("\nNo tracks in the collection.");
        }
    }
    
    public static void main(String[] args) {
        AlbumDatabase database = new AlbumDatabase(50);
        database.run("albums.txt");
    }


    public void run(String filename) {
        readAlbumsFromFile(filename);
        collection.displaySortedAlbums();
        displayTotalPlaytimeForKraftwerk();
        displayShortestTitle();
        displayLongestTrack();
    }

    

    
}
