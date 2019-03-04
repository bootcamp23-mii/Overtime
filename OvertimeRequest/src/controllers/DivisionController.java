/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import java.util.List;
import models.Division;
import org.hibernate.SessionFactory;

/**
 *
 * @author milhamafemi
 */
public class DivisionController {

    private GeneralDAO gdao;

    public DivisionController(SessionFactory factory) {
        gdao = new GeneralDAO(factory);
    }

    public String insertOrUpdate(String id, String name ) {
        if (gdao.saveOrDelete(new Division(id, name), true)) {
            return "Selamat Data berhasil simpan";
        }
        return "Maaf Data gagal disimpan";
    }

    public String delete(String id) {
        if (gdao.saveOrDelete(new Division(id), false)) {
            return "Selamat Data berhasil dihapus";
        }
        return "Maaf Data gagal dihapus";
    }

    public List<Object> getAll() {
        return gdao.getData(new Division(), "");
    }

    public List<Object> getData(String keyword) {
        return gdao.getData(new Division(keyword), keyword);
    }
    
    public Division getById(String id){
        return (Division) gdao.getById(new Division(id), id);
    }



}
