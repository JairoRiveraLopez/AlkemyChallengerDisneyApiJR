package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.crud;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
