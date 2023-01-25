//Importiert alle wichtigen Methoden / Utilities
import java.util.*;

// Erstellt die Klasse Playlist
public class Playlist {
   
    // Attribute 
private String bezeichnung;
private ArrayList<Song> songs;

// Konstruktor (Macht konstruktionen, wie Objekte(eigentlich nur Objekte))
public Playlist(String bez){
    this.bezeichnung = bez;
 }  

 // Methode zum Hinzufügen von Songs mithilfe von dem Attribut song
 public void hinzufuegenSong(Song song){
 }

 // Methode um die Bezeichnung zurückzuholen
 public String getBezeichnung(){
    return bezeichnung;
 }

}
