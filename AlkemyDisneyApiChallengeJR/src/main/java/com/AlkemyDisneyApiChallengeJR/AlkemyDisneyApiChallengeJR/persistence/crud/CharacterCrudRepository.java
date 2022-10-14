package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.crud;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface CharacterCrudRepository extends JpaRepository<Character, Long> {
    Optional<Character> findByName(String name);
    Optional<List<Character>> findByAge(Integer age);
    Optional<List<Character>> findByAudiovisualProductionId(Long audiovisualProductionId);
}
