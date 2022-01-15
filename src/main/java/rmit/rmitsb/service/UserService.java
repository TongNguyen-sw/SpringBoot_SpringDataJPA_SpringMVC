package rmit.rmitsb.service;

// filter pagin
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmit.rmitsb.model.User;

import rmit.rmitsb.repository.EmployeeRepository;
import rmit.rmitsb.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    UserRepository userRepository;

//    @Autowired
//    CategoryRepository categoryRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public List<User> findUsersByName(String name){
        return userRepository.searchUsersByName(name.toLowerCase());
    }

    public Page<User> getUserWithPagination(int offset, int pageSize){
        Page<User> users = userRepository.findAll(PageRequest.of(offset,pageSize));
        return users;
    }

    public List<User> getUserFilteringASC(String field){
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public List<User> getUserFilteringDESC(String field){
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, field));
    }


    public void addUser(User user){
        Optional<User> userOptional = userRepository.findUserByName(user.getAdminName());
        if (userOptional.isPresent()){
            throw new IllegalStateException("User taken");
        }
        user.setAdminName(user.getAdminName().toLowerCase());
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


    @Transactional
    public void updateUser(Long id, User user){
        User user_edit = userRepository.findById(id).orElseThrow(()-> new IllegalStateException(""));

        if(user.getAdminName() != null && user.getAdminName().length()>0){
            user_edit.setAdminName(user.getAdminName());
        }
//        if (product.getPrice() != null && product.getPrice().length()>0){
//            product_edit.setPrice(product.getPrice());
//        }
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
//        if (product.getCategory() != null && product.getCategory().length()>0) {
//            product_edit.setCategory(product.getCategory());
//        }
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findUserById(id);
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


//    public Boolean loginEmployee(String name, String pass){
//        if(userRepository.findNameWithPassword(name, pass).isPresent()){
//            return true;
//        } else{
//            return false;
//        }
//    }


}
