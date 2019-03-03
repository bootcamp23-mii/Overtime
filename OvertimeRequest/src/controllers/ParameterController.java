/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import java.util.List;
import models.Parameter;
import org.hibernate.SessionFactory;

/**
 *
 * @author AdhityaWP
 */
public class ParameterController {

    private GeneralDAO gdao;

    public ParameterController(SessionFactory sessionFactory) {
        gdao = new GeneralDAO(sessionFactory);
    }

    public String insert(String id, String value, String keterangan) {
        if (gdao.saveOrDelete(new Parameter(id, value, keterangan), true)) {
            return " Selamat data berhasil disimpan";
        }
        return "Maaf coba lagi";
    }

    public String update(String id, String value, String keterangan) {
        if (gdao.saveOrDelete(new Parameter(id, value, keterangan), true)) {
            return " Selamat data berhasil disimpan";
        }
        return "Maaf coba lagi";
    }

    public String delete(String id, String value, String keterangan) {
        if (gdao.saveOrDelete(new Parameter(id, value, keterangan), false)) {
            return "Data telah dihapus!";
        }
        return "Maaf coba lagi";
    }

    public Object getById(String id) {
        return gdao.getById(new Parameter(), id);
    }

    public List<Object> getData(String key) {
        return gdao.getData(new Parameter(key), key);
    }

    public List<Object> getAll() {
        return gdao.getData(new Parameter(), "");
    }

}
