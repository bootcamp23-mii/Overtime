/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.DivisionController;
import daos.GeneralDAO;
import models.Division;
import models.Employee;
import org.hibernate.SessionFactory;

/**
 *
 * @author milhamafemi
 */
public class TestRun {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        GeneralDAO gdao = new GeneralDAO(factory);
        DivisionController dc=new DivisionController(factory);
        System.out.println( dc.getById("D01"));
//        System.out.println(dc.getAll());
//        for (Object object : dc.getAll()) {
//            Division division= (Division) object;
//            System.out.println(object);
//        }
//        for (Object object : gdao.getData(new Employee(), "")) {
//            Employee emp= (Employee) object;
//            System.out.println(emp.getName());
//        }
//        for (Object object : gdao.getData(new Division(), "")) {
//            Division d= (Division) object;
//            System.out.println(d.getName());
//        }
        
//        for (Object object : dc.getAll()) {
//            Division d=(Division) object;
//            System.out.println(d.getName());
//        }
    }
}
