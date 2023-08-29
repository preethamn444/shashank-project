package com.SeatBooking.BookingThroughQR.Service;

import com.SeatBooking.BookingThroughQR.Entity.SeatBookingEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatGenerationService {

    public List<SeatBookingEntity> generateSeats(int cubicalNumber) {
        // Create a list to store generated seats
        List<SeatBookingEntity> generatedSeats = new ArrayList<>();

        // Generate seats based on the cubical number
        for (int i = 1; i <= cubicalNumber; i++) {
            SeatBookingEntity seat = new SeatBookingEntity();
            seat.setCubicalNo(i);
            seat.setStatus("Available"); // Set initial status
            generatedSeats.add(seat);
        }

        return generatedSeats;
    }
}

