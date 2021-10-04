/*
 * File: Page.java
 * Created Date: 2021-09-24 14:26:47
 * Author: Nagy János
 * Original: recolletor, Sallai Andras
 * Github: https://github.com/andteki
 * -----
 * Last Modified: 2021-09-24
 * Modified By: Nagy János
 * -----
 * Copyright (c) 2021 Nagy János
 * 
 * GNU GPL v2
 */

package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Page {
    public String url;

    public ArrayList<String> getContent() {
        ArrayList<String> wordList = null;
        try {
            wordList = tryGetContent();
        } catch (IOException e) {
            System.err.println("Hiba! A weblap nem olvasható");
        }
        return wordList;
    }

    public ArrayList<String> tryGetContent() throws IOException {
        String result = "semmi";
        String body = "";
        if (!url.isEmpty()) {
            Connection conn = Jsoup.connect(this.url);
            Document doc = conn.get();
            result = doc.body().text();
            body = filterContent(result);        
        }else {
            System.err.println("Hiba! Az url nincs beállítva!");
        }
        return convertToArray(body);
    }

    private String filterContent(String result) {
        result = result.replaceAll("\\p{Punct}", "");
        result = result.replaceAll("[©0-9]", "");
        result = result.trim().replaceAll(" +", "\n");
        return result;
    }

    private ArrayList<String> convertToArray(String body) {
        ArrayList<String> wordList = new ArrayList<>();
        Scanner scanner = new Scanner(body);
        while(scanner.hasNextLine()) {
            wordList.add(scanner.nextLine());
        }
        scanner.close();
        Collections.sort(wordList);
        return wordList;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
