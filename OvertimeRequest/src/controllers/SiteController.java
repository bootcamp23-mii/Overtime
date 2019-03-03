/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import java.util.List;
import models.Site;
import org.hibernate.SessionFactory;

/**
 *
 * @author AdhityaWP
 */
public class SiteController {
    private GeneralDAO gdao;

    public SiteController(SessionFactory sessionFactory) {
        gdao = new GeneralDAO(sessionFactory);
    }
    
    public String insert(String id, String name, String location){
        if (gdao.saveOrDelete (new Site(id, name, location),true)) {
             return " Selamat data berhasil disimpan";
        }
         return "Maaf coba lagi";
    }
    
    public String update(String id, String name, String location){
        if (gdao.saveOrDelete (new Site(id, name, location),true)) {
             return " Selamat data berhasil diubah";
        }
         return "Maaf coba lagi";
    }
    
    public String delete(String id, String name, String location){
        if (gdao.saveOrDelete (new Site(id, name, location), false)) {
             return "Data telah dihapus!";
        }
         return "Maaf coba lagi";
    }
    public Object getById(String id) {
        return gdao.getById(new Site(), id);
    }

    public List<Object> getData(String key) {
        return gdao.getData(new Site(key), key);
    }
    
     public List<Object> getAll() {
        return gdao.getData(new Site(), "");
    }
    
}
