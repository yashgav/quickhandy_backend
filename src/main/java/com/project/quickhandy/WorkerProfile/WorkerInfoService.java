package com.project.quickhandy.WorkerProfile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WorkerInfoService {
	@Autowired
	private WorkerInfoRepository repo;
	
	
	public WorkerProfile saveWorkerInfo(WorkerProfile ui) {
		return repo.save(ui);
	}
	
	public List<WorkerProfile> getAllUsers() {
	    List<WorkerProfile> userList = repo.findAll();
	    return userList;
	}
	
	public WorkerProfile getuserbyid (Integer id) {
		return repo.findById(id).get();
	}
	
    public void deleteuser(Integer id) {
    	repo.deleteById(id);
    }
    
    public WorkerProfile authenticate(String emailOrPhone, String password) {
        return repo.findByEmailOrPhoneAndPassword(emailOrPhone, emailOrPhone, password);
    }
}
