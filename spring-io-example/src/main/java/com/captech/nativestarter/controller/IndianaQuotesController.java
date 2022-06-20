package com.captech.nativestarter.controller;

import com.captech.nativestarter.model.IndianaQuote;
import com.captech.nativestarter.model.IndianaQuoteUpdateRequest;
import com.captech.nativestarter.service.IndianaQuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndianaQuotesController {

    private final IndianaQuotesService indianaQuotesService;

    @Autowired
    public IndianaQuotesController(IndianaQuotesService indianaQuotesService) {
        this.indianaQuotesService = indianaQuotesService;
    }

    @RequestMapping("yo")
    public String yoWorld() {
        return "yo world";
    }

    @GetMapping("/quotes")
    public ResponseEntity<List<IndianaQuote>> getAllQuotes() {
        return ResponseEntity.ok(this.indianaQuotesService.getAll());
    }

    @GetMapping("/quotes/{quoteId}")
    public ResponseEntity<IndianaQuote> getQuoteById(@PathVariable String quoteId) {
        return this.indianaQuotesService.getQuote(quoteId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping("/quotes/{quoteId}")
    public ResponseEntity<Void> updateQuoteById(@PathVariable String quoteId,
        @RequestBody IndianaQuoteUpdateRequest indianaQuoteUpdateRequest
    ) {
        IndianaQuote indianaQuote = new IndianaQuote();
        indianaQuote.setId(quoteId);
        indianaQuote.setQuote(indianaQuoteUpdateRequest.getQuote());
        indianaQuote.setMovie(indianaQuoteUpdateRequest.getMovie());

        this.indianaQuotesService.updateQuote(indianaQuote);

        return ResponseEntity.noContent().build();
    }
}
