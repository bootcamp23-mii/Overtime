/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.DivisionController;
import controllers.OvertimeController;
import controllers.RoleController;
import controllers.UserController;
import controllers.UserControllerInterface;
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
//        GeneralDAO gdao = new GeneralDAO(factory);
//        OvertimeController oc= new OvertimeController(factory);
        DivisionController dc=new DivisionController(factory);
        UserControllerInterface uc=new UserController(factory);
        uc.save("alien", "alien", "E01");
//        RoleController rc= new RoleController(factory);
//        System.out.println(rc.getById("R01").getId());
//        System.out.println( oc.insert("o020", "2019-03-04", "180", "masuk kuliah", "1", "TS07"));
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

//            UserController uc = new UserController(factory);
//            System.out.println(uc.login("alien", "alien"));
//        }
        
//        for (Object object : dc.getAll()) {
//            Division d=(Division) object;
//            System.out.println(d.getName());
//        }
    }
}
