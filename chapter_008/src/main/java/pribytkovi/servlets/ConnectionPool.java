package pribytkovi.servlets;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {
    private Vector<Connection> availableCon = new Vector<>();
    private Vector<Connection> usedConns = new Vector<>();
    private String url;

    public ConnectionPool(String url, String driver, int initConnCnt) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.url = url;
        for (int i = 0; i < initConnCnt; i++) {
            availableCon.addElement(getConnection());
        }
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public synchronized Connection retrieve(Connection c) throws SQLException {
        Connection newConn = null;
        if (availableCon.size() == 0) {
            newConn  = getConnection();
        } else {
            newConn = (Connection) availableCon.lastElement();
            availableCon.removeElement(newConn);
        }
        usedConns.addElement(newConn);
        return newConn;
    }
    public synchronized void putback(Connection c) throws NullPointerException {
        if (c != null) {
            if (usedConns.removeElement(c)) {
                availableCon.addElement(c);
            } else {
                throw new NullPointerException("Connection not in the usedConns array");
            }
        }
    }
    public int getAvailableConnsCnt() {
        return availableCon.size();
    }
}
