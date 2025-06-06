package com.redcell;

public class Request {
    private String requestId;
    private String name;
    private String bloodType;
    private String date;
    private String status;

    public Request(String requestId, String name, String bloodType, String date, String status) {
        this.requestId = requestId;
        this.name = name;
        this.bloodType = bloodType;
        this.date = date;
        this.status = status;
    }

    // Getters and Setters
    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBloodType() { return bloodType; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
} 