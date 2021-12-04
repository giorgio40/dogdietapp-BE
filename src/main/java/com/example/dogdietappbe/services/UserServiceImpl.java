package com.example.dogdietappbe.services;

import com.example.dogdietappbe.exceptions.ResourceNotFoundException;
import com.example.dogdietappbe.models.Role;
import com.example.dogdietappbe.models.User;
import com.example.dogdietappbe.models.Useremail;
import com.example.dogdietappbe.models.UserRoles;
import com.example.dogdietappbe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service(value = "userservice")
public class UserServiceImpl
        implements UserService {
    @Autowired
    private UserRepository userrepos;

    @Autowired
    private RoleService roleService;

    @Transactional
    @Override public User save(User user) throws Exception
    {
        User newUser = new User();

        if (user.getUserid() != 0)
        {
            userrepos.findById(user.getUserid())
                    .orElseThrow(() -> new ResourceNotFoundException("User id " + user.getUserid() + " not found!"));
            newUser.setUserid(user.getUserid());
        }

        newUser.setUsername(user.getUsername()
                .toLowerCase());
        newUser.setPasswordNoEncrypt(user.getPassword());
        newUser.setEmail(user.getEmail()
                .toLowerCase());

        newUser.getRoles()
                .clear();
        for (UserRoles ur : user.getRoles())
        {
            Role addRole = roleService.findRoleById(ur.getRole()
                    .getRoleid());
            newUser.getRoles()
                    .add(new UserRoles(newUser,
                            addRole));
        }


        return userrepos.save(newUser);
    }
    @Transactional
    @Override public void deleteAllUsers()
    {
        userrepos.deleteAll();
    }

    @Override public User findUserById(long userid)
    {
        return userrepos.findById(userid).orElseThrow(() ->
                new EntityNotFoundException("User id " + userid + " not found"));
    }

    @Override public List<User> findAllUsers()
    {
        List<User> users = new ArrayList<>();
        userrepos.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    @Override public List<User> findUsersByUsernameLike(String username)
    {
        List<User> users = userrepos.findByUsernameContainingIgnoringCase(username.toLowerCase());

        if (users.size() < 1)
        {
            throw new EntityNotFoundException("No users found matching '" + username + "'");
        }

        return users;
    }



    @Override public User findUserByUsername(String username)
    {
        User user = userrepos.findByUsername(username.toLowerCase());
        if (user == null)
        {
            throw new EntityNotFoundException("Username " + username + " not found");
        }

        return user;
    }

}