package com.SeatBooking.BookingThroughQR.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Seat")
@Getter
@Setter
public class SeatBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seatid;

    private int buildingNo;

    private int blockno;

    private int cubicalNo;

    private String status;

    @Override
    public String toString() {
        return "SeatBookingEntity{" +
                "seatid=" + seatid +
                ", buildingNo=" + buildingNo +
                ", blockno=" + blockno +
                ", cubicalNo=" + cubicalNo +
                ", status='" + status + '\'' +
                ", bookedBy=" + bookedBy +
                '}';
    }

    @OneToOne
    @JoinColumn(name = "seatBooking")
    private EmployeeEntity bookedBy;

}
