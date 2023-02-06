import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
public class MusicManager {

    private ArrayList<Playlist> playlists;
    private Abstimmung abstimmung;
    private ArrayList<Song> alleSongs;
    private Connection conn;
    private dataBase db;
private Scanner sc = new Scanner(System.in);
    public MusicManager(){
        playlists = new ArrayList<Playlist>();
    }

    public boolean einstellenSong(){
    public boolean erzeugeAbstimmung(String bez, int ad, int sd ) throws SQLException{
        Statement stm = conn.createStatement();
        String einfügen = "INSERT INTO Song(autowert, songnr, titel, spieldauer, interpret, anzahlStimmen) VALUES( '"+bez+"','"+ad+"','"+sd+"');";
    stm.executeUpdate(einfügen);
         return true;   
    }
    public boolean erzeugeAbstimmung(String bez, int ad, int sd ) throws SQLException{
    Statement stm = conn.createStatement();
    String einfügen = "INSERT INTO Abstimmung(bezeichnung, abstimmdauer, spieldauer) VALUES( '"+bez+"','"+ad+"','"+sd+"');";
    stm.executeUpdate(einfügen);
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
}
