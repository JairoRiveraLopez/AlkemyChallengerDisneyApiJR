package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.dto.AudiovisualProductionDto;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.AudiovisualProduction;

import java.util.List;
import java.util.Optional;

public interface IAudiovisualProductionService {
    List<AudiovisualProductionDto> getAll();
    List<AudiovisualProduction> getAllOrderByDateReleaseAsc();
    List<AudiovisualProduction> getAllOrderByDateReleaseDesc();
    Optional<AudiovisualProduction> getById(Long audiovisualProductionId);
    Optional<AudiovisualProduction> getByTitle(String title);
    Optional<List<AudiovisualProduction>> getByGenreId(Long idGenre);
    AudiovisualProduction saveAudiovisualProduction (AudiovisualProduction audiovisualProduction);
    AudiovisualProduction modifyAudiovisualProduction(AudiovisualProduction audiovisualProduction);
    void deleteAudiovisualProduction (Long audiovisualProductionId);
}
