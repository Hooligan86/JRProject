package model;

import view.View;

import java.io.*;
import java.nio.file.Path;

import static model.Decrypt.decrypt;
import static model.Encrypt.encrypt;

public class Main {
    static final String cryptographicAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.,”:-!? ";

    public static void main(String[] args) {

        View.execute();

    }




}
