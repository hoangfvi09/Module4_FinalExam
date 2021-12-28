package com.hoangfvi.luyentap.service;


import com.hoangfvi.luyentap.model.Role;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}

