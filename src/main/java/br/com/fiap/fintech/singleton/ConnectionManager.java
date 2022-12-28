package br.com.fiap.fintech.singleton;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionManager {

		private static ConnectionManager connectionManager;

		private ConnectionManager() {
		}

		public static ConnectionManager getInstance() {
			if (connectionManager == null) {
				connectionManager = new ConnectionManager();
			}
			return connectionManager;
		}

		public Connection getConnection() {
			Connection connection = null;
			try {

				Class.forName("org.h2.Driver");
					
				connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return connection;
		}

}

