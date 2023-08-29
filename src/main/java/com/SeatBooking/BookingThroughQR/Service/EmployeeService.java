package com.SeatBooking.BookingThroughQR.Service;

import com.SeatBooking.BookingThroughQR.Entity.EmployeeEntity;
import com.SeatBooking.BookingThroughQR.Entity.SeatBookingEntity;
import com.SeatBooking.BookingThroughQR.Repo.EmployeeRepo;
import com.SeatBooking.BookingThroughQR.Repo.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private SeatRepo seatRepo;

    public EmployeeEntity createUser(EmployeeEntity employee){
        EmployeeEntity employeeEntity=employeeRepo.save(employee);
        List<SeatBookingEntity> all = seatRepo.findAll();
        for(SeatBookingEntity seat: all){
            if(seat.getStatus()==null){
                employeeEntity.setSeatBooking(seat);
                seat.setStatus("RESERVED");
               seat.setBookedBy(employeeEntity);
                seatRepo.save(seat);

                break;
            }
        }

        return employeeEntity;
    }

//    public EmployeeEntity login(EmployeeEntity employee){
//       // EmployeeEntity employeeEntity=employeeRepo.findByEmpid(employee.getEmpid());
//        return employeeRepo.findByEmpid(employee.getEmpid());
//    }
}
