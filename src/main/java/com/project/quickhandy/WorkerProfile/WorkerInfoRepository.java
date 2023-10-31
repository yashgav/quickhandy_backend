package com.project.quickhandy.WorkerProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerInfoRepository extends JpaRepository<WorkerProfile, Integer> {
	WorkerProfile findByEmailOrPhoneAndPassword(String email, String phone, String password);
}
