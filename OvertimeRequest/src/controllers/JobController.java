/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import java.text.ParseException;
import java.util.List;
import models.Division;
import models.Job;
import models.TimeSheet;
import org.hibernate.SessionFactory;

/**
 *
 * @author Lusiana
 */
public class JobController {
    
    private GeneralDAO gdao;

    public JobController(SessionFactory factory) {
        gdao = new GeneralDAO(factory);
    }

    public String insertOrUpdate(String id, String name) throws ParseException {
        if (gdao.saveOrDelete(new Job(id, name), true)) {
            return "Selamat Data berhasil simpan";
        }
        return "Maaf Data gagal disimpan";
    }

    public String delete(String id) {
        if (gdao.saveOrDelete(new Job(id), false)) {
            return "Selamat Data berhasil dihapus";
        }
        return "Maaf Data gagal dihapus";
    }

    public List<Object> getAll() {
        return gdao.getData(new Job(), "");
    }

    public List<Object> getData(String keyword) {
        return gdao.getData(new Job(keyword), keyword);
    }
    
    public Job getById(String id){
        return (Job) gdao.getById(new Job(), id);
    }




}
