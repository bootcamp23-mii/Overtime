/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Site;

/**
 *
 * @author AdhityaWP
 */
public interface SiteControllerInterface {
    public Site getByid(String id);
    public List<Site> getAll();
    public List<Site> search(Object keyword);
    public String save(String id, String name, String location);
    public String delete(String id, String name, String location);
    public Site last();
}
