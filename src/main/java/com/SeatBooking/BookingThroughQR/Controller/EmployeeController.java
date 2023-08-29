package com.SeatBooking.BookingThroughQR.Controller;

import com.SeatBooking.BookingThroughQR.Entity.EmployeeEntity;
import com.SeatBooking.BookingThroughQR.Exception.UserNotFound;
import com.SeatBooking.BookingThroughQR.Repo.EmployeeRepo;
import com.SeatBooking.BookingThroughQR.Service.EmployeeService;
import com.SeatBooking.BookingThroughQR.dto.EmployeeResponseData;
import com.SeatBooking.BookingThroughQR.dto.EmployeeResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Employee")
@CrossOrigin("*")
public class EmployeeController {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeService employeeService;



    @PostMapping("/save")
    public ResponseEntity<String> CreateUser(@RequestBody EmployeeEntity employee){
        if(employee.getEmployeeName()==null ){
            return  new ResponseEntity<>("Please Provie the Employee Name it Can Not Be Null", HttpStatus.NOT_ACCEPTABLE);

        }
        EmployeeEntity employeeEntity=employeeService.createUser(employee);

        return  new ResponseEntity<>("Employee Created with Name: "+employeeEntity.getEmployeeName() +" and with Id "+employeeEntity.getEmpid(), HttpStatus.CREATED);

    }

//    @GetMapping
//    public ResponseEntity<EmployeeEntity> login(@RequestBody EmployeeEntity employee) throws UserNotFound {
//       EmployeeEntity employeeEntity= employeeService.login(employee);
//        if(employeeEntity==null ){
//            throw  new UserNotFound("User With The Id:" +employee.getEmpid() +" Not Found");
//        }
//
//        return new ResponseEntity<>(employeeEntity,HttpStatus.FOUND);
//
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<String> getEmployeeById(@PathVariable Long id) throws UserNotFound {
//        EmployeeEntity employeeEntity = employeeRepo.findByEmpid(id);
//
//        if (employeeEntity != null) {
//
//            EmployeeResponseData e
//            return new ResponseEntity<>("EmployeeName: " + employeeEntity.getEmployeeName(), HttpStatus.OK);
//        } else {
//            throw new UserNotFound("User With The Id:" + id + " Not Found");
//        }
//    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id) throws UserNotFound {
        EmployeeResponseDto responseDto = new EmployeeResponseDto();


        EmployeeEntity employeeEntity = employeeRepo.findByEmpid(id);

        if (employeeEntity != null) {
            EmployeeResponseData responseData = new EmployeeResponseData();
            responseData.setId(employeeEntity.getEmpid());
            responseData.setMessage("Found");
            responseData.setData("EmployeeName: " + employeeEntity.getEmployeeName());

            responseDto.setStatus("True");
            responseDto.setData(responseData);

            return new ResponseEntity<>(responseDto, HttpStatus.FOUND);

        } else {
            responseDto.setStatus("False");

            EmployeeResponseData errorResponseData = new EmployeeResponseData();
            errorResponseData.setId(id);
            errorResponseData.setMessage("Employee with ID: " + id + " not found");

            responseDto.setData(errorResponseData);

            return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
        }


    }


}
