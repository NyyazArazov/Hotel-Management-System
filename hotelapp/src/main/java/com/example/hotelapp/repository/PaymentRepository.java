package com.example.hotelapp.repository;

import com.example.hotelapp.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentRepository {

    private static final String insertPaymentSql = "INSERT INTO payment (amount,date,accommodation_id ) VALUES (?,?,?)";
    private static final String updatePaymentSql = "UPDATE payment SET amount = ? , date = ?, accommodation_id = ?  WHERE id = ?";
    private static final String deletePaymentSql = "DELETE FROM payment WHERE id = ?";
    private static final String getPaymentByIdSql = "SELECT * FROM payment WHERE id = ?";
    private static final String getAllPaymentsSql = "SELECT * FROM payment";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Payment savePayment(Payment payment) {
        jdbcTemplate.update(insertPaymentSql, payment.getAmount(), payment.getDate(), payment.getAccommodationId());
        return payment;
    }

    public Payment updatePayment(Payment payment) {
        jdbcTemplate.update(updatePaymentSql, payment.getAmount(), payment.getDate(), payment.getAccommodationId(), payment.getId());
        return payment;
    }

    public String deletePaymentById(int id) {
        jdbcTemplate.update(deletePaymentSql, id);
        return "deletion succeed";
    }

    public Payment getPaymentById(int id) {
        return jdbcTemplate.queryForObject(getPaymentByIdSql, (rs, rowNum) -> {

            return new Payment(rs.getInt("id"),
                    rs.getFloat("amount"),
                    rs.getString("date"),
                    rs.getInt("accommodation_id"));
        }, id);
    }

    public List<Payment> getAllPayments() {
        return jdbcTemplate.query(getAllPaymentsSql, (rs, rowNum) -> {
            return new Payment(rs.getInt("id"),
                    rs.getFloat("amount"),
                    rs.getString("date"),
                    rs.getInt("accommodation_id"));
        });
    }
}
