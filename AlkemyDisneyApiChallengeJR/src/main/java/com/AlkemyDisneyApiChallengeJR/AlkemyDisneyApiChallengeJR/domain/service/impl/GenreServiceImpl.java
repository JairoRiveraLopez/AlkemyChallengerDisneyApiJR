package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service.impl;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service.IGenreService;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.crud.GenreRepository;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements IGenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Genre> getAll() {
        return (List<Genre>) genreRepository.findAll();
    }
}
