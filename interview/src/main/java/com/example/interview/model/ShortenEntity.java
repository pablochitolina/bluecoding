package com.example.interview.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShortenEntity {
    @Id
    private UUID id;

    private String url;
    private String shortUrl;

    private Integer counter;


}
