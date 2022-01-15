package rmit.rmitsb.contrller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import rmit.rmitsb.model.Employee;
import rmit.rmitsb.model.Employer;
import rmit.rmitsb.model.Job;
import rmit.rmitsb.repository.JobRepository;
import rmit.rmitsb.service.JobService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/jobs")
public class JobController {

    private static final Logger LOG = LoggerFactory.getLogger(JobController.class);

    @Autowired
    private JobService jobService;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    // get all jobs
    @GetMapping(path = "list-jobs")
    public List<Job> getAllJob(){
        return jobService.getAllJob();
    }

    @GetMapping("pagination/page={offset}&size={pageSize}")
    public Page<Job> getJobWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<Job> allJobs = jobService.getJobWithPagination(offset, pageSize);
        return allJobs;
    }

    @GetMapping(path = "ASC/field={field}")
    public List<Job> getAllEmployeesWithSortASC(@PathVariable String field){
        List<Job> resultSortASC = jobService.getJobFilteringASC(field);
        return resultSortASC;
    }

    @GetMapping(path = "DESC/field={field}")
    public List<Job> getAllEmployeesWithSortDESC(@PathVariable String field){
        List<Job> resultSortDESC = jobService.getJobFilteringDESC(field);
        return resultSortDESC;
    }


    @GetMapping("search/{name}")
    public List<Job> getJobFromName(@PathVariable String name){
        List<Job> jobName = jobService.findJobsByName(name);
        return jobName;
    }


    // add a product
    @PostMapping(path = "add-job")
    public void addNewJob(@RequestBody Job job) {
        jobService.addJob(job);
    }

    // delect a product
    @DeleteMapping(path = "delete-job/{id}")
    public void deleteAJob(@PathVariable("id") Long id){
        jobService.deleteJob(id);
    }

    // update a product
    @PutMapping(path = "update-job/{id}")
    public void updateAJob(@PathVariable("id") Long id, @RequestBody Job job){
        jobService.updateJob(id, job);
    }
    // get a product by id
    @GetMapping(path = "list-jobs/{id}")
    public Optional<Job> findJobById(@PathVariable("id") Long id){
        return jobService.getJobById(id);
    }

//    @GetMapping(params = { "page", "size" })
//    public List<Foo> findPaginated(@RequestParam("page") int page,
//                                   @RequestParam("size") int size, UriComponentsBuilder uriBuilder,
//                                   HttpServletResponse response) {
//        Page<Foo> resultPage = service.findPaginated(page, size);
//        if (page > resultPage.getTotalPages()) {
//            throw new MyResourceNotFoundException();
//        }
//        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<Foo>(
//                Foo.class, uriBuilder, response, page, resultPage.getTotalPages(), size));
//
//        return resultPage.getContent();
//    }
}

