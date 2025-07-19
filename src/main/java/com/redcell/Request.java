package com.redcell;

public class Request {
    private String requestId;
    private String bloodType;
    private int units;
    private Facility facilityInfo;
    private String status;
    private String date;

    public Request(String requestId, String bloodType, int units, String facilityName, String area, String status, String date) {
        this.requestId = requestId;
        this.bloodType = bloodType;
        this.units = units;
        this.facilityInfo = new Facility(facilityName, area);
        this.status = status;
        this.date = date;
    }

    // Getters and Setters
    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getBloodType() { return bloodType; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }

    public int getUnits() { return units; }
    public void setUnits(int units) { this.units = units; }

    // Modified getters to delegate to Facility object
    public String getHospital() { return this.facilityInfo.getName(); }
    public String getArea() { return this.facilityInfo.getArea(); }

    // New getter/setter for the Facility object
    public Facility getFacilityInfo() { return facilityInfo; }
    public void setFacilityInfo(Facility facilityInfo) { this.facilityInfo = facilityInfo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
} 