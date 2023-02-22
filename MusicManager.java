import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class MusicManager {

    private ArrayList<Playlist> playlists;
    private Abstimmung abstimmung;
    private ArrayList<Song> alleSongs;
    Connection conn;
    private dataBase db;
private Scanner sc = new Scanner(System.in);
    public MusicManager(){
        playlists = new ArrayList<Playlist>();
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String pw = "admin";

            conn = DriverManager.getConnection(url, user, "");
            System.out.println("Inside");


        } catch (SQLException ex) {
            System.out.println("Outside");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    public void datenbankErstellen() throws SQLException {

        Statement stm = conn.createStatement();

        try {
            stm.executeUpdate("CREATE DATABASE IF NOT EXISTS music_manager");
            stm.executeUpdate("use music_manager");
            stm.executeUpdate("CREATE TABLE `abstimmung` (`bezeichnung` varchar(1000) NOT NULL, `abstimmdauer` int(255) NOT NULL, `spieldauer` int(255) NOT NULL, `startzeit` datetime(6) NOT NULL, `aid` int(255) NOT NULL, `sid` int(255) NOT NULL, `pid` int(255) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");
            stm.executeUpdate("CREATE TABLE `playlist` (`bezeichnung` varchar(1000) NOT NULL, `pid` int(255) NOT NULL,`songid` int(255) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");
            stm.executeUpdate("CREATE TABLE `song` ()`songnr` int(255) NOT NULL AUTO_INCREMENT, `titel` varchar(1000) NOT NULL, `spieldauer` int(255) NOT NULL, `interpret` varchar(1000) NOT NULL, `anzahlStimmen` int(255) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");

            stm.executeUpdate("ALTER TABLE `abstimmung` ADD PRIMARY KEY (`aid`), ADD KEY `pid` (`pid`), ADD KEY `sid` (`sid`);");
            stm.executeUpdate("ALTER TABLE `playlist` ADD PRIMARY KEY (`pid`), ADD KEY `songid` (`songid`);");
            stm.executeUpdate("ALTER TABLE `song` ADD PRIMARY KEY (`songnr`);");



        } catch (SQLException e) {
            System.out.print(e);
        }
    }
    public void datenbankNutzen() throws SQLException{
        Statement stm = conn.createStatement();
        stm.executeUpdate("use music_manager");
    }

    public boolean einstellenSong(String titel, int spieldauer, String interpret, int anzahlStimmen ) throws SQLException{
        Statement stm = conn.createStatement();
        String einfügen = "INSERT INTO Song(titel, spieldauer, interpret, anzahlStimmen) VALUES('"+titel+"','"+spieldauer+"','"+interpret+"','"+anzahlStimmen+"');";
    stm.executeUpdate(einfügen);
    //System.out.println("Objekt erzeugt");
         return true;   
    }
    public boolean erzeugeAbstimmung(String bezeichnung, int abstimmdauer, int spieldauer, Date startzeit, int aid, int sid, int pid ) throws SQLException{
    Statement stm = conn.createStatement();
    String einfügen = "INSERT INTO Abstimmung(bezeichnung, abstimmdauer, spieldauer, startzeit, aid, sid, pid) VALUES( '"+bezeichnung+"','"+abstimmdauer+"','"+spieldauer+"', '"+startzeit+"','"+aid+"','"+sid+"' '"+pid+"');";
    stm.executeUpdate(einfügen);
    System.out.println("Abstimmung erzeugt");
        return true;
    }

    public boolean hinzufuegenSongsZurAbstimmung(){
    
        return true;
    }

    public boolean starteAbstimmung(){
        
        return true;
    }

    public String holeSongsDerAbstimmung(){
    
        return "";
    }

    public Song sucheSong(int nr){
        return null;
    }

    public boolean abstimmen(Song song){
        return true;
    }

    public String holePlaylist(String beziehung){
        return "";
    }
    public static void main(String []args) throws SQLException{
        
        MusicManager m = new MusicManager();
        m.datenbankNutzen();
// m.einstellenSong(2, 3, "Test", 4, "Name", 6);
m.erzeugeAbstimmung("TestAbstimmung", 3, 30, 10-10-2020, 2, 1, 3);
    }
}
