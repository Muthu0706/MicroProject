package com.CourierManagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CourierManagement.api.entity.CourierStaff;

@Repository
public interface CourierStaffRepository extends JpaRepository<CourierStaff, Long>{

	CourierStaff findByStaffName(String staffName);


}
