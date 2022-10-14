package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service.impl;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.mapper.CharacterMapper;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service.ICharacterService;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.crud.CharacterCrudRepository;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.dto.CharacterDto;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements ICharacterService {

    @Autowired
    private CharacterCrudRepository characterCrudRepository;

    @Autowired
    private CharacterMapper characterMapper;

    @Override
    public List<CharacterDto> getAll() {
        return characterMapper.toDtoList(characterCrudRepository.findAll());
    }

    @Override
    public Optional<Character> getByName(String name) {
        return characterCrudRepository.findByName(name);
    }

    @Override
    public Optional<Character> getByIdCharacter(Long idCharacter) {
        return characterCrudRepository.findById(idCharacter);
    }

    @Override
    public Optional<List<Character>> getByAge(Integer age) {
        return characterCrudRepository.findByAge(age);
    }

    @Override
    public Optional<List<Character>> getByAudiovisualProductionId(Long audiovisualProductionId) {
        return characterCrudRepository.findByAudiovisualProductionId(audiovisualProductionId);
    }

    @Override
    public Character saveCharacter(Character character) {
        return characterCrudRepository.save(character);
    }

    @Override
    public Character modifyCharacter(Character character) {
        return characterCrudRepository.save(character);
    }

    @Override
    public void deleteCharacter(Long characterId) {
        characterCrudRepository.deleteById(characterId);
    }

}
