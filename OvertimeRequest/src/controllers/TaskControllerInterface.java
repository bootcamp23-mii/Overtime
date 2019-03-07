/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Task;

/**
 *
 * @author AdhityaWP
 */
public interface TaskControllerInterface {
    public Task getByid(String id);
    public List<Task> getAll();
    public List<Task> search(Object keyword);
    public String save(String id, String name, String overtime);
    public String delete(String id, String name, String overtime);
    public Task last();
    public Task first();
}
