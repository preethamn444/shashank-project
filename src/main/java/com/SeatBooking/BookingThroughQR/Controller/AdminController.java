package com.SeatBooking.BookingThroughQR.Controller;


import com.SeatBooking.BookingThroughQR.Entity.SeatBookingEntity;
import com.SeatBooking.BookingThroughQR.Service.SeatGenerationService;
import com.SeatBooking.BookingThroughQR.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SeatService seatService;


    @Autowired
    private SeatGenerationService seatGenerationService;
//    @PostMapping("/createseat")
//    public ResponseEntity<String> createSeat(@RequestBody SeatBookingEntity seatBooking){
//
//        //seatService.registerSeat(seatBooking);
//        return new ResponseEntity<>("Seat Registered Sucessfully", HttpStatus.CREATED);
//
//    }


    @PostMapping("/generate")
    public ResponseEntity<List<SeatBookingEntity>> generateSeats(@RequestParam int cubicalNumber) {
        List<SeatBookingEntity> generatedSeats = seatGenerationService.generateSeats(cubicalNumber);
        return new ResponseEntity<>(generatedSeats, HttpStatus.OK);
    }
}
