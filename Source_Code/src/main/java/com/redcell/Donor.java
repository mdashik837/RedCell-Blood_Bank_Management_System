package com.redcell;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Represents a blood donor
public class Donor extends User {

    // Attributes
    private String bloodType;
    private LocalDate lastDonationDate;
    private DonorStatus status;
    private int totalDonations;

    // Constructor
    public Donor(String name, String bloodType, LocalDate lastDonationDate, String area) {
        super(name, area);
        this.bloodType = bloodType;
        this.lastDonationDate = lastDonationDate;
        this.status = DonorStatus.ELIGIBLE;
        this.totalDonations = 0;
    }

    // Methods
    public String getBloodType() {
        return bloodType;
    }
    
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public LocalDate getLastDonationDate() {
        return lastDonationDate;
    }
    
    public void setLastDonationDate(LocalDate lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }

    public DonorStatus getStatus() {
        return status;
    }

    public void setStatus(DonorStatus status) {
        this.status = status;
    }

    public int getTotalDonations() {
        return totalDonations;
    }

    public void setTotalDonations(int totalDonations) {
        this.totalDonations = totalDonations;
    }

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