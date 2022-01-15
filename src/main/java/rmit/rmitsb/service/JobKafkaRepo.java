package rmit.rmitsb.service;


import rmit.rmitsb.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface JobKafkaRepo {

    // Save a new employee.
    void save(Job job);

    // Find employee by id.
    Job findById(String id);

    // Final all employees.
    Map<String, Job> findAll();

    // Delete a employee.
    void delete(String id);
}

