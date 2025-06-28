import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

class JournalMan{ // this class manages a collection of entry objects
    private List<Entry> entries = new ArrayList<>(); //private list to store all  the entrires.using composition.

    public void addEntries(Entry entry){
        entries.add(entry); // method to add an entry objects to the list.
    }
    public List<Entry> getallEntry(){ //method to return the full list of entries.
        return entries;
    }
}
