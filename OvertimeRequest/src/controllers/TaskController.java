/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import java.nio.channels.SeekableByteChannel;
import java.util.List;
import models.Task;
import org.hibernate.SessionFactory;

/**
 *
 * @author milhamafemi
 */
public class TaskController {
    private GeneralDAO gdao;

    public TaskController(SessionFactory factory) {
        gdao=new GeneralDAO(factory);
    }
    
    public String insertOrUpdate(String id, String name) {
        if (gdao.saveOrDelete(new Task(id, name), true)) {
            return "Selamat Data berhasil simpan";
        }
        return "Maaf Data gagal disimpan";
    }

    public String delete(String id) {
        if (gdao.saveOrDelete(new Task(id), false)) {
            return "Selamat Data berhasil dihapus";
        }
        return "Maaf Data gagal dihapus";
    }

    public List<Object> getAll() {
        return gdao.getData(new Task(), "");
    }

    public List<Object> getData(String keyword) {
        return gdao.getData(new Task(keyword), keyword);
    }
    
    public Task getById(String id){
        return (Task) gdao.getById(new Task(id), id);
    }
    
}
