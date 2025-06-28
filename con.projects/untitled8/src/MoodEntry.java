import java.io.Serializable;

class MoodEntry extends Entry { //moodentry class extends entry and add mood tracking functionality
    private String mood;
    public MoodEntry(String date,String note,String mood){ //construcor to initilize date and note and mood
        super(date,note); //inherited data and call the super class
        this.mood = mood;
    }
    public String GetMood(){
        return mood;
    }
    public String GetSummary(){ // override get summery to include summry for note
        return GetDate() + "|Mood :" + mood + "NOTE :" + GetNote();
    }
    public String Tostring(){ // override get summery to include summry for note in a formatted way
        return GetDate() + "|Mood :" + mood + "\n" + "NOTE :" + GetNote();
    }
}