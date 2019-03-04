/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import java.util.List;
import javassist.compiler.ast.Keyword;
import models.Site;
import org.hibernate.SessionFactory;

/**
 *
 * @author AdhityaWP
 */
public class SiteController implements SiteControllerInterface {

    private DAOInterface<Site> dao;

    public SiteController(SessionFactory factory) {
        dao = new GeneralDAO<>(factory, Site.class);
    }

    @Override
    public Site getByid(String id) {
        return dao.getById(id);
    }

    @Override
    public List<Site> getAll() {
        return dao.getData("");
    }

    @Override
    public List<Site> search(Object keyword) {
        return dao.getData(keyword);
    }

    @Override
    public String save(String id, String name, String location) {
        if (dao.saveOrDelete(new Site(id, name, location), true)) {
            return "Save Data Success!";
        } else {
            return "Save Failed!";
        }
    }

    @Override
    public String delete(String id, String name, String location) {
        if (dao.saveOrDelete(new Site(id, name, location), false)) {
            return "Delete Data Success!";
        } else {
            return "Delete Failed!";
        }
    }

}
