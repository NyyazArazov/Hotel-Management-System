package com.example.hotelapp.repository;

import com.example.hotelapp.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerRepository {
    private static final String insertOwnerSql = "INSERT INTO owner (id, tax_number) VALUES (?,?)";
    private static final String updateOwnerSql = "UPDATE owner SET tax_number = ?  WHERE id = ?";
    private static final String deleteOwnerSql = "DELETE FROM owner WHERE id = ?";
    private static final String getOwnerByIdSql = "SELECT * FROM owner WHERE id = ?";
    private static final String getAllOwnersSql = "SELECT * FROM owner";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Owner saveOwner(Owner owner) {
        jdbcTemplate.update(insertOwnerSql, owner.getId(),owner.getTax());
        return owner;
    }

    public Owner updateOwner(Owner owner) {
        jdbcTemplate.update(updateOwnerSql, owner.getTax(),owner.getId());
        return owner;
    }

    public String deleteOwnerById(int id) {
        jdbcTemplate.update(deleteOwnerSql, id);
        return "deletion succeed";
    }

    public Owner getOwnerById(int id) {
        return jdbcTemplate.queryForObject(getOwnerByIdSql, (rs, rowNum) -> {

            return new Owner(rs.getInt("id"),
                    rs.getString("tax_number"));
        }, id);
    }

    public List<Owner> getAllOwners() {
        return jdbcTemplate.query(getAllOwnersSql, (rs, rowNum) -> {
            return new Owner(rs.getInt("id"),
                    rs.getString("tax_number"));
        });
    }
}
