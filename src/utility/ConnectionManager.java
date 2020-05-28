package utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {
	
	public static Properties loadPropertiesFile() throws Exception {
		Properties properties = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(in);
		in.close();
		return properties;
	}
	
	public static Connection getconnection() throws Exception {
		Connection con = null;
		Properties properties = null;
		try {
			properties = loadPropertiesFile();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		final String driver = properties.getProperty("driver");
		final String url = properties.getProperty("url");
		final String username = properties.getProperty("username");
		final String password = properties.getProperty("password");
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}