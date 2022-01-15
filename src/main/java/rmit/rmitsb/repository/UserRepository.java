package rmit.rmitsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rmit.rmitsb.model.Employee;
import rmit.rmitsb.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.adminId = ?1")
    Optional<User> findUserById(Long adminId);

    @Query("SELECT u FROM User u where u.adminName = ?1")
    Optional<User> findUserByName(String adminName);

//    List<Product> findAllByCategory(Category category);

//    @Query("SELECT u FROM User u where u.employeePhone =?1 and em.employeePass =?2")
//    Optional<Employee> findNameWithPassword(String Phone, String pass);

    @Query("SELECT u FROM User u where u.adminName LIKE %?1%")
    List<User> searchUsersByName(String adminName);



}
