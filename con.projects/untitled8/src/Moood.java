import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class Moood{ //main gui class for mood tracker welcome screen
    private JFrame frame;

    public Moood(){ //initilize main frame
        frame = new JFrame("Mood Tracker");

        frame.setSize(1000,718);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        ImageIcon bgIcon = new ImageIcon("C:/Users/User/Downloads/image.png"); //set background image
        JLabel bgLabel = new JLabel(bgIcon);
        frame.setContentPane(bgLabel);
        frame.setLayout(null);

        JLabel label = new JLabel("MOODMATE", SwingConstants.CENTER);//add title
        label.setBounds(300,40,400,50);
        label.setFont(new Font("Poppins", Font.BOLD, 50));
        label.setForeground(new Color(255, 255, 200));
        frame.add(label);

        JLabel label2 = new JLabel("How Are You?", SwingConstants.CENTER);//add sub-title
        label2.setBounds(350,250,300,40);
        label2.setFont(new Font("Poppins", Font.BOLD, 40));
        label2.setForeground(new Color(255, 255, 200));
        frame.add(label2);

        JLabel dateLabel = new JLabel();
        dateLabel.setBounds(350,350,350,30);
        dateLabel.setFont(new Font("Poppins", Font.BOLD, 20));
        dateLabel.setForeground(new Color(255,255,200));
        frame.add(dateLabel);

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
        dateLabel.setText("Today is:" + today.format(formatter));


        JButton myButton = new JButton("Track Today");//button to track mood
        myButton.setFont(new Font("Poppins", Font.BOLD, 20));
        myButton.setBounds(400, 600, 200, 40);
        myButton.setBackground(Color.BLACK);
        myButton.setForeground(new Color(255, 255, 200));
        myButton.setFocusPainted(false);
        myButton.setContentAreaFilled(false);  // make background paintable
        myButton.setOpaque(true);
        myButton.setBorder(new LineBorder(Color.YELLOW, 2, true));
        frame.add(myButton);

        myButton.addActionListener(new ActionListener() { //action when button is clicked
            public void actionPerformed(ActionEvent e){
                new moodSwingUI();
                frame.dispose();
            }
        });
        frame.setVisible(true);
    }
    public static void main(String[] args){ //launch gui in thread safe way.
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new Moood();
            }
        });
    }

}