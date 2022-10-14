package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.mapper.impl;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.mapper.CharacterMapper;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.dto.CharacterDto;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.Character;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapperImpl implements CharacterMapper {
    @Override
    public Character toEntity(CharacterDto characterDto) {
        if( characterDto == null){
            return null;
        }

        Character character = new Character();
        character.setImage(characterDto.getCharacterImage());
        character.setName(characterDto.getCharacterName());

        return character;
    }

    @Override
    public CharacterDto toDto(Character character) {
        if(character == null){
            return null;
        }

        CharacterDto characterDto = new CharacterDto();
        characterDto.setCharacterImage(character.getImage());
        characterDto.setCharacterName(character.getName());

        return characterDto;
    }

}
