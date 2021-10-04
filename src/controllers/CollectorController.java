/*
 * File: CollectorController.java
 * Created Date: 2021-09-24 10:42:41
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

package controllers;

import java.util.ArrayList;

import models.Page;
import views.CollectorPanel;
import views.MainWindow;


public class CollectorController {
    CollectorPanel collectorPanel;
    MainWindow mainWindow;
    public CollectorController(
            MainWindow mainWindow,
            CollectorPanel collectorPanel) {

        this.collectorPanel = collectorPanel;
        this.mainWindow = mainWindow;
        initEvent();
    }
    private void initEvent() {
        initPasteButton();
        initStartButton();
        initExitButton();
    }
    private void initPasteButton() {
        collectorPanel.pasteFromClipBoardButton.addActionListener(event -> {
            System.out.println("beillesztés");
            mainWindow.urlField.paste();
        });
    }
    private void initStartButton() {
        collectorPanel.startButton.addActionListener(event -> {
            String url = this.setUrl();
            Page webPage = makeWebPage(url);
            fillWordModel(webPage);
            setStatusBarMessageWordCount();
        });
    }
    private String setUrl() {
        String url = mainWindow.urlField.getText();
        if (url.isEmpty()) {
            url = "https://index.hu";
        }
        return url;
    } 
    private Page makeWebPage(String url) {
        Page webPage = new Page();
        webPage.setUrl(url);
        return webPage;
    }
    private void fillWordModel(Page webPage) {
        ArrayList<String> wordList = webPage.getContent();
        for(String word : wordList) {
            if (mainWindow.wordsModel.indexOf(word)<0) {
                mainWindow.wordsModel.addElement(word);
            }                
        }
    }
    private void setStatusBarMessageWordCount() {
        Integer wordCount = mainWindow.wordsModel.getSize();
        mainWindow.statusBar.setMessage("Szavak: " + wordCount.toString());        
    }
    private void initExitButton() {
        this.collectorPanel.exitButton.addActionListener(event ->{
            System.exit(0);
        });
    }    
}
