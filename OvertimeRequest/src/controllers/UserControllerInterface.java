/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Users;

/**
 *
 * @author AdhityaWP
 */
public interface UserControllerInterface {
    public Users getByid(String id);
    public List<Users> getAll();
    public String save(String username, String password, String employee);
    public boolean login(String username, String password);
    public String delete(String username, String password, String employee);
    
}
