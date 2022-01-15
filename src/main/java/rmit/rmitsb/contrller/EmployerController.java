package rmit.rmitsb.contrller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import rmit.rmitsb.model.Employer;
import rmit.rmitsb.model.Job;
import rmit.rmitsb.service.EmployerService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/employers")
public class EmployerController {
    @Autowired
    private EmployerService employerService;


    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }
    // get all products
    @GetMapping(path = "list-employers")
    public List<Employer> getAllEmployer(){
        return employerService.getAllEmployer();
    }

    @GetMapping("pagination/page={offset}&size={pageSize}")
    public Page<Employer> getEmployerWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<Employer> allEmployers = employerService.getEmployerWithPagination(offset, pageSize);
        return allEmployers;
    }

    @GetMapping(path = "ASC/field={field}")
    public List<Employer> getAllEmployeesWithSortASC(@PathVariable String field){
        List<Employer> resultSortASC = employerService.getEmployerFilteringASC(field);
        return resultSortASC;
    }

    @GetMapping(path = "DESC/field={field}")
    public List<Employer> getAllEmployeesWithSortDESC(@PathVariable String field){
        List<Employer> resultSortDESC = employerService.getEmployerFilteringDESC(field);
        return resultSortDESC;
    }


    @GetMapping("search/{name}")
    public List<Employer> getJobFromName(@PathVariable String name){
        List<Employer> employerName = employerService.findEmployersByName(name);
        return employerName;
    }




    // add a product
    @PostMapping(path = "add-employer")
    public void addNewEmployer(@RequestBody Employer employer){
        employerService.addEmployer(employer);
    }

    // delect a product
    @DeleteMapping(path = "delete-employer/{id}")
    public void deleteAEmployer(@PathVariable("id") Long id){
        employerService.deleteEmployer(id);
    }

    // update a product
    @PutMapping(path = "update-employer/{id}")
    public void updateAEmployer(@PathVariable("id") Long id, @RequestBody Employer employer){
        employerService.updateEmployer(id, employer);
    }
    // get a product by id
    @GetMapping(path = "list-employers/{id}")
    public Optional<Employer> findEmployerById(@PathVariable("id") Long id){
        return employerService.getEmployerById(id);
    }
}

