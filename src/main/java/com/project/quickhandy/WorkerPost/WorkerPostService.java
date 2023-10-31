package com.project.quickhandy.WorkerPost;

import com.project.quickhandy.WorkerPost.WorkerPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerPostService {
    @Autowired
    private WorkerPostRepository repo;


    public WorkerPost saveWorkerPost(WorkerPost ui) {
        return repo.save(ui);
    }

    public List<WorkerPost> getAllWorkerPost() {
        List<WorkerPost> userList = repo.findAll();
        return userList;
    }

    public WorkerPost getWorkerPostbyid (Integer id) {
        return repo.findById(id).get();
    }

    public void deleteWorkerPost(Integer id) {
        repo.deleteById(id);
    }

}
