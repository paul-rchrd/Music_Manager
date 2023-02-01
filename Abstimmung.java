import java.util.*;
public class Abstimmung {


    private String bezeichnung;

    Scanner sc = new Scanner(System.in);

    private String beziehung;

    private int abstimmdauer;
    private int spieldauer;
    private Date startzeit;
    private ArrayList<Song> songs = new ArrayList<Song>();

    public Abstimmung(String bez, int ad, int sd){
        this.spieldauer = sd;
        this.abstimmdauer = ad;
        this.bezeichnung = bez;

    }

    public void hinzufuegen(Song song){

    }

    public boolean starten(){
        return true;
    }



    public Playlist generierePlaylist(){
        Playlist p1;
        p1 = new Playlist(bezeichnung);
        return p1;
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
            if(songs.get(i).getAnzahlStimmen() > songs.get(i+1).getAnzahlStimmen()){ //kein Plan was da falsch ist
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

    public Date getStartzeit() {
        return startzeit;
    }

    public void setStartzeit(Date startzeit) {
        this.startzeit = startzeit;
    }
}
