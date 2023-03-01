import java.util.*;
import javax.print.attribute.standard.DateTimeAtCreation;
import java.sql.*;
public class Abstimmung {


    private String bezeichnung;

    Scanner sc = new Scanner(System.in);

    private String beziehung;
    private int abstimmdauer;
    private int spieldauerp;
    private DateTimeAtCreation startzeit;
    Connection conn;
    private ArrayList<Song> songs = new ArrayList<Song>();

    public Abstimmung(String bez, int ad, int sd){
        this.spieldauerp = sd;
        this.abstimmdauer = ad;
        this.bezeichnung = bez;
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
                stm.executeUpdate("CREATE TABLE `abstimmung` (`bezeichnung` varchar(1000) NOT NULL, `abstimmdauer` int(255) NOT NULL, `spieldauer` int(255) NOT NULL, `startzeit` datetime(6) NOT NULL, `aid` int(255) NOT NULL AUTO_INCREMENT, `sid` int(255) NOT NULL, `pid` int(255) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");
                stm.executeUpdate("CREATE TABLE `playlist` (`bezeichnung` varchar(1000) NOT NULL, `pid` int(255) NOT NULL,`songid` int(255) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");
                stm.executeUpdate("CREATE TABLE `song` (`songnr` int(255) NOT NULL AUTO_INCREMENT, `titel` varchar(1000) NOT NULL, `spieldauer` int(255) NOT NULL, `interpret` varchar(1000) NOT NULL, `anzahlStimmen` int(255) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");
    
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

    public void hinzufuegen(String titel, int spieldauer, String interpret, int anzahlStimmen) throws SQLException{
        Statement stm = conn.createStatement();
        String einfügen = "INSERT INTO Song(titel, spieldauer, interpret, anzahlStimmen) VALUES('"+titel+"','"+spieldauer+"','"+interpret+"','"+anzahlStimmen+"');";
    stm.executeUpdate(einfügen);
    System.out.println("Objekt erzeugt");
    }

    public boolean starten(){
        return true;
    }



    public Playlist generierePlaylist() throws SQLException{
    sortiereSongs();
        Statement statement = conn.createStatement();
       String sql = "INSERT INTO Song(autowert, songnr, titel, spieldauer, interpret, anzahlStimmen) VALUES (?,?,?,?,?,?)";
       ResultSet result = statement.executeQuery(sql);
return null;
    }

    public boolean istAktiv(){
        return true;
    }

    private void sortiereSongs(){
   //BubbleSort optimiert. Sortiert songs ArrayList nach Anzahl der Stimmen
    boolean getauscht;
    int unsortiert = songs.size() - 1;

      do{
        getauscht = false;
        for(int i = 0; i < unsortiert; i++){
            if(songs.get(i).getAnzahlStimmen() > songs.get(i+1).getAnzahlStimmen()){
              songs.remove(i+1);
              songs.add(i, songs.get(i+1));
              getauscht = true;
            }
        }
        unsortiert--;
      }while(getauscht);
  }
    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getAbstimmdauer() {
        return abstimmdauer;
    }

    public int getSpieldauer() {
        return spieldauer;
    }

    public DateTimeAtCreation getStartzeit() {
        return startzeit;
    }

    public void setStartzeit(DateTimeAtCreation startzeit) {
        this.startzeit = startzeit;
    }
}
