package com.example.ui1.Models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class ContactModel {
    private String macAddress;
    private LocalDate date;



    public ContactModel(String macAddress, LocalDate date) {
        this.macAddress = macAddress;
        this.date = date;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public ContactModel(String macAddress, String date) {
        this.macAddress = macAddress;
        this.date = LocalDate.parse(date);
    }

    public ContactModel() {
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
