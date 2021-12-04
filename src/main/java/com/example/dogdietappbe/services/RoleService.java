package com.example.dogdietappbe.services;


import com.example.dogdietappbe.models.Role;

public interface RoleService {


    Role save(Role role) throws Exception;

    Role findRoleById(long roleid);

    Role findByName(String name);
}
