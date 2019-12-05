package ru.job4j.currency.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


@Entity(tableName = "rates",foreignKeys = @ForeignKey(entity = Currency.class, parentColumns = "curId", childColumns = "currencyId"))
public class Rates {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int currencyId;

    @SerializedName("CAD")
    private Double cAD;
    @SerializedName("HKD")
    private Double hKD;
    @SerializedName("ISK")

    private Double iSK;
    @SerializedName("PHP")
    private Double pHP;
    @SerializedName("DKK")
    private Double dKK;
    @SerializedName("HUF")
    private Double hUF;
    @SerializedName("CZK")
    private Double cZK;
    @SerializedName("AUD")
    private Double aUD;
    @SerializedName("RON")
    private Double rON;
    @SerializedName("SEK")
    private Double sEK;
    @SerializedName("IDR")
    private Double iDR;
    @SerializedName("INR")
    private Double iNR;
    @SerializedName("BRL")
    private Double bRL;
    @SerializedName("RUB")
    private Double rUB;
    @SerializedName("HRK")
    private Double hRK;
    @SerializedName("JPY")
    private Double jPY;
    @SerializedName("THB")
    private Double tHB;
    @SerializedName("CHF")
    private Double cHF;
    @SerializedName("SGD")
    private Double sGD;
    @SerializedName("PLN")
    private Double pLN;
    @SerializedName("BGN")
    private Double bGN;
    @SerializedName("TRY")
    private Double tRY;
    @SerializedName("CNY")
    private Double cNY;
    @SerializedName("NOK")
    private Double nOK;
    @SerializedName("NZD")
    private Double nZD;
    @SerializedName("ZAR")
    private Double zAR;
    @SerializedName("USD")
    private Double uSD;
    @SerializedName("MXN")
    private Double mXN;
    @SerializedName("ILS")
    private Double iLS;
    @SerializedName("GBP")
    private Double gBP;
    @SerializedName("KRW")
    private Double kRW;
    @SerializedName("MYR")
    private Double mYR;

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public Double getCAD() {
        return cAD;
    }

    public void setCAD(Double cAD) {
        this.cAD = cAD;
    }

    public Double getHKD() {
        return hKD;
    }

    public void setHKD(Double hKD) {
        this.hKD = hKD;
    }

    public Double getISK() {
        return iSK;
    }

    public void setISK(Double iSK) {
        this.iSK = iSK;
    }

    public Double getPHP() {
        return pHP;
    }

    public void setPHP(Double pHP) {
        this.pHP = pHP;
    }

    public Double getDKK() {
        return dKK;
    }

    public void setDKK(Double dKK) {
        this.dKK = dKK;
    }

    public Double getHUF() {
        return hUF;
    }

    public void setHUF(Double hUF) {
        this.hUF = hUF;
    }

    public Double getCZK() {
        return cZK;
    }

    public void setCZK(Double cZK) {
        this.cZK = cZK;
    }

    public Double getAUD() {
        return aUD;
    }

    public void setAUD(Double aUD) {
        this.aUD = aUD;
    }

    public Double getRON() {
        return rON;
    }

    public void setRON(Double rON) {
        this.rON = rON;
    }

    public Double getSEK() {
        return sEK;
    }

    public void setSEK(Double sEK) {
        this.sEK = sEK;
    }

    public Double getIDR() {
        return iDR;
    }

    public void setIDR(Double iDR) {
        this.iDR = iDR;
    }

    public Double getINR() {
        return iNR;
    }

    public void setINR(Double iNR) {
        this.iNR = iNR;
    }

    public Double getBRL() {
        return bRL;
    }

    public void setBRL(Double bRL) {
        this.bRL = bRL;
    }

    public Double getRUB() {
        return rUB;
    }

    public void setRUB(Double rUB) {
        this.rUB = rUB;
    }

    public Double getHRK() {
        return hRK;
    }

    public void setHRK(Double hRK) {
        this.hRK = hRK;
    }

    public Double getJPY() {
        return jPY;
    }

    public void setJPY(Double jPY) {
        this.jPY = jPY;
    }

    public Double getTHB() {
        return tHB;
    }

    public void setTHB(Double tHB) {
        this.tHB = tHB;
    }

    public Double getCHF() {
        return cHF;
    }

    public void setCHF(Double cHF) {
        this.cHF = cHF;
    }

    public Double getSGD() {
        return sGD;
    }

    public void setSGD(Double sGD) {
        this.sGD = sGD;
    }

    public Double getPLN() {
        return pLN;
    }

    public void setPLN(Double pLN) {
        this.pLN = pLN;
    }

    public Double getBGN() {
        return bGN;
    }

    public void setBGN(Double bGN) {
        this.bGN = bGN;
    }

    public Double getTRY() {
        return tRY;
    }

    public void setTRY(Double tRY) {
        this.tRY = tRY;
    }

    public Double getCNY() {
        return cNY;
    }

    public void setCNY(Double cNY) {
        this.cNY = cNY;
    }

    public Double getNOK() {
        return nOK;
    }

    public void setNOK(Double nOK) {
        this.nOK = nOK;
    }

    public Double getNZD() {
        return nZD;
    }

    public void setNZD(Double nZD) {
        this.nZD = nZD;
    }

    public Double getZAR() {
        return zAR;
    }

    public void setZAR(Double zAR) {
        this.zAR = zAR;
    }

    public Double getUSD() {
        return uSD;
    }

    public void setUSD(Double uSD) {
        this.uSD = uSD;
    }

    public Double getMXN() {
        return mXN;
    }

    public void setMXN(Double mXN) {
        this.mXN = mXN;
    }

    public Double getILS() {
        return iLS;
    }

    public void setILS(Double iLS) {
        this.iLS = iLS;
    }

    public Double getGBP() {
        return gBP;
    }

    public void setGBP(Double gBP) {
        this.gBP = gBP;
    }

    public Double getKRW() {
        return kRW;
    }

    public void setKRW(Double kRW) {
        this.kRW = kRW;
    }

    public Double getMYR() {
        return mYR;
    }

    public void setMYR(Double mYR) {
        this.mYR = mYR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}