package com.project.quickhandy.WorkerPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/quick_handy/worker_post")
public class WorkerPostController {
    @Autowired
    private WorkerPostService us;


    @PostMapping("/add")
    public String add(@RequestBody WorkerPost ui){
        us.saveWorkerPost(ui);
        return "QuickHandy: New user info is added";
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<WorkerPost>> userlist() {
        List<WorkerPost> userList = us.getAllWorkerPost();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<WorkerPost> getuser(@PathVariable Integer id){
        try {
            WorkerPost usif=us.getWorkerPostbyid(id);
            return new ResponseEntity<WorkerPost>(usif,HttpStatus.OK);
        } catch (NoSuchElementException e) {
            // TODO: handle exception
            return new ResponseEntity<WorkerPost>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkerPost> updateuser(@RequestBody WorkerPost usif,@PathVariable Integer id){
        try {
            WorkerPost existingStudent=us.getWorkerPostbyid(id);
            us.saveWorkerPost(usif);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            // TODO: handle exception
            return new ResponseEntity<WorkerPost>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteuser(@PathVariable Integer id) {
        us.deleteWorkerPost(id);
        return "QuickHandy: Deleted user with id "+id;
    }




}
