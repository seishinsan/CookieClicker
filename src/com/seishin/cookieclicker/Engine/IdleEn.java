/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seishin.cookieclicker.Engine;

import java.text.DecimalFormat;

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
            this.cookiesPerSecond = this.cookiesPerSecond + 0.1;
            cookiesValue = cookiesValue - farmCosts;
            this.farmCosts = farmCosts * farmMulti;
    }

    public void buyFactory() {
        this.cookiesPerSecond = this.cookiesPerSecond + 1;
        cookiesValue = cookiesValue - factoryCosts;
        this.factoryCosts = factoryCosts * factoryMulti;
    }

    public void buyDealer() {
        this.cookiesPerClick = this.cookiesPerClick + 1;
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
