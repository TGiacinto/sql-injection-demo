package tuccia.sqlinjection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuccia.sqlinjection.model.User;
import tuccia.sqlinjection.repository.UserDao;
import tuccia.sqlinjection.repository.UserRepository;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;


    public List<User> getBy(String username){
        return userDao.getBy(username);
    }
    public List<User> getByUsername(String firstname){
        return userRepository.queryNative(firstname);
    }

}
