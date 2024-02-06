package com.CourierManagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CourierManagement.api.entity.Parcel;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long> {

	List<Parcel> findByCourierStaff_StaffName(String staffName);
}

