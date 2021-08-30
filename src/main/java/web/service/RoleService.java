package web.service;

import web.model.Role;

public interface RoleService {
    Role getRoleById(Long id);
    Role getRoleByName(String name);
}
