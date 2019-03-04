/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Division;
import models.Employee;
import models.TimeSheet;
import org.hibernate.SessionFactory;

/**
 *
 * @author AdhityaWP
 */
public class TimeSheetController implements TimeSheetControllerInterface{
    
    private DAOInterface<TimeSheet> dao;

    public TimeSheetController(SessionFactory factory) {
        dao = new GeneralDAO<>(factory, TimeSheet.class);
    }

    @Override
    public TimeSheet getByid(String id) {
        return dao.getById(id);
    }

    @Override
    public List<TimeSheet> search(Object keyword) {
        return dao.getData(keyword);
    }

    @Override
    public String save(String id, String date, String name, String employee) {
        Date a = null;
        try {
            a = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(TimeSheetController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (dao.saveOrDelete(new TimeSheet(id, a, name, new Employee(employee)), true)) {
            return "Save Data Success";
        }
        return "Save Failed";
    }

    @Override
    public String delete(String id, String date, String name, String employee) {
        Date a = null;
        try {
            a = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(TimeSheetController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (dao.saveOrDelete(new TimeSheet(id, a, name, new Employee(employee)), false)) {
            return "Delete Data Success";
        }
        return "Delete Failed";
    }

    @Override
    public List<TimeSheet> getAll() {
        return dao.getData("");
    }




}
