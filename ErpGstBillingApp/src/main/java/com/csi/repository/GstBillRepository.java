package com.csi.repository;

import com.csi.enitity.GstBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GstBillRepository extends JpaRepository<GstBill,Long> {
  GstBill findByCustEmailId(String custEmailId);
}
