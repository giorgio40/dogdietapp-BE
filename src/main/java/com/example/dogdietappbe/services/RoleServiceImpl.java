package com.example.dogdietappbe.services;

import com.example.dogdietappbe.exceptions.ResourceFoundException;
import com.example.dogdietappbe.exceptions.ResourceNotFoundException;
import com.example.dogdietappbe.models.Role;
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
@Service(value = "roleService")
public class RoleServiceImpl
        implements RoleService {
    /**
     *
     */
     @Autowired
     RoleRepository rolerepos;

     /**
      * Connect this service to the User Model
     */
    @Autowired
    UserRepository userrepos;

    /**
     * Connects this service to the auditing service in order to get current user name
     */
    @Autowired
    private UserAuditing userAuditing;


    @Override
    public Role findRoleById(long id)
    {
        return rolerepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role id " + id + " not found!"));
    }


    @Transactional
    @Override
    public Role save(Role role)
    {
        if (role.getUsers()
                .size() > 0)
        {
            throw new ResourceFoundException("User Roles are not updated through Role.");
        }

        return rolerepos.save(role);
    }

    @Override
    public Role findByName(String user) {
        return null;
    }


}