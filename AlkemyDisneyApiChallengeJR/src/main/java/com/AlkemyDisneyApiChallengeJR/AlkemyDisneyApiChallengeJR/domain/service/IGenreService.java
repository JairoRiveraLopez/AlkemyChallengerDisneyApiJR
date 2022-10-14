package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.Genre;

import java.util.List;

public interface IGenreService {
    List<Genre> getAll();
}
