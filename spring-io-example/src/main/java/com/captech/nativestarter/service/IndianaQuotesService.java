package com.captech.nativestarter.service;

import com.captech.nativestarter.model.IndianaQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.List;
import java.util.Optional;

@Service
public class IndianaQuotesService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public IndianaQuotesService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<IndianaQuote> getAll() {
        return this.jdbcTemplate.query(
                "select * from indiana_quotes",
                new BeanPropertyRowMapper<>(IndianaQuote.class)
        );

    }

    public Optional<IndianaQuote> getQuote(String id){
        List<IndianaQuote> quotes = this.jdbcTemplate
                .query("select * from indiana_quotes where id = ?",
                        new Object[]{id}, new int[]{Types.CHAR}, new BeanPropertyRowMapper<>(IndianaQuote.class));
        if(quotes.size() == 1) {
            return Optional.of(quotes.get(0));
        } else {
            return Optional.empty();
        }

    }

    public void updateQuote(IndianaQuote indianaQuote) {
        int numUpdated = this.jdbcTemplate.update("update indiana_quotes set quote = ?, movie = ? where id= ?",
                new Object[] {indianaQuote.getQuote(), indianaQuote.getMovie(), indianaQuote.getId()},
                new int[]{Types.CLOB, Types.CHAR, Types.CHAR}
                );
    }

}
