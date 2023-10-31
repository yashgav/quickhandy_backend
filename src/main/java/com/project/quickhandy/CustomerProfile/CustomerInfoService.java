package com.project.quickhandy.CustomerProfile;

import java.util.List;

import com.project.quickhandy.WorkerProfile.WorkerProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerInfoService {
	@Autowired
	private CustomerInfoRepository repo;
	
	
	public CustomerProfile saveCustomerInfo(CustomerProfile ui) {
		return repo.save(ui);
	}
	
	public List<CustomerProfile> getAllUsers() {
	    List<CustomerProfile> userList = repo.findAll();
	    return userList;
	}
	
	public CustomerProfile getuserbyid (Integer id) {
		return repo.findById(id).get();
	}
	
    public void deleteuser(Integer id) {
    	repo.deleteById(id);
    }

	public CustomerProfile authenticate(String emailOrPhone, String password) {
		return repo.findByEmailOrPhoneAndPassword(emailOrPhone, emailOrPhone, password);
	}
}
