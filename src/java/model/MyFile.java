/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;

/**
 *
 * @author leftb
 */
public class MyFile {
     private  int id;
    private  String filename;
    private  Blob thefile;
    private  int filesize;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Blob getThefile() {
        return thefile;
    }

    public void setThefile(Blob thefile) {
        this.thefile = thefile;
    }

    public int getFilesize() {
        return filesize;
    }

    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }

    public MyFile() {
    }
}
