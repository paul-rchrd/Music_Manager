import java.sql.*;
import java.util.*;

    // Erstellt die Klasse
public class Song{
    // Attribute
private static int songNr = 0;
private int autowert;
private String titel;
private int spieldauer;
private String interpret;
private int anzahlStimmen;
    // Konstruktor
public Song(String titel, int sd, String interpret){
    this.spieldauer = sd;
this.titel = titel;
this.interpret = interpret;
    autowert = songNr+1;
    songNr++;
}
    //Methode um die Stimmen zu zählen
public void zaehleStimme(){

}
    //Methode um Stimmen zu löschen
public void loescheStimmen(){

}
 //Get und Set Methoden
public void setAnzahlStimmen(int anzahlStimmen){
    this.anzahlStimmen = anzahlStimmen;
}
public int getAnzahlStimmen(){
    return anzahlStimmen;
}
public String getTitel(){
    return titel;
}
public int getSpieldauer(){
    return spieldauer;
}
public String getInterpret(){
    return interpret;
}
public int compareTo() {
    return 0;
}
public int getAutowert(){
    return autowert;
}
}