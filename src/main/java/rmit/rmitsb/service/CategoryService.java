package rmit.rmitsb.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmit.rmitsb.model.Category;
import rmit.rmitsb.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public void addCategory(Category category){
        Optional<Category> categoryOptional = categoryRepository.findCateByType(category.getCateType());
        if (categoryOptional.isPresent()){
            throw new IllegalStateException("category taken");
        }
        categoryRepository.save(category);
    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }


    @Transactional
    public void updateCategory(Long id, Category category){
        Category category_edit = categoryRepository.findById(id).orElseThrow(()-> new IllegalStateException(""));
        if(category.getCateType() != null && category.getCateType().length()>0){
            category_edit.setCateType(category.getCateType());}


    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findCateById(id);

    }


}
