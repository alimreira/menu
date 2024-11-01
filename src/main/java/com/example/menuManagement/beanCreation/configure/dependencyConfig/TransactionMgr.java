package com.example.menuManagement.beanCreation.configure.dependencyConfig;

public class TransactionMgr {

    private DataSourcing dataSourcing;

    public TransactionMgr(DataSourcing dataSourcing) {
        this.dataSourcing = dataSourcing;
    }

    public DataSourcing getDataSource() {
        return dataSourcing;
    }

    public void setDataSource(DataSourcing dataSourcing) {
        this.dataSourcing = dataSourcing;
    }

    @Override
    public String toString() {
        return "TransactionMgr{" +
                "dataSource=" + dataSourcing +
                '}';
    }
}
