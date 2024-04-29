package org.example.ta.Service;

import org.example.ta.DTO.SignInInput;
import org.example.ta.Model.User;
import org.example.ta.Repository.ISignInDao;
import org.example.ta.Repository.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserDao userDao;

    @Autowired
    ISignInDao signInDao;

    public User signUp(User user) {
        userDao.save(user);
        return user;
    }

    public User signIn(SignInInput sign) {
        List<User> users = userDao.findAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equalsIgnoreCase(sign.getEmail()) && users.get(i).getRole().equalsIgnoreCase(sign.getRole()) && users.get(i).getPassword().equals(sign.getPassword())) {
                return users.get(i);
            }
        }
        return null;
    }
}
