import javax.swing.*;
import java.awt.*;
import java.util.List;

class MoodViewTab{
    private JPanel panel; //main pannel
    private JournalMan journalMan;//reference to entry manager


    private JTextArea displayArea; //area to display entries

    public MoodViewTab(JournalMan journalMan) {//layout with a center area
        this.journalMan = journalMan;

        panel = new JPanel(new BorderLayout());
        displayArea = new JTextArea();
        displayArea.setEditable(false);  //make display read only
        displayArea.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(displayArea);//add scroll if entries overflow
        panel.add(scrollPane, BorderLayout.CENTER);

        showEntries();//display entries initially
    }


    public void showEntries(){//method to refesh and show allmood entries records
        displayArea.setText("");
        List<Entry> entries = journalMan.getallEntry();

        for(Entry entry : entries){
            if (entry instanceof MoodEntry) {
                MoodEntry moodEntry = (MoodEntry)entry;
                displayArea.append(moodEntry.Tostring() + "\n\n");//append formatted string
            }
        }
    }
    public JPanel getPanel(){//return the pannel to be added to the tab
        return panel;
    }
}
