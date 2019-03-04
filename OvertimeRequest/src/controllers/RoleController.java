/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import java.util.List;
import models.Employee;
import models.Job;
import models.Role;
import org.hibernate.SessionFactory;

/**
 *
 * @author AdhityaWP
 */
public class RoleController implements RoleControllerInterface {

    private DAOInterface<Role> dao;

    public RoleController(SessionFactory factory) {
        dao = new GeneralDAO<>(factory, Role.class);
    }

    @Override
    public Role getByid(String id) {
        return dao.getById(id);
    }

    @Override
    public List<Role> search(Object keyword) {
        return dao.getData(keyword);
    }

    @Override
    public String save(String id, String name, String employee, String job) {
        if (dao.saveOrDelete(new Role(id, name, new Employee(employee), new Job(job)), true)) {
            return "Save Data Success!";
        } else {
            return "Save Failed!";
        }
    }

    @Override
    public String delete(String id, String name, String employee, String job) {
        if (dao.saveOrDelete(new Role(id, name, new Employee(employee), new Job(job)), false)) {
            return "Delete Data Success!";
        } else {
            return "Delete Failed!";
        }
    }

    @Override
    public List<Role> getAll() {
        return dao.getData("");
    }

}
