package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static ConnectionFactory CONNECTION_FACTORY = null;
	
	private ConnectionFactory() {	
	}
	
	public static synchronized ConnectionFactory getInstance() {
			if(CONNECTION_FACTORY == null) CONNECTION_FACTORY = 
					new ConnectionFactory();
			return CONNECTION_FACTORY;
}

	public Connection getConnection() {

		Connection connection = null;
		Properties properties = new Properties();
		String path = "src/main/resources/database.properties";

		try {
			properties.load(new FileReader(path));
			Class.forName(properties.getProperty("driver"));

			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
