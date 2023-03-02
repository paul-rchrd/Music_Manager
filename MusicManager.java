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
            stm.executeUpdate("CREATE TABLE `abstimmung` (`bezeichnung` varchar(1000) NOT NULL,`abstimmdauer` int(255) NOT NULL,`spieldauer` int(255) NOT NULL,`startzeit` datetime(6) DEFAULT NULL,`aid` int(255) NOT NULL,`pid` int(255) DEFAULT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");
            stm.executeUpdate("CREATE TABLE `playlist` (`bezeichnung` varchar(1000) NOT NULL,`pid` int(255) NOT NULL,`songid` int(255) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");
            stm.executeUpdate("CREATE TABLE `song` (`songnr` int(255) NOT NULL,`titel` varchar(1000) NOT NULL,`spieldauer` int(255) NOT NULL,`interpret` varchar(1000) NOT NULL,`anzahlStimmen` int(255) DEFAULT NULL,`aid` int(255) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");

            stm.executeUpdate("ALTER TABLE `abstimmung` ADD PRIMARY KEY (`aid`), ADD KEY `pid` (`pid`);");
            stm.executeUpdate("ALTER TABLE `playlist`ADD PRIMARY KEY (`pid`), ADD KEY `songid` (`songid`);");
            stm.executeUpdate("ALTER TABLE `song`ADD PRIMARY KEY (`songnr`), ADD KEY `aid` (`aid`), MODIFY `songnr` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5, ADD CONSTRAINT `aid` FOREIGN KEY (`aid`) REFERENCES `abstimmung` (`aid`); COMMIT;");



        } catch (SQLException e) {
            System.out.print(e);
        }
    }
    public void datenbankNutzen() throws SQLException{
        Statement stm = conn.createStatement();
        stm.executeUpdate("use music_manager");
    }

    public boolean einstellenSong(String titel, int spieldauer, String interpret, int anzahlStimmen) throws SQLException{
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT bezeichnung FROM abstimmung WHERE aid = 1");
        if(!rs.next()){
            System.out.println("Keine Abstimmung vorhanden");
            return false;
        }
        String einfügen = "INSERT INTO Song(titel, spieldauer, interpret, anzahlStimmen, aid) VALUES('"+titel+"','"+spieldauer+"','"+interpret+"',null,1);";
        stm.executeUpdate(einfügen);
        System.out.println("Song eingestellt");
        return true;
    }
    public boolean erzeugeAbstimmung(String bezeichnung, int abstimmdauer, int spieldauerp, Date startzeit, int aid, int sid, int pid ) throws SQLException{
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT bezeichnung FROM abstimmung WHERE aid = 1");
        if(!rs.next()){
            String einfügen = "INSERT INTO Abstimmung(bezeichnung, abstimmdauer, spieldauer, startzeit, aid, sid, pid) VALUES( '"+bezeichnung+"','"+abstimmdauer+"','"+spieldauerp+"', null ,1,null ,null);";
            stm.executeUpdate(einfügen);
            Abstimmung abstimmung = new Abstimmung(bezeichnung, aid, sid);
            System.out.println("Abstimmung erzeugt");
            return true;
        }else {
            System.out.println("Es ist schon eine Abstimmung vorhanden");
            return false;
        }

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


    }
}
