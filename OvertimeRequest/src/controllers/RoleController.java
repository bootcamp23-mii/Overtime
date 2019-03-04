/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import java.util.List;
import models.Employee;
import models.Job;
import models.Role;
import org.hibernate.SessionFactory;

/**
 *
 * @author milhamafemi
 */
public class RoleController {
    private GeneralDAO gdao;

    public RoleController(SessionFactory factory) {
        gdao=new GeneralDAO(factory);
    } 
    
    public String insertOrUpdate(String id, String name, String employee, String job) {
        if (gdao.saveOrDelete(new Role(id, name, new Employee(name), new Job(job)), true)) {
            return "Selamat Data berhasil simpan";
        }
        return "Maaf Data gagal disimpan";
    }

    public String delete(String id) {
        if (gdao.saveOrDelete(new Role(id), false)) {
            return "Selamat Data berhasil dihapus";
        }
        return "Maaf Data gagal dihapus";
    }

    public List<Object> getAll() {
        return gdao.getData(new Role(), "");
    }

    public List<Object> getData(String keyword) {
        return gdao.getData(new Role(keyword), keyword);
    }
    
    public Object getById(String id){
        return gdao.getById(new Role(), id);
    }
    
}
