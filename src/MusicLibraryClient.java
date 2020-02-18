public class MusicLibraryClient {
    public static void main(String[] args) {
        MusicLibrary myLibrary = new MusicLibrary();

        Album a1 = new Album("First", "one Guy", 10, 42.5);
        Album a2 = new Album("This Music", "Some Band", 9, 36);
        Album a3 = new Album("Play", "People", 12, 39.1);
        Album a4 = new Album("Jerome", "Jerome", 14, 190.63);
        Album a5 = new Album("A","y",2,10);
        Album a6 = new Album("b","a",2,10);
        Album a7 = new Album("c","g",2,10);
        Album a8 = new Album("d","r",2,10);
        Album a9 = new Album("e","z",2,10);



        myLibrary.add(a1);
        myLibrary.add(a2);
        myLibrary.add(a3);
        myLibrary.add(a4);
        myLibrary.add(a5);
        myLibrary.add(a6);
        myLibrary.add(a7);
        myLibrary.add(a8);
        myLibrary.add(a9);

        System.out.println(myLibrary);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        myLibrary.doubleSize();

        System.out.println(myLibrary);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        myLibrary.remove(1);
        myLibrary.add(a3);
        System.out.println(myLibrary);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("Test Selection Sort");

        myLibrary.sortByTitle();

        System.out.println(myLibrary);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        System.out.println("Test Insertion Sort");

        myLibrary.sortByArtist();

        System.out.println(myLibrary);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        int titleLoc = myLibrary.findTitle("First");
        System.out.println(myLibrary.getAlbum(titleLoc));

        int artistLoc = myLibrary.findArtist("Some Ban");
        System.out.println(myLibrary.getAlbum(artistLoc));

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        System.out.println("Test Binary Searching");

        int binaryArtistLoc = myLibrary.binaryFindArtist("z");
        System.out.println(myLibrary.getAlbum(binaryArtistLoc));

        int binaryTitleLoc = myLibrary.binaryFindTitle("Play");
        System.out.println(myLibrary.getAlbum(binaryTitleLoc));

        System.out.println("+++++++++++++++++++++++++++++++++++++++");
    }
}