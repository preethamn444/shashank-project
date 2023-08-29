package com.SeatBooking.BookingThroughQR.Repo;

import com.SeatBooking.BookingThroughQR.Entity.EmployeeEntity;
import com.SeatBooking.BookingThroughQR.Entity.SeatBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeatRepo extends JpaRepository<SeatBookingEntity,Long> {

    public SeatBookingEntity findByBookedBy(EmployeeEntity employee);
    public SeatBookingEntity findBySeatid(Long id);




}
