/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.TimeSheet;

/**
 *
 * @author AdhityaWP
 */
public interface TimeSheetControllerInterface {
    public TimeSheet getByid(String id);
    public List<TimeSheet> getAll();
    public List<TimeSheet> search(Object keyword);
    public String save(String id, String date, String name, String employee);
    public String delete(String id, String date, String name, String employee);
    public TimeSheet last();
    public TimeSheet first();
    
}
