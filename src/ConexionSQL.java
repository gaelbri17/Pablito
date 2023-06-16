/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
/**
 *
 * @author thepr
 */
public class ConexionSQL {
       
 
    public static Connection getConexion(){
        
     
        String conexionUrl  = "jdbc:sqlserver://localhost:56228;" 
                            + "databaseName=EmpresaRegalos;" 
                            + "user=sa;"
                            + "password=Itr2023!;" 
                            + "encrypt=true;trustServerCertificate=true";
        
       
        try{
        
            Connection conn = DriverManager.getConnection(conexionUrl) ;
         
            return conn;
        }catch(SQLException ex){
        
            System.out.println(ex.toString());
            return null;
        }
    } 
}
