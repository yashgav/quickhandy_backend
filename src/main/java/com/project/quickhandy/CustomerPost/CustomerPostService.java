package com.project.quickhandy.CustomerPost;

import com.project.quickhandy.CustomerPost.CustomerPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerPostService {
    @Autowired
    private CustomerPostRespository repo;


    public CustomerPost saveCustomerPost(CustomerPost ui) {
        return repo.save(ui);
    }

    public List<CustomerPost> getAllCustomerPost() {
        List<CustomerPost> userList = repo.findAll();
        return userList;
    }

    public CustomerPost getCustomerPostbyid (Integer id) {
        return repo.findById(id).get();
    }

    public void deleteCustomerPost(Integer id) {
        repo.deleteById(id);
    }
}
