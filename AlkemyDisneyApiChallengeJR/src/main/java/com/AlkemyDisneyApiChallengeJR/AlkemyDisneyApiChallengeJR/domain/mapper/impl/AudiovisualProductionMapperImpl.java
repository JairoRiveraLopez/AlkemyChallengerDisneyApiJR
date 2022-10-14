package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.mapper.impl;


import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.mapper.AudiovisualProductionMapper;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.dto.AudiovisualProductionDto;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.AudiovisualProduction;
import org.springframework.stereotype.Component;

@Component
public class AudiovisualProductionMapperImpl implements AudiovisualProductionMapper {
    @Override
    public AudiovisualProduction toEntity(AudiovisualProductionDto audiovisualProductionDto) {
        if(audiovisualProductionDto == null){
            return null;
        }

        AudiovisualProduction audiovisualProduction = new AudiovisualProduction();
        audiovisualProduction.setImage(audiovisualProductionDto.getAudiovisualProductionImage());
        audiovisualProduction.setTitle(audiovisualProductionDto.getAudiovisualProductionTitle());
        audiovisualProduction.setReleaseDate(audiovisualProductionDto.getAudiovisualProductionReleaseDate());

        return audiovisualProduction;
    }

    @Override
    public AudiovisualProductionDto toDto(AudiovisualProduction audiovisualProduction) {
        if(audiovisualProduction == null){
            return null;
        }
        AudiovisualProductionDto audiovisualProductionDto = new AudiovisualProductionDto();

        audiovisualProductionDto.setAudiovisualProductionImage(audiovisualProduction.getImage());
        audiovisualProductionDto.setAudiovisualProductionTitle(audiovisualProduction.getTitle());
        audiovisualProductionDto.setAudiovisualProductionReleaseDate(audiovisualProduction.getReleaseDate());

        return audiovisualProductionDto;
    }
}
