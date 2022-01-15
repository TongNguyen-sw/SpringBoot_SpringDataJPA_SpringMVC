package rmit.rmitsb.model;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee", uniqueConstraints = {@UniqueConstraint(columnNames = {"employeeId"})})

public class Employee {
        @SequenceGenerator(
            name = "employee_sequence_generator",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column
    private String employeeName;
    @Column
    private String employeePass;
    @Column
    private String employeePhone;
    @Column
    private String location;
    @Column
    private String experience;
    @Column
    private String employeeSpecialization;

    public Employee(Long employeeId, String employeeName, String employeePass, String employeePhone, String location, String experience, String employeeSpecialization) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeePass = employeePass;
        this.employeePhone = employeePhone;
        this.location = location;
        this.experience = experience;
        this.employeeSpecialization = employeeSpecialization;
    }

    public Employee(){

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePass() {
        return employeePass;
    }

    public void setEmployeePass(String employeePass) {
        this.employeePass = employeePass;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEmployeeSpecialization() {
        return employeeSpecialization;
    }

    public void setEmployeeSpecialization(String employeeSpecialization) {
        this.employeeSpecialization = employeeSpecialization;
    }
}
