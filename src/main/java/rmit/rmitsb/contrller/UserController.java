package rmit.rmitsb.contrller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import rmit.rmitsb.model.User;
import rmit.rmitsb.service.UserService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    // get all products
    @GetMapping(path = "list-users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("pagination/page={offset}&size={pageSize}")
    public Page<User> getUserWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<User> allUsers = userService.getUserWithPagination(offset, pageSize);
        return allUsers;
    }

    @GetMapping(path = "ASC/field={field}")
    public List<User> getAllUsersWithSortASC(@PathVariable String field){
        List<User> allSort = userService.getUserFilteringASC(field);
        return allSort;
    }

    @GetMapping(path = "DESC/field={field}")
    public List<User> getAllUsersWithSortDESC(@PathVariable String field){
        List<User> allSort = userService.getUserFilteringDESC(field);
        return allSort;
    }

    @GetMapping("search/{name}")
    public List<User> getUserFromName(@PathVariable String name){
        List<User> userName = userService.findUsersByName(name);
        return userName;
    }

    // add a product
    @PostMapping(path = "add-user")
    public void addNewUser(@RequestBody User user){
        userService.addUser(user);
    }


//    @GetMapping(path = "login-user/name={name}/pass={pass}")
//    public Boolean loginUser(@PathVariable String name, @PathVariable String pass){
//        return userService.loginUser(name, pass);
//    }

    // delect a product
    @DeleteMapping(path = "delete-user/{id}")
    public void deleteAUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

    // update a product
    @PutMapping(path = "update-user/{id}")
    public void updateAUser(@PathVariable("id") Long id, @RequestBody User user){
        userService.updateUser(id, user);
    }

    // get a product by id
    @GetMapping(path = "list-users/{id}")
    public Optional<User> findUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
}

