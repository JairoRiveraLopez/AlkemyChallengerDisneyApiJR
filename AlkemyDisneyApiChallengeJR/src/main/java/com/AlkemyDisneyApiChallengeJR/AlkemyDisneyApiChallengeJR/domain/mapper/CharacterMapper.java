package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.mapper;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.dto.CharacterDto;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.Character;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface CharacterMapper {

    CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    Character toEntity (CharacterDto characterDto);

    CharacterDto toDto (Character character);

    default List<CharacterDto> toDtoList (List<Character> characterList){
        if(characterList == null){
            return new ArrayList<>();
        }
        return characterList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
