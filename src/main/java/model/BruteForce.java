package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static model.Main.cryptographicAlphabet;

public class BruteForce {
    static int counter = 1;
    static Path temp2 = Path.of("text4.txt");
    public static void bruteForce(Path path) throws IOException {

        Path temp = path;

        while (true) {
            if(!check(temp)){
                temp = moveByKey(temp);
            }else{
                break;
            }
        }
    }

    private static boolean check(Path path) throws IOException {
        String str = Files.readAllLines(path).toString();
        str = str.replaceFirst(".$", "");
        Pattern pattern1 = Pattern.compile("[!,?.][^\s]");
        Pattern pattern2 = Pattern.compile("[аеяюиуоыэёАЕЯЮИУОЫЭЁ]{4,}");
        Pattern pattern3 = Pattern.compile("[бвгджзйклмнпрстфхцчшщБВГДЖЗКЛМНПРСТФХЦЧШЩ]{8,}");
        Matcher matcher1 = pattern1.matcher(str.toString());
        Matcher matcher2 = pattern2.matcher(str.toString());
        Matcher matcher3 = pattern3.matcher(str.toString());
        return !matcher1.find() && !matcher2.find() && !matcher3.find();
    }

    private static Path moveByKey(Path path) throws IOException {
        Path temp5 = Path.of("decryptedFileByBruteForce.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(temp2.toFile()))) {
            while (reader.ready()) {
                char c = (char) reader.read();
                if (cryptographicAlphabet.indexOf(c) != -1) {
                    writer.write((cryptographicAlphabet.charAt((cryptographicAlphabet.indexOf(c) + counter) % cryptographicAlphabet.length())));
                } else {
                    writer.write(c);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Files.delete(temp5);
        Files.copy(temp2,temp5);
        return temp5;
    }
}

