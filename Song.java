import java.util.*;
public class Song{
private static int autowert = 0;
private int songNr;
private String titel;
private int spieldauer;
private String interpret;
private int anzahlStimmen;
public Song(String titel, int sd, String interpret){
    this.spieldauer = sd;
this.titel = titel;
this.interpret = interpret;
    songNr = autowert+1;
    autowert++;
}
public void zaehleStimme(){

}
public void loescheStimmen(){

}
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

}