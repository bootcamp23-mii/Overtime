/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Division;

/**
 *
 * @author milhamafemi
 */
public interface DivisionControllerInterface {

    public String insertOrUpdate(String id, String name);
    public String delete(String id);
    public List<Division> getAll();
    public List<Division> getData(String keyword);
    public Division getById(String id);
    
}
