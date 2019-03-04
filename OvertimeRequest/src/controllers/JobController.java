/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
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
public class JobController implements JobControllerInterface{
    
    private DAOInterface<Job> dao;

    public JobController(SessionFactory factory) {
        dao= new GeneralDAO<>(factory, Job.class);
    }

    @Override
    public String insertOrUpdate(String id, String name){
        if (dao.saveOrDelete(new Job(id, name), true)) {
            return "Selamat Data berhasil simpan";
        }
        return "Maaf Data gagal disimpan";
    }

    @Override
    public String delete(String id, String position) {
        if (dao.saveOrDelete(new Job(id, position), false)) {
            return "Selamat Data berhasil dihapus";
        }
        return "Maaf Data gagal dihapus";
    }

    @Override
    public List<Job> getAll() {
        return dao.getData("");
    }

    @Override
    public List<Job> getData(String keyword) {
        return dao.getData(keyword);
    }
    
    @Override
    public Job getById(String id){
        return dao.getById(id);
    }




}
