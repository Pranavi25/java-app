package ca.jrvs.apps.jdbc.jdbc;

import java.sql.*;

public class JDBCExecutor {
    public static void  main(String... args){
        //create an instance to the DatabaseConnectionManager
        DataBaseConnectionManager dcm = new DataBaseConnectionManager("localhost","hplussport","postgres","password");
        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = customerDAO.findById(1000);
            System.out.println(customer.getFirstName()+" "+customer.getLastName());
            OrderDAO orderDAO = new OrderDAO(connection);
            Order order = orderDAO.findById(1000);
            System.out.println(order.tostring());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}

