package com.misa.fancyLogin.dao;

import com.misa.fancyLogin.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
}
