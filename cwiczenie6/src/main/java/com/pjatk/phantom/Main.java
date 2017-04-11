package com.pjatk.phantom;

import java.io.IOException;

/**
 * Created by Mateusz on 11.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        String fileURL = "http://szuflandia.pjwstk.edu.pl/~s12674/phantom/phantomjs";
        String saveDir = "target/";
        try {
            HttpDownloadUtility.downloadFile(fileURL, saveDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
