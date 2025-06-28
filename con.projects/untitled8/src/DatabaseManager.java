import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=MOODS;encrypt=true;trustServerCertificate=true";
    private static final String USER = "MoodUser";
    private static final String PASSWORD = "NewStrongPassword123!";




    private Connection connection;

    public DatabaseManager()throws SQLException{
        connection = DriverManager.getConnection(URL,USER,PASSWORD);
        System.out.println("Connected to the dtabase successfully");

    }
    public void saveMoodEntry(MoodEntry entry) throws SQLException {
        String sql = "INSERT INTO mood_entries(entry_date, note, mood) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, entry.GetDate());
            stmt.setString(2, entry.GetNote());
            stmt.setString(3, entry.GetMood());
            stmt.executeUpdate();
        }
    }

    public void close() throws SQLException{
        if (connection!= null) connection.close();
    }
    public List<MoodEntry> loadMoodEntries() throws  SQLException{
        List<MoodEntry> entries = new ArrayList<>();
        String sql = "SELECT enrey_date,note,mood FROM mood_entries";
        try(Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String date = rs.getString("entry_date");
                String note = rs.getString("note");
                String mood = rs.getString("mood");
                entries.add(new MoodEntry(date,note,mood));
            }
        }
        return entries;
    }
}

