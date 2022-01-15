package rmit.rmitsb.service;

// filter pagin

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmit.rmitsb.model.Job;
import rmit.rmitsb.repository.JobRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobService {
    @Autowired
    JobRepository jobRepository;

//    @Autowired
//    CategoryRepository categoryRepository;

    public List<Job> getAllJob(){
        return jobRepository.findAll();
    }

    public List<Job> findJobsByName(String name){
        return jobRepository.searchJobsByName(name.toLowerCase());
    }


    public Page<Job> getJobWithPagination(int offset, int pageSize){
        Page<Job> jobs = jobRepository.findAll(PageRequest.of(offset,pageSize));
        return jobs;
    }

//    public List<Job> getJobFiltering(String field, String sortType){
//        if (sortType == "ASC"){
//            jobRepository.findAll(Sort.by(field).ascending());
//        }
//        else{
//            jobRepository.findAll(Sort.by(field).descending());}
//
//        return jobRepository.findAll();
//    }

    public List<Job> getJobFilteringASC(String field){
        return jobRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public List<Job> getJobFilteringDESC(String field){
        return jobRepository.findAll(Sort.by(Sort.Direction.DESC, field));
    }



    public void addJob(Job job){
        Optional<Job> jobOptional = jobRepository.findJobByName(job.getJobName());
        if (jobOptional.isPresent()){
            throw new IllegalStateException("job taken");
        }
        job.setJobName(job.getJobName().toLowerCase());
//        job.setJobCate(job.getJobCate().toLowerCase());
        jobRepository.save(job);
    }


    public void deleteJob(Long id){
        jobRepository.deleteById(id);
    }


    @Transactional
    public void updateJob(Long id, Job job){
        Job job_edit = jobRepository.findById(id).orElseThrow(()-> new IllegalStateException("job updated"));

        if(job.getJobName() != null && job.getJobName().length()>0){
            job_edit.setJobName(job.getJobName());
        }
        if (job.getSalary() != null && job.getSalary().length()>0){
            job_edit.setSalary(job.getSalary());
        }
//        if (product.getImageUrl() != null && product.getImageUrl().length()>0) {
//            product_edit.setImageUrl(product.getImageUrl());
//        }
//
//        if (product.getManufacturer() != null && product.getManufacturer().length()>0) {
//            product_edit.setManufacturer(product.getManufacturer());
//        }
//
//        if (product.getQuantity() != null && product.getQuantity().length()>0) {
//            product_edit.setQuantity(product.getQuantity());
//        }
//
        if (job.getCategory() != null && job.getCategory().length()>0) {
            job_edit.setCategory(job.getCategory());
        }
    }

    public Optional<Job> getJobById(Long id) {
        return jobRepository.findJobById(id);
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


}
