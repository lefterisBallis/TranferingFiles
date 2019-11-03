/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author leftb
 */
public class DbUtils {
     public static Connection getConnection() {
        Connection con = null;

        Context initialContext;
        try {
            initialContext = new InitialContext();

            Context envContext = (Context) initialContext.lookup("java:/comp/env");
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/pool");

            con = dataSource.getConnection();
            
        } catch (SQLException ex) {
            Logger.getLogger(DbUtils.class.getName()).log(Level.SEVERE, null, ex);

        } catch (NamingException ex) {
            Logger.getLogger(DbUtils.class.getName()).log(Level.SEVERE, null, ex);

        }
        return con;
    }
}
