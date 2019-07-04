package ca.jrvs.apps.jdbc.jdbc;

import ca.jrvs.apps.jdbc.jdbc.util.DataTransferObject;

public class Customer implements DataTransferObject {
    private long id;
    private String first_Name;
    private String last_Name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id ){ this.id = id;}
    public String getFirstName(){ return first_Name;}
    public void setFirstName(String firstName){this.first_Name = firstName; }
    public String getLastName() {return last_Name; }
    public void setLastName(String lastName) { this.last_Name = lastName ; }
    public String getEmail() { return email; }
    public void setEmail(String email){this.email = email;}
    public String getAddress(){ return address;}
    public void setAddress(String address){this.address = address;}
    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone = phone;}
    public String getCity(){return city;}
    public void setCity(String city){this.city = city;}
    public String getState(){return state;}
    public void setState(String state){this.state = state;}
    public String getZipCode(){return zipCode;}
    public void setZipCode(String zipCode){this.zipCode = zipCode;}
}

