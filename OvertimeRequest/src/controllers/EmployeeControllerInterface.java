/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Employee;

/**
 *
 * @author milhamafemi
 */
public interface EmployeeControllerInterface {

    public String insertOrUpdate(String id, String name, String address, String email, String salary, String division, String manager, String site);

    public String delete(String id);

    public List<Employee> getAll();

    public List<Employee> getData(String keyword);

    public Employee getById(String id);
    
    public Employee last();

}
