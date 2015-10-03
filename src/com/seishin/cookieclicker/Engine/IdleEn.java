/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seishin.cookieclicker.Engine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Seish
 */
public class IdleEn {

    public Double cookiesPerSecond;
    public Double cookiesPerClick;
    public Double cookiesValue;

    public Double farmCosts;
    public Double factoryCosts;
    public Double dealerCosts;

    public double farmMulti;
    public double factoryMulti;
    public double dealerMulti;

    public void buyFarm() {
        this.cookiesPerSecond = this.cookiesPerSecond + 1.5 + farmCosts / 1000 + cookiesPerSecond / 100;
        cookiesValue = cookiesValue - farmCosts;
        this.farmCosts = farmCosts * farmMulti;
    }

    public void buyFactory() {
        this.cookiesPerSecond = this.cookiesPerSecond + 5 + factoryCosts / 1000 + cookiesPerSecond / 100;
        cookiesValue = cookiesValue - factoryCosts;
        this.factoryCosts = factoryCosts * factoryMulti;
    }

    public void buyDealer() {
        this.cookiesPerClick = this.cookiesPerClick + 6.3 + dealerCosts / 1000 + cookiesPerClick / 100;
        this.cookiesPerSecond = this.cookiesPerSecond + 12 + dealerCosts / 1000 + cookiesPerSecond / 100;
        cookiesValue = cookiesValue - dealerCosts;
        this.dealerCosts = dealerCosts * dealerMulti;
    }

    public void calculateCookiesPerSecond(double cps) {
        this.cookiesPerSecond = cookiesPerSecond + cps;
        this.cookiesPerSecond = ((double) Math.round(this.cookiesPerSecond * 100)) / 100;

    }

    public void calculateCookiesPerClick(double cpc) {
        this.cookiesPerClick = cookiesPerClick + cpc;
        this.cookiesPerClick = ((double) Math.round(this.cookiesPerClick * 100)) / 100;

    }

    public void saveGame() throws IOException {
        BufferedWriter w = null;
        try {
            File saveGame = new File("Saves/save.sv");
            w = new BufferedWriter(new FileWriter(saveGame));
            w.write(cookiesPerClick + System.getProperty("line.separator")
                    + cookiesPerSecond + System.getProperty("line.separator")
                    + cookiesValue + System.getProperty("line.separator")
                    + farmCosts + System.getProperty("line.separator")
                    + factoryCosts + System.getProperty("line.separator")
                    + dealerCosts);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            w.close();
        }
    }

    public void loadGame() throws IOException {
        BufferedReader r = null;
        try {
            String curLine;
            r = new BufferedReader(new FileReader("saves/save.sv"));
            int i = 0;
            while ((curLine = r.readLine()) != null) {
                switch (i) {
                    case 0:
                        cookiesPerClick = Double.parseDouble(curLine);
                        System.out.println("loaded CPC ---");
                        break;
                    case 1:
                        cookiesPerSecond = Double.parseDouble(curLine);
                        System.out.println("loaded CPS ---");
                        break;

                    case 2:
                        cookiesValue = Double.parseDouble(curLine);
                        System.out.println("loaded Cookies ---");
                        break;

                    case 3:
                        farmCosts = Double.parseDouble(curLine);
                        System.out.println("loaded farms ---");
                        break;

                    case 4:
                        factoryCosts = Double.parseDouble(curLine);
                        System.out.println("loaded factorys ---");
                        break;

                    case 5:
                        dealerCosts = Double.parseDouble(curLine);
                        System.out.println("loaded dealers ---");
                        break;

                }
                i++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            r.close();
        }
    }

    public void addCookiesToValue() {
        this.cookiesValue = cookiesValue + cookiesPerSecond;
    }

    public void addCookiesToValueByClick() {
        this.cookiesValue = cookiesValue + cookiesPerClick;
    }

    public Double getCookiesPerSecond() {
        return cookiesPerSecond;
    }

    public Double getCookiesPerClick() {
        return cookiesPerClick;
    }

    public Double getCookiesValue() {
        return cookiesValue;
    }

    public Double getFarmCosts() {
        return farmCosts;
    }

    public Double getFactoryCosts() {
        return factoryCosts;
    }

    public Double getDealerCosts() {
        return dealerCosts;
    }

}
