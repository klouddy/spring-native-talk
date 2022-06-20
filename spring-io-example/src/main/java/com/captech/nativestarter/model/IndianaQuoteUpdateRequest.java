package com.captech.nativestarter.model;

import java.io.Serializable;

public class IndianaQuoteUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String quote;
    private String movie;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}
