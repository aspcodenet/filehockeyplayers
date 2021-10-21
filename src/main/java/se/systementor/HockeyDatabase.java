package se.systementor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class HockeyDatabase {
    private ArrayList<String> allPlayers = new ArrayList<>();
    
    public void run(){
        readPlayersFromFile();

        while(true){
            System.out.println("1. Create player");
            System.out.println("2. List players");
            System.out.println("0. Exit");
            System.out.println();
            int sel = Integer.parseInt(System.console().readLine());
            if(sel == 0)
                break;
            if(sel == 1){
                createPlayer();
                savePlayersToFile();
            }
            if(sel == 2)
                listPlayers();
        }
    }

    private void savePlayersToFile() {
        // delete file if it exists
        String path = "hockeyplayers.txt";
        try{
            Files.deleteIfExists(Paths.get(path));
        }
        catch(Exception ex){}
        // skriver vi om ALLA rader
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path,true))) {
            for(String s: allPlayers)
                br.write(s + "\n");
        }
        catch(IOException ex){
            System.out.println(ex);
        }
    }

    private void readPlayersFromFile() {
        String path = "hockeyplayers.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while (( line = br.readLine()) != null) {
                allPlayers.add(line);
            }
        }
        catch(IOException ex){
            System.out.println(ex);
        }        
    }



    public void createPlayer(){
        System.out.println("***CREATE NEW PLAYER ****");
        System.out.print("Ange namn:");
        String name = System.console().readLine();
        allPlayers.add(name);

    }
    public void listPlayers(){
        System.out.println("***LISTA SPELARE ****");
        for(String s : allPlayers)
            System.out.println(s);
    }
}
