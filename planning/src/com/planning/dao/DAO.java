/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.dao;

import java.sql.Connection;
/**
 *
 * @author genereux
 */
public abstract class DAO <T> {
    
    protected Connection conn = null;
    
    public DAO (Connection conn) {
        this.conn = conn;
    }
    
    public abstract boolean create(T obj);
    
    public abstract boolean delete(T obj);
    
    public abstract boolean update(T obj);
    
    public abstract T find(int id);
}
