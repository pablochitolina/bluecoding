package com.example.interview.service;

import com.example.interview.dto.ShortenDto;
import com.example.interview.model.ShortenEntity;
import com.example.interview.repository.ShortenRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class ShortenService {

    private final ShortenRepository repository;

    public ShortenService(ShortenRepository repository){
        this.repository = repository;
    }

    public ShortenDto shortenUrl(String url){

        if(!Objects.isNull(getUrlByShortUrl(url))){
            throw new IllegalArgumentException("Url already exists");
        }
        //check for valid URL

        var uuid = UUID.randomUUID();

        var entity =  ShortenEntity.builder()
                .id(uuid)
                .url(url)
                .counter(0)
                .shortUrl(getShort(uuid.toString() ,repository.count()))
                .build();

        return entityToDtoMapper(repository.save(entity));
    }

    public ShortenDto getUrlByShortUrl(String shortUrl){
        var entity = repository.findShortenEntityByShortUrl(shortUrl);
        if(Objects.isNull(entity)){
            return  null;
        }
       return entityToDtoMapper(entity);
    }


    private static ShortenEntity dtoToEntityMapper(ShortenDto dto){
        return ShortenEntity.builder()
                .id(dto.getId())
                .url(dto.getUrl())
                .shortUrl(dto.getShortUrl())
                .counter(0)
                .build();

    }

    private static ShortenDto entityToDtoMapper(ShortenEntity entity){
        return ShortenDto.builder()
                .id(entity.getId())
                .url(entity.getUrl())
                .shortUrl(entity.getShortUrl())
                .counter(entity.getCounter())
                .build();

    }

    static String getShort(String uuid, long count)
    {

        int n = 5;
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)(uuid.length() * Math.random());
            sb.append(uuid.charAt(index));
        }
        sb.append(count);

        return sb.toString();
    }

}
