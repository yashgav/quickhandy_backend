package com.project.quickhandy.WorkerProfile;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://yashgav.github.io/QuickHandy"})
@RequestMapping("/quick_handy/worker_info")
public class WorkerInfoController {
	@Autowired
    private WorkerInfoService us;
	
	
    @PostMapping("/add")
    public String add(@RequestBody WorkerProfile ui){
        us.saveWorkerInfo(ui);
        return "QuickHandy: New user info is added";
    }
    
    
    @GetMapping("/getAll")
    public ResponseEntity<List<WorkerProfile>> userlist() {
        List<WorkerProfile> userList = us.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<WorkerProfile> getuser(@PathVariable Integer id){
    	try {
			WorkerProfile usif=us.getuserbyid(id);
			return new ResponseEntity<WorkerProfile>(usif,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<WorkerProfile>(HttpStatus.NOT_FOUND);
		}
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<WorkerProfile> updateuser(@RequestBody WorkerProfile usif,@PathVariable Integer id){
    	try {
			WorkerProfile existingStudent=us.getuserbyid(id);
			us.saveWorkerInfo(usif);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<WorkerProfile>(HttpStatus.NOT_FOUND);
		}
    }
    
    @DeleteMapping("/{id}")
    public String deleteuser(@PathVariable Integer id) {
    	us.deleteuser(id);
    	return "QuickHandy: Deleted user with id "+id;
    }
    
    



    @PostMapping("/checklogin")
	public int login(@RequestBody WorkerCredentails credentials) {
	    String email = credentials.getEmailorphone();
	    String password = credentials.getPassword();
		try {
			WorkerProfile user = us.authenticate(email, password);
		    System.out.println(user.getWp_id());
		    if (user != null) {
		        // User found, return the user information
		    	System.out.println("found");
		    	return user.getWp_id();
		    }

		} catch (Exception e) {
			// TODO: handle exception
		}
	    System.out.println("notfound");
	    return -1;
	}
    
}
