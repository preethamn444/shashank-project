package com.SeatBooking.BookingThroughQR.Service;


import com.SeatBooking.BookingThroughQR.Entity.EmployeeEntity;
import com.SeatBooking.BookingThroughQR.Entity.SeatBookingEntity;
import com.SeatBooking.BookingThroughQR.Exception.UserNotFound;
import com.SeatBooking.BookingThroughQR.Repo.EmployeeRepo;
import com.SeatBooking.BookingThroughQR.Repo.SeatRepo;
import com.SeatBooking.BookingThroughQR.dto.SeatBookingResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SeatService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private SeatRepo seatRepo;

//    public SeatBookingResponseDto saveseat(Long empid, Long seatId) throws UserNotFound {
//        EmployeeEntity employee = employeeRepo.findByEmpid(empid);
//        SeatBookingEntity seatBooking = seatRepo.findByBookedBy(employee);
//        if (employee == null) {
//            throw new UserNotFound("Invalid Employee Id");
//        }
//        if ( seatBooking.getStatus() != null && seatBooking.getStatus().equalsIgnoreCase("RESERVED")) {
//            throw new UserNotFound("Based on SaetId Seat Not Available");
//
//        }
//         employee.setSeatBooking(seatBooking);
//        employeeRepo.save(employee);
//        seatBooking.setStatus("RESERVED");
//        seatRepo.save(seatBooking);
//        SeatBookingResponseDto responseDto = new SeatBookingResponseDto();
//        responseDto.setSeatId(seatBooking.getSeatid());
//        responseDto.setMessage("Seat Successfully Allocated");
//        return responseDto;
//
//
//    }

//
//    public SeatBookingResponseDto saveseat(Long empid, Long seatId) throws UserNotFound {
//        EmployeeEntity employee = employeeRepo.findByEmpid(empid);
//        if (employee == null) {
//            throw new UserNotFound("Invalid Employee Id");
//        }
//
//        SeatBookingEntity seatBooking = seatRepo.findByBookedBy(employee);
//        if (seatBooking != null && seatBooking.getStatus() != null && seatBooking.getStatus().equalsIgnoreCase( "RESERVED")) {
//            throw new UserNotFound("Seat Not Available");
//        }
//
//        if (seatBooking == null) {
//            seatBooking = new SeatBookingEntity();
//            seatBooking.setBookedBy(employee);
//        }
//
//        // Update the seat status and save it
//        seatBooking.setStatus("RESERVED");
//        seatRepo.save(seatBooking);
//
//        // Update the employee's seat booking and save them
//        employee.setSeatBooking(seatBooking);
//        employeeRepo.save(employee);
//
//        SeatBookingResponseDto responseDto = new SeatBookingResponseDto();
//        responseDto.setSeatId(seatBooking.getSeatid());
//        responseDto.setMessage("Seat Successfully Allocated");
//        return responseDto;
//    }


    public SeatBookingResponseDto saveseat(Long empid, SeatBookingEntity seatId) throws UserNotFound {
        EmployeeEntity employee = employeeRepo.findByEmpid(empid);

        if (employee == null) {
            throw new UserNotFound("Invalid Employee Id");
        }

        SeatBookingEntity seatBooking = seatRepo.findByBookedBy(employee);
        if (seatBooking == null) {
            seatBooking = new SeatBookingEntity();
            seatBooking.setBookedBy(employee);
            seatBooking.setStatus("RESERVED");
            seatRepo.save(seatBooking);
            employee.setSeatBooking(seatBooking);
            employeeRepo.save(employee);

            SeatBookingResponseDto responseDto = new SeatBookingResponseDto();
            responseDto.setSeatId(seatBooking.getSeatid());
            responseDto.setMessage("Seat Successfully Allocated");
            return responseDto;// Write About the Seat block no Cubicaal No
        }
            if(seatBooking.getBookedBy()!=null)
            {
                throw new UserNotFound("Seat already allocated for Employee ID for seat Number:  " + seatBooking.getSeatid());

            }
        if (seatBooking!= null ) {
            SeatBookingEntity seatBooking1=new SeatBookingEntity();
            seatBooking1.setBookedBy(employee);
            seatBooking1.setCubicalNo(seatId.getCubicalNo());
            seatBooking1.setBlockno(seatId.getBlockno());
            seatBooking1.setBuildingNo(seatId.getBuildingNo());
            seatBooking1.setStatus("RESERVED");

            seatRepo.save(seatBooking1);
            throw new UserNotFound("Seat already allocated for Employee ID: You Got New Seat " + seatBooking.getBookedBy().getEmpid());
        }



        // Update the seat status and save it


        // Update the employee's seat booking and save them

        return null;
    }




//    public boolean registerSeat(SeatBookingEntity seatBooking){
//        seatBooking.setStatus("NOT RESERVED");
//
//        seatBooking.setBookedBy(null);
////        List<SeatBookingEntity> lis=new ArrayList<>()  ;
//
//        System.out.println(seatBooking.getCubicalNo());
//        int K=seatBooking.getCubicalNo();
//        seatBooking.setCubicalNo(1);
//        SeatBookingEntity seatBooking1=seatBooking;
//        for(int i=0;i<K;i++){
//
//          //  System.out.println(seatBooking.getCubicalNo());
//
//
//            System.out.println(seatBooking);
//            seatRepo.save(seatBooking);
//            seatBooking1.setCubicalNo(seatBooking.getCubicalNo()+1);
//           seatBooking1.setBookedBy(seatBooking.getCubicalNo());
//            seatBooking=null;
//            seatBooking=seatBooking1;
//
//
//
//
////        seatBooking.setCubicalNo(seatBooking.getCubicalNo()+1);
////        seatBooking.setSeatid(seatBooking.getSeatid()+1);
//      }
////        System.out.println(lis.size());
//
//        return true;
//    }
//}

}