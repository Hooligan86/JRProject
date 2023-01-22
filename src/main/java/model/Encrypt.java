package model;

import java.io.*;
import java.nio.file.Path;

import static model.Main.cryptographicAlphabet;

public class Encrypt {

    public static void encrypt(Path path, int key) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
            BufferedWriter writer = new BufferedWriter(new FileWriter("encryptedFile.txt"))){
            while (reader.ready()){
                char c = (char) reader.read();
                if(cryptographicAlphabet.indexOf(c) != -1){
                    writer.write((cryptographicAlphabet.charAt((cryptographicAlphabet.indexOf(c) + key) % cryptographicAlphabet.length())));
                }else{
                    writer.write(c);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
