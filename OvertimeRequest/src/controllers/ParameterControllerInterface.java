/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Parameter;

/**
 *
 * @author milhamafemi
 */
public interface ParameterControllerInterface {

    public String insert(String id, String value, String keterangan);

    public String update(String id, String value, String keterangan);

    public String delete(String id, String value, String keterangan);

    public Parameter getById(String id);

    public List<Parameter> getData(String key);

    public List<Parameter> getAll();
}
