package rmit.rmitsb.model;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employer", uniqueConstraints = {@UniqueConstraint(columnNames = {"employerId"})})

public class Employer {
    @SequenceGenerator(
            name = "employer_sequence_generator",
            sequenceName = "employer_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employerId;
    @Column
    private String employerName;
    @Column
    private String employerPass;
    @Column
    private String employerPhone;
    @Column
    private String location;

    public Employer(Long employerId, String employerName, String employerPass, String employerPhone, String location) {
        this.employerId = employerId;
        this.employerName = employerName;
        this.employerPass = employerPass;
        this.employerPhone = employerPhone;
        this.location = location;
    }

    public Employer(){

    }

    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerPass() {
        return employerPass;
    }

    public void setEmployerPass(String employerPass) {
        this.employerPass = employerPass;
    }

    public String getEmployerPhone() {
        return employerPhone;
    }

    public void setEmployerPhone(String employerPhone) {
        this.employerPhone = employerPhone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
