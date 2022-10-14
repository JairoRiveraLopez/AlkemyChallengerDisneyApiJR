package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.dto.CharacterDto;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.Character;

import java.util.List;
import java.util.Optional;

public interface ICharacterService {
    List<CharacterDto> getAll();
    Optional<Character> getByName(String name);
    Optional<Character> getByIdCharacter(Long idCharacter);
    Optional<List<Character>> getByAge(Integer age);
    Optional<List<Character>> getByAudiovisualProductionId(Long audiovisualProductionId);
    Character saveCharacter (Character character);
    Character modifyCharacter (Character character);
    void deleteCharacter (Long characterId);
}
