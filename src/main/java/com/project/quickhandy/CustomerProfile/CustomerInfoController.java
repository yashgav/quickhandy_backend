package com.project.quickhandy.CustomerProfile;

import java.util.List;
import java.util.NoSuchElementException;

import com.project.quickhandy.WorkerProfile.WorkerCredentails;
import com.project.quickhandy.WorkerProfile.WorkerProfile;
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
@CrossOrigin(origins = {"http://localhost:3000", "https://yashgav.github.io/"})
@RequestMapping("/quick_handy/customer_info")
public class CustomerInfoController {
	@Autowired
    private CustomerInfoService us;
	
	
    @PostMapping("/add")
    public String add(@RequestBody CustomerProfile ui){
        us.saveCustomerInfo(ui);
        return "QuickHandy: New user info is added";
    }
    
    
    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerProfile>> userlist() {
        List<CustomerProfile> userList = us.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<CustomerProfile> getuser(@PathVariable Integer id){
    	try {
			CustomerProfile usif=us.getuserbyid(id);
			return new ResponseEntity<CustomerProfile>(usif,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<CustomerProfile>(HttpStatus.NOT_FOUND);
		}
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CustomerProfile> updateuser(@RequestBody CustomerProfile usif,@PathVariable Integer id){
    	try {
			CustomerProfile existingStudent=us.getuserbyid(id);
			us.saveCustomerInfo(usif);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<CustomerProfile>(HttpStatus.NOT_FOUND);
		}
    }
    
    @DeleteMapping("/{id}")
    public String deleteuser(@PathVariable Integer id) {
    	us.deleteuser(id);
    	return "QuickHandy: Deleted user with id "+id;
    }



    @PostMapping("/checklogin")
    public int login(@RequestBody CustomerCredentials credentials) {
        String email = credentials.getEmailorphone();
        String password = credentials.getPassword();
        try {
            CustomerProfile user = us.authenticate(email, password);
            System.out.println(user.getCp_id());
            if (user != null) {
                // User found, return the user information
                System.out.println("found");
                return user.getCp_id();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("notfound");
        return -1;
    }
}
