package rmit.rmitsb.contrller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rmit.rmitsb.model.Category;
import rmit.rmitsb.model.Employee;
import rmit.rmitsb.service.CategoryService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }
    // get all categories
    @GetMapping(path = "list-categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    // add a category
    @PostMapping(path = "add-category")
    public void addNewCategory(@RequestBody Category category){
        categoryService.addCategory(category);
    }

    // delete a category
    @DeleteMapping(path = "delete-category/{id}")
    public void deleteACategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }

    // update a category
    @PutMapping(path = "update-category/{id}")
    public void updateACategory(@PathVariable("id") Long id, @RequestBody Category category){
        categoryService.updateCategory(id, category);
    }

    // get a category
    @GetMapping(path = "list-categories/{id}")
    public Optional<Category> findCategoryById(@PathVariable("id") Long id){
        return categoryService.getCategoryById(id);
    }

}
