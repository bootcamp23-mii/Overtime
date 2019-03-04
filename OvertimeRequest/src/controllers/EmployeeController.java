/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;
import models.Division;
import models.Employee;
import models.Role;
import models.Site;
import models.TimeSheet;
import org.hibernate.SessionFactory;

/**
 *
 * @author Lusiana
 */
public class EmployeeController {
    
    private GeneralDAO gdao;

    public EmployeeController(SessionFactory factory) {
        gdao = new GeneralDAO(factory);
    }

    public String insertOrUpdate(String id, String name, String address, String email, String salary, String division, String manager, String site) throws ParseException {
        if (gdao.saveOrDelete(new Employee(id, name, address, email, new BigInteger(salary), new Division(division), new Employee(manager), new Site(site)), true)) {
            return "Selamat Data berhasil simpan";
        }
        return "Maaf Data gagal disimpan";
    }

    public String delete(String id) {
        if (gdao.saveOrDelete(new Employee(id), false)) {
            return "Selamat Data berhasil dihapus";
        }
        return "Maaf Data gagal dihapus";
    }

    public List<Object> getAll() {
        return gdao.getData(new Employee(), "");
    }

    public List<Object> getData(String keyword) {
        return gdao.getData(new Employee(keyword), keyword);
    }
    
    public Employee getById(String id){
        return (Employee) gdao.getById(new Employee(), id);
    }




}
