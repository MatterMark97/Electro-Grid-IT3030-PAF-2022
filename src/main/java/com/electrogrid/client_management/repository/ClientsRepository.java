package com.electrogrid.client_management.repository;

import com.electrogrid.client_management.model.Clients;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ClientsRepository {
    Connection con = null;

    public ClientsRepository() {

        String url = "jdbc:mysql://localhost:3306/electrogrid_db?useSSL=false";
        String userName = "root";
        String password = "root";

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(url, userName, password);

            System.out.println("Database connection is success!!!");

        }
        catch (Exception e) {
            System.out.println("Database connection is not success!!!");
        }

    }

    public List<Clients> getClients(){

        List<Clients> clients = new ArrayList<>();
        String sql = "SELECT * FROM electrogrid_db.clients";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Clients c = new Clients();
                c.setClientsID(rs.getInt(1));
                c.setAccountNo(rs.getString(2));
                c.setClientName(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setMobileNo(rs.getString(5));
                c.setAddress(rs.getString(6));
                c.setUnits(rs.getString(7));


                clients.add(c);
            }
        }
        catch (Exception e) {
            System.out.println("Database cannot get Clients!!!");
        }

        return  clients;
    }

    public Clients getClients(int clientsID) {

        String sql = "SELECT * FROM electrogrid_db.clients WHERE clientsID =?";
        Clients c = new Clients();

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,clientsID);
            ResultSet rs = st.executeQuery();

            if(rs.next()){
                c.setClientsID(rs.getInt(1));
                c.setAccountNo(rs.getString(2));
                c.setClientName(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setMobileNo(rs.getString(5));
                c.setAddress(rs.getString(6));
                c.setUnits(rs.getString(7));


            }
        }
        catch (Exception e) {
            System.out.println("Database cannot get Client!!!");
        }

        return c;
    }


    public void createClient(Clients c1) {

        String sql = "INSERT INTO electrogrid_db.clients VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, c1.getClientsID());
            st.setString(2, c1.getAccountNo());
            st.setString(3, c1.getClientName());
            st.setString(4, c1.getEmail());
            st.setString(5, c1.getMobileNo());
            st.setString(6, c1.getAddress());
            st.setString(7, c1.getUnits());

            st.executeUpdate();

        }
        catch (Exception e) {
            System.out.println("Database cannot add Clients!!!");
        }

    }

    public void updateClient(Clients c1) {

        String sql = "UPDATE electrogrid_db.clients SET accountNo=?, clientName=?, email=?, mobileNo=?, address=?, units=?=? WHERE clientsID =?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, c1.getAccountNo());
            st.setString(2, c1.getClientName());
            st.setString(3, c1.getEmail());
            st.setString(4, c1.getMobileNo());
            st.setString(5, c1.getAddress());
            st.setString(6, c1.getUnits());
            st.setInt(7, c1.getClientsID());


            st.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Database cannot update bills!!!");
        }
    }

    public void deleteClient(int clientsID) {

        String sql = "DELETE FROM electrogrid_db.clients WHERE clientsID =?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, clientsID);
            st.execute();
            System.out.println("Database successfully delete the client!!!");
        }
        catch (Exception e) {
            System.out.println("Database cannot delete the client!!!");
        }

    }


}
