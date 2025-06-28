import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

class MoodInputTab {
    private JPanel panel;//main panel that hadle all the ui components
    private JournalMan journalMan;//object to manage journal entries

    public MoodInputTab(JournalMan journalMan) {//constructor to recieves the journal manager and set up the ui
        this.journalMan = journalMan;

        panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(600,400));

        JLabel dateLabel = new JLabel("Date(YYYY-MM-DD):");//label and text field to entering date
        dateLabel.setBounds(30,30,150,25);
        final JTextField dateField = new JTextField();
        dateField.setBounds(180,30,200,25);

        JLabel noteLabel = new JLabel("Note:");//label and text field to entering note
        noteLabel.setBounds(30,70,150,25);
        final JTextArea noteArea = new JTextArea();
        noteArea.setLineWrap(true);
        JScrollPane noteScroll = new JScrollPane(noteArea);
        noteScroll.setBounds(180,70,350,100);

        JLabel moodLabel = new JLabel("Mood:");//mood selection using combo box
        moodLabel.setBounds(30,190,150,25);
        final JComboBox<String>moodBox = new JComboBox<>(Mood.Moods);
        moodBox.setBounds(180,190,150,25);

        JButton saveButton = new JButton("Save Entry");//save button to sub,it entries
        saveButton.setBounds(180,230,150,30);

        panel.add(dateLabel);//add all the componets to panel.
        panel.add(dateField);
        panel.add(noteLabel);
        panel.add(noteScroll);
        panel.add(moodLabel);
        panel.add(moodBox);
        panel.add(saveButton);

        panel.setBackground(Mood.GetMoodColor((String) moodBox.getSelectedItem()));//set background based on the prementioned color

        moodBox.addActionListener(new ActionListener() {//change background color whrn mood is fixed
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Mood.GetMoodColor((String) moodBox.getSelectedItem()));
            }
        });

        saveButton.addActionListener(new ActionListener() {//hadle save button clicks
            public void actionPerformed(ActionEvent e) {
                String date = dateField.getText().trim();// use trim to reduce extra spaces.
                String note = noteArea.getText().trim();
                String selectedMood = (String) moodBox.getSelectedItem();

                if (date.isEmpty() || note.isEmpty()) {//validate input field
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                    return;
                }
                try {
                    MoodEntry entry = new MoodEntry(date,note,selectedMood);
                    DatabaseManager db = new DatabaseManager();
                    db.saveMoodEntry(entry);
                    db.close();
                    JOptionPane.showMessageDialog(panel,"Entry saved sucessfully");
                }
                catch (SQLException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(panel,"DATABASE not found");
                }

                dateField.setText("");//create input fiels after saving
                noteArea.setText("");
            }
        });
    }

    public JPanel getPanel() {//return the panel so it can be addd to a tabbed pane
        return panel;
    }
}
