package rmit.rmitsb.service;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmit.rmitsb.model.Employer;
import rmit.rmitsb.model.Job;
import rmit.rmitsb.repository.EmployerRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployerService {
    @Autowired
    EmployerRepository employerRepository;

//    @Autowired
//    CategoryRepository categoryRepository;

    public List<Employer> getAllEmployer(){
        return employerRepository.findAll();
    }

    public List<Employer> findEmployersByName(String name){
        return employerRepository.searchEmployersByName(name.toLowerCase());
    }

    public Page<Employer> getEmployerWithPagination(int offset, int pageSize){
        Page<Employer> Employers = employerRepository.findAll(PageRequest.of(offset,pageSize));
        return Employers;
    }

    public List<Employer> getEmployerFilteringASC(String field){
        return employerRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public List<Employer> getEmployerFilteringDESC(String field){
        return employerRepository.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    public void addEmployer(Employer employer){
        Optional<Employer> employerOptional = employerRepository.findEmployerByName(employer.getEmployerName());
        if (employerOptional.isPresent()){
            throw new IllegalStateException("employer taken");
        }
        employer.setEmployerName(employer.getEmployerName().toLowerCase());
        employerRepository.save(employer);
    }

    public void deleteEmployer(Long id){
        employerRepository.deleteById(id);
    }


    @Transactional
    public void updateEmployer(Long id, Employer employer){
        Employer employer_edit = employerRepository.findById(id).orElseThrow(()-> new IllegalStateException(""));

        if(employer.getEmployerName() != null && employer.getEmployerName().length()>0){
            employer_edit.setEmployerName(employer.getEmployerName());
        }
        if (employer.getEmployerPass() != null && employer.getEmployerPass().length()>0){
            employer_edit.setEmployerPass(employer.getEmployerPass());
        }
        if (employer.getEmployerPhone() != null && employer.getEmployerPhone().length()>0) {
            employer_edit.setEmployerPhone(employer.getEmployerPhone());
        }

        if (employer.getLocation() != null && employer.getLocation().length()>0) {
            employer_edit.setLocation(employer.getLocation());
        }
//
//        if (product.getQuantity() != null && product.getQuantity().length()>0) {
//            product_edit.setQuantity(product.getQuantity());
//        }
//
//        if (product.getCategory() != null && product.getCategory().length()>0) {
//            product_edit.setCategory(product.getCategory());
//        }
    }

    public Optional<Employer> getEmployerById(Long id) {
        return employerRepository.findEmployerById(id);
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
