package com.example.hotelapp.repository;

import com.example.hotelapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerRepository {

    private static final String insertCustomerSql = "INSERT INTO customer (full_name, mobile, mail) VALUES (?,?,?)";
    private static final String updateCustomerSql = "UPDATE customer SET full_name = ? , mobile = ?, mail = ?  WHERE id = ?";
    private static final String deleteCustomerSql = "DELETE FROM customer WHERE id = ?";
    private static final String getCustomerByIdSql = "SELECT * FROM customer WHERE id = ?";
    private static final String getAllCustomersSql = "SELECT * FROM customer";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Customer saveCustomer(Customer customer) {
        jdbcTemplate.update(insertCustomerSql, customer.getFullName(), customer.getMobile(), customer.getMail());
        return customer;
    }

    public Customer updateCustomer(Customer customer) {
        jdbcTemplate.update(updateCustomerSql, customer.getFullName(), customer.getMobile(), customer.getMail(), customer.getId());
        return customer;
    }

    public String deleteCustomerById(int id) {
        jdbcTemplate.update(deleteCustomerSql, id);
        return "deletion succeed";
    }

    public Customer getCustomerById(int id) {
        return jdbcTemplate.queryForObject(getCustomerByIdSql, (rs, rowNum) -> {

            return new Customer(rs.getInt("id"),
                    rs.getString("full_name"),
                    rs.getString("mobile"),
                    rs.getString("mail"));
        }, id);
    }

    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query(getAllCustomersSql, (rs, rowNum) -> {
            return new Customer(rs.getInt("id"),
                    rs.getString("full_name"),
                    rs.getString("mobile"),
                    rs.getString("mail"));
        });
    }
}
