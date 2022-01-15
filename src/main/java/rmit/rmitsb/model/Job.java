package rmit.rmitsb.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "job", uniqueConstraints = {@UniqueConstraint(columnNames = {"jobId"})})

public class Job {
    @SequenceGenerator(
            name = "job_sequence_generator",
            sequenceName = "job_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    @Column
    private String jobName;
    @Column
    private String salary;
    @Column
    private String category;



    public Job(Long jobId, String jobName, String salary, String category) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.category = category;
        this.salary = salary;
    }

    public Job(){
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn(nullable = false,name = "cateId")
//    private Category category;

}
