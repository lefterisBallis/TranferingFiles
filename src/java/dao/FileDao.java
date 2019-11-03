/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controllers.UploadServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import model.MyFile;
import utils.DbUtils;

/**
 *
 * @author leftb
 */
public class FileDao {

    public void uploadFile(Part p) throws IOException {
        Connection con = DbUtils.getConnection();
        PreparedStatement ps = null;
        String q = "insert into myfiles value (null , ? , ? ,?)";
       
        try {
            ps = con.prepareStatement(q);
            ps.setString(1, p.getSubmittedFileName());
            ps.setBinaryStream(2, p.getInputStream());
            ps.setInt(3, (int) p.getSize());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FileDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public MyFile getById(int id) {
        MyFile mf = new MyFile();
        String sql = "SELECT * FROM MYFILES WHERE ID=?";
        Connection con = DbUtils.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                mf.setId(rs.getInt("id"));
                mf.setFilename(rs.getString("filename"));
                mf.setThefile(rs.getBlob("filearchive"));
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FileDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mf;
    }

    public List<MyFile> getAllFiles() {
        List<MyFile> allFiles = new ArrayList<>();

        Connection con = DbUtils.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String q = "select id,filename,filesize from myfiles";

        try {
            stm = con.createStatement();
            rs = stm.executeQuery(q);
            while (rs.next()) {
                MyFile mf = new MyFile();
                mf.setId(rs.getInt("id"));
                mf.setFilename(rs.getString("filename"));
                mf.setFilesize((rs.getInt("filesize")/1000));
                allFiles.add(mf);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FileDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();
            stm.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FileDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return allFiles;
    }

    public void deleteFileById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        String q = "delete from myfiles where id=?";

        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FileDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FileDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
