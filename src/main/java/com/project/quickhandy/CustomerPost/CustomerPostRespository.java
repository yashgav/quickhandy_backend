package com.project.quickhandy.CustomerPost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPostRespository extends JpaRepository<CustomerPost, Integer> {
}
