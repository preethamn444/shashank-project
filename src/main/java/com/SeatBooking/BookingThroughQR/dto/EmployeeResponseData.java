package com.SeatBooking.BookingThroughQR.dto;

public class EmployeeResponseData {

    private Long id;
    private String message;

    private String Data;

    public EmployeeResponseData(Long id, String message, String data) {
        this.id = id;
        this.message = message;
        Data = data;
    }

    public EmployeeResponseData() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
