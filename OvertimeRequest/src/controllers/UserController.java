/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import java.sql.Connection;
import java.util.List;
import models.Employee;
import models.Sessions;
import models.Users;
import tools.BCrypt;
import org.hibernate.SessionFactory;

/**
 *
 * @author AdhityaWP
 */
public class UserController implements UserControllerInterface{
   private DAOInterface<Users> dao;

    public UserController(SessionFactory factory) {
        dao = new GeneralDAO<>(factory, Users.class);
    }
    
   

    @Override
    public Users getByid(String id) {
        return dao.getById(id);
    }

    @Override
    public List<Users> getAll() {
        return dao.getData("");
    }
    
    public Users last() {
        return dao.last("");
    }

    @Override
    public boolean save(String username, String password, String employee) {
        String x= BCrypt.hashpw(password, BCrypt.gensalt());
        if (dao.saveOrDelete(new Users(username, x, new Employee(employee)), true)) {
            return true;
        }
        return false;
    }

    @Override
    public String delete(String username, String password, String employee) {
        String x= BCrypt.hashpw(password, BCrypt.gensalt());
        if (dao.saveOrDelete(new Users(username, x, new Employee(employee)), false)) {
            return "Data Succefully Deleted";
        }
        return "Failed";
    }

    @Override
    public boolean login(String username, String password) {
        List<Users> list = dao.login(username);
        if (!list.isEmpty())
            for (Users obj : list){
                if (BCrypt.checkpw(password, obj.getPassword()))
                    Sessions.setId(obj.getEmployee().getId());
                    return true;
            }
           
        return false;
    }
   
    
 
    
}
