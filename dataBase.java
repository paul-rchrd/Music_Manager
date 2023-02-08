import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class dataBase {




        private Connection conn;
        private String sqlBefehl;

        //Anbindung der Datenbank
        public dataBase() throws SQLException {

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
                stm.executeUpdate("CREATE TABLE `song` (`autowert` int(255) NOT NULL, `songnr` int(255) NOT NULL, `titel` varchar(1000) NOT NULL, `spieldauer` int(255) NOT NULL, `interpret` varchar(1000) NOT NULL, `anzahlStimmen` int(255) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");

                stm.executeUpdate("ALTER TABLE `abstimmung` ADD PRIMARY KEY (`aid`), ADD KEY `pid` (`pid`), ADD KEY `sid` (`sid`);");
                stm.executeUpdate("ALTER TABLE `playlist` ADD PRIMARY KEY (`pid`), ADD KEY `songid` (`songid`);");
                stm.executeUpdate("ALTER TABLE `song` ADD PRIMARY KEY (`autowert`);");



            } catch (SQLException e) {
                System.out.print(e);
            }
        }

        public void datenbankNutzen() throws SQLException{
            Statement stm = conn.createStatement();
            stm.executeUpdate("use music_manager");
        }

/*
        public void sendSqlBefehl(String sqlBefehl) throws SQLException {

            this.sqlBefehl = sqlBefehl;
            Statement stm = conn.createStatement();
            System.out.println(sqlBefehl);
            stm.executeUpdate(sqlBefehl);
        }
*/



        public void einfuegenHose(String name, String farbe, String art, String groesse) {
            try {
                String einfuegen =
                        "INSERT INTO Hose(name, farbe, art, groesse) VALUES ('" + name + "','" + farbe + "', '" + art + "','" + groesse + "');";
                Statement stm = conn.createStatement();
                stm.execute(einfuegen);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void loeschenHose(String art, int hID) {
            try {
                String loeschen = "DELETE FROM Hose WHERE hID = '" + hID + "';";
                Statement stm = conn.createStatement();
                stm.execute(loeschen);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public void tabellenLeeren(){
            try {
                String loeschenH = "DELETE FROM Hose;";
                Statement stm = conn.createStatement();
                stm.execute(loeschenH);

                String loeschenO = "DELETE FROM Oberteil;";
                stm = conn.createStatement();
                stm.execute(loeschenO);

                String loeschenS = "DELETE FROM Schuhe;";
                stm = conn.createStatement();
                stm.execute(loeschenS);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) throws Exception{

        dataBase d1 = new dataBase();
        d1.datenbankErstellen();

    }

    }

