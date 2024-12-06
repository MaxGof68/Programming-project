public class AlbumCollection {
    private Albums[] albums; //Albums array
    private int albumCount;

    //Constructor
    public AlbumCollection(int maxAlbums) {
        this.albums = new Albums[maxAlbums]; //Initialize array with a fixed size
        this.albumCount = 0;
    }

    //Add album to collection
    public boolean addAlbum(Albums album) {
        if (albumCount < albums.length) {
            albums[albumCount] = album;
            albumCount++;
            return true; //Album added
        } else {
            System.out.println("Album collection is full. Cannot add more albums.");
            return false; //Album not added
        }
    }

    //getters
    public int getAlbumCount() {
        return albumCount;
    }

    public Albums[] getAlbums() {
        return albums;
    }

    // Display albums
    public void displayAlbums() {
        if (albumCount == 0) {
            System.out.println("No albums in the collection.");
            return;
        }

        for (int i = 0; i < albumCount; i++) {
            System.out.println(albums[i]); //Calls the toString() method of Album
        }
    }

    //Sort by artist and year
    public void displaySortedAlbums() {
        if (albumCount == 0) {
            System.out.println("No albums in the collection to sort.");
            return;
        }

        //Bubble sort by artist name and year
        ////https://stackoverflow.com/questions/33240968/java-bubble-sort
        for (int i = 0; i < albumCount - 1; i++) {
            for (int j = 0; j < albumCount - i - 1; j++) {
                // Compare by artist, then by year if artist names are equal
                if (albums[j].getArtist().compareTo(albums[j + 1].getArtist()) > 0 ||
                    (albums[j].getArtist().equals(albums[j + 1].getArtist()) &&
                     albums[j].getYear() > albums[j + 1].getYear())) {
                    // Swap albums
                    Albums temp = albums[j];
                    albums[j] = albums[j + 1];
                    albums[j + 1] = temp;
                }
            }
        }

        
        displayAlbums();
    }
}
