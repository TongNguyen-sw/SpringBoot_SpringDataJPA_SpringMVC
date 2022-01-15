package rmit.rmitsb.contrller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import rmit.rmitsb.model.Employee;
import rmit.rmitsb.model.Job;
import rmit.rmitsb.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    // get all products
    @GetMapping(path = "list-employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("pagination/page={offset}&size={pageSize}")
    public Page<Employee> getEmployeeWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<Employee> allEmployees = employeeService.getEmployeeWithPagination(offset, pageSize);
        return allEmployees;
    }

    @GetMapping(path = "ASC/field={field}")
    public List<Employee> getAllEmployeesWithSortASC(@PathVariable String field){
        List<Employee> allSort = employeeService.getEmployeeFilteringASC(field);
        return allSort;
    }

    @GetMapping(path = "DESC/field={field}")
    public List<Employee> getAllEmployeesWithSortDESC(@PathVariable String field){
        List<Employee> allSort = employeeService.getEmployeeFilteringDESC(field);
        return allSort;
    }

    @GetMapping("search/{name}")
    public List<Employee> getEmployeeFromName(@PathVariable String name){
        List<Employee> employeeName = employeeService.findEmployeesByName(name);
        return employeeName;
    }

    // add a product
    @PostMapping(path = "add-employee")
    public void addNewEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }


    @GetMapping(path = "login-employee/name={name}/pass={pass}")
    public Boolean loginEmployee(@PathVariable String name, @PathVariable String pass){
        return employeeService.loginEmployee(name, pass);
    }

    // delect a product
    @DeleteMapping(path = "delete-employee/{id}")
    public void deleteAEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }

    // update a product
    @PutMapping(path = "update-employee/{id}")
    public void updateAEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        employeeService.updateEmployee(id, employee);
    }
    // get a product by id
    @GetMapping(path = "list-employees/{id}")
    public Optional<Employee> findEmployeeById(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }
}

