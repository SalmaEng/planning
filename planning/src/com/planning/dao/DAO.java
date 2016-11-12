package com.planning.dao;

import java.sql.Connection;

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
