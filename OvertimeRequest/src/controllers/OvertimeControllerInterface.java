/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Overtime;

/**
 *
 * @author milhamafemi
 */
public interface OvertimeControllerInterface {

    public String insert(String id, String overtimeDate, String timeDuration, String keterangan, String status, String timeSheet);

    public String update(String id, String overtimeDate, String timeDuration, String keterangan, String status, String timeSheet);

    public String delete(String id, String overtimeDate, String timeDuration, String keterangan, String status, String timeSheet);

    public Overtime getById(String id);

    public List<Overtime> getData(String key);

    public List<Overtime> getAll();
}
