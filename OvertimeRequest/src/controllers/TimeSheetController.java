/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.Division;
import models.Employee;
import models.TimeSheet;
import org.hibernate.SessionFactory;

/**
 *
 * @author Lusiana
 */
public class TimeSheetController {
    
    private GeneralDAO gdao;

    public TimeSheetController(SessionFactory factory) {
        gdao = new GeneralDAO(factory);
    }

    public String insertOrUpdate(String id, String date, String name, String employee) throws ParseException {
        Date a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(date);
        if (gdao.saveOrDelete(new TimeSheet(id, a, name, new Employee(employee)), true)) {
            return "Selamat Data berhasil simpan";
        }
        return "Maaf Data gagal disimpan";
    }

    public String delete(String id) {
        if (gdao.saveOrDelete(new TimeSheet(id), false)) {
            return "Selamat Data berhasil dihapus";
        }
        return "Maaf Data gagal dihapus";
    }

    public List<Object> getAll() {
        return gdao.getData(new TimeSheet(), "");
    }

    public List<Object> getData(String keyword) {
        return gdao.getData(new TimeSheet(keyword), keyword);
    }
    
    public String getById(String id){
        return (String) gdao.getById(new TimeSheet(), id);
    }




}
