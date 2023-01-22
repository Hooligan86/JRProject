package view;

import model.BruteForce;
import model.Decrypt;
import model.Encrypt;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;


public class View {

    public static void execute(){
        Path encryptFile;
        Path decryptFile;
        int key;
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Hello please choose the action:\n");
        while(true){
            System.out.println("1. Encrypt\n" +
                    "2. Decrypt\n" +
                    "3. Brute Force\n" +
                    "4. Exit");
            if(sc.hasNextInt()){
                choice = sc.nextInt();
                sc.nextLine();
            }else{
                System.out.println("Choose between 1-4");
                sc.nextLine();
                continue;
            }

            switch (choice){
                case 1:
                    System.out.println("Please insert the path to the file that you want encrypt");
                    encryptFile = Path.of(sc.nextLine());
                    System.out.println("Please insert the key");
                    key = sc.nextInt();
                    Encrypt.encrypt(encryptFile, key);
                    System.out.println("The file was encrypted");
                    break;
                case 2:
                    System.out.println("Please insert the path to the file that you want decrypt");
                    decryptFile = Path.of(sc.nextLine());
                    System.out.println("Please insert the key");
                    key = sc.nextInt();
                    Decrypt.decrypt(decryptFile, key);
                    System.out.println("The file was decrypted");
                    break;
                case 3:
                    System.out.println("Please insert the path to the file that you want decrypt by brute force");
                    decryptFile = Path.of(sc.nextLine());
                    try {
                        BruteForce.bruteForce(decryptFile);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("The file was decrypted by brute force");
                    break;
                case 4:
                    return;
            }
        }

    }
}
