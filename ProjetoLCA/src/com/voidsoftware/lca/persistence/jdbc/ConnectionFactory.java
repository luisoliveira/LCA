package com.voidsoftware.lca.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.mail.iap.ConnectionException;

public class ConnectionFactory {
	
	
	private static ConnectionFactory connectionFactory = null;  
    private static Connection connection = null;
    
	private ConnectionFactory(){    } 
	
	 public static ConnectionFactory getInstance(){  
         
         if(connectionFactory == null)  
             connectionFactory = new ConnectionFactory();   

         return connectionFactory;  

 }  
	
	public static Connection obterConexaoOracle() throws Exception {
		
		 if(connection == null){  
             try {  
            	 	Class.forName("oracle.jdbc.driver.OracleDriver");  
                    connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","OPS$RM68308","101288");  
            }   
            catch (SQLException e) {  
                System.out.println("\n>> Problema ao obter conexao\n");  
                e.printStackTrace();  
                throw new ConnectionException();  
            }  
        }  

    return connection;  
   }  
	

	
	public static Connection obterConexaoMySQL() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio", "root", "fiap");
		
	}
}
