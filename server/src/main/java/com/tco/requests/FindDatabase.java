package com.tco.requests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.*;

public class FindDatabase{

    protected int found = 0;
    protected int limit = 0;
    protected String match;
    protected String[] where;
    protected String[] type;
    protected String input = "";
    protected String output = "Hello";
    final String URL = "jdbc:mariadb://faure.cs.colostate.edu/cs314";
    final String USER = "cs314-db";
    final String PASSWORD = "eiK5liet1uej";
    protected int count = 0;

    protected ArrayList<String> nameAL = new ArrayList();
    protected ArrayList<String> latAL = new ArrayList();
    protected ArrayList<String> lngAL = new ArrayList();
    protected ArrayList<String> cityAL = new ArrayList();
    protected ArrayList<String> regionAL = new ArrayList();

    public FindDatabase(){
        this.match = "Dave";
        this.limit = 10;
        where = new String[50];
        type = new String[50];
        where[0] = "United States";
        type[0] = "airport";
    }

    public FindDatabase(String match, int limit, String[] where, String[] type){
        this();
        this.match = match;
        this.limit = limit;
        this.where = where;
        this.type = type;
    }

    public void match(){
        input += "SELECT NAME, municipality, latitude, longitude, TYPE FROM world WHERE NAME LIKE '%dave%' LIMIT 10";
    }

    public void match(String name){
        // input += "SELECT NAME, TYPE FROM "
        //         + where[0] + " WHERE NAME LIKE '%"
        //         + match + "%' LIMIT"
        //         + limit + ";";
        input += "SELECT NAME, municipality, latitude, longitude, TYPE FROM world WHERE NAME LIKE '%" + name + "%' LIMIT " + this.limit;
    }

    public void Database(){
        try{
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement query = conn.createStatement();
            ResultSet results = query.executeQuery(input);
            process(results);
        }catch(Exception e){
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public int getCount(){
        return this.count;
    }

    public void process(ResultSet results) throws Exception{
        while(results.next()){
            synchronized(this){
                count++;
            }
            nameAL.add(results.getString("NAME"));
            latAL.add(results.getString("latitude"));
            lngAL.add(results.getString("longitude"));
            cityAL.add(results.getString("municipality"));
        }
    }

    public ArrayList<String> getNameAL(){
        return this.nameAL;
    }
    
    public ArrayList<String> getLatAL(){
        return this.latAL;
    }

    public ArrayList<String> getLngAL(){
        return this.lngAL;
    }

    public ArrayList<String> getCityAL(){
        return this.cityAL;
    }

}
