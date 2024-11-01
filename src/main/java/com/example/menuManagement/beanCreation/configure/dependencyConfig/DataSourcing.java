package com.example.menuManagement.beanCreation.configure.dependencyConfig;

public class DataSourcing {
    private String connectionString;
    private int max_pool;

    public DataSourcing(String connectionString, int max_pool) {
        this.connectionString = connectionString;
        this.max_pool = max_pool;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public int getMax_pool() {
        return max_pool;
    }

    public void setMax_pool(int max_pool) {
        this.max_pool = max_pool;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "connectionString='" + connectionString + '\'' +
                ", max_pool='" + max_pool + '\'' +
                '}';
    }
}
