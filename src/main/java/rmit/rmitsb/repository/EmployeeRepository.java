package rmit.rmitsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rmit.rmitsb.model.Employee;
import rmit.rmitsb.model.Job;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT em FROM Employee em where em.employeeId = ?1")
    Optional<Employee> findEmployeeById(Long employeeId);

    @Query("SELECT em FROM Employee em where em.employeeName = ?1")
    Optional<Employee> findEmployeeByName(String employeeName);

//    List<Product> findAllByCategory(Category category);

    @Query("SELECT em FROM Employee em WHERE em.employeePhone =?1 and em.employeePass =?2")
    Optional<Employee> findNameWithPassword(String Phone, String pass);

    @Query("SELECT em FROM Employee em where em.employeeName LIKE %?1%")
    List<Employee> searchEmployeesByName(String employeeName);



}