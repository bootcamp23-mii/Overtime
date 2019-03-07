/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.Overtime;
import models.TimeSheet;
import org.hibernate.SessionFactory;

/**
 *
 * @author AdhityaWP
 */
public class OvertimeController implements OvertimeControllerInterface{
    private DAOInterface<Overtime> dao;

    public OvertimeController(SessionFactory sessionFactory) {
        dao= new GeneralDAO<>(sessionFactory, Overtime.class);
    }
    
    @Override
    public String insert(String id, String overtimeDate , String timeDuration, String keterangan, String status, String timeSheet){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date Otdate = dateFormat.parse(overtimeDate);
            if (dao.saveOrDelete(new Overtime(id, Otdate, new BigInteger(timeDuration), keterangan, new BigInteger(status), new TimeSheet(timeSheet)),true)) {
             return " Selamat data berhasil disimpan";
        }           
        } catch (Exception e) {
            e.printStackTrace();
        }       
         return "Maaf coba lagi";
    }
    
    @Override
    public String update(String id, String overtimeDate , String timeDuration, String keterangan, String status, String timeSheet){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date Otdate = dateFormat.parse(overtimeDate);
            if (dao.saveOrDelete(new Overtime(id, Otdate, new BigInteger(timeDuration), keterangan, new BigInteger(status), new TimeSheet(timeSheet)),true)) {
             return " Selamat data berhasil diubah";
        }           
        } catch (Exception e) {
            e.printStackTrace();
        }       
         return "Maaf coba lagi";
    }
    
    @Override
    public String delete(String id, String overtimeDate , String timeDuration, String keterangan, String status, String timeSheet){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date Otdate = dateFormat.parse(overtimeDate);
            if (dao.saveOrDelete(new Overtime(id, Otdate, new BigInteger(timeDuration), keterangan, new BigInteger(status), new TimeSheet(timeSheet)),false)) {
             return " Data telah dihapus!";
        }           
        } catch (Exception e) {
            e.printStackTrace();
        }       
         return "Maaf coba lagi";
    }
    
    @Override
    public Overtime getById(String id) {
        return dao.getById(id);
    }

    @Override
    public List<Overtime> getData(String key) {
        return dao.getData(key);
    }
    
    public Overtime first() {
        return dao.last("");
    }
    
    @Override
     public List<Overtime> getAll() {
        return dao.getData("");
    }
    
    public Overtime last() {
        return dao.last("");
    }
    
}
