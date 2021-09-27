/*
 * File: App.java
 * Created Date: 2021-09-24 10:19:52
 * Author: Nagy János
 * Original: recolletor, Sallai Andras
 * Github: https://github.com/andteki
 * Group: Szoft II N
 * -----
 * Last Modified: 2021-09-24
 * Modified By: Nagy János
 * -----
 * Copyright (c) 2021 Nagy János
 * 
 * GNU GPL v2
 */

import controllers.CollectorController;
import controllers.MainController;
import controllers.WordsController;
import views.MainWindow;

public class App {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        new MainController(mainWindow);
        new CollectorController(mainWindow);
        new WordsController(mainWindow);
        mainWindow.setVisible(true);
    }
}
