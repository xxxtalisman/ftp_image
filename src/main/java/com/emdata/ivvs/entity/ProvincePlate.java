package com.emdata.ivvs.entity;

import java.util.List;

/**
 * Created on 2019/7/11.
 */
public class ProvincePlate {
    private String provice;

    private List<String> letters;

    public ProvincePlate(String provice, List<String> letters) {
        this.provice = provice;
        this.letters = letters;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public List<String> getLetters() {
        return letters;
    }

    public void setLetters(List<String> letters) {
        this.letters = letters;
    }

    @Override
    public String toString() {
        return "ProvincePlate{" +
                "provice='" + provice + '\'' +
                ", letters=" + letters +
                '}';
    }
}
