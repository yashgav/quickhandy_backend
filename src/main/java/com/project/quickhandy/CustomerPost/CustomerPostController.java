package com.project.quickhandy.CustomerPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
//@CrossOrigin("http://localhost:3000/")
@CrossOrigin("https://yashgav.github.io/QuickHandy/")
@RequestMapping("/quick_handy/customer_post")
public class CustomerPostController {
    @Autowired
    private CustomerPostService us;


    @PostMapping("/add")
    public String add(@RequestBody CustomerPost ui){
        us.saveCustomerPost(ui);
        return "QuickHandy: New user info is added";
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerPost>> userlist() {
        List<CustomerPost> userList = us.getAllCustomerPost();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerPost> getuser(@PathVariable Integer id){
        try {
            CustomerPost usif=us.getCustomerPostbyid(id);
            return new ResponseEntity<CustomerPost>(usif,HttpStatus.OK);
        } catch (NoSuchElementException e) {
            // TODO: handle exception
            return new ResponseEntity<CustomerPost>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerPost> updateuser(@RequestBody CustomerPost usif,@PathVariable Integer id){
        try {
            CustomerPost existingStudent=us.getCustomerPostbyid(id);
            us.saveCustomerPost(usif);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            // TODO: handle exception
            return new ResponseEntity<CustomerPost>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteuser(@PathVariable Integer id) {
        us.deleteCustomerPost(id);
        return "QuickHandy: Deleted user with id "+id;
    }

}
