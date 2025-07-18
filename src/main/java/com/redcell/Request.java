package com.redcell;

public class Request {
    private String requestId;
    private String bloodType;
    private int units;
    private String hospital;
    private String area;
    private String status;
    private String date;

    public Request(String requestId, String bloodType, int units, String hospital, String area, String status, String date) {
        this.requestId = requestId;
        this.bloodType = bloodType;
        this.units = units;
        this.hospital = hospital;
        this.area = area;
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

    public String getHospital() { return hospital; }
    public void setHospital(String hospital) { this.hospital = hospital; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
} 