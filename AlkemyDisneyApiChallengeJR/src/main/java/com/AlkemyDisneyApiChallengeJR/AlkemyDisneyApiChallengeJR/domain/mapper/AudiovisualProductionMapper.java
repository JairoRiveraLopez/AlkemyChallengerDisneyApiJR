package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.mapper;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.dto.AudiovisualProductionDto;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.AudiovisualProduction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface AudiovisualProductionMapper {

    AudiovisualProductionMapper INSTANCE = Mappers.getMapper(AudiovisualProductionMapper.class);

    AudiovisualProduction toEntity(AudiovisualProductionDto audiovisualProductionDto);

    AudiovisualProductionDto toDto (AudiovisualProduction audiovisualProduction);

    default List<AudiovisualProductionDto> toDtoList (List<AudiovisualProduction> audiovisualProductionList){
        if(audiovisualProductionList == null){
            return new ArrayList<>();
        }
        return audiovisualProductionList.stream().map(this::toDto).collect(Collectors.toList());
    }

}
