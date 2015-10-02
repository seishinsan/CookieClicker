/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seishin.cookieclicker.daemons;

import com.seishin.cookieclicker.Engine.IdleEn;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

/**
 *
 * @author Seish
 */
public class MinerDaemon extends IdleEn implements Runnable {

    public MinerDaemon() {
        this.cookiesValue = 0.0;
        this.cookiesPerClick = 1.0;
        this.cookiesPerSecond = 1.0;
        
        factoryCosts = 100.0;
        farmCosts = 50.0;
        dealerCosts = 150.0;
        
        factoryMulti = 1.8;
        farmMulti = 1.2;
        dealerMulti = 3.5;
    }

    @Override
    public void run() {
        while (true) {
            addCookiesToValue();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MinerDaemon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
