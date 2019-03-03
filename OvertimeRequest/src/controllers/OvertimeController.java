/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
public class OvertimeController {
    private GeneralDAO gdao;

    public OvertimeController(SessionFactory sessionFactory) {
        gdao = new GeneralDAO(sessionFactory);
    }
    
    public String insert(String id, String overtimeDate , String timeDuration, String keterangan, String status, String timeSheet){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date Otdate = dateFormat.parse(overtimeDate);
            if (gdao.saveOrDelete(new Overtime(id, Otdate, new BigInteger(timeDuration), keterangan, new BigInteger(status), new TimeSheet(timeSheet)),true)) {
             return " Selamat data berhasil disimpan";
        }           
        } catch (Exception e) {
            e.printStackTrace();
        }       
         return "Maaf coba lagi";
    }
    
    public String update(String id, String overtimeDate , String timeDuration, String keterangan, String status, String timeSheet){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date Otdate = dateFormat.parse(overtimeDate);
            if (gdao.saveOrDelete(new Overtime(id, Otdate, new BigInteger(timeDuration), keterangan, new BigInteger(status), new TimeSheet(timeSheet)),true)) {
             return " Selamat data berhasil diubah";
        }           
        } catch (Exception e) {
            e.printStackTrace();
        }       
         return "Maaf coba lagi";
    }
    
    public String delete(String id, String overtimeDate , String timeDuration, String keterangan, String status, String timeSheet){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date Otdate = dateFormat.parse(overtimeDate);
            if (gdao.saveOrDelete(new Overtime(id, Otdate, new BigInteger(timeDuration), keterangan, new BigInteger(status), new TimeSheet(timeSheet)),false)) {
             return " Data telah dihapus!";
        }           
        } catch (Exception e) {
            e.printStackTrace();
        }       
         return "Maaf coba lagi";
    }
    
    public Object getById(String id) {
        return gdao.getById(new Overtime(), id);
    }

    public List<Object> getData(String key) {
        return gdao.getData(new Overtime(key), key);
    }
    
     public List<Object> getAll() {
        return gdao.getData(new Overtime(), "");
    }
    
    
    
}
