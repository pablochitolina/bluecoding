package com.example.interview.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ShortenDto {

    private UUID id;

    private String url;
    private String shortUrl;

    private Integer counter;
}
