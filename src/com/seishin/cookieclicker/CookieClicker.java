/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seishin.cookieclicker;

import com.seishin.cookieclicker.Windows.MainWindow;
import com.seishin.cookieclicker.daemons.MinerDaemon;
import java.io.IOException;

/**
 *
 * @author Seish
 */
public class CookieClicker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        MainWindow mainWindow = new MainWindow();
        Thread renderThread = new Thread(mainWindow);
        mainWindow.setVisible(true);
        renderThread.start();
        //TODO: Preis von Gebäuden nach gameload fehlerhaft (zu viele nachkommastellen)
    }

}
