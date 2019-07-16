package ca.jrvs.apps.jdbc;

import java.sql.*;

public class JDBCExecutor {
    public static void  main(String... args){
        //create an instance to the DatabaseConnectionManager
        DataBaseConnectionManager dcm = new DataBaseConnectionManager("localhost","hplussport","postgres","password");
        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = new Customer();
            customer.setFirstName("John");
            customer.setLastName("Adam");
            customer.setEmail("jadams.wh.gov");
            customer.setPhone("(555) 555 - 9845");
            customer.setAddress("1234 Main st");
            customer.setCity("Arlington");
            customer.setState("VA");
            customer.setZipCode("01234");

            Customer dbcustomer = customerDAO.create(customer);
            System.out.println(dbcustomer);
            dbcustomer = customerDAO.findById(dbcustomer.getId());
            System.out.println(dbcustomer);
            dbcustomer.setEmail("john.adams@wh.gov");
            dbcustomer = customerDAO.updateID(dbcustomer);
            System.out.println(dbcustomer);
            customerDAO.delete(dbcustomer.getId());

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}

