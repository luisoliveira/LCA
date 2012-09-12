package com.voidsoftware.lca.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public static Connection obterConexaoOracle() throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","OPS$RM68308","101288");
		
	}
	
	public static Connection obterConexaoMySQL() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio", "root", "fiap");
		
	}
}
