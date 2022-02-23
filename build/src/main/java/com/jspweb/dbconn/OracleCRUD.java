package com.jspweb.dbconn;

import java.sql.SQLException;

public abstract class OracleCRUD {
	protected OracleCloudConnect occ;
	
	public OracleCRUD() {
		try {
			this.occ = new OracleCloudConnect();
			this.occ.connection();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void commit() {
		try {
			occ.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rollback() {
		try {
			occ.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			occ.connectionClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}