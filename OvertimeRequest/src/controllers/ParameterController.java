/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import java.util.List;
import models.Parameter;
import org.hibernate.SessionFactory;

/**
 *
 * @author AdhityaWP
 */
public class ParameterController implements ParameterControllerInterface{

    private DAOInterface<Parameter> dao;

    public ParameterController(SessionFactory sessionFactory) {
        dao= new GeneralDAO<>(sessionFactory, Parameter.class);
    }

    @Override
    public String insert(String id, String value, String keterangan) {
        if (dao.saveOrDelete(new Parameter(id, value, keterangan), true)) {
            return " Selamat data berhasil disimpan";
        }
        return "Maaf coba lagi";
    }

    @Override
    public String update(String id, String value, String keterangan) {
        if (dao.saveOrDelete(new Parameter(id, value, keterangan), true)) {
            return " Selamat data berhasil disimpan";
        }
        return "Maaf coba lagi";
    }

    @Override
    public String delete(String id, String value, String keterangan) {
        if (dao.saveOrDelete(new Parameter(id, value, keterangan), false)) {
            return "Data telah dihapus!";
        }
        return "Maaf coba lagi";
    }

    @Override
    public Parameter getById(String id) {
        return getById(id);
    }

    @Override
    public List<Parameter> getData(String key) {
        return dao.getData(key);
    }

    @Override
    public List<Parameter> getAll() {
        return dao.getData("");
    }

}
