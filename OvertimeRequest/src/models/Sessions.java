/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Lusiana
 */
public class Sessions {

    private static String id;
    private static String idtab = "";

    public Sessions() {
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Sessions.id = id;
    }

    public static String getIdtab() {
        return idtab;
    }

    public static void setIdtab(String idtab) {
        Sessions.idtab = idtab;
    }

}
