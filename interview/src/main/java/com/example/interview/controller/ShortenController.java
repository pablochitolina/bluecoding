package com.example.interview.controller;

import com.example.interview.dto.ShortenDto;
import com.example.interview.service.ShortenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ShortenController {

    private final ShortenService service;

    public ShortenController(ShortenService service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> shorten(@RequestBody String dto){
        return ResponseEntity.ok(service.shortenUrl(dto));
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> getUrl(@PathVariable String shortUrl){
        return ResponseEntity.ok(service.getUrlByShortUrl(shortUrl).getUrl());
    }
}
