/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Role;

/**
 *
 * @author AdhityaWP
 */
public interface RoleControllerInterface {
    public Role getByid(String id);
    public List<Role> getAll();
    public List<Role> search(Object keyword);
    public String save(String id, String name, String employee, String job);
    public String delete(String id, String name, String employee, String job);
    public Role last();
    public String saveRoleId(String id);
    
}
