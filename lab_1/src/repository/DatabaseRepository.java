package repository;

import domain.Teacher;

import java.sql.*;

abstract class DatabaseRepository {

    protected String dbUrl, tableName, tableSchema;

    DatabaseRepository(String tableName, String tableSchema) {
        this.tableName = tableName;
        this.tableSchema = tableSchema;
        this.dbUrl = "jdbc:sqlite:C:/sqlite/map.db";

        this.createDatabase();
        this.createTable();
    }

    public void executeSQL(String sqlString) {
        try {
            Connection conn = DriverManager.getConnection(this.dbUrl);
            Statement stmt = conn.createStatement();
            stmt.execute(sqlString);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createDatabase() {
        try {
            Connection conn = DriverManager.getConnection(this.dbUrl);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("Database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTable() {
        this.executeSQL("DROP TABLE IF EXISTS " + this.tableName + ";"); // for development drop and recreate
        this.executeSQL("CREATE TABLE IF NOT EXISTS " + this.tableName + " " + this.tableSchema + ";");
    }


}