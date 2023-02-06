import java.util.ArrayList;

public class MusicManager {

    private ArrayList<Playlist> playlists;
    private Abstimmung abstimmung;
    private ArrayList<Song> alleSongs;

    public MusicManager(){
        playlists = new ArrayList<Playlist>();
    }

    public boolean erzeugeAbstimmung(String bez, int ad, int sd ){


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
        Song s1 = new Song("",20,"");
        return  s1;
    }

    public boolean abstimmen(Song song){
        return true;
    }

    public String holePlaylist(String beziehung){
        return "";
    }
}
