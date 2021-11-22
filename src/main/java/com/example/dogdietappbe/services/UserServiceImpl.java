package com.example.dogdietappbe.services;

import com.example.dogdietappbe.exceptions.ResourceNotFoundException;
import com.example.dogdietappbe.models.Role;
import com.example.dogdietappbe.models.User;
import com.example.dogdietappbe.models.UserRoles;
import com.example.dogdietappbe.repositories.RoleRepository;
import com.example.dogdietappbe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service(value = "userService")
public class UserServiceImpl
        implements UserService {
    /**
     * Connects this service to the User table.
     */
    @Autowired
    private UserRepository userrepos;

    @Autowired
    private RoleService roleService;



    /**
     * Connects this service to the Role table
     */
    @Autowired
    private RoleRepository rolerepos;

    @Autowired
    private HelperFunctions helperFunctions;

    public User findUserById(long id) throws
            ResourceNotFoundException {
        return userrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found!"));
    }

    @Override
    public List<User> findByNameContaining(String username) {
        return userrepos.findByUsernameContainingIgnoreCase(username.toLowerCase());
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        userrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }



    @Override
    public User findByName(String name) {
        User uu = userrepos.findByUsername(name.toLowerCase());
        if (uu == null) {
            throw new ResourceNotFoundException("User name " + name + " not found!");
        }
        return uu;
    }

    @Transactional
    @Override
    public User save(User user) {
        User newUser = new User();

        if (user.getUserid() != 0) {
            userrepos.findById(user.getUserid())
                    .orElseThrow(() -> new ResourceNotFoundException("User id " + user.getUserid() + " not found!"));
            newUser.setUserid(user.getUserid());
        }

        newUser.setUsername(user.getUsername()
                .toLowerCase());
        newUser.setPasswordNoEncrypt(user.getPassword());
        newUser.setPasswordNoEncrypt(user.getPassword());

        newUser.getRoles()
                .clear();
        for (UserRoles ur : user.getRoles()) {
            Role addRole = roleService.findRoleById(ur.getRole()
                    .getRoleid());
            newUser.getRoles()
                    .add(new UserRoles(newUser,
                            addRole));
        }

        return userrepos.save(newUser);
    }

    @Transactional
    @Override
    public User update(
            User user,
            long id) {
        User currentUser = findUserById(id);

        if (helperFunctions.isAuthorizedToMakeChange(currentUser.getUsername())) {
            if (user.getUsername() != null) {
                currentUser.setUsername(user.getUsername()
                        .toLowerCase());
            }

            if (user.getPassword() != null) {
                currentUser.setPasswordNoEncrypt(user.getPassword());
            }

            if (user.getRoles()
                    .size() > 0) {
                currentUser.getRoles()
                        .clear();
                for (UserRoles ur : user.getRoles()) {
                    Role addRole = roleService.findRoleById(ur.getRole()
                            .getRoleid());

                    currentUser.getRoles()
                            .add(new UserRoles(currentUser,
                                    addRole));
                }
            }

            return userrepos.save(currentUser);
        } else {
            // note we should never get to this line but is needed for the compiler
            // to recognize that this exception can be thrown
            throw new ResourceNotFoundException("This user is not authorized to make change");
        }
    }

    @Override
    public User findUserByUsername(String username) {
        User user = userrepos.findByUsername(username.toLowerCase());
        if (user == null)
        {
            throw new EntityNotFoundException("Username " + username + " not found");
        }

        return user;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void deleteAllUsers()
    {
        userrepos.deleteAll();
    }
}


