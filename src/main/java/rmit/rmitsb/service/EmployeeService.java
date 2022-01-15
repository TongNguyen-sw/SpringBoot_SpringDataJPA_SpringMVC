package rmit.rmitsb.service;

// filter pagin
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmit.rmitsb.model.Employee;
import rmit.rmitsb.model.Job;
import rmit.rmitsb.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

//    @Autowired
//    CategoryRepository categoryRepository;

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public List<Employee> findEmployeesByName(String name){
        return employeeRepository.searchEmployeesByName(name.toLowerCase());
    }

    public Page<Employee> getEmployeeWithPagination(int offset, int pageSize){
        Page<Employee> employees = employeeRepository.findAll(PageRequest.of(offset,pageSize));
        return employees;
    }

    public List<Employee> getEmployeeFilteringASC(String field){
            return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
        }

    public List<Employee> getEmployeeFilteringDESC(String field){
        return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    
    public void addEmployee(Employee employee){
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByName(employee.getEmployeeName());
        if (employeeOptional.isPresent()){
            throw new IllegalStateException("Employee taken");
        }
        employee.setEmployeeName(employee.getEmployeeName().toLowerCase());
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }


    @Transactional
    public void updateEmployee(Long id, Employee employee){
        Employee employee_edit = employeeRepository.findById(id).orElseThrow(()-> new IllegalStateException(""));

        if(employee.getEmployeeName() != null && employee.getEmployeeName().length()>0){
            employee_edit.setEmployeeName(employee.getEmployeeName());
        }
        if (employee.getEmployeePass() != null && employee.getEmployeePass().length()>0){
            employee_edit.setEmployeePass(employee.getEmployeePass());
        }
        if (employee.getEmployeePhone() != null && employee.getEmployeePhone().length()>0) {
            employee_edit.setEmployeePhone(employee.getEmployeePhone());
        }

        if (employee.getLocation() != null && employee.getLocation().length()>0) {
            employee_edit.setLocation(employee.getLocation());
        }

        if (employee.getExperience() != null && employee.getExperience().length()>0) {
            employee_edit.setExperience(employee.getExperience());
        }

        if (employee.getEmployeeSpecialization() != null && employee.getEmployeeSpecialization().length()>0) {
            employee_edit.setEmployeeSpecialization(employee.getEmployeeSpecialization());
        }
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

//    public List<Product> getProductByCategory(String cateType){
//        Category category = new Category();
//        try {
//            category = this.categoryRepository.findCateByType(cateType)
//                    .orElseThrow(() -> new Exception("Category not found" + cateType));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return this.productRepository.findAllByCategory(category);
//    }


    public Boolean loginEmployee(String name, String pass){
        if(employeeRepository.findNameWithPassword(name, pass).isPresent()){
            return true;
        } else{
            return false;
        }
    }


}
