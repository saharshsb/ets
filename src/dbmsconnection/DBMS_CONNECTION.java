/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbmsconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pranav krishna
 */
public class DBMS_CONNECTION {
    public static int dbms_connection_check(String Username,String Password){
        int found=0;
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");  
           Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/ets","root","tiger");
           Statement stmt=con.createStatement();
           ResultSet rs= stmt.executeQuery("select * from user");
           while(rs.next()){
                if(rs.getString(1).equals(Username)){
                    if(rs.getString(2).equals(Password))
                          found=1;      
                }
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Connection not established"+e);
                    
        }
        return found;
    }
}
