import java.awt.*;

class Mood{ //mood class to manage different moods and their associative colors
    public static String[] Moods= {"HAPPY","SAD","ANGRY","EXCITED","CALM","NEUTRAL"};//array of predefined moods
    public static Color GetMoodColor(String mood){ // return a specific color based on the given mood string
        switch(mood){
            case "HAPPY" : return new Color(227, 219, 158);
            case "SAD" : return new Color(141, 191, 230);
            case "ANGRY" : return new Color(218, 136, 154);
            case "EXCITED" : return new Color(216, 181, 159);
            case "CALM" : return new Color(135,206,235);
            case "NEUTRAL" : return new Color (135,206,235);

            default:return Color.LIGHT_GRAY; //if mood not found
        }
    }
}