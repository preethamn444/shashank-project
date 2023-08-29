package com.SeatBooking.BookingThroughQR.dto;

public class EmployeeResponseDto {
    private String status;
    private EmployeeResponseData data;

    public EmployeeResponseDto(String status, EmployeeResponseData data) {
        this.status = status;
        this.data = data;
    }

    public EmployeeResponseDto() {

    }


// Constructors, getters, setters

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmployeeResponseData getData() {
        return data;
    }

    public void setData(EmployeeResponseData data) {
        this.data = data;
    }
}
