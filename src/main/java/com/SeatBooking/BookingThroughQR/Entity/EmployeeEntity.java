    package com.SeatBooking.BookingThroughQR.Entity;


    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;

    @Entity
    @Table(name = "Employee")
    @Getter
    @Setter
    public class EmployeeEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long empid;
        private String employeeName;

        @OneToOne(mappedBy = "bookedBy")
        private SeatBookingEntity seatBooking;
    }
