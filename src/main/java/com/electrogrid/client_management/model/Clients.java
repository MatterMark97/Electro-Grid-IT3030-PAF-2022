package com.electrogrid.client_management.model;

public class Clients {
    private int clientsID;
    private  String accountNo;
    private String clientName;
    private String email;
    private String mobileNo;
    private String address;
    private String units;

    public Clients() {
    }

    public int getClientsID() {
        return clientsID;
    }

    public void setClientsID(int clientsID) {
        this.clientsID = clientsID;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "clientsID=" + clientsID +
                ", accountNo='" + accountNo + '\'' +
                ", clientName='" + clientName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", address='" + address + '\'' +
                ", units='" + units + '\'' +
                '}';
    }
}
