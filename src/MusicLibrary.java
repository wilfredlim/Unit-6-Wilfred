public class MusicLibrary {
    private Album[] library;
    private int size = 10;
    public MusicLibrary(){
        library = new Album[size];
    }

    //looks for spot that is null, adds album to that location
    //then returns true
    //if no null spots, dont add return false
    public boolean add(Album album) {
        for (int i = 0; i < library.length; i++) {
            if (library[i] == null) {
                library[i] = album;
                return true;
            }
        }
        return false;
    }

    public boolean remove(int index){
        if(index >= 0 && index < library.length && library[index] != null){
            library[index] = null;
            return true;
        }
        return false;
    }

    public void doubleSize(){
        size = size*2;
    }

    public String toString(){
        String result = "";
        for(Album a : library){
            if(a != null)
            result += a.toString() + "\n";
        }
        return result;
    }

    public int findTitle(String title){
        for(int i = 0; i < library.length; i++){
            if(library[i] != null & library[i].getTitle().equals(title)){
                return i;
            }
        }
            return -1;
    }

    public int findArtist(String artist){
        for(int i = 0; i < library.length; i++){
            if(library[i] != null && library[i].getArtist().equals(artist)){
                return i;
            }
        }
        return -1;
    }

    public Album getAlbum(int index){
        if(index>=0 && index<library.length)
             return library[index];
        else{
            System.out.println("Index is out of bounds");
            return null;
        }
    }

    public void sortByTitle(){
        Album temp;
        int min;

        for(int i=0; i < library.length - 1; i++){
            min = i;
            for(int scan = i+1; scan < library.length; scan++) {
                if (library[scan] != null && library[min] != null) {
                    if (library[scan].getTitle().compareTo(library[min].getTitle()) < 0) {
                        min = scan;
                    }
                }
            }
            temp = library[min];
            library[min]=library[i];
            library[i]=temp;
        }
    }

    public void sortByArtist(){
        for(int i = 1; i < library.length; i++) {
            Album key = library[i];
            int position = i;
            if (library[position-1] != null && library[i] != null) {
                while (position > 0 && library[position - 1].getArtist().compareTo(key.getArtist()) > 0) {
                    library[position] = library[position - 1];
                    position--;
                }
                library[position] = key;
            }
        }
    }
    public int binaryFindArtist(String artist) {
        sortByArtist();
        int low = 0;
        int high = library.length - 1;
        int middle = (low + high) / 2;

            while (library[middle].getArtist().compareTo(artist) < 0 && low <= high) {
                if (artist.compareTo(library[middle].getArtist()) < 0)
                    high = middle - 1;
                else
                    low = middle + 1;
                middle = (low + high) / 2;
            }

            if (library[middle].getArtist().equals(artist))
                return middle;
            else
                return -1;
        }
    public int binaryFindTitle(String title) {
        sortByTitle();
        int low = 0;
        int high = library.length - 1;
        int middle = (low + high) / 2;

        while (library[middle].getTitle().compareTo(title) < 0 && low <= high) {
            if (title.compareTo(library[middle].getTitle()) < 0)
                high = middle - 1;
            else
                low = middle + 1;
            middle = (low + high) / 2;
        }

        if (library[middle].getTitle().equals(title))
            return middle;
        else
            return -1;
    }
}

