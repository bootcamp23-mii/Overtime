/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import java.nio.channels.SeekableByteChannel;
import java.util.List;
import models.Task;
import org.hibernate.SessionFactory;

/**
 *
 * @author AdhityaWP
 */
public class TaskController implements TaskControllerInterface{
    private DAOInterface<Task> dao;

    public TaskController(SessionFactory factory) {
        dao = new GeneralDAO<>(factory, Task.class);
    }

    @Override
    public Task getByid(String id) {
        return dao.getById(id);
    }

    @Override
    public List<Task> getAll() {
        return dao.getData("");
    }

    @Override
    public List<Task> search(Object keyword) {
        return dao.getData(keyword);
    }

    @Override
    public String save(String id, String name) {
        if (dao.saveOrDelete(new Task(id, name), true)) {
            return "Save Data Success!";
        } else {
            return "Save Failed!";
        }
    }

    @Override
    public String delete(String id, String name) {
        if (dao.saveOrDelete(new Task(id, name), false)) {
            return "Delete Data Success!";
        } else {
            return "Delete Failed!";
        }
    }
    
}
