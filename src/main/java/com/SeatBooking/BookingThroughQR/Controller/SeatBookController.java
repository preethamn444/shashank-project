package com.SeatBooking.BookingThroughQR.Controller;


import com.SeatBooking.BookingThroughQR.Entity.EmployeeEntity;
import com.SeatBooking.BookingThroughQR.Entity.SeatBookingEntity;
import com.SeatBooking.BookingThroughQR.Exception.UserNotFound;
import com.SeatBooking.BookingThroughQR.Service.SeatService;
import com.SeatBooking.BookingThroughQR.dto.SeatBookingResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seat")
public class SeatBookController {

    @Autowired
    private SeatService seatService;
    @PostMapping("/book/{employeeId}")
    public ResponseEntity<SeatBookingResponseDto> bookSeat(@PathVariable  Long employeeId, @RequestBody SeatBookingEntity seatId) throws UserNotFound {
        SeatBookingResponseDto saveseat = seatService.saveseat(employeeId, seatId);
       return new ResponseEntity<>(saveseat,HttpStatus.OK);


    }




}
