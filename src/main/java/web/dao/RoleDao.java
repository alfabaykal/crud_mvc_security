package web.dao;

import web.model.Role;

public interface RoleDao {
    Role getRoleById(Long id);
    Role getRoleByName(String name);
}
