package ca.jrvs.apps.jdbc;



import ca.jrvs.apps.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO extends DataAccessObject<Customer> {
    private static final String INSERT = "INSERT INTO customer(first_name, last_name,email,phone,address,city,state,zipCode) VALUES (?,?,?,?,?,?,?,?)";
    private static final String GET_ONE="SELECT customer_id, first_name,last_name,email,phone,address,city,state,zipCode FROM customer WHERE customer_id = ?";


    public CustomerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Customer findById(long id) {
        Customer customer = new Customer();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);){
            statement.setLong(1,id);
            ResultSet resultset = statement.executeQuery();
            while(resultset.next()){
                customer.setId(resultset.getLong("customer_id"));
                customer.setFirstName(resultset.getString("first_name"));
                customer.setLastName(resultset.getString("last_name"));
                customer.setEmail(resultset.getString("email"));
                customer.setPhone(resultset.getString("phone"));
                customer.setAddress(resultset.getString("address"));
                customer.setCity(resultset.getString("city"));
                customer.setState(resultset.getString("State"));
                customer.setZipCode(resultset.getString("zipCode"));

            }
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return customer;

    }

    @Override
    public Customer create(Customer dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);){
            statement.setString(1,dto.getFirstName());
            statement.setString(2,dto.getLastName());
            statement.setString(3,dto.getEmail());
            statement.setString(4,dto.getPhone());
            statement.setString(5,dto.getAddress());
            statement.setString(6,dto.getCity());
            statement.setString(7,dto.getState());
            statement.setString(8,dto.getZipCode());
            statement.execute();
            int id = this.getLastVal(CUSTOMER_SEQUENCE);
            return this.findById(id);
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
