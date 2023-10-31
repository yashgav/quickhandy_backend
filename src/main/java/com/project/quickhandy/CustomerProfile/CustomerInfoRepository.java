package com.project.quickhandy.CustomerProfile;

import com.project.quickhandy.WorkerProfile.WorkerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerProfile, Integer> {
    CustomerProfile findByEmailOrPhoneAndPassword(String email, String phone, String password);
}
