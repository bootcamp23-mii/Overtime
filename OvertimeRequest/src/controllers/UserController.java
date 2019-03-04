/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import java.sql.Connection;
import java.util.List;
import models.Employee;
import models.Users;
import tools.BCrypt;
import org.hibernate.SessionFactory;

/**
 *
 * @author FES
 */
public class UserController {
    private Connection connection;
    private GeneralDAO udao;

    public UserController(SessionFactory factory) {
        udao = new GeneralDAO(factory);
    }
    
   
    
    public String register(String username, String password, String employee) {
       String x= BCrypt.hashpw(password, BCrypt.gensalt());
        if (udao.saveOrDelete(new Users(username, x, new Employee(employee)), true)) {
            return "Selamat Data berhasil simpan";
        }
        return "Maaf Data gagal disimpan";
    }
    
   public Users getById(String id) {
        return (Users) udao.getById(new Users(id), id);
    }
   
   
  
   public String login(String username, String password){
        Users a = (Users) udao.getById(new Users(username), username);
        if (!a.equals(0))
           if (BCrypt.checkpw(password, a.getPassword())) 
                    return a.getEmployee().getId();
        return "Gagal";
    }
   
    
 
    
}
