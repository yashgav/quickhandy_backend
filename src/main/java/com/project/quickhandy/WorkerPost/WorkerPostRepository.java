package com.project.quickhandy.WorkerPost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerPostRepository  extends JpaRepository<WorkerPost, Integer> {
}
