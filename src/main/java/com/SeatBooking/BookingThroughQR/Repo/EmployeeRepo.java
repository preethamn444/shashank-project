package com.SeatBooking.BookingThroughQR.Repo;

import com.SeatBooking.BookingThroughQR.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Long> {

    public EmployeeEntity findByEmpid(Long id);



}
