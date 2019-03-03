/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

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

//          System.out.println( gdao.getById(new Division(), "D"));

        for (Object object : gdao.getData(new Employee(), "")) {
            Employee emp= (Employee) object;
            System.out.println(emp.getName());
        }
    }
}
