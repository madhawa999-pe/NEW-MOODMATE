import java.io.Serializable;

class Entry{
    private String date; // private number varibles to store date and note for entry
    private String note;
    public Entry(String date,String note){ //constructor for the entry class
        this.date = date;
        this.note = note;//initialize a new entry object with a given name
    }
    public String GetDate(){ //return date as a string
        return date;
    }
    public String GetNote(){//return note as a string
        return note;
    }
    public String GetSummary(){ //return summery string combining data and note
        return date + "|NOTE :" + note;
    }
    public String Tostring(){ //return a formatted string representation of the entry
        return date + "\n" + note + "\n";
    }
}
