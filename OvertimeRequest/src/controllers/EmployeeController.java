/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
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
public class EmployeeController implements EmployeeControllerInterface {

    private DAOInterface<Employee> dao;

    public EmployeeController(SessionFactory factory) {
        dao = new GeneralDAO<>(factory, Employee.class);
    }

    @Override
    public String insertOrUpdate(String id, String name, String address, String email, String salary, String division, String manager, String site) {
        if (dao.saveOrDelete(new Employee(id, name, address, email, new BigInteger(salary), new Division(division), new Employee(manager), new Site(site)), true)) {
            return "Selamat Data berhasil simpan";
        }
        return "Maaf Data gagal disimpan";
    }

    @Override
    public String delete(String id) {
        if (dao.saveOrDelete(new Employee(id), false)) {
            return "Selamat Data berhasil dihapus";
        }
        return "Maaf Data gagal dihapus";
    }

    @Override
    public List<Employee> getAll() {
        return dao.getData("");
    }

    @Override
    public List<Employee> getData(String keyword) {
        return dao.getData(keyword);
    }

    @Override
    public Employee getById(String id) {
        return dao.getById(id);
    }
    
    public Employee last() {
        return dao.last("");
    }

}
