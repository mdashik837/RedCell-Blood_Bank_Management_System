package com.redcell;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Donor extends User {
    private String name;
    private String bloodType;
    private LocalDate lastDonationDate;
    private String area;

    public Donor(String name, String bloodType, LocalDate lastDonationDate, String area) {
        this.name = name;
        this.bloodType = bloodType;
        this.lastDonationDate = lastDonationDate;
        this.area = area;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBloodType() { return bloodType; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }

    public LocalDate getLastDonationDate() { return lastDonationDate; }
    public void setLastDonationDate(LocalDate lastDonationDate) { this.lastDonationDate = lastDonationDate; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getTimeSinceLastDonation() {
        if (lastDonationDate == null) {
            return "Never donated";
        }
        
        long months = ChronoUnit.MONTHS.between(lastDonationDate, LocalDate.now());
        long days = ChronoUnit.DAYS.between(lastDonationDate, LocalDate.now());
        
        if (months > 0) {
            return months + (months == 1 ? " month ago" : " months ago");
        } else {
            return days + (days == 1 ? " day ago" : " days ago");
        }
    }
} 