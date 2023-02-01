import java.util.*;
public class Abstimmung {

    private String beziehung;
    private int abstimmdauer;
    private int spieldauer;
    private Date startzeit;
    private ArrayList<Song> songs = new ArrayList<Song>();

    public Abstimmung(String bez, int ad, int sd){
        this.spieldauer = sd;
        this.abstimmdauer = ad;
        this.beziehung = bez;

    }

    public void hinzufuegen(Song song){

    }

    public boolean starten(){
        return true;
    }



    public Playlist generierePlaylist(){
        Playlist p1;
        p1 = new Playlist();
        return ;
    }

    public boolean istAktiv(){
        return true;
    }

    public String getBeziehung() {
        return beziehung;
    }

    public int getAbstimmdauer() {
        return abstimmdauer;
    }

    public int getSpieldauer() {
        return spieldauer;
    }

    public Date getStartzeit() {
        return startzeit;
    }

    public void setStartzeit(Date startzeit) {
        this.startzeit = startzeit;
    }
}
