package tuccia.sqlinjection.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tuccia.sqlinjection.model.User;
import tuccia.sqlinjection.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserRest {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/injectable")
    public List<User> findByUsernameInjectable(@RequestParam(value = "username",required = false)String username){
        return userService.getBy(username);
    }
    @GetMapping(value = "/notInjectable")
    public List<User> findByUsernameNotInjectable(@RequestParam(value = "username",required = false)String username){
        System.out.println(username);
        return userService.getByUsername(username);
    }

}
