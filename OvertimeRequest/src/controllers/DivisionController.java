/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import java.util.List;
import models.Division;
import org.hibernate.SessionFactory;

/**
 *
 * @author milhamafemi
 */
public class DivisionController implements DivisionControllerInterface{
    private DAOInterface<Division> dao;


    public DivisionController(SessionFactory factory) {
        dao = new GeneralDAO<>(factory, Division.class);
    }

    @Override
    public String insertOrUpdate(String id, String name) {
        if (dao.saveOrDelete(new Division(id, name), true)) {
            return "Selamat Data berhasil simpan";
        }
        return "Maaf Data gagal disimpan";
    }

    @Override
    public String delete(String id) {
        if (dao.saveOrDelete(new Division(id), false)) {
            return "Selamat Data berhasil dihapus";
        }
        return "Maaf Data gagal dihapus";
    }

    @Override
    public List<Division> getAll() {
        return dao.getData("");
    }

    @Override
    public List<Division> getData(String keyword) {
        return dao.getData(keyword);
    }

    @Override
    public Division getById(String id) {
        return dao.getById(id);
    }
}
