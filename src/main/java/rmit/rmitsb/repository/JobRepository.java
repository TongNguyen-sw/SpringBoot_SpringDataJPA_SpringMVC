package rmit.rmitsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rmit.rmitsb.model.Job;
import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT j FROM Job j where j.jobId = ?1")
    Optional<Job> findJobById(Long jobId);

    @Query("SELECT j FROM Job j where j.jobName = ?1")
    Optional<Job> findJobByName(String jobName);

//    List<Product> findAllByCategory(Category category);

    @Query("SELECT j FROM Job j where j.jobName LIKE %?1%")
    List<Job> searchJobsByName(String jobName);

}